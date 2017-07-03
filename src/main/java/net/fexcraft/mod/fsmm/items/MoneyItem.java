package net.fexcraft.mod.fsmm.items;

import net.fexcraft.mod.fsmm.FSMM;
import net.fexcraft.mod.lib.util.registry.RegistryUtil;
import net.minecraft.item.Item;

public class MoneyItem extends Item implements IMoneyItem {
	
	public String iname;
	private float ivalue = 55;
	
	public MoneyItem(String name, float value) {
		setCreativeTab(FSMM.tabFSMM);
		setMaxStackSize(50);
		iname = name;
		ivalue = value;
		MoneyItems.addItemToMap(this);
		RegistryUtil.get("fsmm").addItem(iname, this, 0, null);
	}

	@Override
	public float getWorth(){
		return ivalue;
	}
	
}