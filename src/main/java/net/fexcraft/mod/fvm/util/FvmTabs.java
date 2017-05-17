package net.fexcraft.mod.fvm.util;

import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class FvmTabs {
	
	public static final CreativeTabs VEHICLES = new CreativeTabs("fvm_vehicles"){
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(Registry.getItem("fvm:vehicle_item"));
		}
	};
	
	public static final CreativeTabs PARTS = new CreativeTabs("fvm_parts"){
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(Registry.getItem("fvm:part_null"));
		}
	};
	
	public static final CreativeTabs MATERIALS = new CreativeTabs("fvm_materials"){
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(Registry.getItem("fvm:material_null"));
		}
	};
	
	public static final CreativeTabs BLOCKS = new CreativeTabs("fvm_blocks"){
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(Blocks.IRON_BLOCK);
		}
	};
	
}