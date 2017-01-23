package net.fexcraft.mod.fwm.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.fexcraft.mod.fwm.api.GenericMapPlugin;
import net.fexcraft.mod.fwm.api.MapPlugin;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraftforge.fml.common.discovery.ASMDataTable;
import net.minecraftforge.fml.common.discovery.ASMDataTable.ASMData;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class Resources {
	
	private static Map<String, GenericMapPlugin> plugins = new HashMap<String, GenericMapPlugin>();
	
	public static void scan(ASMDataTable datatable){
		String name = MapPlugin.class.getCanonicalName();
		Set<ASMData> data = datatable.getAll(name);
		for(ASMData dt : data){
			try {
				Class<?> clazz = Class.forName(dt.getClassName());
				MapPlugin mpd = clazz.getAnnotation(MapPlugin.class);
				GenericMapPlugin plugin = (GenericMapPlugin)clazz.newInstance();
				plugins.put(mpd.id(), plugin);
				Print.log(clazz.toString() + "\n" + mpd.toString());
			}
			catch(Exception e) {
				Print.spam(1, "Error while constructing '" + dt.getClassName() + "'!");
				e.printStackTrace();
				Static.halt();
			}
		}
	}
	
	public static void disablePlugins(){
		for(GenericMapPlugin pl : plugins.values()){
			pl.disable();
		}
	}

	public static void initializePlugins(FMLInitializationEvent event) {
		for(GenericMapPlugin pl : plugins.values()){
			pl.initialise(event);
		}
	}
	
}