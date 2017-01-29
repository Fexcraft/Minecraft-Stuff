package net.fexcraft.mod.frsm.items.common;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.fItem;
import net.minecraft.item.Item;

@fItem(modid = FI.MODID, name = "upgradekit")
public class UpgradeKit extends Item {

	public UpgradeKit(){
		this.setMaxStackSize(16);
		this.setCreativeTab(CD.MATERIALS);
	}
	
}