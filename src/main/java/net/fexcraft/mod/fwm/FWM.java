package net.fexcraft.mod.fwm;

import net.fexcraft.mod.fwm.data.Config;
import net.fexcraft.mod.fwm.data.Resources;
import net.fexcraft.mod.fwm.util.EventHandler;
import net.fexcraft.mod.fwm.util.Ticker;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

@Mod(modid = "fwm", name="Fex's World Map", serverSideOnly = true)
public class FWM {
	
	@Mod.Instance("fwm")
	private static FWM instance;
	
	@Mod.EventHandler
	public void process(FMLPreInitializationEvent event){
		Config.initialize(event);
		Resources.scan(event.getAsmData());
	}
	
	@Mod.EventHandler
	public void process(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(Ticker.getInstance());
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		Resources.initializePlugins(event);
	}
	
	@Mod.EventHandler
	public void process(FMLPostInitializationEvent event){
		//launch webserver
	}
	
	@Mod.EventHandler
	public void process(FMLServerStoppingEvent event){
		Config.save();
		Ticker.saveQueue();
		
		Resources.disablePlugins();
	}
	
}