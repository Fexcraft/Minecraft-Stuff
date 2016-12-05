package net.fexcraft.mod.frsm.proxy;

import net.fexcraft.mod.frsm.FRSM;
import net.fexcraft.mod.frsm.blocks.bus.BSEntity;
import net.fexcraft.mod.frsm.blocks.bus.BSRender;
import net.fexcraft.mod.frsm.blocks.bus.BSSEntity;
import net.fexcraft.mod.frsm.blocks.bus.BSSRender;
import net.fexcraft.mod.frsm.blocks.chair.OfficechairBEntity;
import net.fexcraft.mod.frsm.blocks.chair.OfficechairBRender;
import net.fexcraft.mod.frsm.blocks.chair.OfficechairEntity;
import net.fexcraft.mod.frsm.blocks.chair.OfficechairGEntity;
import net.fexcraft.mod.frsm.blocks.chair.OfficechairGRender;
import net.fexcraft.mod.frsm.blocks.chair.OfficechairRender;
import net.fexcraft.mod.frsm.blocks.chair.OfficechairWEntity;
import net.fexcraft.mod.frsm.blocks.chair.OfficechairWRender;
import net.fexcraft.mod.frsm.blocks.chairtest.OfficechairTEntity;
import net.fexcraft.mod.frsm.blocks.chairtest.OfficechairTRender;
import net.fexcraft.mod.frsm.blocks.chimney.ChimneyBrickEntity;
import net.fexcraft.mod.frsm.blocks.chimney.ChimneyBrickRender;
import net.fexcraft.mod.frsm.blocks.chimney.ChimneyEndstoneEntity;
import net.fexcraft.mod.frsm.blocks.chimney.ChimneyEndstoneRender;
import net.fexcraft.mod.frsm.blocks.chimney.ChimneyNetherbrickEntity;
import net.fexcraft.mod.frsm.blocks.chimney.ChimneyNetherbrickRender;
import net.fexcraft.mod.frsm.blocks.chimney.ChimneySandstoneEntity;
import net.fexcraft.mod.frsm.blocks.chimney.ChimneySandstoneRender;
import net.fexcraft.mod.frsm.blocks.chimney.ChimneyStonebrickEntity;
import net.fexcraft.mod.frsm.blocks.chimney.ChimneyStonebrickRender;
import net.fexcraft.mod.frsm.blocks.clock.Clock1;
import net.fexcraft.mod.frsm.blocks.clock.Clock1Render;
import net.fexcraft.mod.frsm.blocks.crate.CrateEntity;
import net.fexcraft.mod.frsm.blocks.crate.CrateRender;
import net.fexcraft.mod.frsm.blocks.cup.CupGEntity;
import net.fexcraft.mod.frsm.blocks.cup.CupGRender;
import net.fexcraft.mod.frsm.blocks.cup.Year1Entity;
import net.fexcraft.mod.frsm.blocks.cup.Year1Render;
import net.fexcraft.mod.frsm.blocks.fence.Fence1Entity;
import net.fexcraft.mod.frsm.blocks.fence.Fence1Render;
import net.fexcraft.mod.frsm.blocks.fence.Fence1bEntity;
import net.fexcraft.mod.frsm.blocks.fence.Fence1bRender;
import net.fexcraft.mod.frsm.blocks.flag.Flag0Entity;
import net.fexcraft.mod.frsm.blocks.flag.Flag0Render;
import net.fexcraft.mod.frsm.blocks.flag.Flag1Entity;
import net.fexcraft.mod.frsm.blocks.flag.Flag1Render;
import net.fexcraft.mod.frsm.blocks.flag.Flag2Entity;
import net.fexcraft.mod.frsm.blocks.flag.Flag2Render;
import net.fexcraft.mod.frsm.blocks.flag.Flag3Entity;
import net.fexcraft.mod.frsm.blocks.flag.Flag3Render;
import net.fexcraft.mod.frsm.blocks.fridge.FridgeRenderer;
import net.fexcraft.mod.frsm.blocks.fridge.FridgeTileEntity;
import net.fexcraft.mod.frsm.blocks.furnace.Furnance1Entity;
import net.fexcraft.mod.frsm.blocks.furnace.Furnance1Render;
import net.fexcraft.mod.frsm.blocks.furnace.Furnance1bEntity;
import net.fexcraft.mod.frsm.blocks.furnace.Furnance1bRender;
import net.fexcraft.mod.frsm.blocks.kd.KD1Entity;
import net.fexcraft.mod.frsm.blocks.kd.KD1Render;
import net.fexcraft.mod.frsm.blocks.kd.KD2Entity;
import net.fexcraft.mod.frsm.blocks.kd.KD2Render;
import net.fexcraft.mod.frsm.blocks.laptop.LaptopGEntity;
import net.fexcraft.mod.frsm.blocks.laptop.LaptopGRender;
import net.fexcraft.mod.frsm.blocks.model.C2Entity;
import net.fexcraft.mod.frsm.blocks.model.C2Render;
import net.fexcraft.mod.frsm.blocks.model.C5Entity;
import net.fexcraft.mod.frsm.blocks.model.C5Render;
import net.fexcraft.mod.frsm.blocks.model.Car1DEntity;
import net.fexcraft.mod.frsm.blocks.model.Car1DRender;
import net.fexcraft.mod.frsm.blocks.model.Train1DEntity;
import net.fexcraft.mod.frsm.blocks.model.Train1DRender;
import net.fexcraft.mod.frsm.blocks.palet.Palet1x1Entity;
import net.fexcraft.mod.frsm.blocks.palet.Palet1x1Render;
import net.fexcraft.mod.frsm.blocks.palet.Palet1x1_1Entity;
import net.fexcraft.mod.frsm.blocks.palet.Palet1x1_1Render;
import net.fexcraft.mod.frsm.blocks.palet.Palet1x1_2Entity;
import net.fexcraft.mod.frsm.blocks.palet.Palet1x1_2Render;
import net.fexcraft.mod.frsm.blocks.pchardware.pchardware1Entity;
import net.fexcraft.mod.frsm.blocks.pchardware.pchardware1Render;
import net.fexcraft.mod.frsm.blocks.pchardware.pchardware1bEntity;
import net.fexcraft.mod.frsm.blocks.pchardware.pchardware1bRender;
import net.fexcraft.mod.frsm.blocks.pchardware.pchardware2Entity;
import net.fexcraft.mod.frsm.blocks.pchardware.pchardware2Render;
import net.fexcraft.mod.frsm.blocks.pchardware.pchardware2bEntity;
import net.fexcraft.mod.frsm.blocks.pchardware.pchardware2bRender;
import net.fexcraft.mod.frsm.blocks.pillar.Pillar2Entity;
import net.fexcraft.mod.frsm.blocks.pillar.Pillar2Render;
import net.fexcraft.mod.frsm.blocks.pillar.Pillar3Entity;
import net.fexcraft.mod.frsm.blocks.pillar.Pillar3Render;
import net.fexcraft.mod.frsm.blocks.pillar.PillarEntity;
import net.fexcraft.mod.frsm.blocks.pillar.PillarRender;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1Entity;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1Render;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1bEntity;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1bRender;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1cEntity;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1cRender;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1dEntity;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1dRender;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1eEntity;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1eRender;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1fEntity;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1fRender;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1gEntity;
import net.fexcraft.mod.frsm.blocks.pipes.Pipe1gRender;
import net.fexcraft.mod.frsm.blocks.printer.PrinterEntity;
import net.fexcraft.mod.frsm.blocks.printer.PrinterRender;
import net.fexcraft.mod.frsm.blocks.radio.Radio1Entity;
import net.fexcraft.mod.frsm.blocks.radio.Radio1Render;
import net.fexcraft.mod.frsm.blocks.rail.RailEntity;
import net.fexcraft.mod.frsm.blocks.rail.RailRender;
import net.fexcraft.mod.frsm.blocks.rail.RailTurnEntity;
import net.fexcraft.mod.frsm.blocks.rail.RailturnRender;
import net.fexcraft.mod.frsm.blocks.rail.station.Station2Entity;
import net.fexcraft.mod.frsm.blocks.rail.station.Station2Render;
import net.fexcraft.mod.frsm.blocks.rail.station.Station3Entity;
import net.fexcraft.mod.frsm.blocks.rail.station.Station3Render;
import net.fexcraft.mod.frsm.blocks.rail.station.StationEntity;
import net.fexcraft.mod.frsm.blocks.rail.station.StationRender;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign1;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign1Render;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign2;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign2Render;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign3;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign3Render;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign4;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign4Render;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign5;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign5Render;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign6;
import net.fexcraft.mod.frsm.blocks.roadsigns.RoadSign6Render;
import net.fexcraft.mod.frsm.blocks.shelf.Shelf1Entity;
import net.fexcraft.mod.frsm.blocks.shelf.Shelf1Renderer;
import net.fexcraft.mod.frsm.blocks.stove.StoveEntity;
import net.fexcraft.mod.frsm.blocks.stove.StoveRender;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1Entity;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1Render;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1bEntity;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1bRender;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1cEntity;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1cRender;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1dEntity;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1dRender;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1eEntity;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1eRender;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1fEntity;
import net.fexcraft.mod.frsm.blocks.streetlamps.StreetLamp1fRender;
import net.fexcraft.mod.frsm.blocks.tbm.TBM2;
import net.fexcraft.mod.frsm.blocks.tbm.TBM2Render;
import net.fexcraft.mod.frsm.blocks.tbm.TBM3;
import net.fexcraft.mod.frsm.blocks.tbm.TBM3Render;
import net.fexcraft.mod.frsm.blocks.trashcan.TrashcanEntity;
import net.fexcraft.mod.frsm.blocks.trashcan.TrashcanRender;
import net.fexcraft.mod.frsm.blocks.tv.TVL;
import net.fexcraft.mod.frsm.blocks.tv.TVLRender;
import net.fexcraft.mod.frsm.blocks.tv.TVL_1;
import net.fexcraft.mod.frsm.blocks.tv.TVL_1Render;
import net.fexcraft.mod.frsm.blocks.tv.TVMEntity;
import net.fexcraft.mod.frsm.blocks.tv.TVMRender;
import net.fexcraft.mod.frsm.blocks.tv.TVS2;
import net.fexcraft.mod.frsm.blocks.tv.TVS2Render;
import net.fexcraft.mod.frsm.blocks.tv.TVSEntity;
import net.fexcraft.mod.frsm.blocks.tv.TVSRender;
import net.fexcraft.mod.frsm.blocks.vm.VMEntity;
import net.fexcraft.mod.frsm.blocks.vm.VMRender;
import net.fexcraft.mod.frsm.blocks.window.WindowEntity;
import net.fexcraft.mod.frsm.blocks.window.WindowRender;
import net.fexcraft.mod.frsm.blocks.wm.WMEntity;
import net.fexcraft.mod.frsm.blocks.wm.WMRender;
import net.fexcraft.mod.frsm.entities.R1.R1;
import net.fexcraft.mod.frsm.entities.R1.R1Render;
import net.fexcraft.mod.frsm.entities.R2.R2H;
import net.fexcraft.mod.frsm.entities.R2.R2HRender;
import net.fexcraft.mod.frsm.entities.R2.R2J;
import net.fexcraft.mod.frsm.entities.R2.R2JRender;
import net.fexcraft.mod.frsm.entities.R2.R2L;
import net.fexcraft.mod.frsm.entities.R2.R2LRender;
import net.fexcraft.mod.frsm.entities.R2.R2M;
import net.fexcraft.mod.frsm.entities.R2.R2MRender;
import net.fexcraft.mod.frsm.entities.R3.R3J;
import net.fexcraft.mod.frsm.entities.R3.R3JRender;
import net.fexcraft.mod.frsm.entities.R3.R3L;
import net.fexcraft.mod.frsm.entities.R3.R3LJ;
import net.fexcraft.mod.frsm.entities.R3.R3LJRender;
import net.fexcraft.mod.frsm.entities.R3.R3LRender;
import net.fexcraft.mod.frsm.entities.R3.R3M;
import net.fexcraft.mod.frsm.entities.R3.R3MRender;
import net.fexcraft.mod.frsm.entities.car.EntityCar1;
import net.fexcraft.mod.frsm.entities.car.RenderCar1;
import net.fexcraft.mod.frsm.entities.goat.EntityGoat;
import net.fexcraft.mod.frsm.entities.goat.RenderGoat;
import net.fexcraft.mod.frsm.util.custom.CT;
import net.fexcraft.mod.lib.api.entity.RoboType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class Client extends Common{
	
	public void reload(){
		CT.fixCT();
	}
	
	public void registerRenders(){
		RenderManager rm = Minecraft.getMinecraft().getRenderManager();
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGoat.class, new RenderGoat(rm, 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityCar1.class, new RenderCar1(rm, 0.5F));
        //
        if(FRSM.conf5){
	        RenderingRegistry.registerEntityRenderingHandler(R1.Blue.class,   new R1Render.Blue(rm));
	        RenderingRegistry.registerEntityRenderingHandler(R1.Red.class,    new R1Render.Red(rm));
	        RenderingRegistry.registerEntityRenderingHandler(R1.Green.class,  new R1Render.Green(rm));
	        RenderingRegistry.registerEntityRenderingHandler(R1.Yellow.class, new R1Render.Yellow(rm));
	        RenderingRegistry.registerEntityRenderingHandler(R1.Guard.class,  new R1Render.Guard(rm));
	        //
	        RenderingRegistry.registerEntityRenderingHandler(R2H.Blue.class,   new R2HRender(rm, RoboType.BLUE));
	        RenderingRegistry.registerEntityRenderingHandler(R2H.Red.class,    new R2HRender(rm, RoboType.RED));
	        RenderingRegistry.registerEntityRenderingHandler(R2H.Green.class,  new R2HRender(rm, RoboType.GREEN));
	        RenderingRegistry.registerEntityRenderingHandler(R2H.Yellow.class, new R2HRender(rm, RoboType.YELLOW));
	        RenderingRegistry.registerEntityRenderingHandler(R2H.Guard.class,  new R2HRender(rm, RoboType.GUARD));
	        //
	        RenderingRegistry.registerEntityRenderingHandler(R2M.Blue.class,   new R2MRender(rm, RoboType.BLUE));
	        RenderingRegistry.registerEntityRenderingHandler(R2M.Red.class,    new R2MRender(rm, RoboType.RED));
	        RenderingRegistry.registerEntityRenderingHandler(R2M.Green.class,  new R2MRender(rm, RoboType.GREEN));
	        RenderingRegistry.registerEntityRenderingHandler(R2M.Yellow.class, new R2MRender(rm, RoboType.YELLOW));
	        RenderingRegistry.registerEntityRenderingHandler(R2M.Guard.class,  new R2MRender(rm, RoboType.GUARD));
	        //
	        RenderingRegistry.registerEntityRenderingHandler(R2L.Blue.class,   new R2LRender(rm, RoboType.BLUE));
	        RenderingRegistry.registerEntityRenderingHandler(R2L.Red.class,    new R2LRender(rm, RoboType.RED));
	        RenderingRegistry.registerEntityRenderingHandler(R2L.Green.class,  new R2LRender(rm, RoboType.GREEN));
	        RenderingRegistry.registerEntityRenderingHandler(R2L.Yellow.class, new R2LRender(rm, RoboType.YELLOW));
	        RenderingRegistry.registerEntityRenderingHandler(R2L.Guard.class,  new R2LRender(rm, RoboType.GUARD));
	        //
	        RenderingRegistry.registerEntityRenderingHandler(R2J.Blue.class,   new R2JRender(rm, RoboType.BLUE));
	        RenderingRegistry.registerEntityRenderingHandler(R2J.Red.class,    new R2JRender(rm, RoboType.RED));
	        RenderingRegistry.registerEntityRenderingHandler(R2J.Green.class,  new R2JRender(rm, RoboType.GREEN));
	        RenderingRegistry.registerEntityRenderingHandler(R2J.Yellow.class, new R2JRender(rm, RoboType.YELLOW));
	        RenderingRegistry.registerEntityRenderingHandler(R2J.Guard.class,  new R2JRender(rm, RoboType.GUARD));
	        //
	        RenderingRegistry.registerEntityRenderingHandler(R3J.Blue.class,   new R3JRender(rm, RoboType.BLUE));
	        RenderingRegistry.registerEntityRenderingHandler(R3J.Red.class,    new R3JRender(rm, RoboType.RED));
	        RenderingRegistry.registerEntityRenderingHandler(R3J.Green.class,  new R3JRender(rm, RoboType.GREEN));
	        RenderingRegistry.registerEntityRenderingHandler(R3J.Yellow.class, new R3JRender(rm, RoboType.YELLOW));
	        RenderingRegistry.registerEntityRenderingHandler(R3J.Guard.class,  new R3JRender(rm, RoboType.GUARD));
	        //
	        RenderingRegistry.registerEntityRenderingHandler(R3L.Blue.class,   new R3LRender(rm, RoboType.BLUE));
	        RenderingRegistry.registerEntityRenderingHandler(R3L.Red.class,    new R3LRender(rm, RoboType.RED));
	        RenderingRegistry.registerEntityRenderingHandler(R3L.Green.class,  new R3LRender(rm, RoboType.GREEN));
	        RenderingRegistry.registerEntityRenderingHandler(R3L.Yellow.class, new R3LRender(rm, RoboType.YELLOW));
	        RenderingRegistry.registerEntityRenderingHandler(R3L.Guard.class,  new R3LRender(rm, RoboType.GUARD));
	        //
	        RenderingRegistry.registerEntityRenderingHandler(R3LJ.Blue.class,   new R3LJRender(rm, RoboType.BLUE));
	        RenderingRegistry.registerEntityRenderingHandler(R3LJ.Red.class,    new R3LJRender(rm, RoboType.RED));
	        RenderingRegistry.registerEntityRenderingHandler(R3LJ.Green.class,  new R3LJRender(rm, RoboType.GREEN));
	        RenderingRegistry.registerEntityRenderingHandler(R3LJ.Yellow.class, new R3LJRender(rm, RoboType.YELLOW));
	        RenderingRegistry.registerEntityRenderingHandler(R3LJ.Guard.class,  new R3LJRender(rm, RoboType.GUARD));
	        //
	        RenderingRegistry.registerEntityRenderingHandler(R3M.Blue.class,   new R3MRender(rm, RoboType.BLUE));
	        RenderingRegistry.registerEntityRenderingHandler(R3M.Red.class,    new R3MRender(rm, RoboType.RED));
	        RenderingRegistry.registerEntityRenderingHandler(R3M.Green.class,  new R3MRender(rm, RoboType.GREEN));
	        RenderingRegistry.registerEntityRenderingHandler(R3M.Yellow.class, new R3MRender(rm, RoboType.YELLOW));
	        RenderingRegistry.registerEntityRenderingHandler(R3M.Guard.class,  new R3MRender(rm, RoboType.GUARD));
	        //0.5F  = shadowsize
		}
            
        ClientRegistry.bindTileEntitySpecialRenderer(VMEntity.class, new VMRender());
        ClientRegistry.bindTileEntitySpecialRenderer(WMEntity.class, new WMRender());
        ClientRegistry.bindTileEntitySpecialRenderer(BSEntity.class, new BSRender());
        ClientRegistry.bindTileEntitySpecialRenderer(BSSEntity.class, new BSSRender());
        ClientRegistry.bindTileEntitySpecialRenderer(StoveEntity.class, new StoveRender());
        ClientRegistry.bindTileEntitySpecialRenderer(Car1DEntity.class, new Car1DRender());
        ClientRegistry.bindTileEntitySpecialRenderer(ChimneyBrickEntity.class, new ChimneyBrickRender());
        ClientRegistry.bindTileEntitySpecialRenderer(ChimneyStonebrickEntity.class, new ChimneyStonebrickRender());
        ClientRegistry.bindTileEntitySpecialRenderer(ChimneyNetherbrickEntity.class, new ChimneyNetherbrickRender());
        ClientRegistry.bindTileEntitySpecialRenderer(ChimneySandstoneEntity.class, new ChimneySandstoneRender());
        ClientRegistry.bindTileEntitySpecialRenderer(ChimneyEndstoneEntity.class, new ChimneyEndstoneRender());
        ClientRegistry.bindTileEntitySpecialRenderer(CrateEntity.class, new CrateRender());
        ClientRegistry.bindTileEntitySpecialRenderer(CupGEntity.class, new CupGRender());
        ClientRegistry.bindTileEntitySpecialRenderer(Fence1Entity.class, new Fence1Render());
        ClientRegistry.bindTileEntitySpecialRenderer(Fence1bEntity.class, new Fence1bRender());
        ClientRegistry.bindTileEntitySpecialRenderer(Flag0Entity.class, new Flag0Render());
        ClientRegistry.bindTileEntitySpecialRenderer(Flag1Entity.class, new Flag1Render());
        ClientRegistry.bindTileEntitySpecialRenderer(Flag2Entity.class, new Flag2Render());
        ClientRegistry.bindTileEntitySpecialRenderer(Flag3Entity.class, new Flag3Render());
        ClientRegistry.bindTileEntitySpecialRenderer(KD1Entity.class, new KD1Render());
        ClientRegistry.bindTileEntitySpecialRenderer(KD2Entity.class, new KD2Render());
        ClientRegistry.bindTileEntitySpecialRenderer(LaptopGEntity.class, new LaptopGRender());
        ClientRegistry.bindTileEntitySpecialRenderer(pchardware1Entity.class, new pchardware1Render());
        ClientRegistry.bindTileEntitySpecialRenderer(pchardware1bEntity.class, new pchardware1bRender());
        ClientRegistry.bindTileEntitySpecialRenderer(pchardware2Entity.class, new pchardware2Render());
        ClientRegistry.bindTileEntitySpecialRenderer(pchardware2bEntity.class, new pchardware2bRender());
        ClientRegistry.bindTileEntitySpecialRenderer(PillarEntity.class, new PillarRender());
        ClientRegistry.bindTileEntitySpecialRenderer(Pillar2Entity.class, new Pillar2Render());
        ClientRegistry.bindTileEntitySpecialRenderer(Pillar3Entity.class, new Pillar3Render());
        ClientRegistry.bindTileEntitySpecialRenderer(PrinterEntity.class, new PrinterRender());
        ClientRegistry.bindTileEntitySpecialRenderer(Radio1Entity.class, new Radio1Render());
        ClientRegistry.bindTileEntitySpecialRenderer(C2Entity.class, new C2Render());
        ClientRegistry.bindTileEntitySpecialRenderer(RailEntity.class, new RailRender());
        ClientRegistry.bindTileEntitySpecialRenderer(RailTurnEntity.class, new RailturnRender());
        ClientRegistry.bindTileEntitySpecialRenderer(StationEntity.class, new StationRender());
        ClientRegistry.bindTileEntitySpecialRenderer(Station2Entity.class, new Station2Render());
        ClientRegistry.bindTileEntitySpecialRenderer(Station3Entity.class, new Station3Render());
        ClientRegistry.bindTileEntitySpecialRenderer(Train1DEntity.class, new Train1DRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TrashcanEntity.class, new TrashcanRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TVMEntity.class, new TVMRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TVSEntity.class, new TVSRender());
        ClientRegistry.bindTileEntitySpecialRenderer(WindowEntity.class, new WindowRender());
        ClientRegistry.bindTileEntitySpecialRenderer(OfficechairTEntity.class, new OfficechairTRender());
        ClientRegistry.bindTileEntitySpecialRenderer(C5Entity.class, new C5Render());
        ClientRegistry.bindTileEntitySpecialRenderer(OfficechairEntity.class, new OfficechairRender());
        ClientRegistry.bindTileEntitySpecialRenderer(OfficechairBEntity.class, new OfficechairBRender());
        ClientRegistry.bindTileEntitySpecialRenderer(OfficechairGEntity.class, new OfficechairGRender());
        ClientRegistry.bindTileEntitySpecialRenderer(OfficechairWEntity.class, new OfficechairWRender());
        ClientRegistry.bindTileEntitySpecialRenderer(Palet1x1Entity.class, new Palet1x1Render());
        ClientRegistry.bindTileEntitySpecialRenderer(Palet1x1_1Entity.class, new Palet1x1_1Render());
        ClientRegistry.bindTileEntitySpecialRenderer(Palet1x1_2Entity.class, new Palet1x1_2Render());
        ClientRegistry.bindTileEntitySpecialRenderer(Furnance1Entity.class, new Furnance1Render());
        ClientRegistry.bindTileEntitySpecialRenderer(Furnance1bEntity.class, new Furnance1bRender());
        ClientRegistry.bindTileEntitySpecialRenderer(Pipe1Entity.class, new Pipe1Render());
        ClientRegistry.bindTileEntitySpecialRenderer(Pipe1bEntity.class, new Pipe1bRender());
        ClientRegistry.bindTileEntitySpecialRenderer(Pipe1cEntity.class, new Pipe1cRender());
        ClientRegistry.bindTileEntitySpecialRenderer(Pipe1dEntity.class, new Pipe1dRender());
        ClientRegistry.bindTileEntitySpecialRenderer(Pipe1eEntity.class, new Pipe1eRender());
        ClientRegistry.bindTileEntitySpecialRenderer(Pipe1fEntity.class, new Pipe1fRender());
        ClientRegistry.bindTileEntitySpecialRenderer(StreetLamp1Entity.class, new StreetLamp1Render());
        ClientRegistry.bindTileEntitySpecialRenderer(Year1Entity.class, new Year1Render());
        ClientRegistry.bindTileEntitySpecialRenderer(StreetLamp1bEntity.class, new StreetLamp1bRender());
        ClientRegistry.bindTileEntitySpecialRenderer(StreetLamp1cEntity.class, new StreetLamp1cRender());
        ClientRegistry.bindTileEntitySpecialRenderer(StreetLamp1dEntity.class, new StreetLamp1dRender());
        ClientRegistry.bindTileEntitySpecialRenderer(StreetLamp1eEntity.class, new StreetLamp1eRender());
        ClientRegistry.bindTileEntitySpecialRenderer(StreetLamp1fEntity.class, new StreetLamp1fRender());
        ClientRegistry.bindTileEntitySpecialRenderer(Pipe1gEntity.class, new Pipe1gRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TVL.TVL0.TE.class, new TVLRender());
        ClientRegistry.bindTileEntitySpecialRenderer(RoadSign1.TE.class, new RoadSign1Render());
        ClientRegistry.bindTileEntitySpecialRenderer(RoadSign2.TE.class, new RoadSign2Render());
        ClientRegistry.bindTileEntitySpecialRenderer(RoadSign3.TE.class, new RoadSign3Render());
        ClientRegistry.bindTileEntitySpecialRenderer(RoadSign4.TE.class, new RoadSign4Render());
        ClientRegistry.bindTileEntitySpecialRenderer(RoadSign5.TE.class, new RoadSign5Render());
        ClientRegistry.bindTileEntitySpecialRenderer(RoadSign6.TE.class, new RoadSign6Render());
        ClientRegistry.bindTileEntitySpecialRenderer(TVL_1.TE.class, new TVL_1Render());
        ClientRegistry.bindTileEntitySpecialRenderer(TVL.TVL00.TE.class, new TVLRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TVL.TVL000.TE.class, new TVLRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TVL.TVL0000.TE.class, new TVLRender());
        ClientRegistry.bindTileEntitySpecialRenderer(Clock1.TE.class, new Clock1Render());
        ClientRegistry.bindTileEntitySpecialRenderer(TVS2.TVS2TE.class, new TVS2Render());
        ClientRegistry.bindTileEntitySpecialRenderer(TBM2.TE.class, new TBM2Render());
        ClientRegistry.bindTileEntitySpecialRenderer(TBM3.TE.class, new TBM3Render());
        ClientRegistry.bindTileEntitySpecialRenderer(FridgeTileEntity.class, new FridgeRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(Shelf1Entity.class, new Shelf1Renderer());
	}
}