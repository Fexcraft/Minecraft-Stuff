package net.fexcraft.mod.frsm.guis;

import net.fexcraft.mod.frsm.blocks.furnace.Furnace1bEntity;
import net.fexcraft.mod.frsm.guis.client.GuiFurnace1;
import net.fexcraft.mod.frsm.guis.client.GuiLoadingScreen;
import net.fexcraft.mod.frsm.guis.client.TEMT_GUI;
import net.fexcraft.mod.frsm.guis.server.ContainerFurnace1;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	public static final int FURNACE1 = 1;

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity entity = world.getTileEntity(pos);
		
		switch(id){
			case 0:
				return null;
			case 1:
				return new ContainerFurnace1(player.inventory, (Furnace1bEntity)entity); 
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
				return new TEMT_GUI(player, world, pos);
			case 1:
				return new GuiFurnace1(player.inventory, (Furnace1bEntity)entity);
			default:
				return new GuiLoadingScreen();
		}
		
    }
	
	public static class GUIS{
		public static int TEMT = 0;
	}
}
