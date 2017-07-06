package net.fexcraft.mod.frsm.util;

import net.fexcraft.mod.lib.api.common.fRecipeHolder;
import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.fexcraft.mod.lib.util.registry.RegistryUtil;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
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
    	RecipeRegistry.addShapedRecipe("frsm:pizza", null, new ItemStack(reg.getItem("frsm:pizza"), 1), 3, 3, new Ingredient[]{
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
    	RecipeRegistry.addShapelessRecipe("frsm:frsm:chocolatebar", null, new ItemStack(RegistryUtil.getItem("frsm:chocolatebar"), 4), new Ingredient[]{
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
    	RecipeRegistry.addShapedRecipe("frsm:redstoneinput", null, new ItemStack(reg.getItem("frsm:redstoneinput"), 2), 3, 1, new Ingredient[]{
    		INGREDIENT_IRON_INGOT, INGREDIENT_SLIME_BALL, INGREDIENT_REDSTONE
    	});
    	RecipeRegistry.addShapedRecipe("frsm:laptopmainboard", "frsm:mainboard", new ItemStack(reg.getItem("frsm:laptopmainboard"), 1), 3, 2, new Ingredient[]{
    		INGREDIENT_REDSTONE, Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:prozessor2"))), INGREDIENT_SLIME_BALL,
    		Ingredient.EMPTY, INGREDIENT_IRON_INGOT, Ingredient.EMPTY
    	});
    	RecipeRegistry.addShapedRecipe("frsm:nesr", "", new ItemStack(reg.getItem("frsm:nesr"), 1), 2, 1,
    		Ingredient.fromStacks(new ItemStack(Blocks.DIRT)), Ingredient.fromStacks(new ItemStack(Blocks.COBBLESTONE))
    	);
    	RecipeRegistry.addShapelessRecipe("frsm:nesr", "", new ItemStack(reg.getItem("frsm:nesr"), 1),
    		Ingredient.fromStacks(new ItemStack(Blocks.DIRT)), Ingredient.fromStacks(new ItemStack(Blocks.COBBLESTONE))
    	);
    	RecipeRegistry.addShapedRecipe("frsm:keyboard", null, new ItemStack(reg.getItem("frsm:keyboard"), 1), 3, 4, new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(Blocks.STONE_BUTTON)), Ingredient.fromStacks(new ItemStack(Blocks.STONE_BUTTON)), Ingredient.fromStacks(new ItemStack(Blocks.STONE_BUTTON)),
    		Ingredient.fromStacks(new ItemStack(Blocks.STONE_BUTTON)), Ingredient.fromStacks(new ItemStack(Blocks.STONE_BUTTON)), Ingredient.fromStacks(new ItemStack(Blocks.STONE_BUTTON)),
    		INGREDIENT_IRON_INGOT, INGREDIENT_IRON_INGOT, INGREDIENT_IRON_INGOT
    	});
    	RecipeRegistry.addShapedRecipe("frsm:pcmainboard", "frsm:mainboard", new ItemStack(reg.getItem("frsm:pcmainboard"), 1), 3, 3, new Ingredient[]{
    		INGREDIENT_REDSTONE, Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:prozessor4"))), INGREDIENT_SLIME_BALL,
    		INGREDIENT_IRON_INGOT, Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:nesr"))), INGREDIENT_IRON_INGOT
    	});
    	RecipeRegistry.addShapelessRecipe("frsm:upgradekit", null, new ItemStack(reg.getItem("frsm:upgradekit"), 1), INGREDIENT_IRON_INGOT, Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:prozessor"))));
    	RecipeRegistry.addShapedRecipe("frsm:tvcontroller", null, new ItemStack(reg.getItem("frsm:tvcontroller"), 1), 3, 3, new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(Blocks.STONE_BUTTON)), Ingredient.fromStacks(new ItemStack(Blocks.STONE_BUTTON)), Ingredient.fromStacks(new ItemStack(Blocks.STONE_BUTTON)),
    		Ingredient.fromStacks(new ItemStack(Blocks.STONE_BUTTON)), INGREDIENT_REDSTONE, Ingredient.fromStacks(new ItemStack(Blocks.STONE_BUTTON)),
    		Ingredient.fromStacks(new ItemStack(Blocks.STONE_BUTTON)), INGREDIENT_IRON_INGOT, Ingredient.fromStacks(new ItemStack(Blocks.STONE_BUTTON))
    	});
    	RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getItem("frsm:planks_oak"), 64), new ItemStack(Blocks.PLANKS, 4));
    	RecipeRegistry.addShapedRecipe("frsm:tomatoseeds", null, new ItemStack(reg.getItem("frsm:tomatoseeds"), 4), 1, 1, Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:tomato"))));
    	RecipeRegistry.addShapedRecipe("frsm:tbm", "frsm:tbm", new ItemStack(reg.getBlock("frsm:tbm"), 1), 3, 2, new Ingredient[]{
    		INGREDIENT_PLANKS, INGREDIENT_PLANKS, INGREDIENT_PLANKS,
    		INGREDIENT_LOG, Ingredient.EMPTY, INGREDIENT_LOG
    	});
    	RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getBlock("frsm:tbm"), 1), new ItemStack(Blocks.PLANKS, 20), new ItemStack(Blocks.LOG, 2));
    	RecipeRegistry.addShapelessRecipe("frsm:crate", null, new ItemStack(reg.getBlock("frsm:crate"), 1), Ingredient.fromStacks(new ItemStack(Blocks.CHEST)));
    	RecipeRegistry.addShapelessRecipe("frsm:kd1", "frsm:kd", new ItemStack(reg.getBlock("frsm:kd1"), 1), new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:cup"))), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:jar"))),
    		Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:tomatoJar"))), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:jar")))
    	});
    	RecipeRegistry.addShapelessRecipe("frsm:kd2", "frsm:kd", new ItemStack(reg.getBlock("frsm:kd2"), 1), new Ingredient[]{
        	Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:stonemugwithbeer"))), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:stonemugwithbeer"))),
        	Ingredient.fromStacks(new ItemStack(Items.CLAY_BALL)), Ingredient.fromStacks(new ItemStack(Items.IRON_INGOT))
        });
    	RecipeRegistry.addShapedRecipe("frsm:car1d", null, new ItemStack(reg.getBlock("frsm:car1d"), 2), 1, 2, new Ingredient[]{
    		INGREDIENT_IRON_INGOT, INGREDIENT_PLANKS
    	});
    	RecipeRegistry.addShapedRecipe("frsm:trashcan", null, new ItemStack(reg.getBlock("frsm:trashcan"), 1), 3, 3, new Ingredient[]{
    		INGREDIENT_IRON_INGOT, Ingredient.EMPTY, INGREDIENT_IRON_INGOT,
    		INGREDIENT_IRON_INGOT, Ingredient.fromStacks(new ItemStack(Items.LAVA_BUCKET)), INGREDIENT_IRON_INGOT,
    		INGREDIENT_IRON_INGOT, INGREDIENT_IRON_INGOT, INGREDIENT_IRON_INGOT
    	});
    	RecipeRegistry.addShapedRecipe("frsm:window1", null, new ItemStack(reg.getBlock("frsm:window1"), 16), 3, 3, new Ingredient[]{
    		INGREDIENT_LOG, INGREDIENT_LOG, INGREDIENT_LOG,
    		INGREDIENT_PLANKS, Ingredient.fromStacks(new ItemStack(Blocks.GLASS)), INGREDIENT_PLANKS,
    		INGREDIENT_LOG, INGREDIENT_LOG, INGREDIENT_LOG
    	});
    	RecipeRegistry.addShapedRecipe("frsm:fence1", "frsm:fences", new ItemStack(reg.getBlock("frsm:fence1"), 16), 3, 3, new Ingredient[]{
    		INGREDIENT_IRON_INGOT, Ingredient.EMPTY, INGREDIENT_IRON_INGOT,
    		Ingredient.fromStacks(new ItemStack(Blocks.IRON_BARS)), Ingredient.fromStacks(new ItemStack(Blocks.IRON_BARS)), Ingredient.fromStacks(new ItemStack(Blocks.IRON_BARS)),
    		Ingredient.fromStacks(new ItemStack(Blocks.STONE)), Ingredient.fromStacks(new ItemStack(Blocks.STONE)), Ingredient.fromStacks(new ItemStack(Blocks.STONE))
    	});
    	RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getBlock("frsm:furnace1"), 1), new ItemStack[]{
    		new ItemStack(Items.IRON_INGOT, 11), new ItemStack(Items.BRICK, 8), new ItemStack(Blocks.FURNACE, 1), new ItemStack(reg.getBlock("frsm:stove_pipe"), 1)
    	});
    	RecipeRegistry.addShapelessRecipe("frsm:radio2", "frsm:radio", new ItemStack(reg.getBlock("frsm:radio2"), 1), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:nesr"))), INGREDIENT_LOG);
    	RecipeRegistry.addShapedRecipe("frsm:radio2_s", "frsm:radio", new ItemStack(reg.getBlock("frsm:radio2"), 1), 2, 1, Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:nesr"))), INGREDIENT_LOG);
    	RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getBlock("frsm:iron_barrel"), 1), new ItemStack(Items.IRON_INGOT, 6), new ItemStack(Blocks.CHEST, 1));
    	RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getBlock("frsm:tvs2"), 1), new ItemStack[]{
    		new ItemStack(reg.getItem("frsm:nesr"), 1), new ItemStack(reg.getItem("frsm:tvscreensmall"), 1), new ItemStack(Items.IRON_INGOT, 1), new ItemStack(reg.getItem("frsm:redstoneinput"), 1)
    	});
    	for(int i = 0; i < 16; i++){
    		EnumDyeColor color = EnumDyeColor.byMetadata(i);
    		Ingredient ing = Ingredient.fromStacks(new ItemStack(Items.DYE, 1, color.getDyeDamage()));
    		RecipeRegistry.addShapedRecipe("frsm:paintbucket_" + i, "frsm:paintbucket", new ItemStack(reg.getItem("frsm:paintbucket"), 1, color.getMetadata()), 3, 3, new Ingredient[]{
    			ing, ing, ing,
    			Ingredient.EMPTY, Ingredient.fromStacks(new ItemStack(Items.DYE, 1, color.getDyeDamage())), Ingredient.EMPTY,
    			Ingredient.EMPTY, Ingredient.fromStacks(new ItemStack(Items.BUCKET)), Ingredient.EMPTY
    		});
    	}
    	RecipeRegistry.addShapedRecipe("frsm:brush", null, new ItemStack(reg.getItem("frsm:brush"), 3), 1, 2,
    		Ingredient.fromStacks(new ItemStack(Blocks.WOOL)), Ingredient.fromStacks(new ItemStack(Items.STICK))
    	);
    	for(int i = 0; i < 16; i++){
    		RecipeRegistry.addShapedRecipe("frsm:paintset" + i, "frsm:paintset", new ItemStack(reg.getItem("frsm:paintset" + i), 1), 2, 1,
    			Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:brush"), 1)), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:paintbucket"), 1, i))
    		);
    	}
    	RecipeRegistry.addShapedRecipe("frsm:paintset16", "frsm:paintset", new ItemStack(reg.getItem("frsm:paintset16"), 1), 2, 2,
    		Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:brush"), 1)), Ingredient.fromStacks(new ItemStack(reg.getItem("frsm:paintbucket"), 1, 15)),
    		Ingredient.EMPTY, INGREDIENT_DYE
    	);
    	RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getBlock("frsm:palet1x1"), 1), new ItemStack(reg.getItem("frsm:planks_oak"), 8), new ItemStack(Blocks.LOG, 2));
    	RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getBlock("frsm:palet1x1_1"), 1), new ItemStack(reg.getItem("frsm:palet1x1"), 1), new ItemStack(reg.getItem("frsm:nesr"), 1));
    	RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getBlock("frsm:palet1x1_2"), 1), new ItemStack(reg.getItem("frsm:palet1x1"), 1), new ItemStack(reg.getItem("frsm:nesr"), 2));
    	RecipeRegistry.addShapedRecipe("frsm:pillar1", "frsm:pillars", new ItemStack(reg.getBlock("frsm:pillar1"), 4), 1, 1, Ingredient.fromStacks(new ItemStack(Blocks.QUARTZ_BLOCK, 0, 2)));
    	RecipeRegistry.addShapedRecipe("frsm:pillar1_top", "frsm:pillars", new ItemStack(reg.getBlock("frsm:pillar1_top"), 2), 1, 2, new Ingredient[]{
        	Ingredient.fromStacks(new ItemStack(Blocks.QUARTZ_BLOCK, 0, 0)),
    		Ingredient.fromStacks(new ItemStack(reg.getBlock("frsm:pillar1"), 1))
    	});
    	RecipeRegistry.addShapedRecipe("frsm:pillar1_bottom", "frsm:pillars", new ItemStack(reg.getBlock("frsm:pillar1_bottom"), 2), 1, 2, new Ingredient[]{
        	Ingredient.fromStacks(new ItemStack(reg.getBlock("frsm:pillar1"), 1)),
    		Ingredient.fromStacks(new ItemStack(Blocks.QUARTZ_BLOCK, 0, 0))
        });
    	RecipeRegistry.addShapedRecipe("frsm:stove_pipe", "frsm:pipes", new ItemStack(reg.getBlock("frsm:stove_pipe"), 1), 1, 3, new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(Items.IRON_INGOT)), Ingredient.fromStacks(new ItemStack(Items.IRON_INGOT)), Ingredient.fromStacks(new ItemStack(Items.IRON_INGOT))
    	});
    	RecipeRegistry.addShapedRecipe("frsm:model_rail", "frsm:model_rails", new ItemStack(reg.getBlock("frsm:model_rail"), 16), 3, 3, new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(Items.STICK)), Ingredient.EMPTY, Ingredient.fromStacks(new ItemStack(Items.STICK)),
    		Ingredient.fromStacks(new ItemStack(Items.STICK)), INGREDIENT_IRON_INGOT, Ingredient.fromStacks(new ItemStack(Items.STICK)),
    		Ingredient.fromStacks(new ItemStack(Items.STICK)), Ingredient.EMPTY, Ingredient.fromStacks(new ItemStack(Items.STICK))
    	});
    	RecipeRegistry.addShapedRecipe("frsm:model_rail_alt", "frsm:model_rails", new ItemStack(reg.getBlock("frsm:model_rail"), 1), 1, 1, Ingredient.fromStacks(new ItemStack(reg.getBlock("frsm:model_railturn"), 1)));
    	RecipeRegistry.addShapedRecipe("frsm:model_railturn", "frsm:model_rails", new ItemStack(reg.getBlock("frsm:model_railturn"), 1), 1, 1, Ingredient.fromStacks(new ItemStack(reg.getBlock("frsm:model_rail"), 1)));
    	RecipeRegistry.addShapedRecipe("frsm:model_station", "frsm:model_stations", new ItemStack(reg.getBlock("frsm:model_station"), 1), 2, 1,
    		INGREDIENT_IRON_INGOT, Ingredient.fromStacks(new ItemStack(reg.getBlock("frsm:model_rail")))
    	);
    	RecipeRegistry.addShapedRecipe("frsm:model_station2", "frsm:model_stations", new ItemStack(reg.getBlock("frsm:model_station2"), 1), 3, 1,
        	INGREDIENT_IRON_INGOT, Ingredient.fromStacks(new ItemStack(reg.getBlock("frsm:model_rail"))), INGREDIENT_IRON_INGOT
        );
    	RecipeRegistry.addShapedRecipe("frsm:model_station3", "frsm:model_stations", new ItemStack(reg.getBlock("frsm:model_station3"), 1), 2, 1,
    		Ingredient.fromStacks(new ItemStack(reg.getBlock("frsm:model_station2"), 1)), Ingredient.fromStacks(new ItemStack(Items.GLOWSTONE_DUST, 1))
    	);
    	RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getItem("frsm:tilesempty"), 1), new ItemStack(Items.CLAY_BALL));
    	RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getItem("frsm:tilesempty"), 9), new ItemStack(Items.CLAY_BALL, 9));
    	RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getItem("frsm:tiles"), 9), new ItemStack(reg.getItem("frsm:tilesempty"), 8), new ItemStack(Items.DYE, 1, 8));
    	RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getItem("frsm:tiles2"), 9), new ItemStack(reg.getItem("frsm:tilesempty"), 8), new ItemStack(Blocks.GLOWSTONE));
    	RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getItem("frsm:tiles3"), 4), new ItemStack(Blocks.STONEBRICK, 2));
    	RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getBlock("frsm:tiles4"), 6), new ItemStack(reg.getItem("frsm:tilesempty"), 6), new ItemStack(Items.DYE, 1, 8), new ItemStack(Items.DYE, 2, 7));
    	RecipeRegistry.addShapedRecipe("frsm:ironsaw", null, new ItemStack(reg.getItem("frsm:ironsaw"), 1), 3, 2, new Ingredient[]{
    		Ingredient.fromStacks(new ItemStack(Items.STICK)), Ingredient.fromStacks(new ItemStack(Items.STICK)), Ingredient.EMPTY,
    		INGREDIENT_IRON_INGOT, INGREDIENT_IRON_INGOT, INGREDIENT_PLANKS
    	});
    	RecipeRegistry.addBluePrintRecipe(category, new ItemStack(reg.getBlock("frsm:tree_pot"), 1), new ItemStack(Items.BRICK, 7));
    	RecipeRegistry.addShapedRecipe("frsm:tvs", "frsm:tvs", new ItemStack(reg.getBlock("frsm:tvs"), 1), 3, 2, new Ingredient[]{
    		ing(reg.getItem("frsm:prozessor")), ing(reg.getItem("frsm:tvscreensmall")), ing(reg.getItem("frsm:redstoneinput")),
    		Ingredient.EMPTY, INGREDIENT_IRON_INGOT, Ingredient.EMPTY
    	});
    	RecipeRegistry.addShapedRecipe("frsm:pchardware2", "frsm:pchardware", new ItemStack(reg.getBlock("frsm:pchardware2"), 1), 3, 2, new Ingredient[]{
    		ing(reg.getItem("frsm:redstoneinput")), ing(reg.getItem("frsm:tvscreensmall")), INGREDIENT_IRON_INGOT,
    		Ingredient.EMPTY, ing(reg.getItem("frsm:keyboard")), ing(reg.getItem("frsm:nesr"))
    	});
    	RecipeRegistry.addShapedRecipe("frsm:pchardware1", "frsm:pchardware", new ItemStack(reg.getBlock("frsm:pchardware1"), 1), 3, 3, new Ingredient[]{
    		INGREDIENT_IRON_INGOT, ing(reg.getItem("frsm:nesr")), INGREDIENT_IRON_INGOT,
    		INGREDIENT_IRON_INGOT, ing(reg.getItem("frsm:pcmainboard")), INGREDIENT_IRON_INGOT,
    		INGREDIENT_IRON_INGOT, ing(reg.getItem("frsm:redstoneinput")), INGREDIENT_IRON_INGOT
    	});
    	RecipeRegistry.addShapedRecipe("frsm:printer", null, new ItemStack(reg.getBlock("frsm:printer"), 1), 3, 3, new Ingredient[]{
    		Ingredient.EMPTY, ing(Items.PAPER), Ingredient.EMPTY,
    		INGREDIENT_IRON_INGOT, ing(reg.getItem("frsm:nesr")), INGREDIENT_IRON_INGOT,
    		INGREDIENT_IRON_INGOT, INGREDIENT_REDSTONE, INGREDIENT_IRON_INGOT
    	});
    	RecipeRegistry.addShapedRecipe("frsm:washingmashine", null, new ItemStack(reg.getBlock("frsm:washingmashine"), 1), 3, 3, new Ingredient[]{
        	INGREDIENT_IRON_INGOT, ing(reg.getItem("frsm:prozessor")), INGREDIENT_IRON_INGOT,
        	INGREDIENT_IRON_INGOT, ing(reg.getItem("frsm:nesr")), INGREDIENT_IRON_INGOT,
        	INGREDIENT_IRON_INGOT, ing(reg.getItem("frsm:redstoneinput")), INGREDIENT_IRON_INGOT
        });
    	RecipeRegistry.addShapedRecipe("frsm:toaster", null, new ItemStack(reg.getBlock("frsm:toaster"), 1), 3, 3, new Ingredient[]{
    		Ingredient.EMPTY, INGREDIENT_REDSTONE, Ingredient.EMPTY,
    		INGREDIENT_IRON_INGOT, ing(reg.getItem("frsm:nesr")), INGREDIENT_IRON_INGOT,
    		INGREDIENT_IRON_INGOT, ing(reg.getItem("frsm:redstoneinput")), INGREDIENT_IRON_INGOT
    	});
    	RecipeRegistry.addShapedRecipe("frsm:stove", null, new ItemStack(reg.getBlock("frsm:stove"), 1), 3, 3, new Ingredient[]{
    		INGREDIENT_IRON_INGOT, ing(Blocks.FURNACE), INGREDIENT_IRON_INGOT,
            INGREDIENT_IRON_INGOT, ing(reg.getItem("frsm:nesr")), INGREDIENT_IRON_INGOT,
            INGREDIENT_IRON_INGOT, ing(reg.getItem("frsm:redstoneinput")), INGREDIENT_IRON_INGOT	
    	});
    	RecipeRegistry.addShapedRecipe("frsm:tvm", "frsm:tvs", new ItemStack(reg.getBlock("frsm:tvm"), 1), 3, 2, new Ingredient[]{
    		ing(reg.getItem("frsm:prozessor")), ing(reg.getItem("frsm:tvscreenmedium")), ing(reg.getItem("frsm:redstoneinput")),
    		ing(reg.getItem("frsm:nesr")), INGREDIENT_IRON_INGOT, ing(reg.getItem("frsm:tvcontroller"))
    	});
    	RecipeRegistry.addShapedRecipe("frsm:radio1", "frsm:radio", new ItemStack(reg.getBlock("frsm:radio1"), 1), 3, 2, new Ingredient[]{
    		INGREDIENT_IRON_INGOT, ing(reg.getItem("frsm:nesr")), Ingredient.EMPTY,
    		INGREDIENT_IRON_INGOT, ing(reg.getItem("frsm:prozessor")), INGREDIENT_IRON_INGOT
    	});
    	RecipeRegistry.addShapedRecipe("frsm:vendingmashine", null, new ItemStack(reg.getBlock("frsm:vendingmashine"), 1), 3, 3, new Ingredient[]{
    		INGREDIENT_IRON_INGOT, INGREDIENT_IRON_INGOT, INGREDIENT_IRON_INGOT,
    		ing(reg.getItem("frsm:nesr")), ing(reg.getItem("frsm:nesr")), ing(reg.getItem("frsm:nesr")),
    		Ingredient.EMPTY, ing(Blocks.IRON_BLOCK), ing(reg.getItem("frsm:prozessor"))
    	});
    	RecipeRegistry.addShapedRecipe("frsm:tvl", "frsm:tvl", new ItemStack(reg.getBlock("frsm:tvl"), 1), 3, 2, new Ingredient[]{
    		ing(reg.getItem("frsm:prozessor2")), ing(reg.getItem("frsm:tvscreenlarge")), ing(reg.getItem("frsm:redstoneinput")),
    		ing(reg.getItem("frsm:nesr")), INGREDIENT_IRON_INGOT, ing(reg.getItem("frsm:tvcontroller"))
    	});
    	RecipeRegistry.addShapedRecipe("frsm:tvl_1", "frsm:tvl", new ItemStack(reg.getBlock("frsm:tvl_1"), 1), 1, 1, ing(reg.getBlock("frsm:tvl")));
    	RecipeRegistry.addShapedRecipe("frsm:tvl_alt", "frsm:tvl", new ItemStack(reg.getBlock("frsm:tvl"), 1), 1, 1, ing(reg.getBlock("frsm:tvl_1")));
    	RecipeRegistry.addShapedRecipe("frsm:radio2", "frsm:radio", new ItemStack(reg.getBlock("frsm:radio2"), 1), 2, 1, ing(reg.getItem("frsm:nesr")), INGREDIENT_LOG);
	}
	
}