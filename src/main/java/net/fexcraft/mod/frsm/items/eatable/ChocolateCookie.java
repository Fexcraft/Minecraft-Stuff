package net.fexcraft.mod.frsm.items.eatable;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.öItem;
import net.minecraft.item.ItemFood;

@öItem(modid = FI.MODID, name = "chocolatecookie")
public class ChocolateCookie extends ItemFood {

	public ChocolateCookie() {
		super(4, 0.4F, false);
		this.setMaxStackSize(64);
		this.setCreativeTab(CD.EATABLES);
	}
	
}