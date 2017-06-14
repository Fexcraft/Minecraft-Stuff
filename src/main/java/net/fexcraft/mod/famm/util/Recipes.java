package net.fexcraft.mod.famm.util;

import net.fexcraft.mod.famm.FAMM;
import net.fexcraft.mod.famm.blocks.FAMMBlocks;
import net.fexcraft.mod.famm.items.FAMMItems;
import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public final class Recipes{
	
	private static final String category = "FAMM Block Recipes";
	private static final String category_hb = "FAMM HalfBlock Recipes";
	private static final String category_items = "FAMM Item Recipes";
	
	public static void init(){
		if(FAMM.conf2){
			for(String str : FAMMBlocks.blocknames){
				if(!str.equals("empty")){
					RecipeRegistry.addBluePrintRecipe(category, new ItemStack(FAMMBlocks.get(str)), new ItemStack(FAMMItems.plate_empty, 6), new ItemStack(FAMMItems.ink, 2));
				}
				else{
					RecipeRegistry.addBluePrintRecipe(category, new ItemStack(FAMMBlocks.get(str)), new ItemStack(FAMMItems.plate_empty, 6));
				}
			}
		}
		if(FAMM.conf3){
			for(String str : FAMMBlocks.blocknames){
				if(!str.equals("empty")){
					RecipeRegistry.addBluePrintRecipe(category_hb, new ItemStack(FAMMBlocks.get(str + "_hb")), new ItemStack(FAMMItems.plate_empty, 6), new ItemStack(FAMMItems.ink, 2));
				}
				else{
					RecipeRegistry.addBluePrintRecipe(category_hb, new ItemStack(FAMMBlocks.get(str + "_hb")), new ItemStack(FAMMItems.plate_empty, 6));
				}
			}
		}
		RecipeRegistry.addBluePrintRecipe(category_items, new ItemStack(FAMMItems.plate_empty, 16), new ItemStack(Blocks.PLANKS, 16), new ItemStack(Items.PAPER, 9), new ItemStack(Items.DYE, 1, 0));
		RecipeRegistry.addBluePrintRecipe(category_items, new ItemStack(FAMMItems.ink, 1), new ItemStack(Items.FLOWER_POT), new ItemStack(Items.DYE, 1, 0));
	}
}