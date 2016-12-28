package net.fexcraft.mod.lib.crafting;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ShapedRecipes implements IRecipe {
	
    public final int recipeWidth;
    public final int recipeHeight;
    public final ItemStack[] recipeItems;
    private final ItemStack recipeOutput;
    private boolean copyIngredientNBT;

    public ShapedRecipes(int width, int height, ItemStack[] ingredients, ItemStack output){
        this.recipeWidth = width;
        this.recipeHeight = height;
        this.recipeItems = ingredients;
        for(int i = 0; i < this.recipeItems.length; ++i){
            if(this.recipeItems[i] == null){
                this.recipeItems[i] = ItemStack.EMPTY;
            }
        }
        this.recipeOutput = output;
    }

    public ItemStack getRecipeOutput(){
        return this.recipeOutput;
    }

    public NonNullList<ItemStack> getRemainingItems(CraftingInventory inv){
        NonNullList<ItemStack> nonnulllist = NonNullList.<ItemStack>withSize(inv.getSizeInventory(), ItemStack.EMPTY);
        for (int i = 0; i < nonnulllist.size(); ++i){
            ItemStack itemstack = inv.getStackInSlot(i);
            nonnulllist.set(i, net.minecraftforge.common.ForgeHooks.getContainerItem(itemstack));
        }
        return nonnulllist;
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
    
    private boolean checkMatch(CraftingInventory ic, int p_77573_2_, int p_77573_3_, boolean bool){
        for (int i = 0; i < 5; ++i){
            for (int j = 0; j < 5; ++j){
                int k = i - p_77573_2_;
                int l = j - p_77573_3_;
                ItemStack itemstack = ItemStack.EMPTY;
                if(k >= 0 && l >= 0 && k < this.recipeWidth && l < this.recipeHeight){
                    if(bool){
                        itemstack = this.recipeItems[this.recipeWidth - k - 1 + l * this.recipeWidth];
                    }
                    else{
                        itemstack = this.recipeItems[k + l * this.recipeWidth];
                    }
                }
                ItemStack itemstack1 = ic.getStackInRowAndColumn(i, j);
                if(!itemstack1.isEmpty() || !itemstack.isEmpty()){
                    if(itemstack1.isEmpty() != itemstack.isEmpty()){
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
    
    public ItemStack getCraftingResult(CraftingInventory inv){
        ItemStack itemstack = this.getRecipeOutput().copy();
        if(this.copyIngredientNBT){
            for(int i = 0; i < inv.getSizeInventory(); ++i){
                ItemStack itemstack1 = inv.getStackInSlot(i);
                if(!itemstack1.isEmpty() && itemstack1.hasTagCompound()){
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