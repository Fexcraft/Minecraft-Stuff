package net.fexcraft.mod.frsm.items.common;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.fItem;
import net.minecraft.item.Item;

@fItem(modid = FI.MODID, name = "prozessor4")
public class Processor4 extends Item {

	public Processor4(){
		this.setMaxStackSize(32);
		this.setCreativeTab(CD.MATERIALS);
	}
	
}