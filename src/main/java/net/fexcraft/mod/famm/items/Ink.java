package net.fexcraft.mod.famm.items;

import net.fexcraft.mod.famm.FAMM;
import net.fexcraft.mod.famm.util.FI;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.item.Item;

public class Ink extends Item {
	
	public Ink(){
		setCreativeTab(FAMM.tabFAMM);
		Registry.registerItemManually(FI.MODID, "ink", 0, null, this);
	}
	
}