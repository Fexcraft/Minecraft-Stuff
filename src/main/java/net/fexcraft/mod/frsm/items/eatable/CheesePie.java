package net.fexcraft.mod.frsm.items.eatable;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.item.ItemFood;

public class CheesePie extends ItemFood implements IItem{

	public CheesePie() {
		super(10, 1F, true);
		this.setMaxStackSize(8);
		this.setCreativeTab(CD.FOOD.getCreativeTab());
		ItemUtil.register(FI.MODID, this);
	}

	@Override
	public String getName(){
		return "cheesePie";
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
	
}