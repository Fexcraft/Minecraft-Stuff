package net.fexcraft.mod.fvtm.blocks;

import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleData;
import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleItem;
import net.fexcraft.mod.fvtm.auto.GenericLandVehicleData;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.TextComponentString;

public class ConstructorControllerEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate>{
	
	public static final RGB GRAY = new RGB(128, 128, 128);
	public static final RGB DARKGRAY = new RGB(89, 89, 89);
	public static final RGB ORANGE = new RGB(194, 136, 0);
	public byte[] state = new byte[]{0,0,0,0,0,0,0,0,0,0};
	public TextComponentString[] text = new TextComponentString[8];
	public float lift = 0;
	//
	private LandVehicleData vehicledata;
	private boolean linked;
	//public float hitX, hitY, hitZ;
	
	public ConstructorControllerEntity(){
		for(int i = 0; i < 8; i++){
			text[i] = new TextComponentString(">");
		}
	}
	
	public LandVehicleData getData(){
		return this.vehicledata;
	}
	
	public void setData(LandVehicleItem item, ItemStack stack){
		this.vehicledata = item.getLandVehicle(stack);
	}
	
	public boolean isLinked(){
		return linked;
	}

	public void onButtonPress(int id){
		switch(id){
			//TODO
		}
	}

	public void sendUpdate(){
		//TODO
	}

	@Override
	public void processServerPacket(PacketTileEntityUpdate pkt){
		switch(pkt.nbt.getString("task")){
		
		}
	}

	@Override
	public void processClientPacket(PacketTileEntityUpdate pkt){
		switch(pkt.nbt.getString("task")){
			case "bp":
				state = stateFromString(pkt.nbt.getString("s"));
				break;
		}
	}

	private byte[] stateFromString(String string){
		byte[] arr = new byte[string.length()];
		char[] car = string.toCharArray();
		for(int i = 0; i < arr.length; i++){
			arr[i] = (byte)(car[i] == '0' ? 0 : 1);
		}
		return arr;
	}

	public void setState(String string){
		this.state = stateFromString(string);
	}

	public byte[] getStateArray(){
		return state;
	}
	
	//
	
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
		compound.setBoolean("Linked", linked);
		if(vehicledata != null){
			vehicledata.writeToNBT(compound);
		}
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		linked = compound.getBoolean("Linked");
		if(compound.hasKey("VehicleType")){
			vehicledata = new GenericLandVehicleData().readFromNBT(compound);
		}
	}
	
}