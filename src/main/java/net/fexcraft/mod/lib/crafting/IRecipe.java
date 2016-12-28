package net.fexcraft.mod.lib.crafting;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public interface IRecipe {
	
	boolean matches(CraftingInventory inv, World worldIn);
	
	ItemStack getCraftingResult(CraftingInventory inv);
	
	int getRecipeSize();

    ItemStack getRecipeOutput();

    NonNullList<ItemStack> getRemainingItems(CraftingInventory craftMatrix);
    
}