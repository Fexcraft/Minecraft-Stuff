package net.fexcraft.mod.frsm.recipes;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class Recipes_TechnicalStuff{
	public static void register(){
		//TVS//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.tvs, 1), new Object[]{
    		"   ",
    		"BAC",
    		" D ",
    		'A', FRSM_Items.tv_screen_small, 'B', FRSM_Items.processor, 'C', FRSM_Items.redstone_input, 'D', Items.IRON_INGOT,
    	});
    	//PCHW2//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.pchardware2, 1), new Object[]{
    		"   ",
    		"DBA",
    		" EC",
    		'A', Items.IRON_INGOT, 'B', FRSM_Items.tv_screen_small, 'C', FRSM_Items.nesr, 'D', FRSM_Items.redstone_input, 'E', FRSM_Items.keyboard,
    	});
    	//PCHW1//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.pchardware1, 1), new Object[]{
    		"ADA",
    		"ABA",
    		"ACA",
    		'A', Items.IRON_INGOT, 'B', FRSM_Items.pc_mainboard, 'C', FRSM_Items.redstone_input, 'D', FRSM_Items.nesr,
    	});
    	//Printer//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.printer, 1), new Object[]{
    		" C ",
    		"BAB",
    		"BDB",
    		'A', FRSM_Items.nesr, 'B', Items.IRON_INGOT, 'C', Items.PAPER, 'D', Items.REDSTONE,
    	});
    	//WM//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.wm, 1), new Object[]{
    		"ABA",
    		"ACA",
    		"ADA",
    		'A', Items.IRON_INGOT, 'B', FRSM_Items.processor, 'C', FRSM_Items.nesr, 'D', FRSM_Items.redstone_input,
    	});
    	//Toaster//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.toaster, 1), new Object[]{
    		" B ",
    		"ACA",
    		"ADA",
    		'A', Items.IRON_INGOT, 'B', Items.REDSTONE, 'C', FRSM_Items.nesr, 'D', FRSM_Items.redstone_input,
    	});
    	//Stove//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.stove, 1), new Object[]{
    		"ABA",
    		"ACA",
    		"ADA",
    		'A', Items.IRON_INGOT, 'B', Blocks.FURNACE, 'C', FRSM_Items.nesr, 'D', FRSM_Items.redstone_input,
    	});
    	//PCHW2b//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.pchardware2b, 1), new Object[]
    	{
    		FRSM_Blocks.pchardware2, FRSM_Items.upgradekit,
    	});
    	//PCHW1b//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.pchardware1b, 1), new Object[]
    	{
    		FRSM_Blocks.pchardware1, FRSM_Items.upgradekit,
    	});
    	//TVM//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.TVM, 1), new Object[]{
    		"   ",
    		"BAC",
    		"EDF",
    		'A', FRSM_Items.tv_screen_medium, 'B', FRSM_Items.processor, 'C', FRSM_Items.redstone_input, 'D', Items.IRON_INGOT, 'E', FRSM_Items.nesr, 'F', FRSM_Items.tv_controller,
    	});
    	//Radio1//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.Radio1, 1), new Object[]{
    		"   ",
    		"AC ",
    		"ABA",
    		'A', Items.IRON_INGOT, 'B', FRSM_Items.processor, 'C', FRSM_Items.nesr
    	});
    	//VM//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.VM, 1), new Object[]{
    		"DDD",
    		"CCC",
    		" AB",
    		'A', Blocks.IRON_BLOCK, 'B', FRSM_Items.processor, 'C', FRSM_Items.nesr, 'D', Items.IRON_INGOT,
    	});
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.TVL, 1), new Object[]{
        		"   ",
        		"BAC",
        		"EDF",
        		'A', FRSM_Items.tv_screen_large, 'B', FRSM_Items.processor2, 'C', FRSM_Items.redstone_input, 'D', Items.IRON_INGOT, 'E', FRSM_Items.nesr, 'F', FRSM_Items.tv_controller,
        });
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.TVL_1, 1), new Object[]{
    		FRSM_Blocks.TVL
    	});
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.TVL, 1), new Object[]{
        	FRSM_Blocks.TVL_1
        });
    	RecipeRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.radio2), new Object[]{
        	FRSM_Items.nesr, Blocks.LOG
        });
	}
}