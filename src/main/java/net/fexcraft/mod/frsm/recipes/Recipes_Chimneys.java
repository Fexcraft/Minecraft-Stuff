package net.fexcraft.mod.frsm.recipes;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public final class Recipes_Chimneys{
	public static void register(){
    	RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.chimney, 8, 0), new Object[]{
    		"B B",
    		"B B",
    		"B B",
    		"B B",
    		'B', Blocks.BRICK_BLOCK,
    	});
    	RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.chimney1, 8, 0), new Object[]{
    		"B B",
    		"B B",
    		"B B",
    		"B B",
    		'B', Blocks.STONEBRICK,
    	});
    	RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.chimney2, 8, 0), new Object[]{
    		"B B",
    		"B B",
    		"B B",
    		"B B",
    		'B', Blocks.NETHER_BRICK,
    	});
    	RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.chimney3, 8, 0), new Object[]{
    		"B B",
    		"B B",
    		"B B",
    		"B B",
    		'B', Blocks.SANDSTONE,
    	});
    	RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.chimney4, 8, 0), new Object[]{
    		"B B",
    		"B B",
    		"B B",
    		"B B",
    		'B', Blocks.END_STONE,
    	});
	}
}