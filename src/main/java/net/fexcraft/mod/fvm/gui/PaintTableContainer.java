package net.fexcraft.mod.fvm.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

public class PaintTableContainer extends Container {
	
	public PaintTableContainer(TileEntity tileentity){
		super();
	}

	@Override
	public boolean canInteractWith(EntityPlayer player){
		return true;
	}
	
}