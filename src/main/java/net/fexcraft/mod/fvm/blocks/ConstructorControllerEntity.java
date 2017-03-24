package net.fexcraft.mod.fvm.blocks;

import java.util.ArrayList;
import java.util.UUID;

import net.fexcraft.mod.fvm.data.LoadedIn;
import net.fexcraft.mod.fvm.data.PartType;
import net.fexcraft.mod.fvm.data.VehicleType;
import net.fexcraft.mod.fvm.items.PartItem;
import net.fexcraft.mod.fvm.util.FvmPerms;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.Entity;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
				EntityPlayer player = Static.getServer().getPlayerList().getPlayerByUUID(UUID.fromString(data[2]));
				if(player != null){
					for(int i = 0; i < player.inventory.mainInventory.size(); i++){
						ItemStack stack = player.inventory.mainInventory.get(i);
						if(stack.getItem() instanceof PartItem){
							PartType type = PartItem.getType(stack);
							if(type.registryname.equals(data[1])){
								player.inventory.removeStackFromSlot(i);
								this.type.requires.remove(data[0]);
								this.type.parts.put(data[0], FvmResources.getPart(data[1]));
								break;
							}
						}
					}
				}
				break;
			case "remove":
				String string = packet.nbt.getString("Data");
				boolean isDefault = FvmResources.isDefaultPart(type.registryname, string);
				if(isDefault){
					type.requires.add(string);
				}
				PartType part = type.parts.remove(string);
				EntityItem ent = new EntityItem(world);
				ent.setEntityItemStack(part.newStack());
				ent.setPosition(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
				world.spawnEntity(ent);
				break;
			case "create_vehicle":
				ItemStack stack = new ItemStack(Registry.getItem("fvm:vehicle_item"), 1, 0);
				NBTTagCompound nbt = new NBTTagCompound();
				type.write(nbt);
				stack.setTagCompound(nbt);
				type = null;
				EntityItem entity = new EntityItem(world);
				entity.setPosition(pos.getX() + 0.5, pos.getY() + 2, pos.getZ() + 0.5);
				entity.setEntityItemStack(stack);
				world.spawnEntity(entity);
				break;
			case "spawn_vehicle":
				String uuid = packet.nbt.getString("Data");
				EntityPlayer ep = Static.getServer().getPlayerList().getPlayerByUUID(UUID.fromString(uuid));
				if(!PermManager.getPlayerPerms(ep).hasPermission(FvmPerms.LAND_VEHICLE_PLACE)){
					Print.chat(ep, "No permission to place land vehicles.");
					break;
				}
				if(!PermManager.getPlayerPerms(ep).hasPermission(FvmPerms.permPlace(type))){
					Print.chat(ep, "No permission to place a vehicle of this type.");
					break;
				}
				if(!this.linked){
					Print.chat(ep, "This Controller isn't connected to a Center block!");
					break;
				}
				BlockPos pos = null;
				ArrayList<ConstructorCenterEntity> list = ConstructorController.findCenter(world, ep, this.pos);
				for(ConstructorCenterEntity cce : list){
					if(cce.remote != null && cce.remote.equals(this.pos)){
						pos = cce.getPos();
						break;
					}
				}
				if(pos != null){
					VehicleType type = FvmResources.getNewInstanceOf(LoadedIn.ENTITY, this.type);
					Print.debug(type.toString());
					try{
						Class clazz = Class.forName("com.flansmod.fvm.LandVehicle");
						Entity enti = (Entity)clazz.getConstructor(World.class, double.class, double.class, double.class, int.class, VehicleType.class).newInstance(world, (double)pos.getX() + 0.5F, (double)pos.getY() + 2.5F, (double)pos.getZ() + 0.5F, this.getBlockMetadata(), type);
						world.spawnEntity(enti);
						//Compilicated code to prevent runtime crashes when flansmod is missing.
						if(!ep.capabilities.isCreativeMode){	
							ep.getHeldItemMainhand().shrink(1);
						}
						//Reset Controller
						this.type = null;
						//Confirm in chat
						Print.chat(ep, "Vehicle spawned;");
					}
					catch (Exception e){
						e.printStackTrace();
					}
				}
				else{
					Print.chat(ep, "Error, Center block not found!");
				}
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
			case "despawn_vehicle":
				EntityPlayer epm = Static.getServer().getPlayerList().getPlayerByUUID(UUID.fromString(packet.nbt.getString("Data")));
				if(type != null){
					Print.chat(epm, "Constructor Controller already holds a VehicleType;");
					break;
				}
				BlockPos pes = null;
				ArrayList<ConstructorCenterEntity> lest = ConstructorController.findCenter(world, epm, this.pos);
				for(ConstructorCenterEntity cce : lest){
					if(cce.remote != null && cce.remote.equals(this.pos)){
						pes = cce.getPos();
						break;
					}
				}
				if(pes != null){
					//
				}
				else{
					Print.chat(epm, "Error, Center block not found!");
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
			type = new VehicleType(LoadedIn.TILE, packet.nbt);
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
			type.write(nbt);
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
			type.write(compound);
		}
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		setLinked(compound.getBoolean("Linked"));
		if(compound.hasKey("VehicleType")){
			type = new VehicleType(LoadedIn.TILE, compound);
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