package net.fexcraft.mod.frsm.items.eatable;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.item.ItemFood;

public class ChocolateCookie extends ItemFood implements IItem{

	public ChocolateCookie() {
		super(4, 0.4F, false);
		this.setMaxStackSize(64);
		this.setCreativeTab(CD.FOOD.getCreativeTab());
		ItemUtil.register(FI.MODID, this);
	}

	@Override
	public String getName(){
		return "chocolateCookie";
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
	
}