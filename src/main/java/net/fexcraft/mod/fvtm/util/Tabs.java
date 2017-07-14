package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.api.LandVehicle;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Tabs {
	
	private static int sec = 0;
	private static int mat_id = 0;
	private static int part_id = 0;
	private static int veh_id = 0;
	private static int block_id = 0;
	
	public static final CreativeTabs LANDVEHICLES = new CreativeTabs("fvm_landvehicles"){
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(Items.ACACIA_BOAT);
		}
		@Override
		public ItemStack getIconItemStack(){
			return Resources.LANDVEHICLES.getEntries().size() > 0 ? ((LandVehicle)Resources.LANDVEHICLES.getValues().toArray()[veh_id]).getItemStack(null) : new ItemStack(Items.ACACIA_BOAT);
		}
	};
	
	public static final CreativeTabs PARTS = new CreativeTabs("fvm_parts"){
		@Override
		public ItemStack getTabIconItem(){
			return null;
		}
		@Override
		public ItemStack getIconItemStack(){
			return Resources.PARTS.getEntries().size() > 0 ? ((Part)Resources.PARTS.getValues().toArray()[part_id]).getItemStack(null) : new ItemStack(Items.IRON_DOOR);
		}
	};
	
	public static final CreativeTabs MATERIALS = new CreativeTabs("fvtm_materials"){		
		@Override
		public ItemStack getTabIconItem(){
			return null;
		}
		@Override
		public ItemStack getIconItemStack(){
			update();
			return Resources.MATERIALS.getEntries().size() > 0 ? ((Material)Resources.MATERIALS.getValues().toArray()[mat_id]).getItemStack() : new ItemStack(Items.STONE_AXE);
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
			if(mat_id >= Resources.MATERIALS.getEntries().size()){
				mat_id = 0;
			}
			part_id++;
			if(part_id >= Resources.PARTS.getEntries().size()){
				part_id = 0;
			}
			veh_id++;
			if(veh_id >= Resources.LANDVEHICLES.getEntries().size()){
				veh_id = 0;
			}
		}
	}
	
}