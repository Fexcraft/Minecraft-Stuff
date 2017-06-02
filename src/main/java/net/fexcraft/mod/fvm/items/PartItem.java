package net.fexcraft.mod.fvm.items;

import net.fexcraft.mod.fvm.FVM;
import net.fexcraft.mod.fvm.data.Part;
import net.fexcraft.mod.fvm.util.FvmTabs;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.item.Item;

public class PartItem extends Item {
	
	private Part type;
	
	public PartItem(Part type){
		this.setCreativeTab(FvmTabs.MATERIALS);
		this.setHasSubtypes(true);
		this.setMaxStackSize(type.maxStackSize);
		this.type = type;
		Registry.registerItemManually(FVM.MODID, "part_" + type.registryname, 0, null, this);
	}

	public static Item register(Part part){
		return new PartItem(part);
	}
	
}