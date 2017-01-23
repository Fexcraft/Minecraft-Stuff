package net.fexcraft.mod.lib.api.block;

import net.fexcraft.mod.lib.util.common.EnumColor;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface PaintableBlock {
	
	public void onPaintItemUse(RGB color, EnumColor dye, ItemStack stack, EntityPlayer player, BlockPos pos, World world);
	
}