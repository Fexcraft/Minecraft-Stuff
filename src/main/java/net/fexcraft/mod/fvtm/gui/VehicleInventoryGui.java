package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute;
import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute.InventoryAttributeData;
import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleData;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.GenericGuiButton;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class VehicleInventoryGui {
	
	//x 0 = inv view
	//x 1 = pin view
	//x 2 = fuel view
	//x 3 = status view
	
	//y n = part id
	
	//z n = scroll
	
	private static final ResourceLocation maintex = new ResourceLocation("fvtm:textures/guis/vehicle_inventory_main.png");
	private static final ResourceLocation invtex = new ResourceLocation("fvtm:textures/guis/vehicle_inventory.png");
	
	public static class Client extends GuiContainer {
		
		private LandVehicleData data;
		private int x, y, z;
		private GenericGuiButton arrowUp, arrowDown, fuel, info;
		private GenericGuiButton[] parts;
		private int scroll;

		public Client(EntityPlayer player, World world, int x, int y, int z){
			super(new Server(player, world, x, y, z));
			this.x = x; this.y = y; this.z = z;
			data = ((com.flansmod.fvtm.EntitySeat)player.getRidingEntity()).vehicle.data;
			switch(x){
				case 0:{
					this.xSize = 168;
					this.ySize = 153;
					parts = new GenericGuiButton[9];
					break;
				}
				case 1:{
					this.xSize = 226;
					this.ySize = 195;
					this.scroll = z;
					break;
				}
				case 2:{
					//TODO
					break;
				}
				case 3:{
					//TODO
					break;
				}
			}
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
			switch(x){
				case 0:{
					this.mc.getTextureManager().bindTexture(maintex);
					int i = this.guiLeft, j = this.guiTop;
					this.drawTexturedModalRect(i, j, 0, 0, this.xSize + 12, this.ySize);
					this.fontRenderer.drawString(data.getVehicle().getName(), i + 7, j + 7, MapColor.SNOW.colorValue);
					break;
				}
				case 1:{
					this.mc.getTextureManager().bindTexture(invtex);
					int i = this.guiLeft, j = this.guiTop;
					this.drawTexturedModalRect(i, j, 0, 0, this.xSize + 16, this.ySize);
					this.fontRenderer.drawString(data.getInventoryContainers().get(y).getPart().getName(), i + 7, j + 7, MapColor.SNOW.colorValue);
					//
					InventoryAttributeData invdata = data.getInventoryContainers().get(y).getAttributeData(InventoryAttributeData.class);
					String curr = "&a" + ((z * 60) + 1) + "&c-&a" + ((z * 60 + 60) > invdata.getInventory().size() ? invdata.getInventory().size() : (z * 60 + 60));
					this.fontRenderer.drawString(z + " (scr)", i + 171, j + 118, MapColor.SNOW.colorValue);
					this.fontRenderer.drawString(Formatter.format(curr), i + 171, j + 146, MapColor.SNOW.colorValue);
					this.fontRenderer.drawString(Formatter.format("&6" + invdata.getInventory().size() + " max"), i + 171, j + 160, MapColor.SNOW.colorValue);
					break;
				}
				case 2:{
					//TODO
					break;
				}
				case 3:{
					//TODO
					break;
				}
			}
		}
		
		@Override
		protected void actionPerformed(GuiButton button){
			switch(x){
				case 0:{
					switch(button.id){
						case 0: case 1:{
							if(button.id == 0){
								scroll--;
								if(scroll < 0){
									scroll = 0;
								}
								//if(scroll - 1 >= 0){ scroll--; }
							}
							else{
								scroll++;
								if(scroll + 9 > data.getInventoryContainers().size()){
									scroll = data.getInventoryContainers().size() - 9;
								}
							}
							arrowUp.enabled = scroll > 0;
							arrowDown.enabled = scroll + 9 < data.getInventoryContainers().size();
							for(int i = 0; i < 9; i++){
								int j = i + scroll;
								parts[i].displayString = j >= data.getInventoryContainers().size() ? "" : Formatter.format("&6" + j + "&e| &r" + data.getInventoryContainers().get(j).getPart().getName());
							}
							break;
						}
						case 2: case 3: case 4:
						case 5: case 6: case 7:
						case 8: case 9: case 10:{
							y = (button.id - 2) + scroll;
							NBTTagCompound nbt = new NBTTagCompound();
							nbt.setString("target_listener", "fvtm");
							nbt.setString("task", "open_gui");
							nbt.setInteger("gui", GuiHandler.VEHICLE_INVENTORY);
							nbt.setIntArray("args", new int[]{1, y, 0});
							PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(nbt));
							break;
						}
						case 11: case 12:{
							NBTTagCompound nbt = new NBTTagCompound();
							nbt.setString("target_listener", "fvtm");
							nbt.setString("task", "open_gui");
							nbt.setInteger("gui", GuiHandler.VEHICLE_INVENTORY);
							nbt.setIntArray("args", new int[]{button.id - 9, 0, 0});
							PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(nbt));
							break;
						}
					}
					break;
				}
				case 1:{
					switch(button.id){
						case 0: case 1:{
							if(button.id == 0){
								scroll--;
								if(scroll < 0){
									scroll = 0;
								}
							}
							else{
								if((scroll + 1) * 60 <= data.getInventoryContainers().get(y).getAttributeData(InventoryAttribute.InventoryAttributeData.class).getInventory().size()){
									scroll++;
								}
							}
							arrowUp.enabled = scroll > 0;
							arrowDown.enabled = (scroll + 1) * 60 < data.getInventoryContainers().get(y).getAttributeData(InventoryAttribute.InventoryAttributeData.class).getInventory().size();
							if(scroll != z){
								NBTTagCompound nbt = new NBTTagCompound();
								nbt.setString("target_listener", "fvtm");
								nbt.setString("task", "open_gui");
								nbt.setInteger("gui", GuiHandler.VEHICLE_INVENTORY);
								nbt.setIntArray("args", new int[]{1, y, scroll});
								PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(nbt));
							}
						}
						break;
					}
				}
				case 2:{
					//TODO
					break;
				}
				case 3:{
					//TODO
					break;
				}
			}
		}
		
		@Override
		public void initGui(){
			super.initGui();
			this.buttonList.clear();
			int i = this.guiLeft;
			int j = this.guiTop;
			switch(x){
				case 0:{
					this.buttonList.add(arrowUp = new GenericGuiButton(0, 167 + i, 38 + j, 9, 12, ""));
					arrowUp.setTexturePos(0, 192, 38);
					arrowUp.setTexturePos(1, 183, 38);
					arrowUp.setTexturePos(2, 210, 38);
					arrowUp.setTexturePos(3, 201, 38);
					arrowUp.setTexture(maintex);
					arrowUp.enabled = scroll > 0;
					this.buttonList.add(arrowDown = new GenericGuiButton(1, 167 + i, 56 + j, 9, 12, ""));
					arrowDown.setTexturePos(0, 192, 56);
					arrowDown.setTexturePos(1, 183, 56);
					arrowDown.setTexturePos(2, 210, 56);
					arrowDown.setTexturePos(3, 201, 56);
					arrowDown.setTexture(maintex);
					arrowDown.enabled = scroll + 9 < data.getInventoryContainers().size();
					//
					for(int k = 0; k < 9; k++){
						String name = k >= data.getInventoryContainers().size() ? "" : Formatter.format("&6" + k + "&e| &r" + data.getInventoryContainers().get(k).getPart().getName());
						this.buttonList.add(parts[k] = new GenericGuiButton(k + 2, 5 + i, (19 + (k * 14)) + j, 158, 12, name));
						parts[k].setTexture(maintex);
						parts[k].setTexturePos(0, 0, 232);
						parts[k].setTexturePos(1, 0, 244);
						parts[k].setTexturePos(2, 0, 208);
						parts[k].setTexturePos(3, 0, 220);
						parts[k].enabled = !(parts[k].displayString == null || parts[k].displayString.equals(""));
						parts[k].setTextPos(7 + i, (22 + (k * 14)) + j);
					}
					//
					this.buttonList.add(fuel = new GenericGuiButton(11, 167 + i, 80 + j, 9, 12, ""));
					this.buttonList.add(info = new GenericGuiButton(12, 167 + i, 98 + j, 9, 12, ""));
					fuel.setTexturePos(0, 192, 80); info.setTexturePos(0, 192, 98);
					fuel.setTexturePos(1, 183, 80); info.setTexturePos(1, 183, 98);
					fuel.setTexturePos(2, 210, 80); info.setTexturePos(2, 210, 98);
					fuel.setTexturePos(3, 201, 80); info.setTexturePos(3, 201, 98);
					fuel.setTexture(maintex); info.setTexture(maintex);
					break;
				}
				case 1:{
					this.buttonList.add(arrowUp = new GenericGuiButton(0, 225 + i, 127 + j, 12, 15, ""));
					arrowUp.setTexturePos(0, 12, 211);
					arrowUp.setTexturePos(1, 12, 196);
					arrowUp.setTexturePos(2, 12, 226);
					arrowUp.setTexturePos(3, 12, 241);
					arrowUp.setTexture(invtex);
					arrowUp.enabled = scroll > 0;
					this.buttonList.add(arrowDown = new GenericGuiButton(1, 225 + i, 144 + j, 12, 15, ""));
					arrowDown.setTexturePos(0, 0, 211);
					arrowDown.setTexturePos(1, 0, 196);
					arrowDown.setTexturePos(2, 0, 226);
					arrowDown.setTexturePos(3, 0, 241);
					arrowDown.setTexture(invtex);
					arrowDown.enabled = (scroll + 1) * 60 < data.getInventoryContainers().get(y).getAttributeData(InventoryAttribute.InventoryAttributeData.class).getInventory().size();
					break;
				}
				case 2:{
					//TODO
					break;
				}
				case 3:{
					//TODO
					break;
				}
			}
		}
		
		private static void sendRefresh(int screen, int part, int scroll){
			
		}
		
	}
	
	public static class Server extends Container {
		
		private int x, y, z;
		private TempInventory temp = null;
		private LandVehicleData data;
		
		public Server(EntityPlayer player, World world, int x, int y, int z){
			this.x = x; this.y = y; this.z = z;
			data = ((com.flansmod.fvtm.EntitySeat)player.getRidingEntity()).vehicle.data;
			switch(x){
				case 0:{
					//do nothing
					break;
				}
				case 1:{
					temp = new TempInventory(data.getInventoryContainers().get(y));
					for(int row = 0; row < 5; row++){
						for(int col = 0; col < 12; col++){
							int index = (col + row * 12) + (z * 60);
							if(index >= temp.getSizeInventory()){
								break;
							}
							addSlotToContainer(new Slot(temp, index, 6 + col * 18, 20 + row * 18));
						}
					}
					//
					for(int row = 0; row < 3; row++){
						for(int col = 0; col < 9; col++){
							addSlotToContainer(new Slot(player.inventory, col + row * 9 + 9, 6 + col * 18, 117 + row * 18));
						}
					}
					for(int col = 0; col < 9; col++){
						addSlotToContainer(new Slot(player.inventory, col, 6 + col * 18, 173));
					}
					break;
				}
				case 2:{
					//TODO
					break;
				}
				case 3:{
					//TODO
					break;
				}
			}
		}

		@Override
		public boolean canInteractWith(EntityPlayer player){
			return true;
		}
		
	}
	
}