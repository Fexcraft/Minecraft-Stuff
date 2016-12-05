package net.fexcraft.mod.frsm.recipes;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class Recipes_Other{
	public static void register(){

		//TomatoSeeds//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.tomato_seeds, 4), new Object[]
    	{
    		FRSM_Items.tomato,
    	});
    	//TBM//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.tbm, 1), new Object[]{
    		"   ",
    		"AAA",
    		"B B",
    		'A', Blocks.PLANKS, 'B', Blocks.LOG,
    	});
    	//
    	RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.tbm, 1), new Object[]{
    		"AAAAA",
    		"AAAAA",
    		"AAAAA",
    		"AAAAA",
    		"B   B",
    		'A', Blocks.PLANKS, 'B', Blocks.LOG,
    	});
    	//
    	/*RCTCraftingManager.addRecipe(new ItemStack(FRSM_Blocks.tbm, 1), new Object[]{
    		"     ",
    		"     ",
    		"  A  ",
    		"     ",
    		"     ",
    		'A', FRSM_Items.prozessor,
    	});*/
    	//Crate//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.crate, 1), new Object[]
    	{
    		Blocks.CHEST,
    	});
    	//KD1//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.KD1, 1), new Object[]
    	{
    		FRSM_Items.cup, FRSM_Items.jar, FRSM_Items.tomato_jar, FRSM_Items.jar,
    	});
    	//WB//
    	/*GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.wb, 1), new Object[]
    	{
    		Blocks.CRAFTING_TABLE, Items.IRON_INGOT, Blocks.LOG,
    	});*/
    	//Car1D//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.Car1D, 2), new Object[]{
    		"   ",
    		" B ",
    		" A ",
    		'A', Blocks.PLANKS, 'B', Items.IRON_INGOT,
    	});
    	//KD2//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.KD2, 2), new Object[]
    	{
    		FRSM_Items.stone_mug_wb, FRSM_Items.stone_mug_wb, Items.CLAY_BALL, Items.IRON_INGOT
    	});
    	//Trashcan//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.trashcan, 1), new Object[]{
    		"A A",
    		"ABA",
    		"AAA",
    		'A', Items.IRON_INGOT, 'B', Items.LAVA_BUCKET,
    	});
    	//CupG//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.cup_gold, 1), new Object[]{
    		"A A",
    		"AAA",
    		" B ",
    		'A', Items.GOLD_INGOT, 'B', Blocks.LOG,
    	});
    	//Window//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.window, 16), new Object[]{
    		"AAA",
    		"BCB",
    		"AAA",
    		'A', Blocks.LOG, 'B', Blocks.PLANKS, 'C', Blocks.GLASS,
    	});
    	//Fence1//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.fence1, 16), new Object[]{
    		"C C",
    		"BBB",
    		"AAA",
    		'A', Blocks.STONE, 'B', Blocks.IRON_BARS, 'C', Items.IRON_INGOT,
    	});
    	//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.fence1, 1), new Object[]
    	{
    		FRSM_Blocks.fence1b,
    	});
    	//Fence1b//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.fence1b, 1), new Object[]
    	{
    		FRSM_Blocks.fence1,
    	});
    	//Furnace1//
    	RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.furnace1, 1), new Object[]{
    		"  D  ",
    		"AAAAA",
    		"ABBBA",
    		"ABCBA",
    		"ABBBA",
    		'A', Items.IRON_INGOT, 'B', Items.BRICK, 'C', Blocks.FURNACE, 'D', FRSM_Blocks.pipe1f
    	});
    	//RADIO 2
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.radio2, 1), new Object[]{
    		FRSM_Items.nesr, Blocks.LOG
    	});
    	RecipeRegistry.addRecipe(new ItemStack(FRSM_Blocks.furnace1, 1), new Object[]{
        	" B ",
        	"B B",
        	"BCB",
        	" B ",
        	'B', Items.IRON_INGOT, 'C', Blocks.CHEST
        });
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Blocks.TVS2, 1), new Object[]{
        	FRSM_Items.nesr, FRSM_Items.tv_screen_small, Items.IRON_INGOT, FRSM_Items.redstone_input
        });
	}
}