package net.fexcraft.mod.fwm.data;

import java.io.File;

import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config {
	
	public static JsonUtil ju;
	public static File path, files;
	private static File configfile;
	private static JsonObject obj;
	//
	public static int actualization_interval;
	//
	public static void initialize(FMLPreInitializationEvent event){
		path = new File(event.getModConfigurationDirectory().getParent());
		files = new File(path, "/fworldmap/");
		configfile = new File(files, "Configuration.fd");
		
		load();
	}
	
	public static void load(){
		JsonObject obj = JsonUtil.get(configfile);
		actualization_interval = ju.getIfExists(obj, "actualization_interval", 360000).intValue();
		//
		Config.obj = obj;
	}
	
	public static void save(){
		obj.addProperty("last_save", Time.getDate());
		JsonUtil.write(configfile, obj);
	}
	
}