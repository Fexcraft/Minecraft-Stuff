package net.fexcraft.mod.frsm.items.common;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.�Item;
import net.minecraft.item.Item;

@�Item(modid = FI.MODID, name = "brush")
public class Brush extends Item {

	public Brush(){
		this.setMaxStackSize(6);
		this.setCreativeTab(CD.MATERIALS);
	}
	
}