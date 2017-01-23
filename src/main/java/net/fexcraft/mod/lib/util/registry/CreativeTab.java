package net.fexcraft.mod.lib.util.registry;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {
	
	private static final Set<CreativeTab> tabs = new HashSet<CreativeTab>();
	private String item;
	private short meta;

	public CreativeTab(String label, String item, short i){
		super(label);
		this.item = item;
		this.meta = i;
		tabs.add(this);
	}

	@Override
	public ItemStack getTabIconItem(){
		return new ItemStack(Item.getByNameOrId(item), 1, meta);
	}
	
	public static void getIcons(){
		for(CreativeTab tab : tabs){
			tab.getTabIconItem();
		}
	}
	
}