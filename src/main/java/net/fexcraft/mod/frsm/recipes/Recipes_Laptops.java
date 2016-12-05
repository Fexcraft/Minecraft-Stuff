package net.fexcraft.mod.frsm.recipes;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class Recipes_Laptops{
	public static void register(){
		
		//Laptop//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.laptop, 1), new Object[]{
    		"   ",
    		"ABC",
    		"EDF",
    		'A', Items.IRON_INGOT, 'B', FRSM_Items.tv_screen_small, 'C', FRSM_Items.laptop_mainboard, 'D', FRSM_Items.keyboard, 'E', FRSM_Items.nesr, 'F', FRSM_Items.redstone_input,
    	});
    	//LaptopW//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.laptop_white, 1), new Object[]{
    		" G ",
    		"ABC",
    		"EDF",
    		'A', Items.IRON_INGOT, 'B', FRSM_Items.tv_screen_small, 'C', FRSM_Items.laptop_mainboard, 'D', FRSM_Items.keyboard, 'E', FRSM_Items.nesr, 'G', new ItemStack(Items.DYE, 1, 15)
    	});
    	//LaptopG//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.laptop_green, 1), new Object[]{
    		" G ",
    		"ABC",
    		"EDF",
    		'A', Items.IRON_INGOT, 'B', FRSM_Items.tv_screen_small, 'C', FRSM_Items.laptop_mainboard, 'D', FRSM_Items.keyboard, 'E', FRSM_Items.nesr, 'F', FRSM_Items.redstone_input, 'G', new ItemStack(Items.DYE, 1, 2)
    	});
    	//LaptopR//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.laptop_red, 1), new Object[]{
    		" G ",
    		"ABC",
    		"EDF",
    		'A', Items.IRON_INGOT, 'B', FRSM_Items.tv_screen_small, 'C', FRSM_Items.laptop_mainboard, 'D', FRSM_Items.keyboard, 'E', FRSM_Items.nesr, 'F', FRSM_Items.redstone_input, 'G', new ItemStack(Items.DYE, 1, 1)
    	});
    	//LaptopB//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.laptop_blue, 1), new Object[]{
    		" G ",
    		"ABC",
    		"EDF",
    		'A', Items.IRON_INGOT, 'B', FRSM_Items.tv_screen_small, 'C', FRSM_Items.laptop_mainboard, 'D', FRSM_Items.keyboard, 'E', FRSM_Items.nesr, 'F', FRSM_Items.redstone_input, 'G', new ItemStack(Items.DYE, 1, 4)
    	});
    	//LaptopBlack//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.laptop_black, 1), new Object[]{
    		" G ",
    		"ABC",
    		"EDF",
    		'A', Items.IRON_INGOT, 'B', FRSM_Items.tv_screen_small, 'C', FRSM_Items.laptop_mainboard, 'D', FRSM_Items.keyboard, 'E', FRSM_Items.nesr, 'F', FRSM_Items.redstone_input, 'G', new ItemStack(Items.DYE, 1, 0)
    	});
    	//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.laptop_black, 1), new Object[]
    	{
    		FRSM_Blocks.laptop, FRSM_Items.upgradekit,
    	});
    	//LaptopG//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.laptop_gold, 1), new Object[]{
    		" G ",
    		"ABC",
    		"EDF",
    		'A', Items.GOLD_INGOT, 'B', FRSM_Items.tv_screen_small, 'C', FRSM_Items.laptop_mainboard, 'D', FRSM_Items.keyboard, 'E', FRSM_Items.nesr, 'F', FRSM_Items.redstone_input, 'G', FRSM_Items.upgradekit
    	});
	}
}