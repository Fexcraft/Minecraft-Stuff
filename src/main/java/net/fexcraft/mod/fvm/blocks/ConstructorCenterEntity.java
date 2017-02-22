package net.fexcraft.mod.fvm.blocks;

import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class ConstructorCenterEntity extends TileEntity implements IPacketReceiver {
	
	public ConstructorControllerEntity link = null;
	private int offset = 24;
	private int length = 4;
	public BlockPos remote;
	
	public ConstructorCenterEntity(){
		//
	}
	
	public int getLength(){
		if(hasType()){
			return link.type.construction_length;
		}
		return length;
	}
	
	public int getRenderLength(){
		if(hasType()){
			return (link.type.construction_length * 2) + 1;
		}
		return (length * 2) + 1;
	}
	
	public float getRenderOffset(){
		if(hasType()){
			return link.type.construction_wheel_offset * 0.0625f;
		}
		return offset * 0.0625f;
	}

	public boolean isLinked(){
		return link == null;
	}

	public void link(BlockPos pos){
		remote = pos;
		link = (ConstructorControllerEntity)world.getTileEntity(pos);
		if(link != null){
			this.sendUpdate();
		}
		else{
			remote = null;
		}
	}

	public boolean hasType(){
		if(link != null){
			return !link.isTypeNull();
		}
		return false;
	}

	@Override
	public void processServerPacket(IPacket pkt){
		//
	}
	
	@Override
	public void processClientPacket(IPacket pkt){
		PacketTileEntityUpdate packet = (PacketTileEntityUpdate)pkt;
		if(packet.nbt.getBoolean("Linked")){
			int x = packet.nbt.getInteger("XX");
			int y = packet.nbt.getInteger("YY");
			int z = packet.nbt.getInteger("ZZ");
			remote = new BlockPos(x, y, z);
			link = (ConstructorControllerEntity)world.getTileEntity(remote);
		}
		else{
			remote = null;
			link = null;
		}
	}
	
	public void sendUpdate(){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setBoolean("Linked", remote != null);
		if(remote != null){
			nbt.setInteger("XX", remote.getX());
			nbt.setInteger("YY", remote.getY());
			nbt.setInteger("ZZ", remote.getZ());
		}
		ApiUtil.sendTileEntityUpdatePacket(world, pos, nbt, 256);
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
		compound.setBoolean("Linked", !(remote == null));
		if(remote != null){
			compound.setInteger("XX", remote.getX());
			compound.setInteger("YY", remote.getY());
			compound.setInteger("ZZ", remote.getZ());
		}
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		if(compound.getBoolean("Linked")){
			int x = compound.getInteger("XX");
			int y = compound.getInteger("YY");
			int z = compound.getInteger("ZZ");
			remote = new BlockPos(x, y, z);
			//link = (ConstructorControllerEntity)world.getTileEntity(remote);
		}
		else{
			remote = null;
			link = null;
		}
	}
	
}