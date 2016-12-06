package net.fexcraft.mod.frsm.blocks;

import net.fexcraft.mod.frsm.blocks.RCT.RCTEntity;
import net.fexcraft.mod.frsm.blocks.bus.BSEntity;
import net.fexcraft.mod.frsm.blocks.bus.BSSEntity;
import net.fexcraft.mod.frsm.blocks.chair.OfficechairBEntity;
import net.fexcraft.mod.frsm.blocks.chair.OfficechairEntity;
import net.fexcraft.mod.frsm.blocks.chair.OfficechairGEntity;
import net.fexcraft.mod.frsm.blocks.chair.OfficechairWEntity;
import net.fexcraft.mod.frsm.blocks.chairtest.OfficechairTEntity;
import net.fexcraft.mod.frsm.blocks.chimney.ChimneyBrickEntity;
import net.fexcraft.mod.frsm.blocks.chimney.ChimneyEndstoneEntity;
import net.fexcraft.mod.frsm.blocks.chimney.ChimneyNetherbrickEntity;
import net.fexcraft.mod.frsm.blocks.chimney.ChimneySandstoneEntity;
import net.fexcraft.mod.frsm.blocks.chimney.ChimneyStonebrickEntity;
import net.fexcraft.mod.frsm.blocks.clock.Clock1;
import net.fexcraft.mod.frsm.blocks.crate.CrateEntity;
import net.fexcraft.mod.frsm.blocks.cup.CupGEntity;
import net.fexcraft.mod.frsm.blocks.cup.Year1Entity;
import net.fexcraft.mod.frsm.blocks.fence.Fence1Entity;
import net.fexcraft.mod.frsm.blocks.fence.Fence1bEntity;
import net.fexcraft.mod.frsm.blocks.flag.Flag0Entity;
import net.fexcraft.mod.frsm.blocks.flag.Flag1Entity;
import net.fexcraft.mod.frsm.blocks.flag.Flag2Entity;
import net.fexcraft.mod.frsm.blocks.flag.Flag3Entity;
import net.fexcraft.mod.frsm.blocks.fridge.FridgeTileEntity;
import net.fexcraft.mod.frsm.blocks.furnace.Furnance1Entity;
import net.fexcraft.mod.frsm.blocks.furnace.Furnance1bEntity;
import net.fexcraft.mod.frsm.blocks.kd.KD1Entity;
import net.fexcraft.mod.frsm.blocks.kd.KD2Entity;
import net.fexcraft.mod.frsm.blocks.laptop.LaptopGEntity;
import net.fexcraft.mod.frsm.blocks.model.C2Entity;
import net.fexcraft.mod.frsm.blocks.model.C5Entity;
import net.fexcraft.mod.frsm.blocks.model.Car1DEntity;
import net.fexcraft.mod.frsm.blocks.model.Train1DEntity;
import net.fexcraft.mod.frsm.blocks.palet.Palet1x1Entity;
import net.fexcraft.mod.frsm.blocks.palet.Palet1x1_1Entity;
import net.fexcraft.mod.frsm.blocks.palet.Palet1x1_2Entity;
import net.fexcraft.mod.frsm.blocks.pchardware.pchardware1Entity;
import net.fexcraft.mod.frsm.blocks.pchardware.pchardware1bEntity;
import net.fexcraft.mod.frsm.blocks.pchardware.pchardware2Entity;
import net.fexcraft.mod.frsm.blocks.pchardware.pchardware2bEntity;
import net.fexcraft.mod.frsm.blocks.pillar.Pillar2Entity;
import net.fexcraft.mod.frsm.blocks.pillar.Pillar3Entity;
import net.fexcraft.mod.frsm.blocks.pillar.PillarEntity;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1Entity;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1bEntity;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1cEntity;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1dEntity;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1eEntity;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1fEntity;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1gEntity;
import net.fexcraft.mod.frsm.blocks.printer.PrinterEntity;
import net.fexcraft.mod.frsm.blocks.radio.Radio1Entity;
import net.fexcraft.mod.frsm.blocks.rail.RailEntity;
import net.fexcraft.mod.frsm.blocks.rail.RailTurnEntity;
import net.fexcraft.mod.frsm.blocks.rail.station.Station2Entity;
import net.fexcraft.mod.frsm.blocks.rail.station.Station3Entity;
import net.fexcraft.mod.frsm.blocks.rail.station.StationEntity;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign1;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign2;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign3;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign4;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign5;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign6;
import net.fexcraft.mod.frsm.blocks.shelf.Shelf1Entity;
import net.fexcraft.mod.frsm.blocks.stove.StoveEntity;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1Entity;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1bEntity;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1cEntity;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1dEntity;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1eEntity;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1fEntity;
import net.fexcraft.mod.frsm.blocks.tbm.TBM2;
import net.fexcraft.mod.frsm.blocks.tbm.TBM3;
import net.fexcraft.mod.frsm.blocks.trashcan.TrashcanEntity;
import net.fexcraft.mod.frsm.blocks.tv.TVL;
import net.fexcraft.mod.frsm.blocks.tv.TVL_1;
import net.fexcraft.mod.frsm.blocks.tv.TVMEntity;
import net.fexcraft.mod.frsm.blocks.tv.TVS2;
import net.fexcraft.mod.frsm.blocks.tv.TVSEntity;
import net.fexcraft.mod.frsm.blocks.vm.VMEntity;
import net.fexcraft.mod.frsm.blocks.window.WindowEntity;
import net.fexcraft.mod.frsm.blocks.wm.WMEntity;
import net.fexcraft.mod.frsm.util.block.ETE;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class TileEntities{
	
	public static void register(){
        //GameRegistry.registerTileEntity(WBEntity.class, "WB");
	    //if(!FRSM.librarymode){
	        GameRegistry.registerTileEntity(RCTEntity.class, "RCT");
	        GameRegistry.registerTileEntity(VMEntity.class, "VM");
	        GameRegistry.registerTileEntity(WMEntity.class, "WM");
	        GameRegistry.registerTileEntity(BSEntity.class, "BS");
	        GameRegistry.registerTileEntity(BSSEntity.class, "BSS");
	        GameRegistry.registerTileEntity(ETE.class, "ExampleTileEntity");
	        GameRegistry.registerTileEntity(StoveEntity.class, "Stove1");
	        GameRegistry.registerTileEntity(Car1DEntity.class, "Car1D");
	        GameRegistry.registerTileEntity(ChimneyBrickEntity.class, "Chimney");
	        GameRegistry.registerTileEntity(ChimneyStonebrickEntity.class, "Chimney1");
	        GameRegistry.registerTileEntity(ChimneyNetherbrickEntity.class, "Chimney2");
	        GameRegistry.registerTileEntity(ChimneySandstoneEntity.class, "Chimney3");
	        GameRegistry.registerTileEntity(ChimneyEndstoneEntity.class, "Chimney4");
	        GameRegistry.registerTileEntity(CrateEntity.class, "Crate");
	        GameRegistry.registerTileEntity(CupGEntity.class, "cupG");
	        GameRegistry.registerTileEntity(Fence1Entity.class, "fence1");
	        GameRegistry.registerTileEntity(Fence1bEntity.class, "fence1b");
	        GameRegistry.registerTileEntity(Flag0Entity.class, "Flag0");
	        GameRegistry.registerTileEntity(Flag1Entity.class, "Flag1");
	        GameRegistry.registerTileEntity(Flag2Entity.class, "Flag2");
	        GameRegistry.registerTileEntity(Flag3Entity.class, "Flag3");
	        GameRegistry.registerTileEntity(KD1Entity.class, "KD1");
	        GameRegistry.registerTileEntity(KD2Entity.class, "KD2");
	        GameRegistry.registerTileEntity(LaptopGEntity.class, "LaptopG");
	        GameRegistry.registerTileEntity(pchardware1Entity.class, "PCHW1");
	        GameRegistry.registerTileEntity(pchardware1bEntity.class, "PCHW1b");
	        GameRegistry.registerTileEntity(pchardware2Entity.class, "PCHW2");
	        GameRegistry.registerTileEntity(pchardware2bEntity.class, "PCHW2b");
	        GameRegistry.registerTileEntity(PillarEntity.class, "Pillar");
	        GameRegistry.registerTileEntity(Pillar2Entity.class, "Pillar2");
	        GameRegistry.registerTileEntity(Pillar3Entity.class, "Pillar3");
	        GameRegistry.registerTileEntity(PrinterEntity.class, "Printer");
	        GameRegistry.registerTileEntity(Radio1Entity.class, "Radio1");
	        GameRegistry.registerTileEntity(C2Entity.class, "C2Test");
	        GameRegistry.registerTileEntity(RailEntity.class, "rail");
	        GameRegistry.registerTileEntity(RailTurnEntity.class, "railturn");
	        GameRegistry.registerTileEntity(StationEntity.class, "station");
	        GameRegistry.registerTileEntity(Station2Entity.class, "station2");
	        GameRegistry.registerTileEntity(Station3Entity.class, "station3");
	        GameRegistry.registerTileEntity(Train1DEntity.class, "Train1D");
	        GameRegistry.registerTileEntity(TrashcanEntity.class, "trashcan");
	        GameRegistry.registerTileEntity(TVMEntity.class, "TVM");
	        GameRegistry.registerTileEntity(TVSEntity.class, "TVS");
	        GameRegistry.registerTileEntity(WindowEntity.class, "window");
	        GameRegistry.registerTileEntity(OfficechairTEntity.class, "OfficeChairT");
	        GameRegistry.registerTileEntity(C5Entity.class, "C5Test");
	        GameRegistry.registerTileEntity(OfficechairEntity.class, "OfficeChair");
	        GameRegistry.registerTileEntity(OfficechairBEntity.class, "OfficeChairBlack");
	        GameRegistry.registerTileEntity(OfficechairGEntity.class, "OfficeChairGray");
	        GameRegistry.registerTileEntity(OfficechairWEntity.class, "OfficeChairWhite");
	        GameRegistry.registerTileEntity(Palet1x1Entity.class, "Palet1x1");
	        GameRegistry.registerTileEntity(Palet1x1_1Entity.class, "Palet1x1_1");
	        GameRegistry.registerTileEntity(Palet1x1_2Entity.class, "Palet1x1_2");
	        GameRegistry.registerTileEntity(Furnance1Entity.class, "Furnance1");
	        GameRegistry.registerTileEntity(Furnance1bEntity.class, "Furnance1b");
	        GameRegistry.registerTileEntity(Pipe1Entity.class, "Pipe1");
	        GameRegistry.registerTileEntity(Pipe1bEntity.class, "Pipe1b");
	        GameRegistry.registerTileEntity(Pipe1cEntity.class, "Pipe1c");
	        GameRegistry.registerTileEntity(Pipe1dEntity.class, "Pipe1d");
	        GameRegistry.registerTileEntity(Pipe1eEntity.class, "Pipe1e");
	        GameRegistry.registerTileEntity(Pipe1fEntity.class, "Pipe1f");
	        GameRegistry.registerTileEntity(StreetLamp1Entity.class, "StreetLamp1");
	        GameRegistry.registerTileEntity(Year1Entity.class, "year1");
	        GameRegistry.registerTileEntity(StreetLamp1bEntity.class, "StreetLamp1b");
	        GameRegistry.registerTileEntity(StreetLamp1cEntity.class, "StreetLamp1c");
	        GameRegistry.registerTileEntity(StreetLamp1dEntity.class, "StreetLamp1d");
	        GameRegistry.registerTileEntity(StreetLamp1eEntity.class, "StreetLamp1e");
	        GameRegistry.registerTileEntity(StreetLamp1fEntity.class, "StreetLamp1f");
	        GameRegistry.registerTileEntity(Pipe1gEntity.class, "Pipe1g");
	        GameRegistry.registerTileEntity(TVL.TVL0.TE.class, "TVL");
	        GameRegistry.registerTileEntity(RoadSign1.TE.class, "RoadSign1");
	        GameRegistry.registerTileEntity(RoadSign2.TE.class, "RoadSign2");
	        GameRegistry.registerTileEntity(RoadSign3.TE.class, "RoadSign3");
	        GameRegistry.registerTileEntity(RoadSign4.TE.class, "RoadSign4");
	        GameRegistry.registerTileEntity(RoadSign5.TE.class, "RoadSign5");
	        GameRegistry.registerTileEntity(RoadSign6.TE.class, "RoadSign6");
	        GameRegistry.registerTileEntity(TVL_1.TE.class, "TVL_1");
	        GameRegistry.registerTileEntity(TVL.TVL00.TE.class, "TVL0");
	        GameRegistry.registerTileEntity(TVL.TVL000.TE.class, "TVL00");
	        GameRegistry.registerTileEntity(TVL.TVL0000.TE.class, "TVL000");
	        GameRegistry.registerTileEntity(Clock1.TE.class, "Clock1");
	        GameRegistry.registerTileEntity(TVS2.TVS2TE.class, "TVS2");
	        GameRegistry.registerTileEntity(TBM2.TE.class, "TBM2");
	        GameRegistry.registerTileEntity(TBM3.TE.class, "TBM3");
	        GameRegistry.registerTileEntity(FridgeTileEntity.class, "frsm:fridge");
	        GameRegistry.registerTileEntity(Shelf1Entity.class, "frsm:shelf1");
        //}
	}
}