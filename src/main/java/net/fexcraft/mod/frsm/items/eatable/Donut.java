package net.fexcraft.mod.frsm.items.eatable;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.öItem;
import net.minecraft.item.ItemFood;

@öItem(modid = FI.MODID, name = "donut")
public class Donut extends ItemFood {

	public Donut() {
		super(6, 0.6F, false);
		this.setMaxStackSize(32);
		this.setCreativeTab(CD.EATABLES);
	}
	
}