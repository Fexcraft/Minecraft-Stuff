package net.fexcraft.mod.lib.api.block;

public interface IBlock{
	
	/** Block name/id used in resourcelocation etc. without modid.*/
	public String getName();
	
	public boolean hasTileEntity();
	
	public int getVariantAmount();
	
	public int default_variant = 1;
}