package net.fexcraft.mod.extensions.cae.blocks;

import net.fexcraft.mod.extensions.cae.items.PlanningItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class CAEBlocks{
	
	public static Block custom_asphalt;
	public static Block custom_asphalt_nolayer;
	public static Item planning_item;
	
	public static void register(){
		custom_asphalt = new CustomAsphaltBlock();
		custom_asphalt_nolayer = new CAB2();
		planning_item = new PlanningItem();
	}
	
}