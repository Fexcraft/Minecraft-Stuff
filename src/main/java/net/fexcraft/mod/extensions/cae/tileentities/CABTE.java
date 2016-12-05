package net.fexcraft.mod.extensions.cae.tileentities;

import com.google.gson.JsonObject;

import net.fexcraft.mod.extensions.cae.util.CAEUtil;
import net.fexcraft.mod.extensions.cae.util.Type;
import net.fexcraft.mod.frsm.util.SSC;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketJsonObject;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class CABTE extends TileEntity implements IPacketReceiver {
	
	private char[] array;
	private Type type;
	private int[][] arr;
	public boolean sync;
	
	public int[][] getArr(){
		if(arr == null){
			arr = CAEUtil.intXZfromCharArray(type, array);
		}
		return arr;
	}
	
	public void setArray(String string){
		setArray(string.toCharArray());
	}
	
	public void setArray(char[] carr){
		array = carr;
	}
	
	public CABTE(){
		type = Type.x16;
		array = type.getEmptyArray();
		arr = null;
		sync = false;
	}
	
	public void isSynchronized(){
		if(!sync){
			request();
		}
	}
	
	public void request(){
		JsonObject obj = JsonUtil.getJsonForPacket("cae");
		obj.addProperty("task", "request_nbt_update");
		obj.addProperty("x", pos.getX());
		obj.addProperty("y", pos.getY());
		obj.addProperty("z", pos.getZ());
		obj.addProperty("dim", worldObj.provider.getDimension());
		SSC.getPacketHandler().sendToServer(new PacketJsonObject(obj));
		sync = true;
	}

	public Type getType(){
		return type;
	}
	
	public void setType(String string){
		setType(Type.fromString(string));
	}
	
	public void setType(Type tp){
		type = tp;
	}
	
	public String getArrayAsString(){
		return new String(array);
	}
	
	public char[] getArray(){
		return array;
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		nbt.setString("frsm_cae_type", type.toString());
		nbt.setString("frsm_cae_array", new String(array));
		return nbt;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		type = Type.fromString(nbt.getString("frsm_cae_type"));
		array = nbt.getString("frsm_cae_array").toCharArray();
	}
	
	@Override
	public NBTTagCompound getUpdateTag(){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt = this.writeToNBT(nbt);
		return nbt;
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket(){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt = this.writeToNBT(nbt);
		return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), nbt);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
		this.readFromNBT(pkt.getNbtCompound());
	}
	
	@Override
	public void processServerPacket(IPacket pkt){}
	
	@Override
	public void processClientPacket(IPacket pkt){
		PacketTileEntityUpdate packet = (PacketTileEntityUpdate)pkt;
		if(packet.nbt.hasKey("array")){
			type = Type.fromString(packet.nbt.getString("type"));
			array = packet.nbt.getString("array").toCharArray();
			arr = null;
		}
	}

	/*@Override
	public void update(){
		if(!sync){
			resync();
			sync = true;
		}
	}*/
}