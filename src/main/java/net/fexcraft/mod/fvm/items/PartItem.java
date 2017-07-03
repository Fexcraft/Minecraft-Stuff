package net.fexcraft.mod.fvm.items;

import net.fexcraft.mod.fvm.data.Part;
import net.fexcraft.mod.fvm.util.FvmTabs;
import net.fexcraft.mod.lib.util.registry.RegistryUtil;
import net.minecraft.item.Item;

public class PartItem extends Item {
	
	private Part type;
	
	public PartItem(Part type){
		this.setCreativeTab(FvmTabs.PARTS);
		this.setHasSubtypes(true);
		this.setMaxStackSize(type.maxStackSize);
		this.type = type;
		RegistryUtil.get("fvm").addItem("part_" + type.registryname, this, 0, null);
	}

	public static Item register(Part part){
		return new PartItem(part);
	}
	
}