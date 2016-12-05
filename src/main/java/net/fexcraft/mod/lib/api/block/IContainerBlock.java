package net.fexcraft.mod.lib.api.block;

public interface IContainerBlock extends IBlock{
	
	/** If true, implement {@link IMashineBlock} instead, else leave on false; */
	public boolean isMashine();
	
}