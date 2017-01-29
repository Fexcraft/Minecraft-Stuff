package net.fexcraft.mod.frsm.items.common;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.fItem;
import net.minecraft.item.Item;

@fItem(modid = FI.MODID, name = "pcmainboard")
public class PCMainboard extends Item {

	public PCMainboard(){
		this.setMaxStackSize(8);
		this.setCreativeTab(CD.MATERIALS);
	}
	
}