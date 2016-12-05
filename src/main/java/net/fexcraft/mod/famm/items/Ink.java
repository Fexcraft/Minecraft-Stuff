package net.fexcraft.mod.famm.items;

import net.fexcraft.mod.famm.FAMM;
import net.fexcraft.mod.famm.util.FI;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.item.Item;

public class Ink extends Item implements IItem {
	
	public Ink() {
		ItemUtil.register(FI.MODID, this);
		ItemUtil.registerRender(this);
		setCreativeTab(FAMM.tabFAMM);
	}
    
	public String getName(){
		return "ink";
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
	
}