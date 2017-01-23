package net.fexcraft.mod.frsm.items.eatable;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.öItem;
import net.minecraft.item.ItemFood;

@öItem(modid = FI.MODID, name = "bacon")
public class Bacon extends ItemFood {

	public Bacon(){
		super(6, 0.6F, true);
		this.setMaxStackSize(64);
		this.setCreativeTab(CD.EATABLES);
	}
	
}