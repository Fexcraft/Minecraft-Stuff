package net.fexcraft.mod.fvm.blocks;

import net.fexcraft.mod.fvm.data.Vehicle.VehicleData;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class ConstructorControllerEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate>, ITickable {
	
	public static final RGB GRAY = new RGB(128, 128, 128);
	public static final RGB DARKGRAY = new RGB(89, 89, 89);
	public static final RGB ORANGE = new RGB(194, 136, 0);
	public Button[] buttons = new Button[10];
	
	@Override
	public void update(){
		for(Button button : buttons){
			if(button.ticks > 0){
				button.ticks--;
				if(button.ticks >= 20){
					button.pressed = false;
					button.ticks = 0;
					this.sendUpdate();
				}
			}
		}
	}
	
	public ConstructorControllerEntity(){
		if(Static.side().isClient()){
			for(int i = 0; i < buttons.length; i++){
				buttons[i] = new Button(i == 0 ? RGB.GREEN : i == 2 ? RGB.RED : i == 1 ? ORANGE : RGB.WHITE);
			}
		}
		else{
			for(int i = 0; i < buttons.length; i++){
				buttons[i] = new Button();
			}
		}
	}
	
	public static class Button {
		public int ticks;
		public boolean state, pressed;
		public RGB color;
		public Button(){
			ticks = 0;
			state = true;
			color = null;
		}
		public Button(RGB object){
			color = object;
			state = true;
			pressed = false;
		}
	}
	
	public boolean linked;
	public VehicleData data = null;
	public float hitX, hitY, hitZ;
	
	public VehicleData getVehicleData(){
		return data;
	}

	public boolean isTypeNull(){
		return data == null;
	}

	@Override
	public void processServerPacket(PacketTileEntityUpdate pkt){
		//
	}

	@Override
	public void processClientPacket(PacketTileEntityUpdate packet){
		if(packet.nbt.hasKey("Linked")){
			linked = packet.nbt.getBoolean("Linked");
		}
		if(packet.nbt.hasKey("VehicleType")){
			data = VehicleData.fromNBT(packet.nbt);
			Print.debug(packet.nbt);
		}
		else{
			data = null;
		}
		if(packet.nbt.hasKey("buttons")){
			NBTTagList list = packet.nbt.getTagList("buttons", 0);
			for(int i = 0; i < list.tagCount(); i++){
				NBTTagCompound nbt = list.getCompoundTagAt(i);
				buttons[i].pressed = nbt.getBoolean("pressed");
				buttons[i].state = nbt.getBoolean("state");
			}
		}
		Print.debug(data == null ? "TYPE IS NULL" : data.write(null).toString());
	}
	
	public void sendUpdate(){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setBoolean("Linked", linked);
		this.refreshButtons();
		if(data != null){
			data.write(nbt);
		}
		NBTTagList list = new NBTTagList();
		for(Button button : buttons){
			NBTTagCompound com = new NBTTagCompound();
			com.setBoolean("pressed", button.ticks > 0);
			com.setBoolean("state", button.state);
			list.appendTag(com);
		}
			nbt.setTag("buttons", list);
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
		compound.setBoolean("Linked", linked);
		if(data != null){
			data.write(compound);
		}
		NBTTagList list = new NBTTagList();
		for(Button button : buttons){
			NBTTagCompound com = new NBTTagCompound();
			com.setBoolean("pressed", button.ticks > 0);
			com.setBoolean("state", button.state);
			list.appendTag(com);
		}
		compound.setTag("Buttons", list);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		linked = compound.getBoolean("Linked");
		if(compound.hasKey("Buttons")){
			NBTTagList list = compound.getTagList("buttons", 0);
			for(int i = 0; i < list.tagCount(); i++){
				NBTTagCompound nbt = list.getCompoundTagAt(i);
				buttons[i].pressed = nbt.getBoolean("pressed");
				buttons[i].state = nbt.getBoolean("state");
			}
		}
		if(compound.hasKey("VehicleType")){
			data = VehicleData.fromNBT(compound);
		}
		else{
			this.refreshButtons();
		}
	}

	public void onButtonPress(int id){
		Print.debugChat("Button " + id + " Pressed!");
		if(!buttons[id].state){
			return;
		}
		buttons[id].ticks = 1;
		switch(id){
			case 0:
				//this.spawnItem();
				break;
			case 1:
				//this.spawnEntity();
				break;
			default:
				return;
		}
	}

	public void refreshButtons(){
		if(data == null){
			for(Button button : buttons){
				button.state = false;
			}
			return;
		}
		buttons[0].state = data.readyToSpawn;
		buttons[1].state = data.readyToSpawn;
		buttons[2].state = true;
		buttons[3].state = false;
		buttons[4].state = false;
		buttons[5].state = false;
		buttons[6].state = false;
		buttons[7].state = false;
		buttons[8].state = false;
		buttons[9].state = true;
	}
	
}