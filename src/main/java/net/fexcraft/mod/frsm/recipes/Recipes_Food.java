package net.fexcraft.mod.frsm.recipes;

import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class Recipes_Food{
	public static void register(){

		//CupWithCacao//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.cup_with_cacao, 1), new Object[]
    	{
    		new ItemStack(Items.DYE, 1, 3), FRSM_Items.cup
    	});
    	//Hamburger//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.hamburger, 1), new Object[]{
    		" A ",
    		" B ",
    		" A ",
    		'A', Items.BREAD, 'B', Items.COOKED_BEEF
    	});
    	//TomatoJar//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.tomato_jar, 1), new Object[]{
    		" B ",
    		" B ",
    		" A ",
    		'A', FRSM_Items.jar, 'B', FRSM_Items.tomato
    	});
    	//Salami//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.salami, 3), new Object[]
    	{
    		new ItemStack(Items.COOKED_PORKCHOP)
    	});
    	//Cheese//
    	GameRegistry.addSmelting(new ItemStack(Items.MILK_BUCKET), new ItemStack(FRSM_Items.cheese, 4), 0.05F);
    	//Pizza//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.pizza, 1), new Object[]{
    		"DDD",
    		"CBC",
    		"AAA",
    		'A', Items.WHEAT, 'B', FRSM_Items.tomato_jar.setContainerItem(FRSM_Items.jar), 'C', FRSM_Items.cheese, 'D', FRSM_Items.salami,
    	});
    	//ChocolateBar//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.chocolate_bar, 4), new Object[]
    	{
    		new ItemStack(FRSM_Items.chocolate_milk.setContainerItem(Items.BUCKET)), Items.SUGAR
    	});
    	//ChocolateMilk//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.chocolate_milk, 1), new Object[]
    	{
    		new ItemStack(Items.DYE, 1, 3), Items.MILK_BUCKET.setContainerItem(Items.BUCKET)
    	});
    	//ChocolateCookie//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.chocolate_cookie, 4), new Object[]
    	{
    		new ItemStack(Items.WHEAT), FRSM_Items.chocolate_milk.setContainerItem(Items.BUCKET)
    	});
    	//CookedEgg//
    	GameRegistry.addSmelting(new ItemStack(Items.EGG), new ItemStack(FRSM_Items.cooked_egg, 1), 0.05F);
    	//StoneMugWithBeer//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.stone_mug_wb, 1), new Object[]
    	{
    		Items.WHEAT , FRSM_Items.stone_mug, Items.WATER_BUCKET.setContainerItem(Items.BUCKET)
    	});
    	//Donut//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.donut, 4), new Object[]
    	{
    		Items.WHEAT , Items.SUGAR, FRSM_Items.chocolate_milk.setContainerItem(Items.BUCKET)
    	});
    	//CheeseWhite//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.cheese_white, 1), new Object[]
    	{
    		Items.MILK_BUCKET.setContainerItem(Items.BUCKET),
    	});
    	//CheesePie//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.cheese_pie, 1), new Object[]
    	{
    		FRSM_Items.cheese_white, Items.EGG, Items.SUGAR,
    	});
    	//BaconRaw//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.bacon_raw, 4), new Object[]
    	{
    		Items.PORKCHOP,
    	});
    	//Bacon//
    	GameRegistry.addSmelting(new ItemStack(FRSM_Items.bacon_raw), new ItemStack(FRSM_Items.bacon, 1), 0.05F);
    	//ChocolateBarWhite//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.chocolate_bar_white, 1), new Object[]
    	{
    		new ItemStack(Items.MILK_BUCKET.setContainerItem(Items.BUCKET)), Items.SUGAR
    	});
    	//TomatoSoup//
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.tomato_soup, 1), new Object[]
    	{
    		Items.BOWL, FRSM_Items.tomato_jar.setContainerItem(FRSM_Items.jar)
    	});
    	//PotatoChipsBag//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.potatochips, 1), new Object[]{
    		"ABA",
    		"ABA",
    		"ABA",
    		'A', Items.PAPER, 'B', Items.BAKED_POTATO,
    	});
    	//PotatoChipsCheese//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.potatochips_cheese, 1), new Object[]{
    		"ABA",
    		"ACA",
    		"ABA",
    		'A', Items.PAPER, 'B', Items.BAKED_POTATO, 'C', FRSM_Items.cheese
    	});
    	
	}
}