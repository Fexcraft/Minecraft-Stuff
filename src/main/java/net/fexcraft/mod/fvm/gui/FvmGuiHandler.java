package net.fexcraft.mod.fvm.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class FvmGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
			case 1:
				return new ConstructorContainer(world.getTileEntity(new BlockPos(x, y, z)), player.inventory);
			case 12:
				return new PaintTableContainer(world.getTileEntity(new BlockPos(x, y, z)));
				
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
			case 1:
				return new ConstructorGui(world.getTileEntity(new BlockPos(x, y, z)), player.inventory);
			case 12:
				return new PaintTableGui(world.getTileEntity(new BlockPos(x, y, z)));
				
		}
		return null;
	}
	
}