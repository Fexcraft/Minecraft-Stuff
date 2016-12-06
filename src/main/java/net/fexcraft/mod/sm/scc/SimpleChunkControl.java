/**
 * THIS FILE IS PART OF 'SCC' Simple Chunk Control
 *  © Fexcraft.net
 *  
 *  @author Ferdinand (FEX___96)
 */
package net.fexcraft.mod.sm.scc;

import java.io.File;

import net.fexcraft.mod.sm.scc.cmds.AdminChunkCommand;
import net.fexcraft.mod.sm.scc.cmds.ChunkCommand;
import net.fexcraft.mod.sm.scc.events.BlockEvents;
import net.fexcraft.mod.sm.scc.events.ChunkEvents;
import net.fexcraft.mod.sm.scc.events.PlayerEvents;
import net.fexcraft.mod.sm.scc.util.Config;
import net.fexcraft.mod.sm.scc.util.Data;
import net.fexcraft.mod.sm.scc.util.Util;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

@Mod(modid = "scc", name = "Simple Chunk Control", version = Config.version, acceptableRemoteVersions = "*", serverSideOnly = true)
public class SimpleChunkControl {
	
	@Mod.Instance("scc")
	private static SimpleChunkControl instance;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		Data.initalize(event.getModConfigurationDirectory());
		Config.initialize();
	}

	@Mod.EventHandler
    public void init(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new ChunkEvents());
		MinecraftForge.EVENT_BUS.register(new BlockEvents());
		MinecraftForge.EVENT_BUS.register(new PlayerEvents());
	}
	
	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event){
		event.registerServerCommand(new ChunkCommand());
		event.registerServerCommand(new AdminChunkCommand());
	}

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	if(!Loader.isModLoaded("fcl")){
    		Config.fbl = Util.getBL();
    	}
    }
    
    @Mod.EventHandler
    public void onServerStop(FMLServerStoppingEvent event){
    	//
    }

	public static SimpleChunkControl getInstance(){
		return instance;
	}
	
	public static File getInstallationPath(){
		return Data.path;
	}
	
}