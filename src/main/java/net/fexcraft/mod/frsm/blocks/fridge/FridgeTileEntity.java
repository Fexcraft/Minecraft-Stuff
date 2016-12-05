package net.fexcraft.mod.frsm.blocks.fridge;

import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.cls.EnumColor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class FridgeTileEntity extends TileEntity implements IPacketReceiver{
	
	private EnumColor color;
	private boolean open;
	
	public FridgeTileEntity(){
		color = EnumColor.WHITE;
		open = false;
	}
	
	public boolean getState(){
		return open;
	}
	
	public void setState(boolean b){
		this.open = b;
	}
	
	public void setColor(EnumColor color){
		this.color = color;
	}
	
	public EnumColor getColor(){
		return this.color;
	}

	@Override
	public void processServerPacket(IPacket pkt) {
		//
	}

	@Override
	public void processClientPacket(IPacket pkt) {
		PacketTileEntityUpdate packet = (PacketTileEntityUpdate)pkt;
		if(packet.nbt.hasKey("color")){
			color = EnumColor.fromString(packet.nbt.getString("color"));
		}
		if(packet.nbt.hasKey("open")){
			open = packet.nbt.getBoolean("open");
		}
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket(){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt = this.writeToNBT(nbt);
		return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), nbt);
	}
	
	@Override
	public NBTTagCompound getUpdateTag(){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt = this.writeToNBT(nbt);
		return nbt;
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
		this.readFromNBT(pkt.getNbtCompound());
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		compound.setString("frsm_color", color.toString());
		compound.setBoolean("frsm_open", open);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		color = EnumColor.fromString(compound.getString("frsm_color"));
		open = compound.getBoolean("frsm_open");
	}
	
}