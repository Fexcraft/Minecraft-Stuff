package net.fexcraft.mod.lib.crafting;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class CraftingInventory implements IInventory {
	
	private final NonNullList<ItemStack> stackList;
    private final int inventoryWidth;
    private final int inventoryHeight;
    private final Container eventHandler;

    public CraftingInventory(Container eventHandlerIn, int width, int height){
        int i = width * height;
        this.stackList = NonNullList.<ItemStack>withSize(width * height, ItemStack.EMPTY);//new ItemStack[i];
        this.eventHandler = eventHandlerIn;
        this.inventoryWidth = width;
        this.inventoryHeight = height;
    }
    
    public int getSizeInventory(){
        return this.stackList.size();
    }
    
    @Nullable
    public ItemStack getStackInSlot(int index){
        return index >= this.getSizeInventory() ? null : this.stackList.get(index);
    }
    
    @Nullable
    public ItemStack getStackInRowAndColumn(int row, int column){
        return row >= 0 && row < this.inventoryWidth && column >= 0 && column <= this.inventoryHeight ? this.getStackInSlot(row + column * this.inventoryWidth) : null;
    }
    
    public String getName(){
        return "container.crafting";
    }
    
    public boolean hasCustomName(){
        return false;
    }
    
    public ITextComponent getDisplayName(){
        return (ITextComponent)(this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]));
    }
    
    @Nullable
    public ItemStack removeStackFromSlot(int index){
        return ItemStackHelper.getAndRemove(this.stackList, index);
    }
    
    @Nullable
    public ItemStack decrStackSize(int index, int count){
        ItemStack itemstack = ItemStackHelper.getAndSplit(this.stackList, index, count);
        if (itemstack != null){
            this.eventHandler.onCraftMatrixChanged(this);
        }
        return itemstack;
    }
    
    public void setInventorySlotContents(int index, @Nullable ItemStack stack){
        this.stackList.set(index, stack);
        this.eventHandler.onCraftMatrixChanged(this);
    }
    
    public int getInventoryStackLimit(){
        return 64;
    }
    
    public void markDirty(){}
    
    public boolean isUseableByPlayer(EntityPlayer player){
        return true;
    }

    public void openInventory(EntityPlayer player){}

    public void closeInventory(EntityPlayer player){}
    
    public boolean isItemValidForSlot(int index, ItemStack stack){
        return true;
    }

    public int getField(int id){
        return 0;
    }

    public void setField(int id, int value){}

    public int getFieldCount(){
    	return 0;
    }

    public void clear(){
        /*for(int i = 0; i < this.stackList.length; ++i){
            this.stackList[i] = null;
        }*/
    	this.stackList.clear();
    }

    public int getHeight(){
        return this.inventoryHeight;
    }

    public int getWidth(){
        return this.inventoryWidth;
    }

	@Override
	public boolean isEmpty(){
		for(ItemStack itemstack : this.stackList){
            if(!itemstack.isEmpty()){
                return false;
            }
        }
        return true;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player){
		return true;
	}
}