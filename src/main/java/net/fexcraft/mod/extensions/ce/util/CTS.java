package net.fexcraft.mod.extensions.ce.util;

import net.fexcraft.mod.extensions.ce.blocks.ClockBlockBase;
import net.fexcraft.mod.lib.util.cls.Static;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CTS extends CreativeTabs {
	
	public static final CTS tabClocks = new CTS();
	
	public CTS(){
		super("tabCE");
	}

	@Override
	public ItemStack getTabIconItem(){
		return new ItemStack(ClockBlockBase.getClocksList().get(Static.random.nextInt(ClockBlockBase.getClocksList().size())));
	}
	
}