package net.fexcraft.mod.nvr.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class PlaceholderGuiContainer extends Container {
	
	@Override
	public boolean canInteractWith(EntityPlayer player){
		return !(player == null);
	}
		
}