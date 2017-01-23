package net.fexcraft.mod.extensions.bge.tileentities;

import net.fexcraft.mod.frsm.util.java.BoolUtil;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class DiceTileEntity extends TileEntity implements IPacketReceiver{

	@Override
	public void processServerPacket(IPacket pkt) {
		//
	}

	@Override
	public void processClientPacket(IPacket pkt) {
		PacketTileEntityUpdate packet = (PacketTileEntityUpdate)pkt;
		if(packet.nbt.hasKey("bool")){
			toggled = packet.nbt.getBoolean("bool");
		}
		if(packet.nbt.hasKey("result")){
			result = packet.nbt.getInteger("result");
		}
		return;
	}
	
	private boolean toggled;
	private int result;
	
	public DiceTileEntity(){
		toggled = false;
		result = 0;
	}
	
	public void toggle(){
		toggled = BoolUtil.reverse(toggled);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setBoolean("bool", toggled);
		ApiUtil.sendTileEntityUpdatePacket(this.world, this.pos, nbt);
	}
	
	public void getRandomResult(){
		result = this.world.rand.nextInt(6);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("result", result);
		ApiUtil.sendTileEntityUpdatePacket(this.world, this.pos, nbt);
	}
	
	public boolean getState(){
		return toggled;
	}
	
	public int getResult(){
		return result;
	}
	
	@Override
	public NBTTagCompound getUpdateTag(){
		return writeToNBT(new NBTTagCompound());
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket(){
		NBTTagCompound nbt = this.writeToNBT(new NBTTagCompound());
		return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), nbt);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
		this.readFromNBT(pkt.getNbtCompound());
		return;
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		nbt.setBoolean("frsm_bge_toggled", toggled);
		nbt.setInteger("frsm_bge_result", result);
		return nbt;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		toggled = nbt.getBoolean("frsm_bge_toggled");
		result = nbt.getInteger("frsm_bge_result");
		return;
	}
}