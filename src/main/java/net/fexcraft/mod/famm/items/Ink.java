package net.fexcraft.mod.famm.items;

import net.fexcraft.mod.famm.FAMM;
import net.fexcraft.mod.lib.util.registry.RegistryUtil;
import net.minecraft.item.Item;

public class Ink extends Item {
	
	public Ink(){
		setCreativeTab(FAMM.tabFAMM);
		RegistryUtil.get("famm").addItem("ink", this, 0, null);
	}
	
}