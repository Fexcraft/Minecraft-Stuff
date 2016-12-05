package net.fexcraft.mod.frsm.recipes;

import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class Recipes_Materials{
	public static void register(){
		//Cup//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.cup, 2), new Object[]
    	{
    		new ItemStack(Items.CLAY_BALL, 1)
    	});
    	//Jar//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.jar, 9), new Object[]
    	{
    		new ItemStack(Blocks.GLASS, 1)
    	});
    	//StoneMug//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.stone_mug, 1), new Object[]
    	{
    		Blocks.STONE, Blocks.GLASS
    	});
    	//EmeraldBlade//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.emerald_blade, 1), new Object[]{
    		" A ",
    		" B ",
    		" A ",
    		'A', Items.EMERALD, 'B', Items.DIAMOND,
    	});
    	//Prozessor//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.processor, 2), new Object[]{
    		"BBB",
    		"CAC",
    		"BBB",
    		'A', Items.GOLD_NUGGET, 'B', Items.REDSTONE, 'C', Items.IRON_INGOT
    	});
    	//SmallTVScreen//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.tv_screen_small, 1), new Object[]{
    		"BBB",
    		"CAD",
    		"BBB",
    		'A', new ItemStack(Items.DYE, 1, 2), 'B', Blocks.GLASS, 'C', new ItemStack(Items.DYE, 1, 1), 'D', new ItemStack(Items.DYE, 1, 12),
    	});
    	//RedstoneInPut
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.redstone_input, 2), new Object[]{
    		"   ",
    		"ABC",
    		"   ",
    		'A', Items.IRON_INGOT, 'B', Items.SLIME_BALL, 'C', Items.REDSTONE
    	});
    	//Prozessor2//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.processor2, 1), new Object[]{
    		"   ",
    		"ABA",
    		"   ",
    		'A', FRSM_Items.processor, 'B', Items.REDSTONE,
    	});
    	//LaptopMainboard//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.laptop_mainboard, 1), new Object[]{
    		"   ",
    		"ABC",
    		" D ",
    		'A', Items.REDSTONE, 'B', FRSM_Items.processor2, 'C', Items.SLIME_BALL, 'D', Items.IRON_INGOT,
    	});
    	//NESR//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.nesr, 1), new Object[]
    	{
    		Blocks.DIRT, Blocks.COBBLESTONE,
    	});
    	//Keyboard//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.keyboard, 1), new Object[]{
    		"AAA",
    		"ABA",
    		"AAA",
    		'A', Blocks.STONE_BUTTON, 'B', Items.IRON_INGOT,
    	});
    	//Prozessor4//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.processor4, 1), new Object[]{
    		" A ",
    		"ABA",
    		" A ",
    		'A', FRSM_Items.processor, 'B', Items.REDSTONE,
    	});
    	//PCMainboard//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.pc_mainboard, 1), new Object[]{
    		"   ",
    		"ABC",
    		"DED",
    		'A', Items.REDSTONE, 'B', FRSM_Items.processor4, 'C', Items.SLIME_BALL, 'D', Items.IRON_INGOT, 'E', FRSM_Items.nesr,
    	});
    	//UpgradeKit//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.upgradekit, 1), new Object[]
    	{
    		Items.IRON_INGOT, FRSM_Items.processor
    	});
    	//MediumTVScreen
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.tv_screen_medium, 1), new Object[]
    	{
    		FRSM_Items.tv_screen_small, FRSM_Items.tv_screen_small,
    	});
    	//TVController
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.tv_controller, 1), new Object[]{
    		"AAA",
    		"ABA",
    		"ACA",
    		'A', Blocks.STONE_BUTTON, 'B', Items.REDSTONE, 'C', Items.IRON_INGOT
    	});
    	//Planks_Oak
    	RecipeRegistry.addRecipe(new ItemStack(FRSM_Items.planks_oak, 64), new Object[]{
    		"AAAA",
    		'A', Blocks.LOG,
    	});
    	RecipeRegistry.addRecipe(new ItemStack(FRSM_Items.tv_screen_large, 1), new Object[]{
        	"EBBBE",
    		"BCADB",
        	"BCADB",
        	"EBBBE",
        	'A', new ItemStack(Items.DYE, 1, 2),
        	'B', Blocks.GLASS,
        	'C', new ItemStack(Items.DYE, 1, 1),
        	'D', new ItemStack(Items.DYE, 1, 12),
        	'E', Items.IRON_INGOT
        });
	}
}