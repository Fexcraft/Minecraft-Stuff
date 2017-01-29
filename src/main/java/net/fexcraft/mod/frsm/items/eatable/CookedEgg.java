package net.fexcraft.mod.frsm.items.eatable;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.fItem;
import net.minecraft.item.ItemFood;

@fItem(modid = FI.MODID, name = "cookedegg")
public class CookedEgg extends ItemFood {

	public CookedEgg() {
		super(4, 0.4F, true);
		this.setMaxStackSize(64);
		this.setCreativeTab(CD.EATABLES);
	}
	
}