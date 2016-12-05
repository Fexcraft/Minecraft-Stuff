package net.fexcraft.mod.extensions.ie;

import net.fexcraft.mod.extensions.ie.blocks.CableType4;
import net.fexcraft.mod.extensions.ie.blocks.CableType4Bridge;
import net.fexcraft.mod.extensions.ie.blocks.CableType4Copper;
import net.fexcraft.mod.extensions.ie.blocks.CableType4CopperBridge;
import net.fexcraft.mod.extensions.ie.blocks.CableType4Vertical;
import net.fexcraft.mod.extensions.ie.blocks.ElectricalFurnace;
import net.fexcraft.mod.extensions.ie.blocks.FireWorkSpawner;
import net.fexcraft.mod.extensions.ie.blocks.WaterWheel;
import net.fexcraft.mod.extensions.ie.gui.GuiHandler;
import net.fexcraft.mod.extensions.ie.render.ElectricFurnaceRenderer;
import net.fexcraft.mod.extensions.ie.render.FWSRenderer;
import net.fexcraft.mod.extensions.ie.render.RenderCT4;
import net.fexcraft.mod.extensions.ie.render.RenderCT4Bridge;
import net.fexcraft.mod.extensions.ie.render.RenderCT4Copper;
import net.fexcraft.mod.extensions.ie.render.RenderCT4CopperBridge;
import net.fexcraft.mod.extensions.ie.render.RenderCT4Vertical;
import net.fexcraft.mod.extensions.ie.render.WW1Render;
import net.fexcraft.mod.extensions.ie.tileentities.CableType4BridgeEntity;
import net.fexcraft.mod.extensions.ie.tileentities.CableType4CopperBridgeEntity;
import net.fexcraft.mod.extensions.ie.tileentities.CableType4CopperEntity;
import net.fexcraft.mod.extensions.ie.tileentities.CableType4Entity;
import net.fexcraft.mod.extensions.ie.tileentities.CableType4VerticalEntity;
import net.fexcraft.mod.extensions.ie.tileentities.ElectricalFurnaceEntity;
import net.fexcraft.mod.extensions.ie.tileentities.WaterWheelTileEntity;
import net.fexcraft.mod.extensions.ie.util.Ticker;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Static.MODID, name = Static.NAME, version = Static.VERSION, dependencies = "required-after:frsm")
public class IE {
	
	@Mod.Instance("frsm_ie")
	private static IE instance;
	
	private static IBlock ct4;
	private static IBlock ww1;
	private static IBlock fws;
	private static IBlock ef;
	private static IBlock ct4c;
	private static IBlock ct4b;
	private static IBlock ct4cb;
	private static IBlock ct4v;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		ct4 = new CableType4();
		ww1 = new WaterWheel();
		fws = new FireWorkSpawner();
		ef = new ElectricalFurnace();
		ct4c = new CableType4Copper();
		ct4b = new CableType4Bridge();
		ct4cb = new CableType4CopperBridge();
		ct4v = new CableType4Vertical();
		GameRegistry.registerTileEntity(CableType4Entity.class, ct4.getName());
		GameRegistry.registerTileEntity(WaterWheelTileEntity.class, ww1.getName());
		GameRegistry.registerTileEntity(FireWorkSpawner.FWSTE.class, fws.getName());
		GameRegistry.registerTileEntity(ElectricalFurnaceEntity.class, ef.getName());
		GameRegistry.registerTileEntity(CableType4CopperEntity.class, ct4c.getName());
		GameRegistry.registerTileEntity(CableType4BridgeEntity.class, ct4b.getName());
		GameRegistry.registerTileEntity(CableType4CopperBridgeEntity.class, ct4cb.getName());
		GameRegistry.registerTileEntity(CableType4VerticalEntity.class, ct4v.getName());
	}
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new Ticker());
		ClientRegistry.bindTileEntitySpecialRenderer(CableType4Entity.class, new RenderCT4());
		ClientRegistry.bindTileEntitySpecialRenderer(WaterWheelTileEntity.class, new WW1Render());
		ClientRegistry.bindTileEntitySpecialRenderer(FireWorkSpawner.FWSTE.class, new FWSRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(ElectricalFurnaceEntity.class, new ElectricFurnaceRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(CableType4CopperEntity.class, new RenderCT4Copper());
		ClientRegistry.bindTileEntitySpecialRenderer(CableType4BridgeEntity.class, new RenderCT4Bridge());
		ClientRegistry.bindTileEntitySpecialRenderer(CableType4CopperBridgeEntity.class, new RenderCT4CopperBridge());
		ClientRegistry.bindTileEntitySpecialRenderer(CableType4VerticalEntity.class, new RenderCT4Vertical());
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
	}
	
	@Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	
    }
	
	public static Object getInstance(){
		return instance;
	}
}