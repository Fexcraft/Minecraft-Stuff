package net.fexcraft.mod.frsm.util;

import net.fexcraft.mod.lib.api.common.fRecipeHolder;
import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.fexcraft.mod.lib.util.registry.RegistryUtil;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static net.fexcraft.mod.lib.crafting.RecipeRegistry.*;

@fRecipeHolder("frsm")
public final class Recipes {
	
	public Recipes(){
		register();
	}
	
	private static RegistryUtil reg;
	private static final String category = "FRSM Common Recipes";
	
	public static void register(){
		RecipeRegistry.addShapedRecipe("frsm:officechair", null, new ItemStack(reg.getBlock("frsm:officechair"), 1), 2, 3, new Ingredient[]{
			INGREDIENT_WOOL, INGREDIENT_NULL,
			INGREDIENT_WOOL, INGREDIENT_WOOL,
			Ingredient.fromStacks(new ItemStack(Items.IRON_INGOT)), INGREDIENT_NULL
		});
		RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getBlock("frsm:chimney"), 1, 0), new ItemStack(Blocks.BRICK_BLOCK, 1));
		RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getBlock("frsm:chimney"), 1, 1), new ItemStack(Blocks.STONEBRICK, 1));
		RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getBlock("frsm:chimney"), 1, 2), new ItemStack(Blocks.NETHER_BRICK, 1));
		RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getBlock("frsm:chimney"), 1, 3), new ItemStack(Blocks.SANDSTONE, 1));
		RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getBlock("frsm:chimney"), 1, 4), new ItemStack(Blocks.END_STONE, 1));
		RecipeRegistry.addShapedRecipe("frsm:woodenlightbox", "frsm:lightbox", new ItemStack(reg.getBlock("frsm:woodenlightbox"), 1), 3, 3, new Ingredient[]{
			INGREDIENT_PLANKS, INGREDIENT_PLANKS, INGREDIENT_PLANKS, INGREDIENT_PLANKS,
			Ingredient.fromStacks(new ItemStack(Items.GLOWSTONE_DUST)),
			INGREDIENT_PLANKS, INGREDIENT_PLANKS, INGREDIENT_PLANKS, INGREDIENT_PLANKS
		});
		RecipeRegistry.addShapedRecipe("frsm:stonelightbox", "frsm:lightbox", new ItemStack(reg.getBlock("frsm:stonelightbox"), 1), 3, 3, new Ingredient[]{
			Ingredient.fromStacks(new ItemStack(Blocks.COBBLESTONE)),
			Ingredient.fromStacks(new ItemStack(Blocks.COBBLESTONE)),
			Ingredient.fromStacks(new ItemStack(Blocks.COBBLESTONE)),
			Ingredient.fromStacks(new ItemStack(Blocks.COBBLESTONE)),
			Ingredient.fromStacks(new ItemStack(Items.GLOWSTONE_DUST)),
			Ingredient.fromStacks(new ItemStack(Blocks.COBBLESTONE)),
			Ingredient.fromStacks(new ItemStack(Blocks.COBBLESTONE)),
			Ingredient.fromStacks(new ItemStack(Blocks.COBBLESTONE)),
			Ingredient.fromStacks(new ItemStack(Blocks.COBBLESTONE))
		});
		RecipeRegistry.addShapedRecipe("frsm:decoblock2", "", new ItemStack(reg.getBlock("frsm:decoblock2"), 9), 3, 3, new Ingredient[]{
			INGREDIENT_WOOL, INGREDIENT_LOG, INGREDIENT_WOOL,
			INGREDIENT_WOOL, INGREDIENT_LOG, INGREDIENT_WOOL,
			INGREDIENT_WOOL, INGREDIENT_LOG, INGREDIENT_WOOL
		});
		for(int i = 0; i < 6; i++){
			RecipeRegistry.addShapedRecipe("frsm:framedglowstone_" + i, "frsm:framedglowstone", new ItemStack(reg.getBlock("frsm:framedglowstone"), 1, i), 3, 3, new Ingredient[]{
				INGREDIENT_NULL, Ingredient.fromStacks(new ItemStack(Blocks.PLANKS, 1, i)), INGREDIENT_NULL,
				Ingredient.fromStacks(new ItemStack(Blocks.PLANKS, 1, i)), Ingredient.fromStacks(new ItemStack(Blocks.GLOWSTONE)), Ingredient.fromStacks(new ItemStack(Blocks.PLANKS, 1, i)),
				INGREDIENT_NULL, Ingredient.fromStacks(new ItemStack(Blocks.PLANKS, 1, i)), INGREDIENT_NULL
			});
		}
		for(int i = 0; i < 16; i++){
			RecipeRegistry.addShapedRecipe("frsm:decoblock1_" + i, "frsm:decoblock1", new ItemStack(reg.getBlock("frsm:decoblock1"), 9, i), 3, 3, new Ingredient[]{
					INGREDIENT_LOG, Ingredient.fromStacks(new ItemStack(Blocks.WOOL, 1, i)), INGREDIENT_LOG,
					Ingredient.fromStacks(new ItemStack(Blocks.WOOL, 1, i)), INGREDIENT_LOG, Ingredient.fromStacks(new ItemStack(Blocks.WOOL, 1, i)),
					INGREDIENT_LOG, Ingredient.fromStacks(new ItemStack(Blocks.WOOL, 1, i)), INGREDIENT_LOG
			});
		}
		RecipeRegistry.addShapedRecipe("frsm:stoneslabpillar", null, new ItemStack(reg.getBlock("frsm:stoneslabpillar"), 3), 2, 3, new Ingredient[]{
			Ingredient.fromStacks(new ItemStack(Blocks.STONE_SLAB)), Ingredient.fromStacks(new ItemStack(Blocks.STONE_SLAB)),
			Ingredient.fromStacks(new ItemStack(Blocks.STONE_SLAB)), Ingredient.fromStacks(new ItemStack(Blocks.STONE_SLAB)),
			Ingredient.fromStacks(new ItemStack(Blocks.STONE_SLAB)), Ingredient.fromStacks(new ItemStack(Blocks.STONE_SLAB))
		});
		RecipeRegistry.addShapelessRecipe("frsm:cupwithcacao", null, new ItemStack(reg.getItem("frsm:cupwithcacao"), 1), new Ingredient[]{
			Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 3)), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:cup")))
		});
		RecipeRegistry.addShapedRecipe("frsm:hamburger", null, new ItemStack(reg.getItem("frsm:hamburger"), 1), 1, 3, new Ingredient[]{
			Ingredient.fromStacks(new ItemStack(Items.BREAD)), Ingredient.fromStacks(new ItemStack(Items.COOKED_BEEF)), Ingredient.fromStacks(new ItemStack(Items.BREAD))
		});
		RecipeRegistry.addShapedRecipe("frsm:tomatojar", null, new ItemStack(reg.getItem("frsm:tomatojar"), 1), 1, 3, new Ingredient[]{
			Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:jar"))),
			Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:jar"))),
			Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:tomato")))
		});
		RecipeRegistry.addShapelessRecipe("frsm:salami", null, new ItemStack(reg.getItem("frsm:salami"), 3), new Ingredient[]{
			Ingredient.fromStacks(new ItemStack(Items.COOKED_PORKCHOP))
		});
    	GameRegistry.addSmelting(new ItemStack(Items.MILK_BUCKET), new ItemStack(reg.getItem("frsm:cheese"), 4), 0.05F);
    	/*RecipeRegistry.addShapedRecipe("frsm:pizza", null, new ItemStack(reg.getItem("frsm:pizza"), 1), 3, 3, new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:salami"))),
    		Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:salami"))),
    		Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:salami"))),
    		Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:cheese"))),
    		Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:tomatojar").setContainerItem(reg.getItem("frsm:jar")))),
    		Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:cheese"))),
    		Ingredient.fromStacks(new ItemStack(Items.WHEAT)),
    		Ingredient.fromStacks(new ItemStack(Items.WHEAT)),
    		Ingredient.fromStacks(new ItemStack(Items.WHEAT))
    	});
    	RecipeRegistry.addShapelessRecipe("frsm:frsm:chocolatebar", null, new ItemStack(Registry.getItem("frsm:chocolatebar"), 4), new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:chocolatemilk").setContainerItem(Items.BUCKET))),
    		Ingredient.fromStacks(new ItemStack(Items.SUGAR))
    	});
    	RecipeRegistry.addShapelessRecipe("frsm:chocolatemilk", null, new ItemStack(reg.getItem("frsm:chocolatemilk"), 1), new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 3)), Ingredient.fromStacks(new ItemStack(Items.MILK_BUCKET.setContainerItem(Items.BUCKET)))
    	});
    	RecipeRegistry.addShapelessRecipe("frsm:chocolatecookie", null, new ItemStack(reg.getItem("frsm:chocolatecookie"), 4), new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(Items.WHEAT)), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:chocolatemilk").setContainerItem(Items.BUCKET)))
    	});
    	GameRegistry.addSmelting(new ItemStack(Items.EGG), new ItemStack(reg.getItem("frsm:cookedegg"), 1), 0.05F);
    	RecipeRegistry.addShapelessRecipe("frsm:stonemugwithbeer", null, new ItemStack(reg.getItem("frsm:stonemugwithbeer"), 1), new Ingredient[]{
			Ingredient.fromStacks(new ItemStack(Items.WHEAT)), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:stonemug"))),
			Ingredient.fromStacks(new ItemStack(Items.WATER_BUCKET.setContainerItem(Items.BUCKET)))
    	});
    	RecipeRegistry.addShapelessRecipe("frsm:donut", null, new ItemStack(reg.getItem("frsm:donut"), 4), new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(Items.WHEAT)), Ingredient.fromStacks(new ItemStack(Items.SUGAR)),
    		Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:chocolatemilk").setContainerItem(Items.BUCKET)))
    	});
    	RecipeRegistry.addShapelessRecipe("frsm:cheesewhite", null, new ItemStack(reg.getItem("frsm:cheesewhite"), 1), new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(Items.MILK_BUCKET.setContainerItem(Items.BUCKET)))
    	});
    	RecipeRegistry.addShapelessRecipe("frsm:cheesepie", null, new ItemStack(reg.getItem("frsm:cheesepie"), 1), new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:cheesewhite"))), Ingredient.fromStacks(new ItemStack(Items.EGG)),
    		Ingredient.fromStacks(new ItemStack(Items.SUGAR))
    	});
    	RecipeRegistry.addShapelessRecipe("frsm:baconraw", null, new ItemStack(reg.getItem("frsm:baconraw"), 4), new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(Items.PORKCHOP))
    	});
    	GameRegistry.addSmelting(new ItemStack(reg.getItem("frsm:baconraw")), new ItemStack(reg.getItem("frsm:bacon"), 1), 0.05F);
    	RecipeRegistry.addShapelessRecipe("frsm:chocolatebarwhite", null, new ItemStack(reg.getItem("frsm:chocolatebarwhite"), 1), new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(Items.MILK_BUCKET.setContainerItem(Items.BUCKET))), Ingredient.fromStacks(new ItemStack(Items.SUGAR))
    	});
    	RecipeRegistry.addShapelessRecipe("frsm:tomatosoup", null, new ItemStack(reg.getItem("frsm:tomatosoup"), 1), new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(Items.BOWL)), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:tomatojar").setContainerItem(reg.getItem("frsm:jar"))))
    	});
    	RecipeRegistry.addShapedRecipe("frsm:potatochipsbag", "frsm:potatochips", new ItemStack(reg.getItem("frsm:potatochipsbag"), 1), 3, 3, new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(Items.PAPER)), Ingredient.fromStacks(new ItemStack(Items.BAKED_POTATO)), Ingredient.fromStacks(new ItemStack(Items.PAPER)),
    		Ingredient.fromStacks(new ItemStack(Items.PAPER)), Ingredient.fromStacks(new ItemStack(Items.BAKED_POTATO)), Ingredient.fromStacks(new ItemStack(Items.PAPER)),
    		Ingredient.fromStacks(new ItemStack(Items.PAPER)), Ingredient.fromStacks(new ItemStack(Items.BAKED_POTATO)), Ingredient.fromStacks(new ItemStack(Items.PAPER)),
    	});
    	RecipeRegistry.addShapedRecipe("frsm:potatochipscheese", "frsm:potatochips", new ItemStack(reg.getItem("frsm:potatochipscheese"), 1), 3, 3, new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(Items.PAPER)), Ingredient.fromStacks(new ItemStack(Items.BAKED_POTATO)), Ingredient.fromStacks(new ItemStack(Items.PAPER)),
        	Ingredient.fromStacks(new ItemStack(Items.PAPER)), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:cheese"))), Ingredient.fromStacks(new ItemStack(Items.PAPER)),
        	Ingredient.fromStacks(new ItemStack(Items.PAPER)), Ingredient.fromStacks(new ItemStack(Items.BAKED_POTATO)), Ingredient.fromStacks(new ItemStack(Items.PAPER)),
    	});
    	RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getItem("frsm:key"), 3, 1), new ItemStack(Items.IRON_INGOT, 3));
    	RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getItem("frsm:key"), 3, 0), new ItemStack(Items.IRON_INGOT, 2), new ItemStack(Items.GOLD_INGOT));
    	for(int i = 0; i < 16; i++){
    		RecipeRegistry.addShapedRecipe("frsm:lamp_" + i, "frsm:lamp", new ItemStack(reg.getBlock("frsm:lamp"), 16, i), 3, 2, new Ingredient[]{
    			Ingredient.fromStacks(new ItemStack(Blocks.WOOL, 1, i)), Ingredient.fromStacks(new ItemStack(Blocks.GLOWSTONE)), Ingredient.fromStacks(new ItemStack(Blocks.WOOL, 1, i)),
    			Ingredient.fromStacks(new ItemStack(Blocks.WOOL, 1, i)), Ingredient.fromStacks(new ItemStack(Blocks.WOOL, 1, i)), Ingredient.fromStacks(new ItemStack(Blocks.WOOL, 1, i)),
    		});
    	}
    	RecipeRegistry.addShapedRecipe("frsm:lamp_16", "frsm:lamp", new ItemStack(reg.getBlock("frsm:lamp"), 16, 15), 3, 2, new Ingredient[]{
    		INGREDIENT_WOOL, Ingredient.fromStacks(new ItemStack(Blocks.GLOWSTONE)), INGREDIENT_WOOL,
    		INGREDIENT_WOOL, INGREDIENT_WOOL, INGREDIENT_WOOL,
    	});
    	RecipeRegistry.addShapedRecipe("frsm:laptop", "frsm:laptops", new ItemStack(reg.getBlock("frsm:laptop"), 1), 3, 2, new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(Items.IRON_INGOT)), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:tvscreensmall"))),
    		Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:laptopmainboard"))), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:nesr"))),
    		Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:keyboard"))), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:redstoneinput")))
    	});
    	RecipeRegistry.addShapedRecipe("frsm:laptop_white", "frsm:laptops", new ItemStack(reg.getBlock("frsm:laptop_white"), 1), 3, 3, new Ingredient[]{
    		INGREDIENT_NULL, Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 15)), INGREDIENT_NULL,
        	Ingredient.fromStacks(new ItemStack(Items.IRON_INGOT)), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:tvscreensmall"))),
        	Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:laptopmainboard"))), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:nesr"))),
        	Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:keyboard"))), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:redstoneinput")))
        });
    	RecipeRegistry.addShapedRecipe("frsm:laptop_green", "frsm:laptops", new ItemStack(reg.getBlock("frsm:laptop_green"), 1), 3, 3, new Ingredient[]{
    		INGREDIENT_NULL, Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 2)), INGREDIENT_NULL,
        	Ingredient.fromStacks(new ItemStack(Items.IRON_INGOT)), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:tvscreensmall"))),
        	Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:laptopmainboard"))), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:nesr"))),
        	Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:keyboard"))), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:redstoneinput")))
        });
    	RecipeRegistry.addShapedRecipe("frsm:laptop_red", "frsm:laptops", new ItemStack(reg.getBlock("frsm:laptop_red"), 1), 3, 3, new Ingredient[]{
    		INGREDIENT_NULL, Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 1)), INGREDIENT_NULL,
        	Ingredient.fromStacks(new ItemStack(Items.IRON_INGOT)), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:tvscreensmall"))),
        	Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:laptopmainboard"))), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:nesr"))),
        	Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:keyboard"))), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:redstoneinput")))
        });
    	RecipeRegistry.addShapedRecipe("frsm:laptop_blue", "frsm:laptops", new ItemStack(reg.getBlock("frsm:laptop_blue"), 1), 3, 3, new Ingredient[]{
    		INGREDIENT_NULL, Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 4)), INGREDIENT_NULL,
        	Ingredient.fromStacks(new ItemStack(Items.IRON_INGOT)), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:tvscreensmall"))),
        	Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:laptopmainboard"))), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:nesr"))),
        	Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:keyboard"))), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:redstoneinput")))
        });
    	RecipeRegistry.addShapedRecipe("frsm:laptop_black", "frsm:laptops", new ItemStack(reg.getBlock("frsm:laptop_black"), 1), 3, 3, new Ingredient[]{
    		INGREDIENT_NULL, Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 0)), INGREDIENT_NULL,
        	Ingredient.fromStacks(new ItemStack(Items.IRON_INGOT)), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:tvscreensmall"))),
        	Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:laptopmainboard"))), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:nesr"))),
        	Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:keyboard"))), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:redstoneinput")))
        });
    	RecipeRegistry.addShapelessRecipe("frsm:laptop_black_alt", "frsm:laptops", new ItemStack(reg.getBlock("frsm:laptop_black"), 1), new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(reg.getBlock("frsm:laptop"))), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:upgradekit")))
        });
    	RecipeRegistry.addShapedRecipe("frsm:cup", null, new ItemStack(reg.getItem("frsm:cup"), 2), 1, 1, Ingredient.fromStacks(new ItemStack(Items.CLAY_BALL, 1)));
    	RecipeRegistry.addShapedRecipe("frsm:jar", null, new ItemStack(reg.getItem("frsm:jar"), 9), 1, 1, Ingredient.fromStacks(new ItemStack(Blocks.GLASS, 1)));
    	RecipeRegistry.addShapelessRecipe("frsm:stonemug", null, new ItemStack(reg.getItem("frsm:stonemug"), 1), Ingredient.fromStacks(new ItemStack(Blocks.GLASS, 1)), INGREDIENT_STONE);
    	RecipeRegistry.addShapedRecipe("frsm:prozessor", "frsm:processor", new ItemStack(reg.getItem("frsm:prozessor"), 2), 3, 3, new Ingredient[]{
    		INGREDIENT_REDSTONE, INGREDIENT_REDSTONE, INGREDIENT_REDSTONE,
    		INGREDIENT_IRON_INGOT, INGREDIENT_GOLD_NUGGET, INGREDIENT_IRON_INGOT,
    		INGREDIENT_REDSTONE, INGREDIENT_REDSTONE, INGREDIENT_REDSTONE
    	});
    	RecipeRegistry.addShapedRecipe("frsm:prozessor2", "frsm:processor", new ItemStack(reg.getItem("frsm:prozessor2"), 1), 1, 3, new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:prozessor"))), INGREDIENT_REDSTONE, Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:prozessor")))
        });
    	RecipeRegistry.addShapedRecipe("frsm:prozessor4", "frsm:processor", new ItemStack(reg.getItem("frsm:prozessor4"), 1), 3, 3, new Ingredient[]{
    		INGREDIENT_NULL, Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:prozessor"))), INGREDIENT_NULL,
        	Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:prozessor"))), INGREDIENT_REDSTONE, Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:prozessor"))),
        	INGREDIENT_NULL, Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:prozessor"))), INGREDIENT_NULL
        });
    	RecipeRegistry.addShapedRecipe("frsm:tvscreensmall", "frsm:tvscreens", new ItemStack(reg.getItem("frsm:tvscreensmall"), 1), 3, 3, new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(Blocks.GLASS)), Ingredient.fromStacks(new ItemStack(Blocks.GLASS)), Ingredient.fromStacks(new ItemStack(Blocks.GLASS)),
    		Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 1)), Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 2)), Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 12)),
    	    Ingredient.fromStacks(new ItemStack(Blocks.GLASS)), Ingredient.fromStacks(new ItemStack(Blocks.GLASS)), Ingredient.fromStacks(new ItemStack(Blocks.GLASS))
    	});
    	RecipeRegistry.addShapedRecipe("frsm:tvscreenmedium", "frsm:tvscreens", new ItemStack(reg.getItem("frsm:tvscreenmedium"), 1), 2, 1, new Ingredient[]{
        	Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:tvscreensmall"))), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:tvscreensmall")))
        });
    	RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getItem("frsm:tvscreenlarge"), 1), new ItemStack(Items.IRON_INGOT, 4), new ItemStack(Blocks.GLASS, 10),
    		new ItemStack(Items.DYE, 2, 1), new ItemStack(Items.DYE, 2, 2), new ItemStack(Items.DYE, 2, 12));
		// // // // // // // // // //
    	/*GameRegistry.addRecipe(new ItemStack(reg.getItem("frsm:redstoneinput"), 2), new Object[]{
    		"   ",
    		"ABC",
    		"   ",
    		'A', Items.IRON_INGOT, 'B', Items.SLIME_BALL, 'C', Items.REDSTONE
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getItem("frsm:laptopmainboard"), 1), new Object[]{
    		"   ",
    		"ABC",
    		" D ",
    		'A', Items.REDSTONE, 'B', reg.getItem("frsm:prozessor2"), 'C', Items.SLIME_BALL, 'D', Items.IRON_INGOT,
    	});
    	GameRegistry.addShapelessRecipe(new ItemStack(reg.getItem("frsm:nesr"), 1), new Object[]{
    		Blocks.DIRT, Blocks.COBBLESTONE,
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getItem("frsm:keyboard"), 1), new Object[]{
    		"AAA",
    		"ABA",
    		"AAA",
    		'A', Blocks.STONE_BUTTON, 'B', Items.IRON_INGOT,
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getItem("frsm:pcmainboard"), 1), new Object[]{
    		"   ",
    		"ABC",
    		"DED",
    		'A', Items.REDSTONE, 'B', reg.getItem("frsm:prozessor4"),
    		'C', Items.SLIME_BALL, 'D', Items.IRON_INGOT, 'E', reg.getItem("frsm:nesr"),
    	});
    	GameRegistry.addShapelessRecipe(new ItemStack(reg.getItem("frsm:upgradekit"), 1), new Object[]{
    		Items.IRON_INGOT, reg.getItem("frsm:prozessor")
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getItem("frsm:tvcontroller"), 1), new Object[]{
    		"AAA",
    		"ABA",
    		"ACA",
    		'A', Blocks.STONE_BUTTON, 'B', Items.REDSTONE, 'C', Items.IRON_INGOT
    	});
    	RecipeRegistry.addRecipe(new ItemStack(reg.getItem("frsm:planks_oak"), 64), new Object[]{
    		"AAAA",
    		'A', Blocks.LOG,
    	});
    	GameRegistry.addShapelessRecipe(new ItemStack(reg.getItem("frsm:tomatoseeds"), 4), new Object[]{
    		reg.getItem("frsm:tomato"),
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:tbm"), 1), new Object[]{
    		"   ",
    		"AAA",
    		"B B",
    		'A', Blocks.PLANKS, 'B', Blocks.LOG,
    	});
    	RecipeRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:tbm"), 1), new Object[]{
    		"AAAAA",
    		"AAAAA",
    		"AAAAA",
    		"AAAAA",
    		"B   B",
    		'A', Blocks.PLANKS, 'B', Blocks.LOG,
    	});
    	GameRegistry.addShapelessRecipe(new ItemStack(reg.getBlock("frsm:crate"), 1), new Object[]{
    		Blocks.CHEST,
    	});
    	GameRegistry.addShapelessRecipe(new ItemStack(reg.getBlock("frsm:kd1"), 1), new Object[]{
    		reg.getItem("frsm:cup"), reg.getItem("frsm:jar"), reg.getItem("frsm:tomatojar"), reg.getItem("frsm:jar"),
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:car1d"), 2), new Object[]{
    		"   ",
    		" B ",
    		" A ",
    		'A', Blocks.PLANKS, 'B', Items.IRON_INGOT,
    	});
    	GameRegistry.addShapelessRecipe(new ItemStack(reg.getBlock("frsm:kd2"), 2), new Object[]{
    		reg.getItem("frsm:stonemugwithbeer"), reg.getItem("frsm:stonemugwithbeer"), Items.CLAY_BALL, Items.IRON_INGOT
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:trashcan"), 1), new Object[]{
    		"A A",
    		"ABA",
    		"AAA",
    		'A', Items.IRON_INGOT, 'B', Items.LAVA_BUCKET,
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:window1"), 16), new Object[]{
    		"AAA",
    		"BCB",
    		"AAA",
    		'A', Blocks.LOG, 'B', Blocks.PLANKS, 'C', Blocks.GLASS,
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:fence1"), 16), new Object[]{
    		"C C",
    		"BBB",
    		"AAA",
    		'A', Blocks.STONE, 'B', Blocks.IRON_BARS, 'C', Items.IRON_INGOT,
    	});
    	RecipeRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:furnace1"), 1), new Object[]{
    		"  D  ",
    		"AAAAA",
    		"ABBBA",
    		"ABCBA",
    		"ABBBA",
    		'A', Items.IRON_INGOT, 'B', Items.BRICK, 'C', Blocks.FURNACE, 'D', reg.getBlock("frsm:stove_pipe")
    	});
    	GameRegistry.addShapelessRecipe(new ItemStack(reg.getBlock("frsm:radio2"), 1), new Object[]{
    		reg.getItem("frsm:nesr"), Blocks.LOG
    	});
    	RecipeRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:furnace1"), 1), new Object[]{
        	" B ",
        	"B B",
        	"BCB",
        	" B ",
        	'B', Items.IRON_INGOT, 'C', Blocks.CHEST
        });
    	GameRegistry.addShapelessRecipe(new ItemStack(reg.getBlock("frsm:tvs2"), 1), new Object[]{
        	reg.getItem("frsm:nesr"), reg.getItem("frsm:tvscreensmall"), Items.IRON_INGOT, reg.getItem("frsm:redstoneinput")
        });
    	for(int i = 0; i < 16; i++){
    		EnumDyeColor color = EnumDyeColor.byMetadata(i);
    		GameRegistry.addRecipe(new ItemStack(reg.getItem("frsm:paintbucket"), 1, color.getMetadata()), new Object[]{
    	    	"BBB",
    	    	" B ",
    	    	" A ",
    	    	'A', Items.BUCKET, 'B', new ItemStack(Items.DYE, 1, color.getDyeDamage()),
    	    });
    	}
    	GameRegistry.addRecipe(new ItemStack(reg.getItem("frsm:brush"), 3), new Object[]{
    		"   ",
    		" B ",
    		" A ",
    		'A', Items.STICK, 'B', Blocks.WOOL,
    	});
    	for(int i = 0; i < 16; i++){
    		GameRegistry.addShapelessRecipe(new ItemStack(reg.getItem("frsm:paintset" + i), 1), new Object[]{
    			reg.getItem("frsm:brush"), new ItemStack(reg.getItem("frsm:paintbucket"), 1, i)
    		});
    	}
    	GameRegistry.addShapelessRecipe(new ItemStack(reg.getItem("frsm:paintset16"), 1), new Object[]{
    		reg.getItem("frsm:brush"), new ItemStack(reg.getItem("frsm:paintbucket"), 1, 15), new ItemStack(Items.DYE)
    	});
    	RecipeRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:palet1x1"), 1), new Object[]{
    		"AAAA",
    		"B  B",
    		"AAAA",
    		'A', reg.getItem("frsm:planks_oak"), 'B', Blocks.LOG,
    	});
    	RecipeRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:palet1x1_1"), 1), new Object[]{
    		"B",
    		"A",
    		'A', reg.getBlock("frsm:palet1x1"), 'B', reg.getItem("frsm:nesr"),
    	});
    	RecipeRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:palet1x1_2"), 1), new Object[]{
    		"B",
    		"B",
    		"A",
    		'A', reg.getBlock("frsm:palet1x1"), 'B', reg.getItem("frsm:nesr"),
    	});
    	GameRegistry.addShapelessRecipe(new ItemStack(reg.getBlock("frsm:pillar1"), 4), new Object[]{
    		new ItemStack(Blocks.QUARTZ_BLOCK, 0, 2),
    	});
    	GameRegistry.addShapelessRecipe(new ItemStack(reg.getBlock("frsm:pillar1_top"), 4), new Object[]{
    		reg.getBlock("frsm:pillar1"), reg.getBlock("frsm:pillar1"), reg.getBlock("frsm:pillar1"),
    		reg.getBlock("frsm:pillar1"), new ItemStack(Blocks.QUARTZ_BLOCK, 0, 0),
    	});
    	GameRegistry.addShapelessRecipe(new ItemStack(reg.getBlock("frsm:pillar1_bottom"), 2), new Object[]{
    		reg.getBlock("frsm:pillar1"), reg.getBlock("frsm:pillar1"), new ItemStack(Blocks.QUARTZ_BLOCK, 0, 0),
    	});
    	RecipeRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:stove_pipe"), 1), new Object[]{
        	"A",
        	"A",
        	"A",
        	'A', Items.IRON_INGOT,
        });
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:model_rail"), 16), new Object[]{
    		"A A",
    		"ABA",
    		"A A",
    		'A', Items.STICK, 'B', Items.IRON_INGOT,
    	});
    	GameRegistry.addShapelessRecipe(new ItemStack(reg.getBlock("frsm:model_rail"), 1), new Object[]{
    			reg.getBlock("frsm:model_railturn")
    	});
    	GameRegistry.addShapelessRecipe(new ItemStack(reg.getBlock("frsm:model_railturn"), 1), new Object[]{
    		reg.getBlock("frsm:model_rail")
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:model_station"), 1), new Object[]{
    		"   ",
    		"AB ",
    		"   ",
    		'A', Items.IRON_INGOT, 'B', reg.getBlock("frsm:model_rail")
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:model_station2"), 1), new Object[]{
    		"   ",
    		"ABA",
    		"   ",
    		'A', Items.IRON_INGOT, 'B', reg.getBlock("frsm:model_rail")
    	});
    	GameRegistry.addShapelessRecipe(new ItemStack(reg.getBlock("frsm:model_station3"), 1), new Object[]{
    		reg.getBlock("frsm:model_station2"), Items.GLOWSTONE_DUST,
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getItem("frsm:tilesempty"), 9), new Object[]{
    		"AAA",
    		"AAA",
    		"AAA",
    		'A', Items.CLAY_BALL,
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:tiles"), 9), new Object[]{
    		"AAA",
    		"ABA",
    		"AAA",
    		'A', reg.getItem("frsm:tilesempty"), 'B', new ItemStack(Items.DYE, 1, 8)
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:tiles2"), 9), new Object[]{
    		"AAA",
    		"ABA",
    		"AAA",
    		'A', reg.getItem("frsm:tilesempty"), 'B', Blocks.GLOWSTONE
    	});
    	GameRegistry.addShapelessRecipe(new ItemStack(reg.getBlock("frsm:tiles3"), 3), new Object[]{
    		Blocks.STONEBRICK, Blocks.STONEBRICK,
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:tiles4"), 6), new Object[]{
    		"AAA",
    		"CBC",
    		"AAA",
    		'A', reg.getItem("frsm:tilesempty"), 'B', new ItemStack(Items.DYE, 1, 8), 'C', new ItemStack(Items.DYE, 1, 7)
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getItem("frsm:ironsaw"), 1), new Object[]{
    		"   ",
    		"AA ",
    		"CCB",
    		'A', Items.STICK, 'B', Blocks.PLANKS, 'C', Items.IRON_INGOT,
    	});
    	RecipeRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:tree_pot"), 1), new Object[]{
    		"A   A",
    		"A   A",
    		" AAA ",
    		'A', Items.BRICK,
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:tvs"), 1), new Object[]{
    		"   ",
    		"BAC",
    		" D ",
    		'A', reg.getItem("frsm:tvscreensmall"), 'B', reg.getItem("frsm:prozessor"), 'C', reg.getItem("frsm:redstoneinput"), 'D', Items.IRON_INGOT,
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:pchardware2"), 1), new Object[]{
    		"   ",
    		"DBA",
    		" EC",
    		'A', Items.IRON_INGOT, 'B', reg.getItem("frsm:tvscreensmall"), 'C', reg.getItem("frsm:nesr"), 'D', reg.getItem("frsm:redstoneinput"), 'E', reg.getItem("frsm:keyboard"),
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:pchardware1"), 1), new Object[]{
    		"ADA",
    		"ABA",
    		"ACA",
    		'A', Items.IRON_INGOT, 'B', reg.getItem("frsm:pcmainboard"), 'C', reg.getItem("frsm:redstoneinput"), 'D', reg.getItem("frsm:nesr"),
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:printer"), 1), new Object[]{
    		" C ",
    		"BAB",
    		"BDB",
    		'A', reg.getItem("frsm:nesr"), 'B', Items.IRON_INGOT, 'C', Items.PAPER, 'D', Items.REDSTONE,
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:washingmashine"), 1), new Object[]{
    		"ABA",
    		"ACA",
    		"ADA",
    		'A', Items.IRON_INGOT, 'B', reg.getItem("frsm:prozessor"), 'C', reg.getItem("frsm:nesr"), 'D', reg.getItem("frsm:redstoneinput"),
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:toaster"), 1), new Object[]{
    		" B ",
    		"ACA",
    		"ADA",
    		'A', Items.IRON_INGOT, 'B', Items.REDSTONE, 'C', reg.getItem("frsm:nesr"), 'D', reg.getItem("frsm:redstoneinput"),
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:stove"), 1), new Object[]{
    		"ABA",
    		"ACA",
    		"ADA",
    		'A', Items.IRON_INGOT, 'B', Blocks.FURNACE, 'C', reg.getItem("frsm:nesr"), 'D', reg.getItem("frsm:redstoneinput"),
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:tvm"), 1), new Object[]{
    		"   ",
    		"BAC",
    		"EDF",
    		'A', reg.getItem("frsm:tvscreenmedium"), 'B', reg.getItem("frsm:prozessor"), 'C', reg.getItem("frsm:redstoneinput"),
    		'D', Items.IRON_INGOT, 'E', reg.getItem("frsm:nesr"), 'F', reg.getItem("frsm:tvcontroller"),
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:radio1"), 1), new Object[]{
    		"   ",
    		"AC ",
    		"ABA",
    		'A', Items.IRON_INGOT, 'B', reg.getItem("frsm:prozessor"), 'C', reg.getItem("frsm:nesr")
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:vendingmashine"), 1), new Object[]{
    		"DDD",
    		"CCC",
    		" AB",
    		'A', Blocks.IRON_BLOCK, 'B', reg.getItem("frsm:prozessor"), 'C', reg.getItem("frsm:nesr"), 'D', Items.IRON_INGOT,
    	});
    	GameRegistry.addRecipe(new ItemStack(reg.getBlock("frsm:tvl"), 1), new Object[]{
        		"   ",
        		"BAC",
        		"EDF",
        		'A', reg.getItem("frsm:tvscreenlarge"), 'B', reg.getItem("frsm:prozessor2"), 'C', reg.getItem("frsm:redstoneinput"),
        		'D', Items.IRON_INGOT, 'E', reg.getItem("frsm:nesr"), 'F', reg.getItem("frsm:tvcontroller"),
        });
    	GameRegistry.addShapelessRecipe(new ItemStack(reg.getBlock("frsm:tvl_1"), 1), new Object[]{
    			reg.getBlock("frsm:tvl")
    	});
    	GameRegistry.addShapelessRecipe(new ItemStack(reg.getBlock("frsm:tvl"), 1), new Object[]{
    			reg.getBlock("frsm:tvl_1")
        });
    	RecipeRegistry.addShapelessRecipe(new ItemStack(reg.getBlock("frsm:radio2")), new Object[]{
        	reg.getItem("frsm:nesr"), Blocks.LOG
        });
        */
	}
	
}