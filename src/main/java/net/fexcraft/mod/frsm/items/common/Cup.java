package net.fexcraft.mod.frsm.items.common;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.�Item;
import net.minecraft.item.Item;

@�Item(modid = FI.MODID, name = "cup")
public class Cup extends Item {

	public Cup(){
		this.setMaxStackSize(6);
		this.setCreativeTab(net.fexcraft.mod.frsm.util.CD.MATERIALS);
	}
	
}