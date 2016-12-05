package net.fexcraft.mod.frsm.items;

import java.util.HashSet;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.fexcraft.mod.frsm.items.common.AIC_E;
import net.fexcraft.mod.frsm.items.common.AIC_Z1;
import net.fexcraft.mod.frsm.items.common.Brush;
import net.fexcraft.mod.frsm.items.common.Cup;
import net.fexcraft.mod.frsm.items.common.EmeraldBlade;
import net.fexcraft.mod.frsm.items.common.EmptyTiles;
import net.fexcraft.mod.frsm.items.common.Jar;
import net.fexcraft.mod.frsm.items.common.Keyboard;
import net.fexcraft.mod.frsm.items.common.LaptopMainboard;
import net.fexcraft.mod.frsm.items.common.NESR;
import net.fexcraft.mod.frsm.items.common.OakPlanks;
import net.fexcraft.mod.frsm.items.common.PCMainboard;
import net.fexcraft.mod.frsm.items.common.PaintBucket;
import net.fexcraft.mod.frsm.items.common.Processor;
import net.fexcraft.mod.frsm.items.common.Processor2;
import net.fexcraft.mod.frsm.items.common.Processor4;
import net.fexcraft.mod.frsm.items.common.R1_Chassis;
import net.fexcraft.mod.frsm.items.common.RCTabIco;
import net.fexcraft.mod.frsm.items.common.RedstoneInput;
import net.fexcraft.mod.frsm.items.common.StoneMug;
import net.fexcraft.mod.frsm.items.common.TVController;
import net.fexcraft.mod.frsm.items.common.TVScreenLarge;
import net.fexcraft.mod.frsm.items.common.TVScreenMedium;
import net.fexcraft.mod.frsm.items.common.TVScreenSmall;
import net.fexcraft.mod.frsm.items.common.UpgradeKit;
import net.fexcraft.mod.frsm.items.eatable.Bacon;
import net.fexcraft.mod.frsm.items.eatable.BaconRaw;
import net.fexcraft.mod.frsm.items.eatable.Cheese;
import net.fexcraft.mod.frsm.items.eatable.CheesePie;
import net.fexcraft.mod.frsm.items.eatable.CheeseWhite;
import net.fexcraft.mod.frsm.items.eatable.ChocolateBar;
import net.fexcraft.mod.frsm.items.eatable.ChocolateBarWhite;
import net.fexcraft.mod.frsm.items.eatable.ChocolateCookie;
import net.fexcraft.mod.frsm.items.eatable.ChocolateMilk;
import net.fexcraft.mod.frsm.items.eatable.CookedEgg;
import net.fexcraft.mod.frsm.items.eatable.CupWithCacao;
import net.fexcraft.mod.frsm.items.eatable.Donut;
import net.fexcraft.mod.frsm.items.eatable.Hamburger;
import net.fexcraft.mod.frsm.items.eatable.Pizza;
import net.fexcraft.mod.frsm.items.eatable.PotatoChipsBag;
import net.fexcraft.mod.frsm.items.eatable.PotatoChipsCheese;
import net.fexcraft.mod.frsm.items.eatable.Salami;
import net.fexcraft.mod.frsm.items.eatable.StoneMugWithBeer;
import net.fexcraft.mod.frsm.items.eatable.Tomato;
import net.fexcraft.mod.frsm.items.eatable.TomatoJar;
import net.fexcraft.mod.frsm.items.eatable.TomatoSoup;
import net.fexcraft.mod.frsm.items.keys.Key;
import net.fexcraft.mod.frsm.items.keys.Key2;
import net.fexcraft.mod.frsm.items.keys.Key3;
import net.fexcraft.mod.frsm.items.tools.EmeraldSword;
import net.fexcraft.mod.frsm.items.tools.IronSaw;
import net.fexcraft.mod.frsm.items.tools.PaintSet;
import net.fexcraft.mod.frsm.items.tools.TEMT;
import net.fexcraft.mod.frsm.items.usable.RC;
import net.fexcraft.mod.frsm.items.usable.TVLI;
import net.fexcraft.mod.frsm.items.usable.TomatoSeeds;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.PrintLog;
import net.fexcraft.mod.lib.api.entity.RoboType;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.cls.EnumColor;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.relauncher.Side;

public class FRSM_Items{
	
	public static String id = FI.MODID;
	
	//public static ToolMaterial emerald = EnumHelper.addToolMaterial("emerald", 3, 2000, 15.0F, 4.0F, 30);//CHECKDIS
	
	public static Item cup_with_cacao;
	public static Item cup;
	public static Item jar;
	public static Item nesr;
	public static Item paint_bucket;
	public static Item brush;
	public static Item paintSet0;
	public static Item paintSet1;
	public static Item paintSet2;
	public static Item paintSet3;
	public static Item paintSet4;
	public static Item paintSet5;
	public static Item paintSet6;
	public static Item paintSet7;
	public static Item paintSet8;
	public static Item paintSet9;
	public static Item paintSet10;
	public static Item paintSet11;
	public static Item paintSet12;
	public static Item paintSet13;
	public static Item paintSet14;
	public static Item paintSet15;
	public static Item key;
	public static Item key2;
	public static Item key3;
	public static Item TEMT;
	public static Item hamburger;
	public static Item pizza;
	public static Item cheese;
	public static Item salami;
	public static Item tomato;
	public static Item tomato_jar;
	public static Item chocolate_bar;
	public static Item chocolate_milk;
	public static Item chocolate_cookie;
	public static Item cooked_egg;
	public static Item stone_mug;
	public static Item stone_mug_wb;
	public static Item donut;
	public static Item tomato_seeds;
	public static Item emerald_sword;
	public static Item emerald_blade;
	public static Item cheese_white;
	public static Item processor;
	public static Item processor2;
	public static Item processor4;
	public static Item tv_screen_small;
	public static Item redstone_input;
	public static Item cheese_pie;
	public static Item laptop_mainboard;
	public static Item keyboard;
	public static Item pc_mainboard;
	public static Item iron_saw;
	public static Item bacon_raw;
	public static Item bacon;
	public static Item chocolate_bar_white;
	public static Item tomato_soup;
	public static Item upgradekit;
	public static Item RRC;
	public static Item RBC;
	public static Item RGC;
	public static Item RYC;
	public static Item RPC;
	public static Item tv_screen_medium;
	public static Item tiles_empty;
	public static Item tv_controller;
	public static Item potatochips;
	public static Item potatochips_cheese;
	public static Item aic_empty;
	public static Item aic_z1;
	public static Item r1_chassis;
	public static Item rctabico;
	public static Item planks_oak;
	public static Item tv_screen_large;
	public static Item TVLI;
	
	public static HashSet<Item> items;

	public static Item SR1_blue;
	public static Item SR1_red;
	public static Item SR1_green;
	public static Item SR1_yellow;
	public static Item SR1_guard;
	//
	public static Item SR2H_blue;
	public static Item SR2H_red;
	public static Item SR2H_green;
	public static Item SR2H_yellow;
	public static Item SR2H_guard;
	//
	public static Item SR2M_blue;
	public static Item SR2M_red;
	public static Item SR2M_green;
	public static Item SR2M_yellow;
	public static Item SR2M_guard;
	//
	public static Item SR2L_blue;
	public static Item SR2L_red;
	public static Item SR2L_green;
	public static Item SR2L_yellow;
	public static Item SR2L_guard;
	//
	public static Item SR2J_blue;
	public static Item SR2J_red;
	public static Item SR2J_green;
	public static Item SR2J_yellow;
	public static Item SR2J_guard;
	//
	public static Item SR3J_blue;
	public static Item SR3J_red;
	public static Item SR3J_green;
	public static Item SR3J_yellow;
	public static Item SR3J_guard;
	//
	public static Item SR3M_blue;
	public static Item SR3M_red;
	public static Item SR3M_green;
	public static Item SR3M_yellow;
	public static Item SR3M_guard;
	//
	public static Item SR3L_blue;
	public static Item SR3L_red;
	public static Item SR3L_green;
	public static Item SR3L_yellow;
	public static Item SR3L_guard;
	//
	public static Item SR3LJ_blue;
	public static Item SR3LJ_red;
	public static Item SR3LJ_green;
	public static Item SR3LJ_yellow;
	public static Item SR3LJ_guard;
	//
	public static Item SRLLR1_blue;
	public static Item SRLLR1_red;
	public static Item SRLLR1_green;
	public static Item SRLLR1_yellow;
	public static Item SRLLR1_guard;
	
	public static void register(){
		items = new HashSet<Item>();
		
		jar = new Jar(); items.add(jar);
		nesr = new NESR(); items.add(nesr);
		paint_bucket = new PaintBucket(); items.add(paint_bucket);
		brush = new Brush(); items.add(brush);
        paintSet0 = new PaintSet("paintSet0", EnumColor.WHITE); items.add(paintSet0);
        paintSet1 = new PaintSet("paintSet1", EnumColor.ORANGE); items.add(paintSet1);
        paintSet2 = new PaintSet("paintSet2", EnumColor.MAGENTA); items.add(paintSet2);
        paintSet3 = new PaintSet("paintSet3", EnumColor.LIGHT_BLUE); items.add(paintSet3);
        paintSet4 = new PaintSet("paintSet4", EnumColor.YELLOW); items.add(paintSet4);
        paintSet5 = new PaintSet("paintSet5", EnumColor.LIME); items.add(paintSet5);
        paintSet6 = new PaintSet("paintSet6", EnumColor.PINK); items.add(paintSet6);
        paintSet7 = new PaintSet("paintSet7", EnumColor.GRAY); items.add(paintSet7);
        paintSet8 = new PaintSet("paintSet8", EnumColor.LIGHT_GRAY); items.add(paintSet8);
        paintSet9 = new PaintSet("paintSet9", EnumColor.CYAN); items.add(paintSet9);
        paintSet10 = new PaintSet("paintSet10", EnumColor.PURPLE); items.add(paintSet10);
        paintSet11 = new PaintSet("paintSet11", EnumColor.BLUE); items.add(paintSet11);
        paintSet12 = new PaintSet("paintSet12", EnumColor.BROWN); items.add(paintSet12);
        paintSet13 = new PaintSet("paintSet13", EnumColor.GREEN); items.add(paintSet13);
        paintSet14 = new PaintSet("paintSet14", EnumColor.RED); items.add(paintSet14);
        paintSet15 = new PaintSet("paintSet15", EnumColor.BLACK); items.add(paintSet15);
        key = new Key(); items.add(key);
        key2 = new Key2(); items.add(key2);
        key3 = new Key3(); items.add(key3);
        TEMT = new TEMT(); items.add(TEMT);
		
        
			cup = new Cup(); items.add(cup);
			cup_with_cacao = new CupWithCacao(); items.add(cup_with_cacao);
			hamburger = new Hamburger(); items.add(hamburger);
			pizza = new Pizza(); items.add(pizza);
			cheese = new Cheese(); items.add(cheese);
			salami = new Salami(); items.add(salami);
			tomato = new Tomato(); items.add(tomato);
			tomato_jar = new TomatoJar(); items.add(tomato_jar);
			chocolate_bar = new ChocolateBar(); items.add(chocolate_bar);
			chocolate_milk = new ChocolateMilk(); items.add(chocolate_milk);
			chocolate_cookie = new ChocolateCookie(); items.add(chocolate_cookie);
			cooked_egg = new CookedEgg(); items.add(cooked_egg);
			stone_mug = new StoneMug(); items.add(stone_mug);
			stone_mug_wb = new StoneMugWithBeer(); items.add(stone_mug_wb);
			donut = new Donut(); items.add(donut);
			tomato_seeds = new TomatoSeeds(FRSM_Blocks.tomato_plant, Blocks.FARMLAND); items.add(tomato_seeds);
			emerald_sword = new EmeraldSword(ToolMaterial.DIAMOND); items.add(emerald_sword);
			emerald_blade = new EmeraldBlade(); items.add(emerald_blade);
			cheese_white = new CheeseWhite(); items.add(cheese_white);
			processor = new Processor(); items.add(processor);
			processor2 = new Processor2(); items.add(processor2);
			processor4 = new Processor4(); items.add(processor4);
			tv_screen_small = new TVScreenSmall(); items.add(tv_screen_small);
			redstone_input = new RedstoneInput(); items.add(redstone_input);
			cheese_pie = new CheesePie(); items.add(cheese_pie);
			laptop_mainboard = new LaptopMainboard(); items.add(laptop_mainboard);
			keyboard = new Keyboard(); items.add(keyboard);
			pc_mainboard = new PCMainboard(); items.add(pc_mainboard);
			iron_saw = new IronSaw(ToolMaterial.DIAMOND); items.add(iron_saw);
			bacon_raw = new BaconRaw(); items.add(bacon_raw);
			bacon = new Bacon(); items.add(bacon);
			chocolate_bar_white = new ChocolateBarWhite(); items.add(chocolate_bar_white);
			tomato_soup = new TomatoSoup(); items.add(tomato_soup);
			upgradekit = new UpgradeKit(); items.add(upgradekit);
			RBC = new RC(RoboType.BLUE); items.add(RBC);
			RRC = new RC(RoboType.RED); items.add(RRC);
			RGC = new RC(RoboType.GREEN); items.add(RGC);
			RYC = new RC(RoboType.YELLOW); items.add(RYC);
			RPC = new RC(RoboType.GUARD); items.add(RPC);
			tv_screen_medium = new TVScreenMedium(); items.add(tv_screen_medium);
			tiles_empty = new EmptyTiles(); items.add(tiles_empty);
			tv_controller = new TVController(); items.add(tv_controller);
			potatochips = new PotatoChipsBag(); items.add(potatochips);
			potatochips_cheese = new PotatoChipsCheese(); items.add(potatochips_cheese);
			aic_empty = new AIC_E(); items.add(aic_empty);
			aic_z1 = new AIC_Z1(); items.add(aic_z1);
			r1_chassis = new R1_Chassis(); items.add(r1_chassis);
			rctabico = new  RCTabIco(); items.add(rctabico);
			planks_oak = new OakPlanks(); items.add(planks_oak);
			tv_screen_large = new TVScreenLarge(); items.add(tv_screen_large);
			TVLI = new TVLI(); items.add(TVLI);
	}
	
	public static void registerItemRenders(Side side){
		if(side == side.SERVER){
			return;
		}
		for(Item item : items){
			if(item instanceof IItem == false){
				PrintLog.print("FRSM:ItemRegistry", "Item '" + item.toString() + "' not implementing IItem, skipping!");
				return;
			}
			ItemUtil.registerRender(item, ((IItem)item).getVariantAmount());
		}
	}
}