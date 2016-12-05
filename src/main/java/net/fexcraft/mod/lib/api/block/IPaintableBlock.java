package net.fexcraft.mod.lib.api.block;

import net.fexcraft.mod.lib.util.cls.EnumColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IPaintableBlock extends IBlock{
	
	public void onPaintItemUse(EnumColor color, ItemStack stack, EntityPlayer player, BlockPos pos, World world);
	
}