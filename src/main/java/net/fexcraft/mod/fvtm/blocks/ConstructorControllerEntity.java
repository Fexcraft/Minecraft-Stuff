package net.fexcraft.mod.fvtm.blocks;

import static net.fexcraft.mod.fvtm.blocks.ConstructorController.Button.*;

import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleData;
import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleItem;
import net.fexcraft.mod.fvtm.auto.GenericLandVehicleData;
import net.fexcraft.mod.fvtm.blocks.ConstructorController.Button;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class ConstructorControllerEntity {
	
	public static class Server extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate>, ITickable {
		
		private LandVehicleData vehicledata;
		private byte lift = 0, selection = 0, scroll;
		private float liftstate = 0;
		private static final byte text = 8;
		private BlockPos center;
		private String window = "null";//Don't save/sync this! Should reset on every world load.
		
		public void setData(LandVehicleItem item, ItemStack stack){
			this.updateLandVehicle(item.getLandVehicle(stack));
			this.updateScreen();
		}

		public LandVehicleData getData(){
			return this.vehicledata;
		}
		
		public BlockPos getCenter(){
			return center;
		}
		
		public byte getLift(){
			return lift;
		}

		public void addLift(int i){
			this.lift += i;
			if(this.lift > 10){
				this.lift = 10;
			}
			if(this.lift < -10){
				this.lift = -10;
			}
		}

		@Override
		public void update(){
			//TODO
		}
		
		@Override
		public void processServerPacket(PacketTileEntityUpdate pkt){
			
		}
		
		@Override
		public SPacketUpdateTileEntity getUpdatePacket(){
			return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), this.getUpdateTag());
		}
		
		@Override
		public NBTTagCompound getUpdateTag(){
			NBTTagCompound compound = super.writeToNBT(new NBTTagCompound());
			if(this.vehicledata != null){
				compound = this.vehicledata.writeToNBT(compound);
			}
			compound.setFloat("LiftState", liftstate);
			compound = getWindowUpdate(compound);
			compound.setByte("Selection", selection);
			return compound;
		}

		@Override
		public NBTTagCompound writeToNBT(NBTTagCompound compound){
			super.writeToNBT(compound);
			if(this.vehicledata != null){
				compound = vehicledata.writeToNBT(compound);
			}
			compound.setByte("Lift", lift);
			compound.setFloat("LiftState", liftstate);
			//compound.setByte("Selection", selection);
			//compound.setByte("Scroll", scroll);
			if(center != null){
				compound.setLong("Center", center.toLong());
			}
			return compound;
		}
		
		@Override
		public void readFromNBT(NBTTagCompound compound){
			super.readFromNBT(compound);
			if(compound.hasKey(LandVehicleItem.NBTKEY)){
				this.vehicledata = new GenericLandVehicleData().readFromNBT(compound);
			}
			this.lift = compound.getByte("Lift");
			this.liftstate = compound.getFloat("LiftState");
			//this.selection = compound.getByte("Selection");
			//this.scroll = compound.getByte("Scroll");
			if(compound.hasKey("Center")){
				this.center = BlockPos.fromLong(compound.getLong("Center"));
			}
		}

		public void onButtonPress(Button button){
			switch(window){
				case "main": case "null":{
					if(this.vehicledata == null){
						//
					}
					else{
						if(button.isVerticalArrow()){
							this.updateSelection(button == ARROW_UP ? -1 : 1);
						}
						else if(button.isSelect()){
							switch(selection){
								case 0:{
									this.updateScreen("info");
									break;
								}
								case 2:{
									this.updateScreen("colour_menu");
									break;
								}
								case 7:{
									this.updateScreen("crash");
									break;
								}
								case -1:
								default:
									return;
							}
						}
					}
					break;
				}
				case "info":{
					if(button.isHome() || button.isReturn()){
						this.updateScreen("main");
					}
					break;
				}
				case "colour_menu":{
					if(button.isHome() || button.isReturn()){
						this.updateScreen("main");
					}
					if(button.isVerticalArrow()){
						this.updateSelection(button == ARROW_UP ? -1 : 1);
					}
					if(button.isSelect()){
						switch(selection){
							case 2:{
								//TODO
								break;
							}
							case 3:{
								//TODO
								break;
							}
							case 4: case 5:{
								this.updateScreen("colour_unavailable");
								break;
							}
							case 7:{
								this.updateScreen("main");
								break;
							}
						}
					}
					break;
				}
				case "colour_unavailable":{
					if(button.isHome()){
						this.updateScreen("main");
					}
					if(button.isReturn()){
						this.updateScreen("colour_menu");
					}
					break;
				}
				case "crash":{
					if(button.isReturn() || button.isHome()){
						this.updateScreen("main");
					}
					if(button.isVerticalArrow()){
						this.updateSelection(button == ARROW_UP ? -1 : 1);
					}
					if(button.isSelect()){
						switch(selection){
							case 2: case 4:{
								Static.halt();
							}
							case 3:{
								this.updateScreen("null");
							}
						}
					}
					break;
				}
				default:{
					if(button.isHome() || button.isReturn()){
						this.updateScreen("main");
					}
					break;
				}
			}
		}
		
		private final NBTTagCompound getWindowUpdate(NBTTagCompound compound){
			switch(window){
				case "main": case "null":{
					if(vehicledata == null){
						compound.setString("Text0", "No Vehicle.");
						compound.setString("Text1", "_");
						fill(2, compound);
						selection = -1;
					}
					else{
						compound.setString("Text0", ">> Welcome!");
						compound.setString("Text1", "View Vehicle Details");
						compound.setString("Text2", "Edit Vehicle Colour");
						compound.setString("Text3", "View Missing Parts");
						compound.setString("Text4", "View Installed Parts");
						compound.setString("Text5", "Recycle Vehicle");
						compound.setString("Text6", "- - - - - - - - - -");
						compound.setString("Text7", "Crash Game");
					}
					break;
				}
				case "info":{
					compound.setString("Text0", "Welcome to the FVTM");
					compound.setString("Text1", "Vehicle Constructor!");
					compound.setString("Text2", "");
					compound.setString("Text3", "You can use this Block to");
					compound.setString("Text4", "build FVTM Land Vehicles.");
					fill(5, compound);
					break;
				}
				case "colour_menu":{
					compound.setString("Text0", "Vehicle Color Editor");
					compound.setString("Text1", "- - - - - - - - - -");
					compound.setString("Text2", "Primary");
					compound.setString("Text3", "Secondary");
					compound.setString("Text4", "Tertiary");
					compound.setString("Text5", "Quaternary");
					compound.setString("Text6", "- - - - - - - - - -");
					compound.setString("Text7", "Main Menu");
					break;
				}
				case "colour_unavailable":{
					compound.setString("Text0", "- - - - - - - - - -");
					compound.setString("Text1", "Color Unavailable");
					compound.setString("Text2", "- - - - - - - - - -");
					fill(3, compound);
					break;
				}
				case "crash":{
					compound.setString("Text0", "Are you sure?");
					compound.setString("Text1", "- - - - - - - - - -");
					compound.setString("Text2", "Yes!");
					compound.setString("Text3", "No.");
					compound.setString("Text4", "I'd like to consult my Doc.");
					compound.setString("Text5", "- - - - - - - - - -");
					fill(6, compound);
					break;
				}
			}
			return compound;
		}
		
		private static final void fill(int j, NBTTagCompound compound){
			for(int i = j; i < text; i++){
				compound.setString("Text" + i, "");
			}
		}
		
		private void updateScreen(){
			this.updateScreen(null);
		}
		
		private void updateScreen(String string){
			if(string != null){
				window = string;
			}
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("task", "update_screen");
			ApiUtil.sendTileEntityUpdatePacket(this, this.getWindowUpdate(compound), 256);
			this.updateSelection(-10);
		}
		
		private void updateLiftState(){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("task", "update_liftstate");
			compound.setFloat("LiftState", liftstate);
			ApiUtil.sendTileEntityUpdatePacket(this, compound, 256);
		}
		
		private void updateSelection(int i){
			if(i == -10){ this.selection = -1; }
			else{
				this.selection += i;
				if(selection < -1){ selection = -1; }
				if(selection > 7){ selection = 7; }
			}
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("task", "update_selection");
			compound.setByte("Selection", selection);
			ApiUtil.sendTileEntityUpdatePacket(this, compound, 256);
		}
		
		private void updateLandVehicle(LandVehicleData data){
			this.vehicledata = data;
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setString("task", "update_vehicledata");
			ApiUtil.sendTileEntityUpdatePacket(this, vehicledata == null ? nbt : vehicledata.writeToNBT(nbt), 256);
		}
		
	}
	
	public static class Client extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate>{
		
		public LandVehicleData vehicledata;
		public float liftstate;
		public String[] text = new String[8];
		public byte selection = -1;
		
		@Override
		public void processClientPacket(PacketTileEntityUpdate pkt){
			if(!pkt.nbt.hasKey("task")){
				return;
			}
			switch(pkt.nbt.getString("task")){
				case "update_vehicledata":{
					if(pkt.nbt.hasKey(LandVehicleItem.NBTKEY)){
						this.vehicledata = new GenericLandVehicleData().readFromNBT(pkt.nbt);
					}
					else{
						Print.debug("NO VEHICLE NBT KEY FOUND, RESETTING!");
						this.vehicledata = null;
					}
				}
				case "update_screen":{
					this.parseScreen(pkt.nbt);
				}
				case "update_liftstate":{
					this.liftstate = pkt.nbt.getFloat("ListState");
				}
				case "update_selection":{
					this.selection = pkt.nbt.getByte("Selection");
				}
			}
			Print.debug(pkt.nbt);
		}
		
		@Override
		public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
			this.readFromNBT(pkt.getNbtCompound());
	    }
		
		@Override
		public void readFromNBT(NBTTagCompound compound){
			super.readFromNBT(compound);
			if(compound.hasKey(LandVehicleItem.NBTKEY)){
				this.vehicledata = new GenericLandVehicleData().readFromNBT(compound);
			}
			this.liftstate = compound.getFloat("LiftState");
			this.parseScreen(compound);
			this.selection = compound.getByte("Selection");
		}
		
		private void parseScreen(NBTTagCompound compound){
			for(int i =0; i < text.length; i++){
				text[i] = compound.getString("Text" + i);
			}
		}
		
	}
	
	public static final RGB GRAY = new RGB(128, 128, 128);
	public static final RGB DARKGRAY = new RGB(89, 89, 89);
	public static final RGB ORANGE = new RGB(194, 136, 0);
	
}