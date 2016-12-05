package net.fexcraft.mod.lib.api.item;

public interface IItem{
	
	public String getName();

	public int getVariantAmount();
	
	public int default_variant = 1;
}