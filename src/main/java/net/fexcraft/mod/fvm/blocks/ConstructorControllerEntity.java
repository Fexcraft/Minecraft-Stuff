package net.fexcraft.mod.fvm.blocks;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.data.LoadedIn;
import net.fexcraft.mod.fvm.data.PartType;
import net.fexcraft.mod.fvm.data.VehicleType;
import net.fexcraft.mod.fvm.items.PartItem;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;

public class ConstructorControllerEntity extends TileEntity implements IInventory, IPacketReceiver {
	
	private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(1, ItemStack.EMPTY);
	private boolean linked;
	public VehicleType type = null;
	
	public VehicleType getType(){
		return type;
	}

	public boolean isTypeNull(){
		return type == null;
	}

	@Override
	public String getName(){
		return "vcte";
	}

	@Override
	public boolean hasCustomName(){
		return false;
	}

	@Override
	public int getSizeInventory(){
		return 1;
	}

	@Override
	public boolean isEmpty(){
		return stacks.isEmpty();
	}

	@Override
	public ItemStack getStackInSlot(int index){
		return stacks.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count){
		return ItemStackHelper.getAndSplit(this.stacks, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index){
		return ItemStackHelper.getAndRemove(this.stacks, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		this.stacks.set(index, stack);
	}

	@Override
	public int getInventoryStackLimit(){
		return 128;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player){
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player){
		//
	}

	@Override
	public void closeInventory(EntityPlayer player){
		if(!stacks.isEmpty() && !stacks.get(0).isEmpty() && !world.isRemote){
			EntityItem ent = new EntityItem(world);
			ent.setEntityItemStack(stacks.get(0));
			ent.setPosition(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
			world.spawnEntity(ent);
		}
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack){
		return stack.getItem() instanceof PartItem;
	}

	@Override
	public int getField(int id){
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		//
	}

	@Override
	public int getFieldCount(){
		return 0;
	}

	@Override
	public void clear(){
		 stacks = NonNullList.<ItemStack>withSize(1, ItemStack.EMPTY);
	}

	@Override
	public void processServerPacket(IPacket pkt) {
		PacketTileEntityUpdate packet = (PacketTileEntityUpdate)pkt;
		switch(packet.nbt.getString("Task")){
			case "install":
				type.installPart(false, ((PartItem)getStackInSlot(0).getItem()).getType(getStackInSlot(0)));
				removeStackFromSlot(0);
				break;
			case "add":
				String[] data = packet.nbt.getString("Data").split("//");
				type.requires.remove(data[0]);
				type.parts.put(data[0], FvmResources.getPart(data[1]));
				break;
			case "remove":
				String string = packet.nbt.getString("Data");
				boolean isDefault = FvmResources.isDefaultPart(type.registryname, string);
				if(isDefault){
					type.requires.add(string);
				}
				PartType part = type.parts.remove(string);
				EntityItem ent = new EntityItem(world);
				ent.setEntityItemStack(part.itemstack.copy());
				ent.setPosition(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
				world.spawnEntity(ent);
				break;
			case "create_vehicle":
				String str = type.toString();
				type = null;
				ItemStack stack = new ItemStack(Registry.getItem("fvm:vehicle_item"), 1, 0);
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setString("VehicleType", str);
				stack.setTagCompound(nbt);
				EntityItem entity = new EntityItem(world);
				entity.setPosition(pos.getX() + 0.5, pos.getY() + 2, pos.getZ() + 0.5);
				entity.setEntityItemStack(stack);
				world.spawnEntity(entity);
				break;
			case "painttable":
				String[] rgbs = packet.nbt.getString("Data").split("//");
				try{
					type.primaryColor = RGB.fromUnknown(rgbs[0], rgbs[1], rgbs[2]);
				}
				catch(Exception e){
					VehicleType vehicle = FvmResources.getVehicle(type.registryname);
					if(vehicle != null){
						type.primaryColor.copyFrom(vehicle.primaryColor);
					}
					else{
						type.primaryColor.copyFrom(RGB.WHITE);
					}
				}
				try{
					type.secondaryColor = RGB.fromUnknown(rgbs[3], rgbs[4], rgbs[5]);
				}
				catch(Exception e){
					VehicleType vehicle = FvmResources.getVehicle(type.registryname);
					if(vehicle != null){
						type.secondaryColor.copyFrom(vehicle.secondaryColor);
					}
					else{
						type.secondaryColor.copyFrom(RGB.WHITE);
					}
				}
				break;
			default:
				break;
		}
		this.sendUpdate();
	}

	@Override
	public void processClientPacket(IPacket pkt) {
		PacketTileEntityUpdate packet = (PacketTileEntityUpdate)pkt;
		if(packet.nbt.hasKey("Linked")){
			setLinked(packet.nbt.getBoolean("Linked"));
		}
		if(packet.nbt.hasKey("VehicleType")){
			type = new VehicleType(LoadedIn.TILE, JsonUtil.getFromString(packet.nbt.getString("VehicleType")).getAsJsonObject());
			FvmResources.loadVehicleModel(type);
			Print.debug(packet.nbt.getString("VehicleType"));
		}
		else{
			type = null;
		}
		Print.debug(type == null ? "TYPE IS NULL" : type.save(null).toString());
	}
	
	public void sendUpdate(){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setBoolean("Linked", isLinked());
		if(type != null){
			nbt.setString("VehicleType", type.save(new JsonObject()).toString());
		}
		ApiUtil.sendTileEntityUpdatePacket(world, pos, nbt, 256);
	}
	
	public void installPart(){
		//TODO
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket(){
		return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), this.writeToNBT(new NBTTagCompound()));
	}
	
	@Override
	public NBTTagCompound getUpdateTag(){
		return this.writeToNBT(new NBTTagCompound());
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
		this.readFromNBT(pkt.getNbtCompound());
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		compound.setBoolean("Linked", isLinked());
		if(type != null){
			compound.setString("VehicleType", type.save(null).toString());
		}
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		setLinked(compound.getBoolean("Linked"));
		if(compound.hasKey("VehicleType")){
			type = new VehicleType(LoadedIn.TILE, JsonUtil.getFromString(compound.getString("VehicleType")).getAsJsonObject());
			FvmResources.loadVehicleModel(type);
		}
	}

	public boolean isLinked(){
		return linked;
	}

	public void setLinked(boolean linked){
		this.linked = linked;
	}

	public void notifyServer(String string){
		String[] split = string.split(":");
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Task", split[0]);
		if(split.length > 1){
			nbt.setString("Data", split[1]);
		}
		PacketHandler.getInstance().sendToServer(new PacketTileEntityUpdate(world.provider.getDimension(), pos, nbt));
	}
	
}