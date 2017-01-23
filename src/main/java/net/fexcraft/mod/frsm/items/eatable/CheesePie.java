package net.fexcraft.mod.frsm.items.eatable;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.öItem;
import net.minecraft.item.ItemFood;

@öItem(modid = FI.MODID, name = "cheesepie")
public class CheesePie extends ItemFood {

	public CheesePie(){
		super(10, 1F, true);
		this.setMaxStackSize(8);
		this.setCreativeTab(CD.EATABLES);
	}
	
}