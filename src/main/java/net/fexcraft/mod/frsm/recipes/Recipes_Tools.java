package net.fexcraft.mod.frsm.recipes;

import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class Recipes_Tools{
	public static void register(){

		//EmeraldSword//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.emerald_sword, 1), new Object[]{
    		" C ",
    		" B ",
    		" A ",
    		'A', Items.STICK, 'B', Items.EMERALD, 'C', FRSM_Items.emerald_blade,
    	});
    	/*//Helmet1//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.helmet1, 1), new Object[]
    	{
    		Items.IRON_HELMET, Items.ENDER_EYE,
    	});
    	//ChestPlate1//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.chestplate1, 1), new Object[]
    	{
    		Items.IRON_CHESTPLATE, Items.ENDER_EYE,
    	});*/
    	//IronSaw//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.iron_saw, 1), new Object[]{
    		"   ",
    		"AA ",
    		"CCB",
    		'A', Items.STICK, 'B', Blocks.PLANKS, 'C', Items.IRON_INGOT,
    	});
	}
}