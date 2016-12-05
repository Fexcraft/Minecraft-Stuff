package net.fexcraft.mod.lib.crafting;

import javax.annotation.Nullable;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IRecipe{
	
    boolean matches(CraftingInventory inv, World worldIn);
    
    @Nullable
    ItemStack getCraftingResult(CraftingInventory inv);
    
    int getRecipeSize();
    
    @Nullable
    ItemStack getRecipeOutput();

    ItemStack[] getRemainingItems(CraftingInventory inv);
    
}