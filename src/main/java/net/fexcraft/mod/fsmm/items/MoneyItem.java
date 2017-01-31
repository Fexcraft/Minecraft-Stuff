package net.fexcraft.mod.fsmm.items;

import net.fexcraft.mod.fsmm.FSMM;
import net.fexcraft.mod.fsmm.util.FI;
import net.fexcraft.mod.lib.util.registry.Registry;
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
		Registry.registerItemManually(FI.MODID, name, 0, null, this);
	}

	@Override
	public float getWorth(){
		return ivalue;
	}
	
}