package net.fexcraft.mod.fvm.blocks;

import net.fexcraft.mod.fvm.data.Vehicle.VehicleData;
import net.fexcraft.mod.fvm.items.PartItem;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
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

public class ConstructorControllerEntity extends TileEntity implements IInventory, IPacketReceiver<PacketTileEntityUpdate> {
	
	private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(1, ItemStack.EMPTY);
	private boolean linked;
	public VehicleData data = null;
	public float hitX, hitY, hitZ;
	
	public VehicleData getVehicleData(){
		return data;
	}

	public boolean isTypeNull(){
		return data == null;
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
	public void processServerPacket(PacketTileEntityUpdate packet){
		switch(packet.nbt.getString("Task")){
			default:
				break;
		}
		this.sendUpdate();
	}

	@Override
	public void processClientPacket(PacketTileEntityUpdate packet){
		if(packet.nbt.hasKey("Linked")){
			setLinked(packet.nbt.getBoolean("Linked"));
		}
		if(packet.nbt.hasKey("VehicleType")){
			data = VehicleData.fromNBT(packet.nbt);
			Print.debug(packet.nbt);
		}
		else{
			data = null;
		}
		Print.debug(data == null ? "TYPE IS NULL" : data.write(null).toString());
	}
	
	public void sendUpdate(){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setBoolean("Linked", isLinked());
		if(data != null){
			data.write(nbt);
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
		if(data != null){
			data.write(compound);
		}
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		setLinked(compound.getBoolean("Linked"));
		if(compound.hasKey("VehicleType")){
			data = VehicleData.fromNBT(compound);
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