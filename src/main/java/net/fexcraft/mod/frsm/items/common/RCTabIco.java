package net.fexcraft.mod.frsm.items.common;

import java.util.List;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RCTabIco extends Item implements IItem{

	public RCTabIco(){
		this.setMaxStackSize(16);
		this.setCreativeTab(CD.MATERIALS.getCreativeTab());
		ItemUtil.register(FI.MODID, this);
	}
	
	@Override
	public String getName(){
		return "tabFRSMRCico";
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced){
		tooltip.add("This Item Exists only in the case that Robo Crafting");
		tooltip.add("is disabled in your config, so that the Robo tab still");
		tooltip.add("has an Icon and don't crash your Game! ;)");
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
	
}