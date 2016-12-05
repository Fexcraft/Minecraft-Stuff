package net.fexcraft.mod.frsm.recipes;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class Recipes_Tiles {
	public static void register(){
		//TilesEmpty//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.tiles_empty, 9), new Object[]{
    		"AAA",
    		"AAA",
    		"AAA",
    		'A', Items.CLAY_BALL,
    	});
    	//Tiles//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.tiles, 9), new Object[]{
    		"AAA",
    		"ABA",
    		"AAA",
    		'A', FRSM_Items.tiles_empty, 'B', new ItemStack(Items.DYE, 1, 8)
    	});
    	//Tiles2//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.tiles2, 9), new Object[]{
    		"AAA",
    		"ABA",
    		"AAA",
    		'A', FRSM_Blocks.tiles, 'B', Blocks.GLOWSTONE
    	});
    	//Tiles3//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.tiles3, 3), new Object[]
    	{
    		Blocks.STONEBRICK, Blocks.STONEBRICK,
    	});
    	//Tiles4//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.tiles4, 6), new Object[]{
    		"AAA",
    		"CBC",
    		"AAA",
    		'A', FRSM_Items.tiles_empty, 'B', new ItemStack(Items.DYE, 1, 8), 'C', new ItemStack(Items.DYE, 1, 7)
    	});
	}
}
