package net.fexcraft.mod.fvm.blocks;

import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class PaintTableEntity extends TileEntity implements IPacketReceiver {
	
	private EnumFacing facing;
	private RGB primary, secondary;
	
	public PaintTableEntity(){
		facing = EnumFacing.UP;
	}
	
	@Override
	public void processServerPacket(IPacket pkt){
		//
	}

	@Override
	public void processClientPacket(IPacket pkt){
		NBTTagCompound nbt = ((PacketTileEntityUpdate)pkt).nbt;
		if(nbt.hasKey("Facing")){
			facing = EnumFacing.byName(nbt.getString("Facing"));
		}
		else{
			facing = EnumFacing.UP;
		}
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
		if(facing != null){
			compound.setString("Facing", facing.getName());
		}
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		if(compound.hasKey("Facing")){
			facing = EnumFacing.byName(compound.getString("Facing"));
		}
		else{
			facing = EnumFacing.UP;
		}
	}

	public EnumFacing getFacing(){
		return facing;
	}

	public void setFacing(EnumFacing facing){
		this.facing = facing;
		this.sendUpdate();
	}
	
	public void sendUpdate(){
		NBTTagCompound nbt = new NBTTagCompound();
		if(facing != null){
			nbt.setString("Facing", facing.getName());
		}
		ApiUtil.sendTileEntityUpdatePacket(world, pos, nbt, 256);
	}
	
}