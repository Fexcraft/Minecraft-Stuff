package net.fexcraft.mod.frsm.items.common;

import java.util.List;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.öItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@öItem(modid = FI.MODID, name = "tilesempty")
public class EmptyTiles extends Item {

	public EmptyTiles() {
		super();
		this.setMaxStackSize(64);
		this.setCreativeTab(CD.MATERIALS);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced){
		tooltip.add("Used to craft different types of Tiles");
	}
	
}