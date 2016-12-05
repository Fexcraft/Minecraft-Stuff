package net.fexcraft.mod.frsm.items.common;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.item.Item;

public class OakPlanks extends Item implements IItem{

	public OakPlanks(){
		this.setMaxStackSize(64);
		this.setCreativeTab(CD.MATERIALS.getCreativeTab());
		ItemUtil.register(FI.MODID, this);
	}
	
	@Override
	public String getName(){
		return "planks_oak";
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
	
}