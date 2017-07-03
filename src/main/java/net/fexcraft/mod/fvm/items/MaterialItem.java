package net.fexcraft.mod.fvm.items;

import net.fexcraft.mod.fvm.data.Material;
import net.fexcraft.mod.fvm.util.FvmTabs;
import net.fexcraft.mod.lib.util.registry.RegistryUtil;
import net.minecraft.item.Item;

public class MaterialItem extends Item {
	
	private Material type;
	
	public MaterialItem(Material type){
		this.setCreativeTab(FvmTabs.MATERIALS);
		this.setHasSubtypes(true);
		this.setMaxStackSize(type.maxStackSize);
		this.type = type;
		RegistryUtil.get("fvm").addItem("material_" + type.registryname, this, 0, null);
	}

	public static Item register(Material material){
		return new MaterialItem(material);
	}
	
}