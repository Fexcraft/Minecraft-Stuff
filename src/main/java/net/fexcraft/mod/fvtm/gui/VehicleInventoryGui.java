package net.fexcraft.mod.fvtm.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;

public class VehicleInventoryGui {
	
	public static class Client extends GuiContainer {

		public Client(EntityPlayer player, World world, int x, int y, int z){
			super(new Server(player, world, x, y, z));
			
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
			
		}
		
	}
	
	public static class Server extends Container {
		
		public Server(EntityPlayer player, World world, int x, int y, int z){
			
		}

		@Override
		public boolean canInteractWith(EntityPlayer playerIn){
			return false;//TODO permissions check
		}
		
	}
	
}