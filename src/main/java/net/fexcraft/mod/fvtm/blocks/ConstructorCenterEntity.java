package net.fexcraft.mod.fvtm.blocks;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity.*;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class ConstructorCenterEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {
	
	private ConstructorControllerEntity.Client link = null;
	private final int offset = 24;
	private final int length = 4;
	private BlockPos constructor;
	
	public void link(BlockPos pos){
		if(world.isRemote){
			try{
				link = (Client)world.getTileEntity(pos);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		else{
			this.constructor = pos;
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setLong("pos", this.constructor.toLong());
			nbt.setBoolean("reset", false);
			ApiUtil.sendTileEntityUpdatePacket(world, this.pos, nbt);
			//remind controller we're here
			((Server)world.getTileEntity(constructor)).setCenter(this.pos);
		}
	}
	
	@Override
	public void processClientPacket(PacketTileEntityUpdate packet){
		Print.debug("SYNC -> CK");
		if(packet.nbt.hasKey("pos")){
			this.constructor = BlockPos.fromLong(packet.nbt.getLong("pos"));
			this.link(this.constructor);
			Print.debug("SYNC -> OK");
		}
		if(packet.nbt.hasKey("reset") && packet.nbt.getBoolean("reset")){
			this.constructor = null; this.link = null;
			Print.chat(net.minecraft.client.Minecraft.getMinecraft().player, "Center Block at " + pos.toString() + " resseted!");
			Print.debug("SYNC -> RS");
		}
	}
	
	public int getLength(){
		if(link != null && link.vehicledata != null){
			return link.vehicledata.getVehicle().getConstructionLength();
		}
		return length;
	}
	
	public int getRenderLength(){
		if(link != null && link.vehicledata != null){
			return (link.vehicledata.getVehicle().getConstructionLength() * 2) + 1;
		}
		return (length * 2) + 1;
	}
	
	public float getRenderOffset(){
		if(link != null && link.vehicledata != null){
			return link.vehicledata.getVehicle().getWheelConstructorOffset() * 0.0625f;
		}
		return offset * 0.0625f;
	}
	
	public ConstructorControllerEntity.Client getLink(){
		return link;
	}

	public double getLiftState(){
		return link == null ? 0 : link.liftstate;
	}

	public VehicleData getVehicleData(){
		return link == null ? null : link.vehicledata == null ? null : link.vehicledata;
	}

	public BlockPos getConstructor(){
		return constructor;
	}
	
	//
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket(){
		return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), this.getUpdateTag());
	}
	
	@Override
	public NBTTagCompound getUpdateTag(){
		return this.writeToNBT(new NBTTagCompound());
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		if(constructor != null){
			compound.setLong("Constructor", constructor.toLong());
		}
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		if(compound.hasKey("Constructor")){
			this.constructor = BlockPos.fromLong(compound.getLong("Constructor"));
		}
	}
	
}