package net.fexcraft.mod.lib.api.tileentity;

import net.minecraft.item.ItemStack;

public interface IItemContainerTileEntity extends IContainerTileEntity{
	
	public int maxSlots = 54;
	
	public ItemStack[] getItemStacks();
	
	public void setItemStacks(ItemStack[] stack);
	
	public void setItemStack(ItemStack stack, int slot);
	
	public int getSlotAmount();
	
	public ItemStack getItemStackInSlot(int slot);
	
}