package net.fexcraft.mod.fvm.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class GenericPlaceholderContainer extends Container {
	
	@Override
	public boolean canInteractWith(EntityPlayer player){
		return !(player == null);
	}
		
}