package net.fexcraft.mod.frsm.recipes;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public final class Recipes_Palets{
	public static void register(){
		//Palet1x1
		RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.palet1x1, 1), new Object[]{
    		"AAAA",
    		"B  B",
    		"AAAA",
    		'A', FRSM_Items.planks_oak, 'B', Blocks.LOG,
    	});
		//Palet1x1_1
		RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.palet1x1_1, 1), new Object[]{
    		"B",
    		"A",
    		'A', FRSM_Blocks.palet1x1, 'B', FRSM_Items.nesr,
    	});
		//Palet1x1_2
		RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.palet1x1_2, 1), new Object[]{
    		"B",
    		"B",
    		"A",
    		'A', FRSM_Blocks.palet1x1, 'B', FRSM_Items.nesr,
    	});
	}
}