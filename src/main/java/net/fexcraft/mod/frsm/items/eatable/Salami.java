package net.fexcraft.mod.frsm.items.eatable;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.fItem;
import net.minecraft.item.ItemFood;

@fItem(modid = FI.MODID, name = "salami")
public class Salami extends ItemFood {

	public Salami() {
		super(2, 0.4F, true);
		this.setMaxStackSize(64);
		this.setCreativeTab(CD.EATABLES);
	}
	
}