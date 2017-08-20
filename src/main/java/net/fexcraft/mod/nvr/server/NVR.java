package net.fexcraft.mod.nvr.server;

import net.fexcraft.mod.fsu.server.network.WebIO;
import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.perms.PermissionNode;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

@Mod(modid = NVR.MODID, name = "NVR Standalone", version="xxx.xxx", acceptableRemoteVersions = "*", serverSideOnly = true, dependencies = "required-after:fcl")
public class NVR {
	
	@Mod.Instance("fsu-server")
	public static NVR INSTANCE;
	
	public static final String MODID = "nvr";
	
	
	@Mod.EventHandler
	public static void preInit(FMLPreInitializationEvent event){
		PermManager.setEnabled(MODID);
		//
	}

	@Mod.EventHandler
	public static void init(FMLInitializationEvent event){
		PermManager.add("general.chat_message.send", PermissionNode.Type.BOOLEAN, true, true);
		//
	}
	
	@Mod.EventHandler
	public static void serverLoad(FMLServerStartingEvent event){
		//
	}
	
	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event){
		//WebIO.launch();
		//
	}
	
	@Mod.EventHandler
	public static void serverStop(FMLServerStoppingEvent event){
		//
		WebIO.end(0);
	}
	
}