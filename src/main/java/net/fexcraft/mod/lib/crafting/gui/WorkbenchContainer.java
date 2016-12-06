package net.fexcraft.mod.lib.crafting.gui;

import javax.annotation.Nullable;

import net.fexcraft.mod.lib.crafting.CraftingInventory;
import net.fexcraft.mod.lib.crafting.CraftingSlot;
import net.fexcraft.mod.lib.crafting.ManagerCrafting;
import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorkbenchContainer extends Container {
	
    /** The crafting matrix (5x5). */
    public CraftingInventory craftMatrix = new CraftingInventory(this, 5, 5);
    public IInventory craftResult = new InventoryCraftResult();
    private final World worldObj;
    private final BlockPos pos;
    
    public WorkbenchContainer(InventoryPlayer playerInventory, World worldIn, BlockPos posIn){
        this.worldObj = worldIn;
        this.pos = posIn;
        this.addSlotToContainer(new CraftingSlot(playerInventory.player, this.craftMatrix, this.craftResult, 0, 141, 43));
        int id = 0;
        for(int i = 0; i < 5; ++i){
            for (int j = 0; j < 5; ++j){
                this.addSlotToContainer(new Slot(this.craftMatrix, id, 8 + j * 18, 7 + i * 18));
                id++;
            }
        }
        for(int k = 0; k < 3; ++k){
            for(int i1 = 0; i1 < 9; ++i1){
                this.addSlotToContainer(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 106 + k * 18));
            }
        }
        for(int l = 0; l < 9; ++l){
            this.addSlotToContainer(new Slot(playerInventory, l, 8 + l * 18, 164));
        }
        this.onCraftMatrixChanged(this.craftMatrix);
    }
    
    @Override
    public void onCraftMatrixChanged(IInventory inventoryIn){
        this.craftResult.setInventorySlotContents(0, ManagerCrafting.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
    }
    
    public void onContainerClosed(EntityPlayer playerIn){
        super.onContainerClosed(playerIn);
        if(!this.worldObj.isRemote){
            for(int i = 0; i < 25; ++i){
                ItemStack itemstack = this.craftMatrix.removeStackFromSlot(i);
                if(itemstack != null){
                    playerIn.dropItem(itemstack, false);
                }
            }
        }
    }

    public boolean canInteractWith(EntityPlayer playerIn){
        return this.worldObj.getBlockState(this.pos).getBlock() != RecipeRegistry.workbench ? false : playerIn.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }
    
    @Nullable
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index){
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(index);
        if(slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if(index == 0){
                if(!this.mergeItemStack(itemstack1, 10, 62, true)){
                    return null;
                }
                slot.onSlotChange(itemstack1, itemstack);
            }
            else if(index >= 10 && index < 37){
                if(!this.mergeItemStack(itemstack1, 37, 62, false)){
                    return null;
                }
            }
            else if(index >= 37 && index < 62){
                if(!this.mergeItemStack(itemstack1, 10, 37, false)){
                    return null;
                }
            }
            else if(!this.mergeItemStack(itemstack1, 10, 62, false)){
                return null;
            }
            if(itemstack1.stackSize == 0){
                slot.putStack((ItemStack)null);
            }
            else{
                slot.onSlotChanged();
            }
            if(itemstack1.stackSize == itemstack.stackSize){
                return null;
            }
            slot.onPickupFromSlot(playerIn, itemstack1);
        }
        return itemstack;
    }
    
    public boolean canMergeSlot(ItemStack stack, Slot slotIn){
        return slotIn.inventory != this.craftResult && super.canMergeSlot(stack, slotIn);
    }
}