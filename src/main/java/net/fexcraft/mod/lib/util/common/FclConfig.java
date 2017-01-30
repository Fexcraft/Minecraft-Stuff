package net.fexcraft.mod.lib.util.common;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class FclConfig {
	
	public static boolean uuid_logging;
	public static boolean private_server;
	public static boolean remind;

	public static void initalize(FMLPreInitializationEvent event, File file) {
		Configuration cfg = new Configuration(file);
		cfg.load();
		uuid_logging = cfg.getBoolean("uuid_logging", "Statistics", true, "Set to 'false' if you don't want your UUID to be sent together with Statistical data.");
		if(cfg.getBoolean("remove_from_database", "Statistics", false, "Set to 'true' if you want all data regarding your UUID to be removed from the Statistics Database.")){
			requestRemoval();
		}
		private_server = cfg.getBoolean("private_server", "Statistics", false, "Set to 'true' if you don't want your Server to be logged into the Statistics data.");
		remind = cfg.getBoolean("remind", "Common", true, "Set to 'false' if you do not want to be reminded to check the config.");
		cfg.save();
	}
	
	public static void requestRemoval(){
		//TODO
	}
	
}