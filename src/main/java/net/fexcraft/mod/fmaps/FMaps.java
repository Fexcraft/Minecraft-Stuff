package net.fexcraft.mod.fmaps;

import java.util.List;

import net.fexcraft.mod.fmaps.nano.WebServer;
import net.fexcraft.mod.fmaps.plugins.DefaultPlugin;
import net.fexcraft.mod.fmaps.plugins.IMapPlugin;
import net.fexcraft.mod.fmaps.utils.MainCommand;
import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.perms.PermissionNode;
import net.fexcraft.mod.lib.util.lang.ArrayList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

//@Mod(modid = FMaps.MODID, name = "Fex's World Maps", version="x", acceptableRemoteVersions = "*", dependencies = "required-after:fcl")
public class FMaps {
	
	@Mod.Instance(FMaps.MODID)
	public static FMaps INSTANCE;
	public static WebServer WEBSERVER;
	public static int PORT, SESSIONEXPIRY;
	public static final String MODID = "fmaps";
	private static final ArrayList<IMapPlugin> plugins = new ArrayList<IMapPlugin>();
	
	@Mod.EventHandler
	public static void preInit(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		PORT = config.getInt("port", "Network", 8996, 0, 9999, "The port on which the WebServer will be running on.");
		SESSIONEXPIRY = config.getInt("session_expiry", "Network", 300000, 1000, Integer.MAX_VALUE, "How long till a session expires since the last use.");
	}

	@Mod.EventHandler
	public static void init(FMLInitializationEvent event){
		PermManager.setEnabled(MODID);
		PermManager.add("fmaps.command.use", PermissionNode.Type.BOOLEAN, false, true);
		//
		addPlugin(new DefaultPlugin());
	}
	
	@Mod.EventHandler
	public static void serverLoad(FMLServerStartingEvent event){
		event.registerServerCommand(new MainCommand());
	}
	
	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event){
		WEBSERVER = new WebServer(PORT);
		MinecraftForge.EVENT_BUS.register(WEBSERVER);
		//
	}
	
	@Mod.EventHandler
	public static void serverStop(FMLServerStoppingEvent event){
		//
		WEBSERVER.end(0);
	}
	
	public static final List<IMapPlugin> getPlugins(){
		return plugins;
	}
	
	public static final void addPlugin(IMapPlugin plugin){
		if(!plugins.contains(plugin)){
			plugins.add(plugin);
		}
	}
	
	public static final IMapPlugin getPlugin(String id){
		for(IMapPlugin plugin : getPlugins()){
			if(plugin.getId().equals(id)){
				return plugin;
			}
		}
		return null;
	}
	
}