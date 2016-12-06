package net.fexcraft.mod.extensions.ve.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CTS{
	
	public static CreativeTabs VEHICLES;
	public static CreativeTabs PARTS;
	
	public static void init(){
		VEHICLES = new CreativeTabs("tabFRSMVE-Vehicles"){@Override public Item getTabIconItem(){return Item.getItemFromBlock(Blocks.IRON_BLOCK);}};
		PARTS = new CreativeTabs("tabFRSMVE-Parts"){@Override public Item getTabIconItem(){return Items.IRON_INGOT;}};
	}
}