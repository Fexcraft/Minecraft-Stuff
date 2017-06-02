package net.fexcraft.mod.fvm.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FvmTabs {
	
	public static final CreativeTabs VEHICLES = new CreativeTabs("fvm_vehicles"){
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(Items.ACACIA_BOAT);//Registry.getItem("fvm:vehicle_item"));
		}
	};
	
	public static final CreativeTabs PARTS = new CreativeTabs("fvm_parts"){
		@Override
		public ItemStack getTabIconItem(){
			Item item = FvmResources.getRandomPart();
			return new ItemStack(item == null ? Items.IRON_DOOR : item);
		}
	};
	
	public static final CreativeTabs MATERIALS = new CreativeTabs("fvm_materials"){
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(Items.STONE_AXE);//Registry.getItem("fvm:material_null"));
		}
	};
	
	public static final CreativeTabs BLOCKS = new CreativeTabs("fvm_blocks"){
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(Blocks.IRON_BLOCK);
		}
	};
	
}