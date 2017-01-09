package net.fexcraft.mod.extensions.ce.items;
import net.minecraft.item.Item;

public final class CE_Items{
	
	public static Item universal_tool;
	
	public static void init(){
		universal_tool = new Tool();
	}
}