package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleData;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.GenericGuiButton;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
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
		private GenericGuiButton arrowUp, arrowDown;
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
							
							break;
						}
					}
					break;
				}
				case 1:{
					
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
					break;
				}
			}
		}
		
		private static void sendRefresh(int screen, int part, int scroll){
			
		}
		
	}
	
	public static class Server extends Container {
		
		private int x, y, z;
		
		public Server(EntityPlayer player, World world, int x, int y, int z){
			this.x = x; this.y = y; this.z = z;
			switch(x){
				case 0:{
					//do nothing
					break;
				}
				case 1:{
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