package net.fexcraft.mod.fvtm.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class FuelInventory implements IInventory {
	
	private NonNullList<ItemStack> fuelinv = NonNullList.<ItemStack>withSize(1, ItemStack.EMPTY);
	
	@Override
	public String getName(){
		return fuelinv.get(0).isEmpty() ? "Null;" : fuelinv.get(0).getDisplayName();
	}

	@Override
	public boolean hasCustomName(){
		return true;
	}

	@Override
	public ITextComponent getDisplayName(){
		return new TextComponentString(getName());
	}

	@Override
	public int getSizeInventory(){
		return 1;
	}

	@Override
	public boolean isEmpty(){
		return fuelinv.get(0).isEmpty();
	}

	@Override
	public ItemStack getStackInSlot(int index){
		return fuelinv.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count){
		return !getStackInSlot(index).isEmpty() ? ItemStackHelper.getAndSplit(fuelinv, index, count) : ItemStack.EMPTY;
	}

	@Override
	public ItemStack removeStackFromSlot(int index){
		return fuelinv.set(index, ItemStack.EMPTY);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack){
		fuelinv.set(index, stack);
	}

	@Override
	public int getInventoryStackLimit(){
		return 1;
	}

	@Override
	public void markDirty(){
		//
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player){
		return !player.isDead;
	}

	@Override
	public void openInventory(EntityPlayer player){
		//
	}

	@Override
	public void closeInventory(EntityPlayer player){
		player.dropItem(fuelinv.get(0), false);
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack){
		return true;
	}

	@Override
	public int getField(int id){
		return 0;
	}

	@Override
	public void setField(int id, int value){
		//
	}

	@Override
	public int getFieldCount(){
		return 0;
	}

	@Override
	public void clear(){
		fuelinv.clear();
	}
	
}