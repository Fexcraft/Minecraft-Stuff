package net.fexcraft.mod.frsm.blocks.tv;

import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TVS2Entity extends TileEntity implements IPacketReceiver {
	
	int rotation;
	
	public TVS2Entity(){
		rotation = 0;
	}
	
	public int getRotation(){
		return rotation;
	}
	
	@Override
	public NBTTagCompound getUpdateTag(){
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return nbt;
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket(){
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), nbt);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
		this.readFromNBT(pkt.getNbtCompound());
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		rotation = nbt.getInteger("Rotation");
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		nbt.setInteger("Rotation", rotation);
		return nbt;
	}
	
	@Override
	public void processServerPacket(IPacket pkt){
		//
	}
	
	@Override
	public void processClientPacket(IPacket pkt){
		rotation = ((PacketTileEntityUpdate)pkt).nbt.getInteger("rotation");
	}
	
}