package net.fexcraft.mod.frsm.recipes;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public final class Recipes_Robo{
	public static void register(){
    	RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.rct, 1), new Object[]{
    		"AAEAA",
    		"BBCBB",
    		"BBDBB",
    		"B   B",
    		"B   B",
    		'A', Blocks.STONE_PRESSURE_PLATE, 'B', Items.IRON_INGOT, 'C', FRSM_Items.processor4, 'D', Blocks.REDSTONE_BLOCK, 'E', RecipeRegistry.workbench,
    	});
    	RecipeRegistry.addRecipe(new ItemStack(FRSM_Items.aic_empty, 1), new Object[]{
    		"A", 'A', FRSM_Items.processor,
    	});
    	RecipeRegistry.addRecipe(new ItemStack(FRSM_Items.r1_chassis, 4), new Object[]{
    		" AAA",
    		"AAAA",
    		'A', Items.IRON_INGOT,
    	});
    	/*RCTCraftingManager.addRecipe(new ItemStack(FRSM_Items.SRobo1B, 1), new Object[]{
    		"    B",
    		"     ",
    		" DA  ",
    		"     ",
    		"    C",
    		'A', FRSM_Items.processor, 'B', new ItemStack(Items.DYE, 1, 1), 'C', FRSM_Items.aic_Z1, 'D', FRSM_Items.r1_chassis
    	});
    	RCTCraftingManager.addRecipe(new ItemStack(FRSM_Items.SRobo1BB, 1), new Object[]{
    		"    B",
    		"     ",
    		" DA  ",
    		"     ",
    		"    C",
    		'A', FRSM_Items.processor, 'B', new ItemStack(Items.DYE, 1, 4), 'C', FRSM_Items.aic_Z1, 'D', FRSM_Items.r1_chassis
    	});
    	RCTCraftingManager.addRecipe(new ItemStack(FRSM_Items.SRobo1BG, 1), new Object[]{
    		"    B",
    		"     ",
    		" DA  ",
    		"     ",
    		"    C",
    		'A', FRSM_Items.processor, 'B', new ItemStack(Items.DYE, 1, 2), 'C', FRSM_Items.aic_Z1, 'D', FRSM_Items.r1_chassis
    	});
    	RCTCraftingManager.addRecipe(new ItemStack(FRSM_Items.SRobo1BY, 1), new Object[]{
    		"    B",
    		"     ",
    		" DA  ",
    		"     ",
    		"    C",
    		'A', FRSM_Items.processor, 'B', new ItemStack(Items.DYE, 1, 11), 'C', FRSM_Items.aic_Z1, 'D', FRSM_Items.r1_chassis
    	});*/
	}
}