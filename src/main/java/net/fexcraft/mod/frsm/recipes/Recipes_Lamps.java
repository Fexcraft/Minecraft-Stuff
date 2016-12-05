package net.fexcraft.mod.frsm.recipes;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class Recipes_Lamps {
	public static void register(){
		for(int i = 0; i < 16; i++){
	    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.lamp, 16, i), new Object[]{
	        	"ABA",
	        	"AAA",
	        	"   ",
	        	'A', new ItemStack(Blocks.WOOL, 0, i), 'B', Blocks.GLOWSTONE,
	        });
		}
	}
}