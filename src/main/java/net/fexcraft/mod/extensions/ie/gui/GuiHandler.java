package net.fexcraft.mod.extensions.ie.gui;

import net.fexcraft.mod.extensions.ie.gui.client.GuiEF;
import net.fexcraft.mod.extensions.ie.gui.server.ContainerEF;
import net.fexcraft.mod.extensions.ie.tileentities.ElectricalFurnaceEntity;
import net.fexcraft.mod.frsm.guis.client.GuiLoadingScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	public static final int ELECTRICFURNACE = 1;

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity entity = world.getTileEntity(pos);
		
		switch(id){
			case 0:
				return null;
			case 1:
				return new ContainerEF(player.inventory, (ElectricalFurnaceEntity)entity); 
			default:
				return null;
		}
		
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity entity = world.getTileEntity(pos);
		
		switch(id){
			case 0:
				return null;
			case 1:
				return new GuiEF(player.inventory, (ElectricalFurnaceEntity)entity);
			default:
				return new GuiLoadingScreen();
		}
		
    }
	
	public static class GUIS{
		public static int TEMT = 0;
	}
}
