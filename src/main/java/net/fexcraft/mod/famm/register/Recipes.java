package net.fexcraft.mod.famm.register;

import net.fexcraft.mod.famm.blocks.FAMMBlocks;
import net.fexcraft.mod.famm.items.FAMMItems;
import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class Recipes{
	public static void init(){
    	/*RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("empty"), 25, 0), new Object[]{
    		"AAAAA",
    		"AAAAA",
    		"AAAAA",
    		"AAAAA",
    		"AAAAA",
    		'A', FAMMItems.plate_empty,
    	});
    	RecipeRegistry.addRecipe(new ItemStack(FAMMItems.plate_empty, 16), new Object[]{
    		"AAAAA",
    		"ABBBA",
    		"ABCBA",
    		"ABBBA",
    		"AAAAA",
    		'A', Blocks.PLANKS, 'B', Items.PAPER, 'C', new ItemStack(Items.DYE, 1, 0),
    	});
    	GameRegistry.addRecipe(new ItemStack(FAMMItems.ink, 1), new Object[]{
    		"B",
    		"A",
    		'A',  Items.FLOWER_POT, 'B', new ItemStack(Items.DYE, 1, 0),
    	});
    	RecipeRegistry.addRecipe(new ItemStack(FAMMItems.plate_painted, 24), new Object[]{
    		"AAAAA",
    		"AAAAA",
    		"AABAA",
    		"AAAAA",
    		"AAAAA",
    		'A', FAMMItems.plate_empty, 'B', FAMMItems.ink.setContainerItem(Items.FLOWER_POT),
    	});
    	//A//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("a"), 25), new Object[]{
    		"BBBBB",
    		"BAAAB",
    		"BBBBB",
    		"BAAAB",
    		"BAAAB",
    		'A', FAMMItems.plate_empty, 'B', FAMMItems.plate_painted,
    	});
    	//B//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("b"), 25), new Object[]{
    		"BBBBA",
    		"BAAAB",
    		"BBBBA",
    		"BAAAB",
    		"BBBBA",
    		'A', FAMMItems.plate_empty, 'B', FAMMItems.plate_painted,
    	});
    	//C//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("c"), 25), new Object[]{
    		"BBBBB",
    		"BAAAA",
    		"BAAAA",
    		"BAAAA",
    		"BBBBB",
    		'A', FAMMItems.plate_empty, 'B', FAMMItems.plate_painted,
    	});
    	//D//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("d"), 25), new Object[]{
    		"XXXX#",
    		"X###X",
    		"X###X",
    		"X###X",
    		"XXXX#",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//E//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("e"), 25), new Object[]{
    		"XXXXX",
    		"X####",
    		"XXXXX",
    		"X####",
    		"XXXXX",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//F//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("f"), 25), new Object[]{
    		"XXXXX",
    		"X####",
    		"XXXXX",
    		"X####",
    		"X####",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//G//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("g"), 25), new Object[]{
    		"XXXXX",
    		"X####",
    		"X#XXX",
    		"X###X",
    		"XXXXX",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//H//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("h"), 25), new Object[]{
    		"X###X",
    		"X###X",
    		"XXXXX",
    		"X###X",
    		"X###X",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//I//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("i"), 25), new Object[]{
    		"XXXXX",
    		"##X##",
    		"##X##",
    		"##X##",
    		"XXXXX",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//J//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("j"), 25), new Object[]{
    		"XXXXX",
    		"####X",
    		"####X",
    		"X###X",
    		"#XXX#",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//K//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("k"), 25), new Object[]{
    		"X###X",
    		"X##X#",
    		"XXX##",
    		"X##X#",
    		"X###X",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//L//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("l"), 25), new Object[]{
    		"X####",
    		"X####",
    		"X####",
    		"X####",
    		"XXXXX",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//M//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("m"), 25), new Object[]{
    		"X###X",
    		"XX#XX",
    		"X#X#X",
    		"X###X",
    		"X###X",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//N//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("n"), 25), new Object[]{
    		"X###X",
    		"XX##X",
    		"X#X#X",
    		"X##XX",
    		"X###X",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//O//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("o"), 25), new Object[]{
    		"XXXXX",
    		"X###X",
    		"X###X",
    		"X###X",
    		"XXXXX",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//P//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("p"), 25), new Object[]{
    		"XXXXX",
    		"X###X",
    		"XXXXX",
    		"X####",
    		"X####",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//Q//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("q"), 25), new Object[]{
    		"XXXXX",
    		"X###X",
    		"X###X",
    		"X##XX",
    		"XXXXX",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//R//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("r"), 25), new Object[]{
    		"XXXXX",
    		"X###X",
    		"XXXXX",
    		"X##X#",
    		"X###X",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//S//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("s"), 25), new Object[]{
    		"XXXXX",
    		"X####",
    		"XXXXX",
    		"####X",
    		"XXXXX",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//T//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("t"), 25), new Object[]{
    		"XXXXX",
    		"##X##",
    		"##X##",
    		"##X##",
    		"##X##",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//U//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("u"), 25), new Object[]{
    		"X###X",
    		"X###X",
    		"X###X",
    		"X###X",
    		"XXXXX",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//V//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("v"), 25), new Object[]{
    		"X###X",
    		"X###X",
    		"X###X",
    		"#X#X#",
    		"##X##",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//W//
    	RecipeRegistry.addShapelessRecipe(new ItemStack(FAMMBlocks.get("w"), 2), new Object[]{
    		FAMMBlocks.get("v"), FAMMBlocks.get("v"),
    	});
    	//X//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("x"), 25), new Object[]{
    		"X###X",
    		"#X#X#",
    		"##X##",
    		"#X#X#",
    		"X###X",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//Y//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("y"), 25), new Object[]{
    		"X###X",
    		"X###X",
    		"#X#X#",
    		"##X##",
    		"##X##",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//Z//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("z"), 25), new Object[]{
    		"XXXXX",
    		"###X#",
    		"##X##",
    		"#X###",
    		"XXXXX",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//1//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("n1"), 25), new Object[]{
    		"##X##",
    		"#XX##",
    		"##X##",
    		"##X##",
    		"#XXX#",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//2//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("n2"), 25), new Object[]{
    		"#XXX#",
    		"###X#",
    		"#XXX#",
    		"#X###",
    		"#XXX#",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//3//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("n3"), 25), new Object[]{
    		"#XXX#",
    		"###X#",
    		"#XXX#",
    		"###X#",
    		"#XXX#",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//4//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("n4"), 25), new Object[]{
    		"#X#X#",
    		"#X#X#",
    		"#XXX#",
    		"###X#",
    		"###X#",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//5//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("n5"), 25), new Object[]{
    		"#XXX#",
    		"#X###",
    		"#XXX#",
    		"###X#",
    		"#XX##",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//6//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("n6"), 25), new Object[]{
    		"#XXX#",
    		"#X###",
    		"#XXX#",
    		"#X#X#",
    		"#XXX#",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//7//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("n7"), 25), new Object[]{
    		"#XXX#",
    		"###X#",
    		"###X#",
    		"###X#",
    		"###X#",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//8//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("n8"), 25), new Object[]{
    		"#XXX#",
    		"#X#X#",
    		"#XXX#",
    		"#X#X#",
    		"#XXX#",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//9//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("n9"), 25), new Object[]{
    		"#XXX#",
    		"#X#X#",
    		"#XXX#",
    		"###X#",
    		"#XXX#",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});
    	//0//
    	RecipeRegistry.addRecipe(new ItemStack(FAMMBlocks.get("n0"), 25), new Object[]{
    		"#XXX#",
    		"#X#X#",
    		"#X#X#",
    		"#X#X#",
    		"#XXX#",
    		'#', FAMMItems.plate_empty, 'X', FAMMItems.plate_painted,
    	});*/
	}
}