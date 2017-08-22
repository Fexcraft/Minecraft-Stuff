package net.fexcraft.mod.nvr.client;

import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.PacketHandler.PacketHandlerType;
import net.fexcraft.mod.nvr.client.gui.LocationGui;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = NVR.MODID, name = "NVR Client", version="xxx.xxx", acceptableRemoteVersions = "*", clientSideOnly = true, dependencies = "required-after:fcl")
public class NVR {
	
	public static final String MODID = "nvr-c";
	
	@Mod.EventHandler
	public static void preInit(FMLPreInitializationEvent event){
		//
	}

	@Mod.EventHandler
	public static void init(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new LocationGui());
		PacketHandler.registerListener(PacketHandlerType.NBT, Side.CLIENT, new LocationGui.LGReceiver());
	}
	
	@Mod.EventHandler
	public static void serverLoad(FMLServerStartingEvent event){
		//
	}
	
	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event){
		//
	}
	
}