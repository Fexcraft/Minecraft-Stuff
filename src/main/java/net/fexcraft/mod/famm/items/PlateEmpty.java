package net.fexcraft.mod.famm.items;

import net.fexcraft.mod.famm.FAMM;
import net.fexcraft.mod.famm.util.FI;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.item.Item;

public class PlateEmpty extends Item {
	
	public PlateEmpty(){
		setCreativeTab(FAMM.tabFAMM);
		Registry.registerItemManually(FI.MODID, "plate_empty", 0, null, this);
	}
	
}