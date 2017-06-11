package net.fexcraft.mod.fvm.items;

import net.fexcraft.mod.fvm.FVM;
import net.fexcraft.mod.fvm.data.Material;
import net.fexcraft.mod.fvm.util.FvmTabs;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.item.Item;

public class MaterialItem extends Item {
	
	private Material type;
	
	public MaterialItem(Material type){
		this.setCreativeTab(FvmTabs.MATERIALS);
		this.setHasSubtypes(true);
		this.setMaxStackSize(type.maxStackSize);
		this.type = type;
		Registry.registerItemManually(FVM.MODID, "material_" + type.registryname, 0, null, this);
	}

	public static Item register(Material material){
		return new MaterialItem(material);
	}
	
}