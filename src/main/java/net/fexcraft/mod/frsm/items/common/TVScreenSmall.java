package net.fexcraft.mod.frsm.items.common;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.�Item;
import net.minecraft.item.Item;

@�Item(modid = FI.MODID, name = "tvscreensmall")
public class TVScreenSmall extends Item {

	public TVScreenSmall(){
		this.setMaxStackSize(4);
		this.setCreativeTab(CD.MATERIALS);
	}
	
}