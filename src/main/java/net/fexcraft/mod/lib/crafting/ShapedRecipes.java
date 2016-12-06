package net.fexcraft.mod.lib.crafting;

import javax.annotation.Nullable;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ShapedRecipes implements IRecipe {
	
    public final int recipeWidth;
    public final int recipeHeight;
    public final ItemStack[] recipeItems;
    private final ItemStack recipeOutput;
    private boolean copyIngredientNBT;

    public ShapedRecipes(int width, int height, ItemStack[] p_i1917_3_, ItemStack output){
        this.recipeWidth = width;
        this.recipeHeight = height;
        this.recipeItems = p_i1917_3_;
        this.recipeOutput = output;
    }

    @Nullable
    public ItemStack getRecipeOutput(){
        return this.recipeOutput;
    }

    public ItemStack[] getRemainingItems(CraftingInventory inv){
        ItemStack[] aitemstack = new ItemStack[inv.getSizeInventory()];
        for(int i = 0; i < aitemstack.length; ++i){
            ItemStack itemstack = inv.getStackInSlot(i);
            aitemstack[i] = net.minecraftforge.common.ForgeHooks.getContainerItem(itemstack);
        }
        return aitemstack;
    }
    
    public boolean matches(CraftingInventory inv, World worldIn){
        for(int i = 0; i <= 5 - this.recipeWidth; ++i){
            for(int j = 0; j <= 5 - this.recipeHeight; ++j){
                if(this.checkMatch(inv, i, j, true)){
                    return true;
                }
                if(this.checkMatch(inv, i, j, false)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean checkMatch(CraftingInventory p_77573_1_, int p_77573_2_, int p_77573_3_, boolean p_77573_4_){
        for(int i = 0; i < 5; ++i){
            for(int j = 0; j < 5; ++j){
                int k = i - p_77573_2_;
                int l = j - p_77573_3_;
                ItemStack itemstack = null;
                if(k >= 0 && l >= 0 && k < this.recipeWidth && l < this.recipeHeight){
                    if (p_77573_4_){
                        itemstack = this.recipeItems[this.recipeWidth - k - 1 + l * this.recipeWidth];
                    }
                    else{
                        itemstack = this.recipeItems[k + l * this.recipeWidth];
                    }
                }
                ItemStack itemstack1 = p_77573_1_.getStackInRowAndColumn(i, j);
                if(itemstack1 != null || itemstack != null){
                    if(itemstack1 == null && itemstack != null || itemstack1 != null && itemstack == null){
                        return false;
                    }
                    if(itemstack.getItem() != itemstack1.getItem()){
                        return false;
                    }
                    if(itemstack.getMetadata() != 32767 && itemstack.getMetadata() != itemstack1.getMetadata()){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    @Nullable
    public ItemStack getCraftingResult(CraftingInventory inv){
        ItemStack itemstack = this.getRecipeOutput().copy();
        if (this.copyIngredientNBT){
            for (int i = 0; i < inv.getSizeInventory(); ++i){
            	ItemStack itemstack1 = inv.getStackInSlot(i);
                if (itemstack1 != null && itemstack1.hasTagCompound()){
                    itemstack.setTagCompound(itemstack1.getTagCompound().copy());
                }
            }
        }
        return itemstack;
    }
    
    public int getRecipeSize(){
        return this.recipeWidth * this.recipeHeight;
    }
    
}