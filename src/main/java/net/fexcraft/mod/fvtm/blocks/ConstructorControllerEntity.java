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
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class ConstructorControllerEntity {
	
	public static class Server extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate>, ITickable {
		
		private LandVehicleData vehicledata;
		private byte lift = 0, selection = 0, scroll = 0;
		private int lc = -1;
		private double liftstate = 0;
		private float brush = 0.01f;
		private static final byte text = 8;
		private BlockPos center;
		private String window = "null";//Don't save/sync this! Should reset on every world load.
		
		public void setData(LandVehicleItem item, ItemStack stack){
			this.updateLandVehicle(item.getLandVehicle(stack));
			this.updateScreen(null);
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
			this.updateLift();
		}

		@Override
		public void update(){
			if(lift != 0){
				if(lc == Time.getSecond()){
					return;
				}
				lc = Time.getSecond();
				this.liftstate += -(lift * 0.01);
				if(liftstate <= 0){
					liftstate = 0;
					lift = 0;
					this.updateLift();
					return;
				}
				if(liftstate >= 4.5f){
					liftstate = 4.5f;
					lift = 0;
					this.updateLift();
					return;
				}
				this.updateLiftState();
			}
			return;
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
			compound.setDouble("LiftState", liftstate);
			compound.setByte("Lift", lift);
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
			compound.setDouble("LiftState", liftstate);
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
								this.updateScreen("colour_edit_primary");
								break;
							}
							case 3:{
								this.updateScreen("colour_edit_secondary");
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
								if(Static.side().isServer()){
									NBTTagCompound compound = new NBTTagCompound();
									compound.setString("task", "crash_menu_request");
									compound.setString("Message", "Sorry, this feature is disabled on Servers ;)");
									ApiUtil.sendTileEntityUpdatePacket(this, compound, 256);
								}
								else{
									Static.halt();
								}
							}
							case 3:{
								this.updateScreen("null");
							}
						}
					}
					break;
				}
				case "colour_edit_primary":
				case "colour_edit_secondary":{
					String str = window.split("_")[2];
					RGB rgb = str.equals("primary") ? this.vehicledata.getPrimaryColor() : this.vehicledata.getSecondaryColor();
					if(button.isReturn()){
						this.updateScreen("colour_menu");
					}
					if(button.isHome()){
						this.updateScreen("main");
					}
					if(button.isReset()){
						switch(selection){
							case 1:{
								brush = 0.01f;
								break;
							}
							case 2: case 3: {
								rgb.red   = 1f;
								break;
							}
							case 4: case 5: {
								rgb.green = 1f;
								break;
							}
							case 6: case 7: {
								rgb.blue  = 1f;
								break;
							}
						}
						rgb.quickValidate();
						this.updateScreen(window, false);
						this.updateColour(str, rgb);
					}
					if(button.isSelect()){
						//guess, nothing to select here?
					}
					if(button.isHorizontalArrow()){
						switch(selection){
							case 1:{
								brush += button.isLeftArrow() ? -0.011f : 0.011f;
								brush = RGB.truncateS(brush);
								if(brush <= 0){ brush = 0f;};
								break;
							}
							case 3:{
								rgb.red   += button.isLeftArrow() ? -brush : brush;
								break;
							}
							case 5:{
								rgb.green += button.isLeftArrow() ? -brush : brush;
								break;
							}
							case 7:{
								rgb.blue  += button.isLeftArrow() ? -brush : brush;
								break;
							}
						}
						rgb.quickValidate();
						this.updateScreen(window, false);
						this.updateColour(str, rgb);
					}
					if(button.isVerticalArrow()){
						this.updateSelection(button == ARROW_UP ? -1 : 1);
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
						compound.setString("Text1", "Vehicle Settings");
						compound.setString("Text2", "Colour Settings");
						compound.setString("Text3", "Part Settings");
						compound.setString("Text4", "- - - - - - - - - -");
						compound.setString("Text5", "Constructor Settings");
						compound.setString("Text6", "Recycle Vehicle");
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
				case "colour_edit_primary":
				case "colour_edit_secondary":{
					String str = window.split("_")[2];
					RGB rgb = str.equals("primary") ? this.vehicledata.getPrimaryColor() : this.vehicledata.getSecondaryColor();
					compound.setString("Text0", "Color Editor (" + str + ")");
					compound.setString("Text1", "&9Brush: &7" + brush);
					compound.setString("Text2", "&cRed:");
					compound.setString("Text3", "{ " + rgb.red   + " }f  [~" + floatTo256Int(rgb.red)   + "]i");
					compound.setString("Text4", "&aGreen:");
					compound.setString("Text5", "{ " + rgb.green + " }f  [~" + floatTo256Int(rgb.green) + "]i");
					compound.setString("Text6", "&3Blue:");
					compound.setString("Text7", "{ " + rgb.blue  + " }f  [~" + floatTo256Int(rgb.blue)  + "]i");
					break;
				}
			}
			return compound;
		}
		
		private int floatTo256Int(float f){
			return MathHelper.floor(f * 255);
		}
		
		private static final void fill(int j, NBTTagCompound compound){
			for(int i = j; i < text; i++){
				compound.setString("Text" + i, "");
			}
		}
		
		private void updateScreen(String string){
			this.updateScreen(string, true);
		}
		
		private void updateScreen(String string, boolean selres){
			if(string != null){
				window = string;
			}
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("task", "update_screen");
			ApiUtil.sendTileEntityUpdatePacket(this, this.getWindowUpdate(compound), 256);
			if(selres){
				this.updateSelection(-10);
			}
		}
		
		private void updateLiftState(){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("task", "update_liftstate");
			compound.setDouble("LiftState", liftstate);
			ApiUtil.sendTileEntityUpdatePacket(this, compound, 256);
		}
		
		private void updateLift(){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("task", "update_lift");
			compound.setByte("Lift", lift);
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
		
		private void updateColour(String str, RGB rgb){
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setString("task", "update_colour");
			nbt.setString("type", str);
			nbt = rgb.writeToNBT(nbt, null);
			ApiUtil.sendTileEntityUpdatePacket(this, nbt, 256);
		}
		
	}
	
	public static class Client extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate>{
		
		public static LandVehicleData vehicledata;//TODO temporary static, fix later;
		public static double liftstate = 0;//TODO temporary static, fix later;
		public String[] text = new String[8];
		public byte selection = -1, lift = 0;
		
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
					break;
				}
				case "update_screen":{
					this.parseScreen(pkt.nbt);
					break;
				}
				case "update_liftstate":{
					this.liftstate = pkt.nbt.getDouble("LiftState");
					break;
				}
				case "update_lift":{
					this.lift = pkt.nbt.getByte("Lift");
					break;
				}
				case "update_selection":{
					this.selection = pkt.nbt.getByte("Selection");
					break;
				}
				case "crash_menu_request":{
					Print.chat(net.minecraft.client.Minecraft.getMinecraft().player, pkt.nbt.getString("Message"));
					Static.halt();
					break;
				}
				case "update_colour":{
					RGB rgb = pkt.nbt.getString("type").equals("primary") ? this.vehicledata.getPrimaryColor() : this.vehicledata.getSecondaryColor();
					rgb.readFromNBT(pkt.nbt, null);
					break;
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
			this.lift = compound.getByte("Lift");
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