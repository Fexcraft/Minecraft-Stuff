package net.fexcraft.mod.frsm.items.common;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.fItem;
import net.minecraft.item.Item;

@fItem(modid = FI.MODID, name = "planks_oak")
public class OakPlanks extends Item {

	public OakPlanks(){
		this.setMaxStackSize(64);
		this.setCreativeTab(CD.MATERIALS);
	}
	
}