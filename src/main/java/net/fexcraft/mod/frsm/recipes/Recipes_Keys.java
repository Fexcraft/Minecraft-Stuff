package net.fexcraft.mod.frsm.recipes;

import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public final class Recipes_Keys{
	public static void register(){
			RecipeRegistry.addRecipe(new ItemStack(FRSM_Items.key, 3), new Object[]{
			    "  A",
			    " A ",
			    "B  ",
			    'A', Items.IRON_INGOT, 'B', Items.GOLD_INGOT
			});
			RecipeRegistry.addRecipe(new ItemStack(FRSM_Items.key2, 3), new Object[]{
			    "  A",
			    " A ",
			    "A  ",
			    'A', Items.IRON_INGOT,
			});
	}
}