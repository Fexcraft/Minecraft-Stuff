package net.fexcraft.mod.lib.api.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ITileEntityEdit{
	
	public void onTileEntityModelEditItemUse(World world, BlockPos pos, EntityPlayer player);
	
}