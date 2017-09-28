package net.fexcraft.mod.nvr.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
			case 0:{
				return new PlaceholderGuiContainer();
			}
			default:{
				return null;
			}
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
			case 0:{
				return new net.fexcraft.mod.nvr.client.gui.ChunkViewGui(x, y == 0 ? false : true, z == 0 ? false : true);
			}
			default:{
				return null;
			}
		}
	}
	
}