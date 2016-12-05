package net.fexcraft.mod.frsm.items.common;

import java.util.List;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EmptyTiles extends Item implements IItem{

	public EmptyTiles() {
		super();
		this.setMaxStackSize(64);
		this.setCreativeTab(CD.MATERIALS.getCreativeTab());
		ItemUtil.register(FI.MODID, this);
	}

	@Override
	public String getName(){
		return "tilesempty";
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced){
		tooltip.add("Used to craft different types of Tiles");
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
	
}