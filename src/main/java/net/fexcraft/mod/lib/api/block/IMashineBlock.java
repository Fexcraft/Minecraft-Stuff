package net.fexcraft.mod.lib.api.block;

import net.fexcraft.mod.lib.util.cls.EnumMashineType;

public interface IMashineBlock extends IContainerBlock{
	
	public EnumMashineType getMashineType();
	
	/*@Deprecated
	public FPU getPowerLevel();
	
	@Deprecated
	public void setPowerLevel(int e);*/
}