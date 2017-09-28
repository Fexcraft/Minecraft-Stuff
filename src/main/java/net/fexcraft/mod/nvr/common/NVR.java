package net.fexcraft.mod.nvr.common;

import net.fexcraft.mod.nvr.common.GuiHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = NVR.MODID, name = "NVR Standalone", version="xxx.xxx", acceptableRemoteVersions = "*", dependencies = "required-after:fcl")
public class NVR {
	
	@Mod.Instance(NVR.MODID)
	public static NVR INSTANCE;
	public static final String MODID = "nvr";
	
	@Mod.EventHandler
	public static void preInit(FMLPreInitializationEvent event){
		if(event.getSide().isClient()){
			net.fexcraft.mod.nvr.client.NVR.preInit(event);
		}
		else{
			net.fexcraft.mod.nvr.server.NVR.preInit(event);
		}
	}

	@Mod.EventHandler
	public static void init(FMLInitializationEvent event){
		if(event.getSide().isClient()){
			net.fexcraft.mod.nvr.client.NVR.init(event);
		}
		else{
			net.fexcraft.mod.nvr.server.NVR.init(event);
		}
		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new GuiHandler());
	}
	
	@Mod.EventHandler
	public static void serverLoad(FMLServerStartingEvent event){
		if(event.getSide().isClient()){
			net.fexcraft.mod.nvr.client.NVR.serverLoad(event);
		}
		else{
			net.fexcraft.mod.nvr.server.NVR.serverLoad(event);
		}
	}
	
	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event){
		if(event.getSide().isClient()){
			net.fexcraft.mod.nvr.client.NVR.postInit(event);
		}
		else{
			net.fexcraft.mod.nvr.server.NVR.postInit(event);
		}
	}
	
}