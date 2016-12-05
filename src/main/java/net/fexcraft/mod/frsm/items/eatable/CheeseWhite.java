package net.fexcraft.mod.frsm.items.eatable;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.item.ItemFood;

public class CheeseWhite extends ItemFood implements IItem{

	public CheeseWhite() {
		super(2, 0.4F, true);
		this.setMaxStackSize(64);
		this.setCreativeTab(CD.FOOD.getCreativeTab());
		ItemUtil.register(FI.MODID, this);
	}

	@Override
	public String getName(){
		return "cheeseWhite";
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
	
}