package net.fexcraft.mod.frsm.recipes;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class Recipes_Rails {
	public static void register(){
		//Rail//
		GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.rail, 16), new Object[]{
			"A A",
			"ABA",
			"A A",
			'A', Items.STICK, 'B', Items.IRON_INGOT,
		});
		GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.rail, 1), new Object[]
			{
			FRSM_Blocks.railturn
		});
		//RailTurn//
		GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.railturn, 1), new Object[]
			{
			FRSM_Blocks.rail
		});
		//Train1D//
		GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.Train1D, 2), new Object[]{
			"   ",
			" B ",
			" A ",
			'A', FRSM_Blocks.rail, 'B', Items.IRON_INGOT,
		});
		//Station//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.station, 1), new Object[]{
    		"   ",
    		"AB ",
    		"   ",
    		'A', Items.IRON_INGOT, 'B', FRSM_Blocks.rail,
    	});
    	//Station2//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.station2, 1), new Object[]{
    		"   ",
    		"ABA",
    		"   ",
    		'A', Items.IRON_INGOT, 'B', FRSM_Blocks.rail,
    	});
    	//Station3//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.station3, 1), new Object[]
    	{
    		FRSM_Blocks.station2, Items.GLOWSTONE_DUST,
    	});
	}
}