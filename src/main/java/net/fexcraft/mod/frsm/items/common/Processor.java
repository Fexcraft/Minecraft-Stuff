package net.fexcraft.mod.frsm.items.common;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.�Item;
import net.minecraft.item.Item;

@�Item(modid = FI.MODID, name = "prozessor")
public class Processor extends Item {

	public Processor(){
		this.setMaxStackSize(32);
		this.setCreativeTab(CD.MATERIALS);
	}
	
}