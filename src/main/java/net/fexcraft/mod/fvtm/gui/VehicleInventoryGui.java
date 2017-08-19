package net.fexcraft.mod.fvtm.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class VehicleInventoryGui {
	
	//x 0 = inv view
	//x 1 = pin view
	//x 2/3 = ? ?
	
	//y n = part id
	
	//z n = scroll
	
	private static final ResourceLocation maintex = new ResourceLocation("fvtm:textures/guis/vehicle_inventory_main.png");
	private static final ResourceLocation invtex = new ResourceLocation("fvtm:textures/guis/vehicle_inventory.png");
	
	public static class Client extends GuiContainer {

		public Client(EntityPlayer player, World world, int x, int y, int z){
			super(new Server(player, world, x, y, z));
			switch(x){
				case 0:{
					//TODO
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
			
		}
		
		private static void sendRefresh(int screen, int part, int scroll){
			
		}
		
	}
	
	public static class Server extends Container {
		
		public Server(EntityPlayer player, World world, int x, int y, int z){
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
		public boolean canInteractWith(EntityPlayer playerIn){
			return false;//TODO permissions check? or however mc handles this usually.
		}
		
	}
	
}