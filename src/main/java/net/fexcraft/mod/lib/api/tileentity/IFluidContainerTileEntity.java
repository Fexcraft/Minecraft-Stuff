package net.fexcraft.mod.lib.api.tileentity;

import net.fexcraft.mod.lib.util.cls.EnumNumberType;
import net.fexcraft.mod.lib.util.cls.FFU;

public interface IFluidContainerTileEntity extends IContainerTileEntity{
	
	public FFU getFluid();
	
	public void setFluid(FFU f);
	
	public void setAmount(Number n);
	
	public int getMaxAmount();

	public int getMinAmount();
	
	public EnumNumberType getNumberType();
	
	@Deprecated
	public boolean canAmountBeNegative();
	
}