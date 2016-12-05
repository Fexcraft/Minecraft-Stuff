package net.fexcraft.mod.frsm.recipes;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class Recipes_DecoBlocks{
    public static void register(){

    	//WoodenLightBox//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.wooden_light_box, 1), new Object[]{
    		"BBB",
    		"BAB",
    		"BBB",
    		'A', Items.GLOWSTONE_DUST, 'B', Blocks.PLANKS,
    	});
    	//StoneLightBox//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.stone_light_box, 1), new Object[]{
    		"BBB",
    		"BAB",
    		"BBB",
    		'A', Items.GLOWSTONE_DUST, 'B', Blocks.COBBLESTONE,
    	});
    	//DB2//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.decoblock2, 9), new Object[]{
    		"BAB",
    		"BAB",
    		"BAB",
    		'A', Blocks.WOOL, 'B', Blocks.LOG,
    	});
    	//FramedGlowStone//
    	for(int i = 0; i < 6; i++){
        	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.framed_glowstone, 1, i), new Object[]{
        		" A ",
        		"ABA",
        		" A ",
        		'A', new ItemStack(Blocks.PLANKS, 1, i), 'B', Blocks.GLOWSTONE,
        	});
    	}
    	//DB1//
    	for(int i = 0; i < 16; i++){
        	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.decoblock1, 9, i), new Object[]{
            	"BAB",
            	"ABA",
            	"BAB",
            	'A', (new ItemStack(Blocks.WOOL, 1, i)), 'B', (new ItemStack(Blocks.LOG, 1, 0)),
            });
    	}
    	//StoneSlabPillar//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Blocks.stoneslab_pillar, 3), new Object[]{
    		"AA ",
    		"AA ",
    		"AA ",
    		'A', Blocks.STONE_SLAB,
    	});
    }
}