package net.fexcraft.mod.famm.items;

import net.fexcraft.mod.famm.FAMM;
import net.fexcraft.mod.lib.util.registry.RegistryUtil;
import net.minecraft.item.Item;

public class PlatePainted extends Item {
	
	public PlatePainted(){
		setCreativeTab(FAMM.tabFAMM);
		RegistryUtil.get("famm").addItem("plate_painted", this, 0, null);
	}
	
}