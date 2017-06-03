package net.fexcraft.mod.fvm.util;

import net.fexcraft.mod.fvm.data.Material;
import net.fexcraft.mod.fvm.data.Part;
import net.fexcraft.mod.fvm.data.Vehicle;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class FvmTabs {
	
	private static int sec = 0;
	private static int mat_id = 0;
	private static int part_id = 0;
	private static int veh_id = 0;
	private static int black_id = 0;
	
	public static final CreativeTabs VEHICLES = new CreativeTabs("fvm_vehicles"){
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(Items.ACACIA_BOAT);
		}
		@Override
		public ItemStack getIconItemStack(){
			return new ItemStack(FvmResources.vehicles.size() > 0 ? ((Vehicle)FvmResources.vehicles.values().toArray()[veh_id]).item : Items.ACACIA_BOAT);
		}
	};
	
	public static final CreativeTabs PARTS = new CreativeTabs("fvm_parts"){
		@Override
		public ItemStack getTabIconItem(){
			return null;
		}
		@Override
		public ItemStack getIconItemStack(){
			return new ItemStack(FvmResources.parts.size() > 0 ? ((Part)FvmResources.parts.values().toArray()[part_id]).item : Items.IRON_DOOR);
		}
	};
	
	public static final CreativeTabs MATERIALS = new CreativeTabs("fvm_materials"){		
		@Override
		public ItemStack getTabIconItem(){
			return null;
		}
		@Override
		public ItemStack getIconItemStack(){
			update();
			return new ItemStack(FvmResources.materials.size() > 0 ? ((Material)FvmResources.materials.values().toArray()[mat_id]).item : Items.STONE_AXE);
		}
	};
	
	public static final CreativeTabs BLOCKS = new CreativeTabs("fvm_blocks"){
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(Blocks.IRON_BLOCK);
		}
	};
	
	private static final void update(){
		if(sec != Time.getSecond()){
			sec = Time.getSecond();
			mat_id++;
			if(mat_id >= FvmResources.materials.size()){
				mat_id = 0;
			}
			part_id++;
			if(part_id >= FvmResources.parts.size()){
				part_id = 0;
			}
			veh_id++;
			if(veh_id >= FvmResources.vehicles.size()){
				veh_id = 0;
			}
		}
	}
	
}