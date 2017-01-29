package net.fexcraft.mod.frsm.items.common;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.fItem;
import net.minecraft.item.Item;

@fItem(modid = FI.MODID, name = "stonemug")
public class StoneMug extends Item {

	public StoneMug(){
		this.setMaxStackSize(4);
		this.setCreativeTab(CD.MATERIALS);
	}
	
}