package net.fexcraft.mod.frsm.recipes;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class Recipes_Chairs{
	public static void register(){
		
		//OC//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.officechair, 1), new Object[]{
    		"B  ",
    		"BB ",
    		"A  ",
    		'A', Items.IRON_INGOT, 'B', new ItemStack(Blocks.WOOL, 1, 1),
    	});
    	//OCB//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.officechair_black, 1), new Object[]{
    		"B  ",
    		"BB ",
    		"A  ",
    		'A', Items.IRON_INGOT, 'B', new ItemStack(Blocks.WOOL, 1, 15),
    	});
    	//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.officechair_black, 1), new Object[]{
    		"B  ",
    		"BB ",
    		"A  ",
    		'A', Items.IRON_INGOT, 'B', Blocks.WOOL,
    	});
    	//OCG//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.officechair_gray, 1), new Object[]{
    		"B  ",
    		"BB ",
    		"A  ",
    		'A', Items.IRON_INGOT, 'B', new ItemStack(Blocks.WOOL, 1, 8),
    	});
    	//OCW//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.officechair_white, 1), new Object[]{
    		"B  ",
    		"BB ",
    		"A  ",
    		'A', Items.IRON_INGOT, 'B', new ItemStack(Blocks.WOOL, 1, 0),
    	});
	}
}