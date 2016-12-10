/**
 * THIS FILE IS PART OF 'JAPM' Just A Protection Mod
 *  © Fexcraft.net
 *  
 *  @author Ferdinand Calo' (FEX___96)
 */
package net.fexcraft.mod.japm;

import java.io.File;

import net.fexcraft.mod.japm.util.Config;
import net.fexcraft.mod.japm.util.Data;
import net.fexcraft.mod.japm.util.Util;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

@Mod(modid = "japm", name = "Just A Protection Mod", version = Config.version, acceptableRemoteVersions = "*", serverSideOnly = true)
public class JAPM {
	
	@Mod.Instance("japm")
	private static JAPM instance;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		Data.initalize(event.getModConfigurationDirectory());
		Config.initialize();
	}

	@Mod.EventHandler
    public void init(FMLInitializationEvent event){
		//
	}
	
	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event){
		//
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

	public static JAPM getInstance(){
		return instance;
	}
	
	public static File getInstallationPath(){
		return Data.path;
	}
	
}