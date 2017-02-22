package net.fexcraft.mod.fvm.blocks;

import net.fexcraft.mod.fvm.data.LoadedIn;
import net.fexcraft.mod.fvm.data.VehicleType;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class DisplayBlockEntity extends TileEntity implements IPacketReceiver {

	private VehicleType type;
	private byte rotation;
	
	public DisplayBlockEntity(){
		type = null;
		rotation = 0;
	}

	public void rotate(EntityPlayer p){
		rotation++;
		if(rotation >= 36){
			rotation = 0;
		}
		this.sendUpdate("rotation");
	}

	@Override
	public void processServerPacket(IPacket pkt){
		//
	}

	@Override
	public void processClientPacket(IPacket pkt){
		PacketTileEntityUpdate packet = (PacketTileEntityUpdate)pkt;
		if(packet.nbt.hasKey("VehicleType")){
			type = new VehicleType(LoadedIn.TILE, JsonUtil.getFromString(packet.nbt.getString("VehicleType")).getAsJsonObject());
			FvmResources.loadVehicleModel(type);
			Print.debug(packet.nbt.getString("VehicleType"));
		}
		if(packet.nbt.hasKey("Rotation")){
			this.rotation = packet.nbt.getByte("Rotation");
			if(rotation >= 36){
				rotation = 0;
			}
		}
	}

	public void setType(VehicleType vehc){
		type = vehc;
		this.sendUpdate("vehicle");
	}
	
	public void sendUpdate(String s){
		NBTTagCompound nbt = new NBTTagCompound();
		switch(s){
			case "vehicle":
				nbt.setString("VehicleType", type.save(null).toString());
				break;
			case "rotation":
				nbt.setByte("Rotation", rotation);
				break;
			case "all":
			default:
				nbt.setString("VehicleType", type.save(null).toString());
				nbt.setByte("Rotation", rotation);
				break;
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
		if(type != null){
			compound.setString("VehicleType", type.save(null).toString());
		}
		compound.setByte("ModelRotation", rotation);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		if(compound.hasKey("VehicleType")){
			type = new VehicleType(LoadedIn.TILE, JsonUtil.getFromString(compound.getString("VehicleType")).getAsJsonObject());
			FvmResources.loadVehicleModel(type);
		}
		if(compound.hasKey("ModelRotation")){
			rotation = compound.getByte("ModelRotation");
		}
	}

	public boolean hasType(){
		return !(type == null);
	}

	public VehicleType getType(){
		return type;
	}

	public int getRotation(){
		return rotation;
	}
	
}