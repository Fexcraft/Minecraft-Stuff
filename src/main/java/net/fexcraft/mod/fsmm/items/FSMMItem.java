package net.fexcraft.mod.fsmm.items;

import net.fexcraft.mod.fsmm.FSMM;
import net.fexcraft.mod.fsmm.util.FI;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.item.Item;

public class FSMMItem extends Item implements IMoneyItem {
	
	private String iname;
	private float ivalue = 55;
	
	public FSMMItem(String name, float value) {
		setCreativeTab(FSMM.tabFSMM);
		setMaxStackSize(50);
		iname = name;
		ivalue = value;
		
		ItemUtil.register(FI.MODID, this);
		ItemUtil.registerRender(this);
	}

	@Override
	public String getName(){
		return iname;
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}

	@Override
	public float getWorth(){
		return ivalue;
	}
	
}