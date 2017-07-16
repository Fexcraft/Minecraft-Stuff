package net.fexcraft.mod.fvtm.blocks;

import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleData;
import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleItem;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class ConstructorControllerEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate>{
	
	public static final RGB GRAY = new RGB(128, 128, 128);
	public static final RGB DARKGRAY = new RGB(89, 89, 89);
	public static final RGB ORANGE = new RGB(194, 136, 0);
	public byte[] state = new byte[]{0,0,0,0,0,0,0,0,0,0};
	public float lift = 0;
	//
	private LandVehicleData vehicledata;
	private boolean linked;
	public float hitX, hitY, hitZ;
	
	public ConstructorControllerEntity(){
		
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
	
}