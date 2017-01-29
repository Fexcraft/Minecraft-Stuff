package net.fexcraft.mod.frsm.items.eatable;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.fItem;
import net.minecraft.item.ItemFood;

@fItem(modid = FI.MODID, name = "cheese")
public class Cheese extends ItemFood {

	public Cheese(){
		super(2, 0.4F, true);
		this.setMaxStackSize(64);
		this.setCreativeTab(CD.EATABLES);
	}
	
}