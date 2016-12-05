package net.fexcraft.mod.frsm.recipes;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public final class Recipes_Stove_Pipes{
	public static void register(){
		RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.pipe1, 1), new Object[]{
    		"A",
    		"A",
    		"A",
    		'A', Items.IRON_INGOT,
    	});
		RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.pipe1b, 1), new Object[]{
    		"AAA",
    		'A', Items.IRON_INGOT,
    	});
		RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.pipe1c, 4), new Object[]{
    		" A ",
    		"BCB",
    		" A ",
    		'A', FRSM_Blocks.pipe1, 'B', FRSM_Blocks.pipe1b, 'C', Items.IRON_INGOT
    	});
		RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.pipe1d, 4), new Object[]{
    		"A ",
    		"AB",
    		"A ",
    		'A', FRSM_Blocks.pipe1, 'B', FRSM_Blocks.pipe1b
    	});
		RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.pipe1e, 2), new Object[]{
    		"CB",
    		"A ",
    		'A', FRSM_Blocks.pipe1, 'B', FRSM_Blocks.pipe1b, 'C', Items.IRON_INGOT
    	});
		RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.pipe1f, 2), new Object[]{
    		"A ",
    		"CB",
    		'A', FRSM_Blocks.pipe1, 'B', FRSM_Blocks.pipe1b, 'C', Items.IRON_INGOT
    	});
	}
}