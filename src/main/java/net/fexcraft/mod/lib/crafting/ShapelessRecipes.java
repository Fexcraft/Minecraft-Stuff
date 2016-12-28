package net.fexcraft.mod.lib.crafting;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ShapelessRecipes implements IRecipe {
	
    private final ItemStack recipeOutput;
    public final List<ItemStack> recipeItems;

    public ShapelessRecipes(ItemStack output, List<ItemStack> inputList){
        this.recipeOutput = output;
        this.recipeItems = inputList;
    }

    public ItemStack getRecipeOutput(){
        return this.recipeOutput;
    }

    public NonNullList<ItemStack> getRemainingItems(CraftingInventory inv){
        NonNullList<ItemStack> nonnulllist = NonNullList.<ItemStack>withSize(inv.getSizeInventory(), ItemStack.EMPTY);
        for(int i = 0; i < nonnulllist.size(); ++i){
            ItemStack itemstack = inv.getStackInSlot(i);
            nonnulllist.set(i, net.minecraftforge.common.ForgeHooks.getContainerItem(itemstack));
        }
        return nonnulllist;
    }
    
    public boolean matches(CraftingInventory inv, World worldIn){
        List<ItemStack> list = Lists.newArrayList(this.recipeItems);
        for(int i = 0; i < inv.getHeight(); ++i){
            for(int j = 0; j < inv.getWidth(); ++j){
                ItemStack itemstack = inv.getStackInRowAndColumn(j, i);
                if(!itemstack.isEmpty()){
                    boolean flag = false;
                    for(ItemStack itemstack1 : list){
                        if(itemstack.getItem() == itemstack1.getItem() && (itemstack1.getMetadata() == 32767 || itemstack.getMetadata() == itemstack1.getMetadata())){
                            flag = true;
                            list.remove(itemstack1);
                            break;
                        }
                    }
                    if(!flag){
                        return false;
                    }
                }
            }
        }
        return list.isEmpty();
    }
    
    public ItemStack getCraftingResult(CraftingInventory inv){
        return this.recipeOutput.copy();
    }
    
    public int getRecipeSize(){
        return this.recipeItems.size();
    }
    
}