package net.fexcraft.mod.frsm.recipes;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public final class Recipes_Flags{
	public static void register(){
    	RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.flag0, 16), new Object[]{
    		"BAAAB",
    		"BCCCB",
    		"BCCCB",
    		"BCCCB",
    		" BCB ",
    		'A', Blocks.LOG, 'B', Items.STICK, 'C', new ItemStack(Blocks.WOOL, 1, 0)
    	});
    	RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.flag1, 16), new Object[]{
    		"BAAAB",
    		"BCCCB",
    		"BCCCB",
    		"BCCCB",
    		" BCB ",
    		'A', Blocks.LOG, 'B', Items.STICK, 'C', new ItemStack(Blocks.WOOL, 1, 1)
    	});
    	RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.flag2, 16), new Object[]{
    		"BAAAB",
    		"BCCCB",
    		"BCCCB",
    		"BCCCB",
    		" BCB ",
    		'A', Blocks.LOG, 'B', Items.STICK, 'C', new ItemStack(Blocks.WOOL, 1, 2)
    	});
    	RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.flag3, 16), new Object[]{
    		"BAAAB",
    		"BCCCB",
    		"BCCCB",
    		"BCCCB",
    		" BCB ",
    		'A', Blocks.LOG, 'B', Items.STICK, 'C', new ItemStack(Blocks.WOOL, 1, 3)
    	});
	}
}