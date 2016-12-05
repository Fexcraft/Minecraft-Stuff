package net.fexcraft.mod.frsm.blocks;

import java.util.HashSet;

import net.fexcraft.mod.frsm.blocks.RCT.RCT;
import net.fexcraft.mod.frsm.blocks.asphalt.Asphalt;
import net.fexcraft.mod.frsm.blocks.asphalt.Asphalt2;
import net.fexcraft.mod.frsm.blocks.asphalt.Asphalt2Slab;
import net.fexcraft.mod.frsm.blocks.asphalt.AsphaltFull;
import net.fexcraft.mod.frsm.blocks.asphalt.AsphaltSlab;
import net.fexcraft.mod.frsm.blocks.barrel.IronBarrel;
import net.fexcraft.mod.frsm.blocks.bus.BS;
import net.fexcraft.mod.frsm.blocks.bus.BSS;
import net.fexcraft.mod.frsm.blocks.chair.Officechair;
import net.fexcraft.mod.frsm.blocks.chair.OfficechairB;
import net.fexcraft.mod.frsm.blocks.chair.OfficechairG;
import net.fexcraft.mod.frsm.blocks.chair.OfficechairW;
import net.fexcraft.mod.frsm.blocks.chairtest.OfficechairT;
import net.fexcraft.mod.frsm.blocks.chimney.ChimneyBrick;
import net.fexcraft.mod.frsm.blocks.chimney.ChimneyEndstone;
import net.fexcraft.mod.frsm.blocks.chimney.ChimneyNetherbrick;
import net.fexcraft.mod.frsm.blocks.chimney.ChimneySandstone;
import net.fexcraft.mod.frsm.blocks.chimney.ChimneyStonebrick;
import net.fexcraft.mod.frsm.blocks.clock.Clock1;
import net.fexcraft.mod.frsm.blocks.common.Bench1;
import net.fexcraft.mod.frsm.blocks.common.Cobble;
import net.fexcraft.mod.frsm.blocks.common.DecoBlock1;
import net.fexcraft.mod.frsm.blocks.common.DecoBlock2;
import net.fexcraft.mod.frsm.blocks.common.FramedGlowstone;
import net.fexcraft.mod.frsm.blocks.common.Placeholder;
import net.fexcraft.mod.frsm.blocks.common.Status;
import net.fexcraft.mod.frsm.blocks.common.StoneLightBox;
import net.fexcraft.mod.frsm.blocks.common.StoneSlabPillar;
import net.fexcraft.mod.frsm.blocks.common.TestDoor;
import net.fexcraft.mod.frsm.blocks.common.TreePot;
import net.fexcraft.mod.frsm.blocks.common.WoodenLightBox;
import net.fexcraft.mod.frsm.blocks.crate.Crate;
import net.fexcraft.mod.frsm.blocks.cup.CupG;
import net.fexcraft.mod.frsm.blocks.cup.Year1;
import net.fexcraft.mod.frsm.blocks.fence.Fence1;
import net.fexcraft.mod.frsm.blocks.fence.Fence1b;
import net.fexcraft.mod.frsm.blocks.flag.Flag0;
import net.fexcraft.mod.frsm.blocks.flag.Flag1;
import net.fexcraft.mod.frsm.blocks.flag.Flag2;
import net.fexcraft.mod.frsm.blocks.flag.Flag3;
import net.fexcraft.mod.frsm.blocks.fridge.Fridge;
import net.fexcraft.mod.frsm.blocks.furnace.Furnance1;
import net.fexcraft.mod.frsm.blocks.furnace.Furnance1b;
import net.fexcraft.mod.frsm.blocks.kd.KD1;
import net.fexcraft.mod.frsm.blocks.kd.KD2;
import net.fexcraft.mod.frsm.blocks.lamp.Lamp;
import net.fexcraft.mod.frsm.blocks.lamp.LampOff;
import net.fexcraft.mod.frsm.blocks.laptop.Laptop;
import net.fexcraft.mod.frsm.blocks.laptop.LaptopBlack;
import net.fexcraft.mod.frsm.blocks.laptop.LaptopBlue;
import net.fexcraft.mod.frsm.blocks.laptop.LaptopG;
import net.fexcraft.mod.frsm.blocks.laptop.LaptopGreen;
import net.fexcraft.mod.frsm.blocks.laptop.LaptopRed;
import net.fexcraft.mod.frsm.blocks.laptop.LaptopWhite;
import net.fexcraft.mod.frsm.blocks.model.C2;
import net.fexcraft.mod.frsm.blocks.model.C5;
import net.fexcraft.mod.frsm.blocks.model.Car1D;
import net.fexcraft.mod.frsm.blocks.model.Train1D;
import net.fexcraft.mod.frsm.blocks.palet.Palet1x1;
import net.fexcraft.mod.frsm.blocks.palet.Palet1x1_1;
import net.fexcraft.mod.frsm.blocks.palet.Palet1x1_2;
import net.fexcraft.mod.frsm.blocks.pchardware.pchardware1;
import net.fexcraft.mod.frsm.blocks.pchardware.pchardware1b;
import net.fexcraft.mod.frsm.blocks.pchardware.pchardware2;
import net.fexcraft.mod.frsm.blocks.pchardware.pchardware2b;
import net.fexcraft.mod.frsm.blocks.pillar.Pillar;
import net.fexcraft.mod.frsm.blocks.pillar.Pillar2;
import net.fexcraft.mod.frsm.blocks.pillar.Pillar3;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1b;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1c;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1d;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1e;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1f;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1g;
import net.fexcraft.mod.frsm.blocks.plants.TomatoPlant;
import net.fexcraft.mod.frsm.blocks.printer.Printer;
import net.fexcraft.mod.frsm.blocks.radio.Radio1;
import net.fexcraft.mod.frsm.blocks.radio.Radio2;
import net.fexcraft.mod.frsm.blocks.rail.Rail;
import net.fexcraft.mod.frsm.blocks.rail.RailTurn;
import net.fexcraft.mod.frsm.blocks.rail.station.Station;
import net.fexcraft.mod.frsm.blocks.rail.station.Station2;
import net.fexcraft.mod.frsm.blocks.rail.station.Station3;
import net.fexcraft.mod.frsm.blocks.redstone.RedstonePillar;
import net.fexcraft.mod.frsm.blocks.redstone.RedstonePillar2;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign1;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign2;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign3;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign4;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign5;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign6;
import net.fexcraft.mod.frsm.blocks.shelf.Shelf1;
import net.fexcraft.mod.frsm.blocks.stove.Stove;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1b;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1c;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1d;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1e;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1f;
import net.fexcraft.mod.frsm.blocks.tbm.TBM;
import net.fexcraft.mod.frsm.blocks.tbm.TBM2;
import net.fexcraft.mod.frsm.blocks.tbm.TBM3;
import net.fexcraft.mod.frsm.blocks.tiles.Tiles;
import net.fexcraft.mod.frsm.blocks.tiles.Tiles2;
import net.fexcraft.mod.frsm.blocks.tiles.Tiles3;
import net.fexcraft.mod.frsm.blocks.tiles.Tiles4;
import net.fexcraft.mod.frsm.blocks.toaster.Toaster;
import net.fexcraft.mod.frsm.blocks.trashcan.Trashcan;
import net.fexcraft.mod.frsm.blocks.tv.TVL;
import net.fexcraft.mod.frsm.blocks.tv.TVL_1;
import net.fexcraft.mod.frsm.blocks.tv.TVM;
import net.fexcraft.mod.frsm.blocks.tv.TVS;
import net.fexcraft.mod.frsm.blocks.tv.TVS2;
import net.fexcraft.mod.frsm.blocks.vm.VM;
import net.fexcraft.mod.frsm.blocks.window.Window;
import net.fexcraft.mod.frsm.blocks.wm.WM;
import net.fexcraft.mod.frsm.util.PrintLog;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;

public final class FRSM_Blocks {

    public static Block wooden_light_box;
    public static Block stone_light_box;
    public static Block decoblock1;
    public static Block decoblock2;
    public static Block framed_glowstone;
    public static Block stoneslab_pillar;
    public static Block tomato_plant;
    public static Block tbm;
    public static Block crate;
    public static Block tvs;
    public static Block KD1;
    //public static Block wb;
    public static Block laptop;
    public static Block pchardware2;
    public static Block pchardware1;
    public static Block laptop_white;
    public static Block printer;
    public static Block laptop_green;
    public static Block wm;
    public static Block toaster;
    public static Block stove;
    public static Block rail;
    public static Block railturn;
    public static Block Train1D;
    public static Block Car1D;
    public static Block laptop_red;
    public static Block laptop_blue;
    public static Block pchardware2b;
    public static Block pchardware1b;
    public static Block laptop_black;
    public static Block TVM;
    public static Block KD2;
    public static Block tiles;
    public static Block tiles2;
    public static Block tiles3;
    public static Block tiles4;
    public static Block busstop;
    public static Block busstation;
    public static Block trashcan;
    public static Block VM;
    public static Block station;
    public static Block station2;
    public static Block station3;
    public static Block testdoor;
    public static Block Radio1;
    public static Block cup_gold;
    public static Block laptop_gold;
    public static Block window;
    public static Block pillar;
    public static Block glassslab;
    public static Block pillar2;
    public static Block pillar3;
    public static Block asphalt;
    public static Block officechair;
    public static Block officechair_black;
    public static Block officechair_gray;
    public static Block officechair_white;
    public static Block officechair_test;
    public static Block lamp;
    public static Block fence1;
    public static Block fence1b;
    public static Block flag0;
    public static Block flag1;
    public static Block flag2;
    public static Block chimney;
    public static Block flag3;
    public static Block lamp_off;
    public static Block placeholder;
    public static Block rct;
    public static Block status;
    public static Block asphalt2;
    public static Block redstone_pillar;
    public static Block redstone_pillar2;
    public static Block C2;
    public static Block chimney1;
    public static Block chimney2;
    public static Block chimney3;
    public static Block chimney4;
    public static Block asphalt_slab;
    public static Block asphalt2_slab;
    public static Block asphalt_full;
    public static Block C5;
    public static Block cobble1;
    public static Block palet1x1;
    public static Block palet1x1_1;
    public static Block palet1x1_2;
    public static Block furnace1;
    public static Block furnace1b;
    public static Block pipe1;
    public static Block pipe1b;
    public static Block pipe1c;
    public static Block pipe1d;
    public static Block pipe1e;
    public static Block pipe1f;
    public static Block sign1;
    public static Block streetlamp1;
    public static Block streetlamp1b;
    public static Block streetlamp1c;
    public static Block streetlamp1d;
    public static Block streetlamp1e;
    public static Block streetlamp1f;
    public static Block pipe1g;
    public static Block tree_pot;
    public static Block TVL;
    public static Block roadsign1;
    public static Block roadsign2;
    public static Block roadsign3;
    public static Block roadsign4;
    public static Block roadsign5;
    public static Block roadsign6;
    public static Block TVL_1;
    public static Block TVL0;
    public static Block TVL00;
    public static Block TVL000;
    public static Block bench1;
    public static Block bench1_1;
    public static Block bench1_2;
    public static Block bench1_3;
    public static Block clock1;
    public static Block TVS2;
    public static Block TBM2;
    public static Block TBM3;
    public static Block year1;
	public static Block cobble2;
    public static Block cobble3;
    public static Block cobble4;
    public static Block cobble5;
    public static Block cobble5b;
    public static Block cobble6;
    public static Block cobble6b;
    public static Block cobble7;
    public static Block cobble7b;
    public static Block cobble8;
    public static Block cobble8b;
    public static Block cobble9;
    public static Block cobble9b;
    public static Block cobble10;
    public static Block cobble10b;
    public static Block fridge;
    public static Block shelf1;
    public static Block radio2;
    public static Block iron_barrel;
    
    public static HashSet<Block> blocks;
    
    public static void register(){
    	blocks = new HashSet<Block>();
    	
    	//wb = new WB();
    	wooden_light_box = new WoodenLightBox(); blocks.add(wooden_light_box);
	    stone_light_box = new StoneLightBox(); blocks.add(stone_light_box);
	    decoblock1 = new DecoBlock1(); blocks.add(decoblock1);
	    decoblock2 = new DecoBlock2(); blocks.add(decoblock2);
	    framed_glowstone = new FramedGlowstone(); blocks.add(framed_glowstone);
	    stoneslab_pillar = new StoneSlabPillar(); blocks.add(stoneslab_pillar);
	    tomato_plant = new TomatoPlant(); blocks.add(tomato_plant);
	    tbm = new TBM(); blocks.add(tbm);
	    TBM2 = new TBM2(); blocks.add(TBM2);
	    TBM3 = new TBM3(); blocks.add(TBM3);
	    crate = new Crate(); blocks.add(crate);
	    tvs = new TVS(); blocks.add(tvs);
	    TVS2 = new TVS2(); blocks.add(TVS2);
	    KD1 = new KD1(); blocks.add(KD1);
	    KD2 = new KD2(); blocks.add(KD2);
	    laptop = new Laptop(); blocks.add(laptop);
	    laptop_black = new LaptopBlack(); blocks.add(laptop_black);
	    laptop_blue = new LaptopBlue(); blocks.add(laptop_blue);
	    laptop_gold = new LaptopG(); blocks.add(laptop_gold);
	    laptop_green = new LaptopGreen(); blocks.add(laptop_green);
	    laptop_red = new LaptopRed(); blocks.add(laptop_red);
	    laptop_white = new LaptopWhite(); blocks.add(laptop_white);
	    printer = new Printer(); blocks.add(printer);
	    wm = new WM(); blocks.add(wm);
	    pchardware1 = new pchardware1(); blocks.add(pchardware1);
	    pchardware1b = new pchardware1b(); blocks.add(pchardware1b);
	    pchardware2 = new pchardware2(); blocks.add(pchardware2);
	    pchardware2b = new pchardware2b(); blocks.add(pchardware2b);
	    toaster = new Toaster(); blocks.add(toaster);
	    stove = new Stove(); blocks.add(stove);
	    rail = new Rail(); blocks.add(rail);
	    railturn = new RailTurn(); blocks.add(railturn);
	    station = new Station(); blocks.add(station);
	    station2 = new Station2(); blocks.add(station2);
	    station3 = new Station3(); blocks.add(station3);
	    testdoor = new TestDoor(); blocks.add(testdoor);
	    Train1D = new Train1D(); blocks.add(Train1D); 
	    Car1D = new Car1D(); blocks.add(Car1D);
	    C2 = new C2(); blocks.add(C2);
	    C5 = new C5(); blocks.add(C5);
	    TVM = new TVM(); blocks.add(TVM);
	    tiles = new Tiles(); blocks.add(tiles);
	    tiles2 = new Tiles2(); blocks.add(tiles2);
	    tiles3 = new Tiles3(); blocks.add(tiles3);
	    tiles4 = new Tiles4(); blocks.add(tiles4);
	    busstation = new BS(); blocks.add(busstation);
	    busstop = new BSS(); blocks.add(busstop);
	    trashcan = new Trashcan(); blocks.add(trashcan);
	    VM = new VM(); blocks.add(VM);
	    Radio1 = new Radio1(); blocks.add(Radio1);
	    cup_gold = new CupG(); blocks.add(cup_gold);
	    year1 = new Year1(); blocks.add(year1);
	    window = new Window(); blocks.add(window);
	    pillar = new Pillar(); blocks.add(pillar);
	    pillar2 = new Pillar2(); blocks.add(pillar2);
	    pillar3 = new Pillar3(); blocks.add(pillar3);
	    asphalt = new Asphalt(); blocks.add(asphalt);
	    asphalt2 = new Asphalt2(); blocks.add(asphalt2);
	    asphalt_full = new AsphaltFull(); blocks.add(asphalt_full);
	    asphalt_slab = new AsphaltSlab(); blocks.add(asphalt_slab);
	    asphalt2_slab = new Asphalt2Slab(); blocks.add(asphalt2_slab);
	    officechair = new Officechair(); blocks.add(officechair);
	    officechair_black = new OfficechairB(); blocks.add(officechair_black);
	    officechair_white = new OfficechairW(); blocks.add(officechair_white);
	    officechair_gray = new OfficechairG(); blocks.add(officechair_gray);
	    officechair_test = new OfficechairT(); blocks.add(officechair_test);
	    lamp = new Lamp(); blocks.add(lamp);
	    lamp_off = new LampOff(); blocks.add(lamp_off);
	    fence1 = new Fence1(); blocks.add(fence1);
	    fence1b = new Fence1b(); blocks.add(fence1b);
	    flag0 = new Flag0(); blocks.add(flag0);
	    flag1 = new Flag1(); blocks.add(flag1);
	    flag2 = new Flag2(); blocks.add(flag2);
	    flag3 = new Flag3(); blocks.add(flag3);
	    chimney = new ChimneyBrick(); blocks.add(chimney);
	    chimney1 = new ChimneyStonebrick(); blocks.add(chimney1);
	    chimney2 = new ChimneyNetherbrick(); blocks.add(chimney2);
	    chimney3 = new ChimneySandstone(); blocks.add(chimney3);
	    chimney4 = new ChimneyEndstone(); blocks.add(chimney4);
	    placeholder = new Placeholder(); blocks.add(placeholder);
	    rct = new RCT(); blocks.add(rct);
	    status = new Status(); blocks.add(status);
	    redstone_pillar = new RedstonePillar(); blocks.add(redstone_pillar);
	    redstone_pillar2 = new RedstonePillar2(); blocks.add(redstone_pillar2);
	    cobble1 = new Cobble("1"); blocks.add(cobble1);
	    cobble2 = new Cobble("2"); blocks.add(cobble2);
	    cobble3 = new Cobble("3"); blocks.add(cobble3);
	    cobble4 = new Cobble("4"); blocks.add(cobble4);
	    cobble5 = new Cobble("5"); blocks.add(cobble5);
	    cobble5b = new Cobble("5b"); blocks.add(cobble5b);
	    cobble6 = new Cobble("6"); blocks.add(cobble6);
	    cobble6b = new Cobble("6b"); blocks.add(cobble6b);
	    cobble7 = new Cobble("7"); blocks.add(cobble7);
	    cobble7b = new Cobble("7b"); blocks.add(cobble7b);
	    cobble8 = new Cobble("8"); blocks.add(cobble8);
	    cobble8b = new Cobble("8b"); blocks.add(cobble8b);
	    cobble9 = new Cobble("9"); blocks.add(cobble9);
	    cobble9b = new Cobble("9b"); blocks.add(cobble9b);
	    cobble10 = new Cobble("10"); blocks.add(cobble10);
	    cobble10b = new Cobble("10b"); blocks.add(cobble10b);
	    palet1x1 = new Palet1x1(); blocks.add(palet1x1);
	    palet1x1_1 = new Palet1x1_1(); blocks.add(palet1x1_1);
	    palet1x1_2 = new Palet1x1_2(); blocks.add(palet1x1_2);
	    furnace1 = new Furnance1(); blocks.add(furnace1);
	    furnace1b = new Furnance1b(); blocks.add(furnace1b);
	    pipe1 = new Pipe1(); blocks.add(pipe1);
	    pipe1b = new Pipe1b(); blocks.add(pipe1b);
	    pipe1c = new Pipe1c(); blocks.add(pipe1c);
	    pipe1d = new Pipe1d(); blocks.add(pipe1d);
	    pipe1e = new Pipe1e(); blocks.add(pipe1e);
	    pipe1f = new Pipe1f(); blocks.add(pipe1f);
	    pipe1g = new Pipe1g(); blocks.add(pipe1g);
	    streetlamp1 = new StreetLamp1(); blocks.add(streetlamp1);
	    streetlamp1b = new StreetLamp1b(); blocks.add(streetlamp1b);
	    streetlamp1c = new StreetLamp1c(); blocks.add(streetlamp1c);
	    streetlamp1d = new StreetLamp1d(); blocks.add(streetlamp1d);
	    streetlamp1e = new StreetLamp1e(); blocks.add(streetlamp1e);
	    streetlamp1f = new StreetLamp1f(); blocks.add(streetlamp1f);
	    tree_pot = new TreePot(); blocks.add(tree_pot);
	    TVL = new TVL.TVL0(); blocks.add(TVL);
	    TVL0 = new TVL.TVL00(); blocks.add(TVL0);
	    TVL00 = new TVL.TVL000(); blocks.add(TVL00);
	    TVL000 = new TVL.TVL0000(); blocks.add(TVL000);
	    TVL_1 = new TVL_1(); blocks.add(TVL_1);
	    roadsign1 = new RoadSign1(); blocks.add(roadsign1);
	    roadsign2 = new RoadSign2(); blocks.add(roadsign2);
	    roadsign3 = new RoadSign3(); blocks.add(roadsign3);
	    roadsign4 = new RoadSign4(); blocks.add(roadsign4);
	    roadsign5 = new RoadSign5(); blocks.add(roadsign5);
	    roadsign6 = new RoadSign6(); blocks.add(roadsign6);
	    bench1 = new Bench1("Bench1"); blocks.add(bench1);
	    bench1_1 = new Bench1("Bench1_1"); blocks.add(bench1_1);
	    bench1_2 = new Bench1("Bench1_2"); blocks.add(bench1_2);
	    bench1_3 = new Bench1("Bench1_3"); blocks.add(bench1_3);
	   	clock1 = new Clock1(); blocks.add(clock1);
	    fridge = new Fridge(); blocks.add(fridge);
	   	shelf1 = new Shelf1(); blocks.add(shelf1);
	   	radio2 = new Radio2(); blocks.add(radio2);
	   	iron_barrel = new IronBarrel(); blocks.add(iron_barrel);
	}

	public static void registerItemRenders(Side s) {
		if(s == Side.SERVER){
			return;
		}
		for(Block block : blocks){
			Item item = Item.getItemFromBlock(block);
			if(item instanceof IItem == false){
				PrintLog.print("FRSM:ItemRegistry", "Item '" + item.toString() + "' not implementing IItem, skipping!");
				return;
			}
			ItemUtil.registerRender(item, ((IItem)item).getVariantAmount());
		}
	}
} 
