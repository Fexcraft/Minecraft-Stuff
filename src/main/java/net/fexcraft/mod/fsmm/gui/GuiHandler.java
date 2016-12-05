package net.fexcraft.mod.fsmm.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static int atm = 0;
	public static int safe = 1;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		//BlockPos pos = new BlockPos(x, y, z);
		
		switch(ID){
			case 0:
				return new GuiATM(false);
			case 1:
				return new GuiATM(true);
			default:
				return null;
		}
    }
}
