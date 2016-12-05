package net.fexcraft.mod.frsm.recipes;

import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class Recipes_PaintStuff{
	public static void register(){
		
    	//paint_bucket//
		//0
		GameRegistry.addRecipe(new ItemStack(FRSM_Items.paint_bucket, 1, 0), new Object[]{
    		"BBB",
    		" B ",
    		" A ",
    		'A', Items.BUCKET, 'B', new ItemStack(Items.DYE, 1, 15),
    	});
		//1
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.paint_bucket, 1, 1), new Object[]{
    		"BBB",
    		" B ",
    		" A ",
    		'A', Items.BUCKET, 'B', new ItemStack(Items.DYE, 1, 14),
    	});
    	//2
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.paint_bucket, 1, 2), new Object[]{
    		"BBB",
    		" B ",
    		" A ",
    		'A', Items.BUCKET, 'B', new ItemStack(Items.DYE, 1, 13),
    	});
    	//3
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.paint_bucket, 1, 3), new Object[]{
    		"BBB",
    		" B ",
    		" A ",
    		'A', Items.BUCKET, 'B', new ItemStack(Items.DYE, 1, 12),
    	});
    	//4
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.paint_bucket, 1, 4), new Object[]{
    		"BBB",
    		" B ",
    		" A ",
    		'A', Items.BUCKET, 'B', new ItemStack(Items.DYE, 1, 11),
    	});
    	//5
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.paint_bucket, 1, 5), new Object[]{
    		"BBB",
    		" B ",
    		" A ",
    		'A', Items.BUCKET, 'B', new ItemStack(Items.DYE, 1, 10),
    	});
    	//6
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.paint_bucket, 1, 6), new Object[]{
    		"BBB",
    		" B ",
    		" A ",
    		'A', Items.BUCKET, 'B', new ItemStack(Items.DYE, 1, 9),
    	});
    	//7
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.paint_bucket, 1, 7), new Object[]{
    		"BBB",
    		" B ",
    		" A ",
    		'A', Items.BUCKET, 'B', new ItemStack(Items.DYE, 1, 8),
    	});
    	//8
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.paint_bucket, 1, 8), new Object[]{
    		"BBB",
    		" B ",
    		" A ",
    		'A', Items.BUCKET, 'B', new ItemStack(Items.DYE, 1, 7),
    	});
    	//9
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.paint_bucket, 1, 9), new Object[]{
    		"BBB",
    		" B ",
    		" A ",
    		'A', Items.BUCKET, 'B', new ItemStack(Items.DYE, 1, 6),
    	});
    	//10
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.paint_bucket, 1, 10), new Object[]{
    		"BBB",
    		" B ",
    		" A ",
    		'A', Items.BUCKET, 'B', new ItemStack(Items.DYE, 1, 5),
    	});
    	//11
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.paint_bucket, 1, 11), new Object[]{
    		"BBB",
    		" B ",
    		" A ",
    		'A', Items.BUCKET, 'B', new ItemStack(Items.DYE, 1, 4),
    	});
    	//12
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.paint_bucket, 1, 12), new Object[]{
    		"BBB",
    		" B ",
    		" A ",
    		'A', Items.BUCKET, 'B', new ItemStack(Items.DYE, 1, 3),
    	});
    	//13
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.paint_bucket, 1, 13), new Object[]{
    		"BBB",
    		" B ",
    		" A ",
    		'A', Items.BUCKET, 'B', new ItemStack(Items.DYE, 1, 2),
    	});
    	//14
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.paint_bucket, 1, 14), new Object[]{
    		"BBB",
    		" B ",
    		" A ",
    		'A', Items.BUCKET, 'B', new ItemStack(Items.DYE, 1, 1),
    	});
    	//15
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.paint_bucket, 1, 15), new Object[]{
    		"BBB",
    		" B ",
    		" A ",
    		'A', Items.BUCKET, 'B', new ItemStack(Items.DYE, 1, 0),
    	});
    	//paint_bucket-End//
    	//Brush//
    	GameRegistry.addRecipe(new ItemStack(FRSM_Items.brush, 3), new Object[]{
    		"   ",
    		" B ",
    		" A ",
    		'A', Items.STICK, 'B', Blocks.WOOL,
    	});
    	//PaintSet//
    	//0
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.paintSet0, 1), new Object[]
    	{FRSM_Items.brush, new ItemStack(FRSM_Items.paint_bucket, 1, 0)});
    	//1
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.paintSet1, 1), new Object[]
    	{FRSM_Items.brush, new ItemStack(FRSM_Items.paint_bucket, 1, 1)});
    	//2
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.paintSet2, 1), new Object[]
    	{FRSM_Items.brush, new ItemStack(FRSM_Items.paint_bucket, 1, 2)});
    	//3
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.paintSet3, 1), new Object[]
    	{FRSM_Items.brush, new ItemStack(FRSM_Items.paint_bucket, 1, 3)});
    	//4
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.paintSet4, 1), new Object[]
    	{FRSM_Items.brush, new ItemStack(FRSM_Items.paint_bucket, 1, 4)});
    	//5
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.paintSet5, 1), new Object[]
    	{FRSM_Items.brush, new ItemStack(FRSM_Items.paint_bucket, 1, 5)});
    	//6
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.paintSet6, 1), new Object[]
    	{FRSM_Items.brush, new ItemStack(FRSM_Items.paint_bucket, 1, 6)});
    	//7
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.paintSet7, 1), new Object[]
    	{FRSM_Items.brush, new ItemStack(FRSM_Items.paint_bucket, 1, 7)});
    	//8
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.paintSet8, 1), new Object[]
    	{FRSM_Items.brush, new ItemStack(FRSM_Items.paint_bucket, 1, 8)});
    	//9
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.paintSet9, 1), new Object[]
    	{FRSM_Items.brush, new ItemStack(FRSM_Items.paint_bucket, 1, 9)});
    	//10
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.paintSet10, 1), new Object[]
    	{FRSM_Items.brush, new ItemStack(FRSM_Items.paint_bucket, 1, 10)});
    	//11
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.paintSet11, 1), new Object[]
    	{FRSM_Items.brush, new ItemStack(FRSM_Items.paint_bucket, 1, 11)});
    	//12
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.paintSet12, 1), new Object[]
    	{FRSM_Items.brush, new ItemStack(FRSM_Items.paint_bucket, 1, 12)});
    	//13
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.paintSet13, 1), new Object[]
    	{FRSM_Items.brush, new ItemStack(FRSM_Items.paint_bucket, 1, 13)});
    	//14
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.paintSet14, 1), new Object[]
    	{FRSM_Items.brush, new ItemStack(FRSM_Items.paint_bucket, 1, 14)});
    	//15
    	GameRegistry.addShapelessRecipe(new ItemStack(FRSM_Items.paintSet15, 1), new Object[]
    	{FRSM_Items.brush, new ItemStack(FRSM_Items.paint_bucket, 1, 15)});
    	//PaintSet-End//
	}
}