package net.fexcraft.mod.frsm.recipes;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public final class Recipes_TreePot{
	public static void register(){
		RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.tree_pot, 1), new Object[]{
    		"A   A",
    		"A   A",
    		" AAA ",
    		'A', Items.BRICK,
    	});
	}
}