package net.fexcraft.mod.lib.api.common;

import net.minecraft.util.EnumFacing;

public interface IFluidContainerTile {
	
	public String ffu_id(EnumFacing ef);
	
	public int ffu_get(EnumFacing ef);
	
	public void ffu_set(EnumFacing ef, int e);
	
	public void ffu_add(EnumFacing ef, int e);
	
	public void ffu_subtract(EnumFacing ef, int e);
	
	public int ffu_max(EnumFacing ef);
	
	public int ffu_min(EnumFacing ef);
	
	public int ffu_transfer_speed(EnumFacing ef);
	
	public EnumFacing ffu_input();
	
	public boolean ffu_isInput(EnumFacing ef);
	
	public EnumFacing ffu_output();
	
	public boolean ffu_isOutput(EnumFacing ef);
	
	public void ffu_setInput(EnumFacing ef, int i);
	
	public void ffu_setOutput(EnumFacing ef, int i);
	
	public void detectAndSendChanges(EnumFacing ef);
	
}