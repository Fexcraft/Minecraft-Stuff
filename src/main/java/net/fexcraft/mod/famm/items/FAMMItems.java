package net.fexcraft.mod.famm.items;

import net.minecraft.item.Item;

public final class FAMMItems {
	
	public static Item ink;
	public static Item plate_empty;
	public static Item plate_painted;
	
	public static void init(){
		ink = new Ink();
		plate_empty = new PlateEmpty();
		plate_painted = new PlatePainted();
	}
	
}