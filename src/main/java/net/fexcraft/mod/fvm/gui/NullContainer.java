package net.fexcraft.mod.fvm.gui;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class NullContainer implements IInventory {
	
	private NonNullList<ItemStack> stacks;
	public static final ArrayList<String> LIST = new ArrayList<String>();
	
	public NullContainer(int i){
		stacks = NonNullList.<ItemStack>withSize(i, new ItemStack(Blocks.BARRIER));
		if(LIST.isEmpty()){
			LIST.add("minecraft:barrier");
		}
	}

	@Override
	public String getName(){
		return "null";
	}

	@Override
	public boolean hasCustomName(){
		return false;
	}

	@Override
	public ITextComponent getDisplayName(){
		return new TextComponentString(getName());
	}

	@Override
	public int getSizeInventory(){
		return stacks.size();
	}

	public void readFromNBT(NBTTagCompound tag) {
		ItemStackHelper.loadAllItems(tag, stacks);
	}
	
	public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		return ItemStackHelper.saveAllItems(tag, stacks);
	}
	
	@Override
	public boolean isEmpty(){
		return stacks.isEmpty();
	}

	@Override
	public ItemStack getStackInSlot(int index){
		return stacks.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count){
		return ItemStack.EMPTY.copy();
	}

	@Override
	public ItemStack removeStackFromSlot(int index){
		return ItemStack.EMPTY.copy();
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		//
	}

	@Override
	public int getInventoryStackLimit(){
		return 128;
	}

	@Override
	public void markDirty(){
		// ?
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player){
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player){
		//
	}

	@Override
	public void closeInventory(EntityPlayer player){
		//
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack){
		return false;
	}

	@Override
	public int getField(int id){
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		//
	}

	@Override
	public int getFieldCount(){
		return 0;
	}

	@Override
	public void clear(){
		stacks.clear();
	}
	
}