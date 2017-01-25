package net.fexcraft.mod.frsm.items.common;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.�Item;
import net.minecraft.item.Item;

@�Item(modid = FI.MODID, name = "jar")
public class Jar extends Item {

	public Jar(){
		this.setMaxStackSize(16);
		this.setCreativeTab(CD.MATERIALS);
	}
	
}