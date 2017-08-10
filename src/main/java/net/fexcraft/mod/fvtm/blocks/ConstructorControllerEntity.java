package net.fexcraft.mod.fvtm.blocks;

import static net.fexcraft.mod.fvtm.blocks.ConstructorController.Button.*;

import java.util.Map.Entry;

import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleData;
import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleItem;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.blocks.ConstructorController.Button;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ConstructorControllerEntity {
	
	public static class Server extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate>, ITickable {
		
		private LandVehicleData vehicledata;
		private PartData partdata;
		private byte lift = 0, selection = 0, scroll = 0;
		private int lc = -1;
		private double liftstate = 0;
		private float brush = 0.01f;
		private static final byte text = 8;
		private BlockPos center;
		private String window = "null";//Don't save/sync this! Should reset on every world load.
		private int sel;
		
		public void setData(LandVehicleItem item, ItemStack stack){
			this.updateLandVehicle(item.getLandVehicle(stack));
			this.updateScreen(null);
		}

		public LandVehicleData getData(){
			return this.vehicledata;
		}

		public void setPartData(PartData data){
			if(this.partdata != null){
				ItemStack stack = this.partdata.getPart().getItemStack(partdata);
				EntityItem entity = new EntityItem(world, this.pos.getX(), this.pos.getY() + 1.5f, this.pos.getZ(), stack);
				world.spawnEntity(entity);
				this.partdata = null;
			}
			this.partdata = data;
			//this.updateLandVehicle(null);
			if(this.window.equals("part_add_new")){
				this.updateScreen("part_view_cache");
			}
		}
		
		public PartData getPartData(){
			return this.partdata;
		}
		
		public String getScreenId(){
			return window;
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
			if(partdata != null){
				compound = this.partdata.writeToNBT(compound);
			}
			return compound;
		}
		
		@Override
		public void readFromNBT(NBTTagCompound compound){
			super.readFromNBT(compound);
			this.vehicledata = Resources.getLandVehicleData(compound);
			this.liftstate = compound.getFloat("LiftState");
			//this.selection = compound.getByte("Selection");
			//this.scroll = compound.getByte("Scroll");
			if(compound.hasKey("Center")){
				this.center = BlockPos.fromLong(compound.getLong("Center"));
			}
			this.partdata = Resources.getPartData(compound);
		}

		public void onButtonPress(Button button, EntityPlayer player){
			if(button.isHome()){
				this.updateScreen("main");
			}
			else if(button.ID < 2){
				if(button.ID < 0){
					return;
				}
				else if(button.ID == 0){
					ItemStack stack = vehicledata.getVehicle().getItemStack(vehicledata);
					EntityItem item = new EntityItem(world);
					item.setItem(stack);
					item.setPosition(this.pos.getX() + 0.5f, this.pos.getY(), this.pos.getZ() + 0.5f);
					world.spawnEntity(item);
					this.vehicledata = null;
					this.updateLandVehicle(null);
				}
				else{
					try{
						Entity ent = (Entity)Class.forName("com.flansmod.fvtm.LandVehicle").getConstructor(World.class, double.class, double.class, double.class, int.class, LandVehicleData.class)
								.newInstance(world, pos.getX() + 0.5d, pos.getY(), pos.getZ() + 0.5d, this.getBlockMetadata(), vehicledata);//TODO center position
						world.spawnEntity(ent);
						this.vehicledata = null;
						this.updateLandVehicle(null);
						
						this.liftstate = 0;
						this.updateLiftState();
						this.lift = 0;
						this.updateLift();
						this.updateScreen("main");
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
			else if(window.startsWith("attr")){
				//TODO
			}
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
								case 3:{
									this.updateScreen("part_menu");
									break;
								}
								case 5:{
									this.updateScreen("constructor_menu");
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
					if(button.isReturn()){
						this.updateScreen("main");
					}
					break;
				}
				case "colour_menu":{
					if(button.isReturn()){
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
					if(button.isReturn()){
						this.updateScreen("colour_menu");
					}
					break;
				}
				case "crash":{
					if(button.isReturn()){
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
				case "part_menu":{
					if(button.isReturn()){
						this.updateScreen("main");
					}
					if(button.isVerticalArrow()){
						this.updateSelection(button == ARROW_UP ? -1 : 1);
					}
					if(button.isSelect()){
						switch(selection){
							case 2:{
								this.updateScreen("part_view_installed");
								break;
							}
							case 3:{
								this.updateScreen("part_view_required");
								break;
							}
							case 5:{
								if(partdata != null){
									Print.chat(player, "Please drop the current part first.");
								}
								else{
									this.updateScreen("part_add_new");
								}
								break;
							}
							case 6:{
								this.updateScreen("part_view_cache");
								break;
							}
							case 7:{
								if(partdata == null){
									Print.chat(player, "No part in constructor to drop.");
								}
								else{
									world.spawnEntity(new EntityItem(world, this.pos.getX(), this.pos.getY() + 1.5f, this.pos.getZ(), this.partdata.getPart().getItemStack(partdata)));
									this.partdata = null;
									Print.chat(player, "Cache cleared.");
								}
								break;
							}
						}
					}
					break;
				}
				case "part_add_new":{
					if(button.isReturn()){
						this.updateScreen("part_menu");
					}
					break;
				}
				case "part_view_cache":{
					if(button.isReturn()){
						this.updateScreen("part_menu");
					}
					if(button.isVerticalArrow()){
						this.updateSelection(button == ARROW_UP ? -1 : 1);
					}
					if(button.isSelect()){
						switch(selection){
							case 4:{
								
								break;
							}
							case 5:{
															
								break;
							}
							case 6:{
								
								break;
							}
							case 7:{
								this.updateScreen("part_cache_install");
								break;
							}
						}
					}
					break;
				}
				case "part_cache_install":{
					if(button.isReturn()){
						this.updateScreen("part_view_cache");
					}
					if(button.isVerticalArrow()){
						this.updateSelection(button == ARROW_UP ? -1 : 1, true);
					}
					if(button.isSelect()){
						if(scroll + selection >= partdata.getPart().getCategories().size()){
							return;
						}
						if(vehicledata.getInstalledParts().contains(partdata.getPart().getCategories().get(scroll + selection))){
							Print.chat(player, "Part of that category already installed.");
							return;
						}
						if(this.partdata.getPart().canInstall(partdata.getPart().getCategories().get(scroll + selection), vehicledata, player)){
							this.vehicledata.installPart(partdata.getPart().getCategories().get(scroll + selection), partdata);
							this.partdata = null;
							this.updateLandVehicle(null);
							this.updateScreen("part_menu");
						}
					}
					break;
				}
				case "part_view_required":{
					if(button.isReturn()){
						this.updateScreen("part_menu");
					}
					if(button.isVerticalArrow()){
						this.updateSelection(button == ARROW_UP ? -1 : 1, true);
					}
					break;
				}
				case "part_view_installed":{
					if(button.isReturn()){
						this.updateScreen("part_menu");
					}
					if(button.isVerticalArrow()){
						this.updateSelection(button == ARROW_UP ? -1 : 1, true);
					}
					if(button.isSelect()){
						PartData data = vehicledata.getParts().values().toArray(new PartData[]{})[selection + scroll];
						if(data != null){
							this.sel = selection + scroll;
							this.updateScreen("part_view_selected");
						}
					}
					break;
				}
				case "part_view_selected":{
					if(button.isReturn()){
						this.updateScreen("part_view_installed");
					}
					if(button.isVerticalArrow()){
						this.updateSelection(button == ARROW_UP ? -1 : 1);
					}
					if(button.isSelect()){
						switch(selection){
							case 4:{
								this.updateScreen("part_selected_edit_texture");
								break;
							}
							case 5:{
								this.updateScreen("part_selected_view_attributes");
								break;
							}
							case 6:{
								this.updateScreen("part_selected_edit_offset");
								break;
							}
							case 7:{
								this.updateScreen("part_selected_remove");
								break;
							}
						}
					}
					break;
				}
				case "constructor_menu":{
					if(button.isReturn()){
						this.updateScreen("main");
					}
					if(button.isSelect()){
						return;//TODO
					}
					break;
				}
				default:{
					if(button.isReturn()){
						this.updateScreen("main");
					}
					break;
				}
			}
		}

		private final NBTTagCompound getWindowUpdate(NBTTagCompound compound){
			if(window.startsWith("attr")){
				//TODO
				return compound;
			}
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
				case "part_menu":{
					compound.setString("Text0", "Part Editor");
					compound.setString("Text1", "- - - - - - - - - -");
					compound.setString("Text2", "View Installed Parts");
					compound.setString("Text3", "View Required Parts");
					compound.setString("Text4", "- - - - - - - - - -");
					compound.setString("Text5", "Select new Part");
					compound.setString("Text6", "Edit Selected Part");
					compound.setString("Text7", "Drop Selected Part");
					break;
				}
				case "part_add_new":{
					compound.setString("Text0", "- - - - - - - - - -");
					compound.setString("Text1", "Rightclick constructor with");
					compound.setString("Text2", "the part you want to adjust.");
					compound.setString("Text3", "(\"select part\")");
					compound.setString("Text4", "- - - - - - - - - -");
					fill(5, compound);
					sel = -1;
					break;
				}
				case "part_view_cache":{
					if(partdata == null){
						compound.setString("Text0", "ERROR: NO PART");
						fill(1, compound);
						break;
					}
					compound.setString("Text0", "ID: " + partdata.getPart().getName());
					compound.setString("Text1", "RG: " + partdata.getPart().getRegistryName());
					compound.setString("Text2", "MC: " + partdata.getPart().getCategory());
					compound.setString("Text3", "- - - - - - - - - -");
					compound.setString("Text4", "Edit Texture Settings");
					compound.setString("Text5", "Edit Attribute Settings");
					compound.setString("Text6", "Edit Offset");
					compound.setString("Text7", "Install as...");
					break;
				}
				case "part_cache_install":{
					if(partdata == null){
						compound.setString("Text0", "ERROR: NO PART");
						fill(1, compound);
						break;
					}
					//
					for(int i = 0; i < text; i++){
						int j = i + scroll;
						if(j >= partdata.getPart().getCategories().size()){
							compound.setString("Text" + i, "[" + j + "]");
						}
						else{
							compound.setString("Text" + i, "[" + j + "] " + partdata.getPart().getCategories().get(j));
						}
					}
					break;
				}
				case "part_view_required":{
					for(int i = 0; i < text; i++){
						int j = i + scroll;
						if(j >= vehicledata.getVehicle().getRequiredParts().size()){
							compound.setString("Text" + i, "&7[&e" + j + "&7]");
						}
						else{
							String str = vehicledata.getVehicle().getRequiredParts().get(j);
							compound.setString("Text" + i, "&7[&" + (vehicledata.getParts().containsKey(str) ? "a" : "c") + j + "&7] " + str);
						}
					}
					break;
				}
				case "part_view_installed":{
					for(int i = 0; i < text; i++){
						int j = i + scroll;
						if(j >= vehicledata.getParts().size()){
							compound.setString("Text" + i, "[" + j + "]");
						}
						else{
							PartData data = vehicledata.getParts().values().toArray(new PartData[]{})[j];
							compound.setString("Text" + i, "[" + j + "] " + data.getPart().getName());
						}
					}
					break;
				}
				case "part_view_selected":{
					Entry<String, PartData> entry = (Entry<String, PartData>)vehicledata.getParts().entrySet().toArray()[sel];
					if(entry == null){
						compound.setString("Text0", "ERROR: NO PART");
						fill(1, compound);
						break;
					}
					PartData data = entry.getValue();
					compound.setString("Text0", "ID: " + data.getPart().getName());
					compound.setString("Text1", "RG: " + data.getPart().getRegistryName());
					compound.setString("Text2", "IS: " + entry.getKey());
					compound.setString("Text3", "- - - - - - - - - -");
					compound.setString("Text4", "Edit Texture Settings");
					compound.setString("Text5", "Edit Attribute Settings");
					compound.setString("Text6", "Edit Offset");
					compound.setString("Text7", "Remove");
					break;
				}
				case "constructor_menu":{
					
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
			updateSelection(i, false);
		}
		
		private void updateSelection(int i, boolean b){
			if(i == -10){ this.selection = -1; }
			else{
				if(b){
					if(selection == 0 && i == -1){
						scroll -= 1;
						if(scroll < 0){
							scroll = 0;
						}
						this.updateScreen(null, false);
					}
					else if(selection == 7 && i == 1){
						scroll++;
						this.updateScreen(null, false);
					}
				}
				//
				this.selection += i;
				if(selection < -1){ selection = -1; }
				if(selection > 7){ selection = 7; }
				if(b && selection < 0) { selection = 0; }
			}
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("task", "update_selection");
			compound.setByte("Selection", selection);
			ApiUtil.sendTileEntityUpdatePacket(this, compound, 256);
		}
		
		public void updateLandVehicle(LandVehicleData data){
			if(data != null){
				this.vehicledata = data;
			}
			//this.writeToNBT(this.getTileData());
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
					this.vehicledata = Resources.getLandVehicleData(pkt.nbt);
					if(this.vehicledata == null){
						Print.debug("NO VEHICLE NBT KEY FOUND, RESETTING!");
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
			this.vehicledata = Resources.getLandVehicleData(compound);
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