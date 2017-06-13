package net.fexcraft.mod.frsm.items.common;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.fItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@fItem(modid = FI.MODID, name = "tilesempty")
public class EmptyTiles extends Item {

	public EmptyTiles() {
		super();
		this.setMaxStackSize(64);
		this.setCreativeTab(CD.MATERIALS);
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> tooltip, ITooltipFlag advanced){
		tooltip.add("Used to craft different types of Tiles");
	}
	
}