package net.fexcraft.mod.frsm.items.eatable;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.öItem;
import net.minecraft.item.ItemFood;

@öItem(modid = FI.MODID, name = "cheesewhite")
public class CheeseWhite extends ItemFood {

	public CheeseWhite(){
		super(2, 0.4F, true);
		this.setMaxStackSize(64);
		this.setCreativeTab(CD.EATABLES);
	}
	
}