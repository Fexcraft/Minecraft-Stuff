package net.fexcraft.mod.frsm.recipes;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class Recipes_Pillars {
	public static void register(){
		//Pillar//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.pillar, 4), new Object[]
    	{
    		new ItemStack(Blocks.QUARTZ_BLOCK, 0, 2),
    	});
    	//Pillar2//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.pillar2, 4), new Object[]
    	{
    		FRSM_Blocks.pillar, FRSM_Blocks.pillar, FRSM_Blocks.pillar, FRSM_Blocks.pillar, new ItemStack(Blocks.QUARTZ_BLOCK, 0, 0),
    	});
    	//Pillar3//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.pillar3, 2), new Object[]
    	{
    		FRSM_Blocks.pillar, FRSM_Blocks.pillar, new ItemStack(Blocks.QUARTZ_BLOCK, 0, 0),
    	});
	}
}