package net.fexcraft.mod.fsmm.util;

import java.io.File;
import java.util.UUID;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FsmmConfig {
	
	public static File CONFIG_PATH;
	public static boolean FSU_OVERRIDE;
	public static float STARTING_BALANCE;
	public static UUID DEFAULT_BANK;
	public static boolean DEBUG;
	private static Configuration config;
	
	public static void initialize(FMLPreInitializationEvent event){
		CONFIG_PATH = event.getSuggestedConfigurationFile().getParentFile();
		config = new Configuration(new File(event.getSuggestedConfigurationFile().getParentFile(), "/fsmm/config.cfg"), "1.0", true);
		resync(true);
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	
	public static void resync(){
		resync(false);
	}
	
	private static void resync(boolean b){
		if(b){
			config.setCategoryRequiresMcRestart("General", true);
			config.setCategoryRequiresWorldRestart("General", true);
			config.setCategoryRequiresMcRestart("Logging", false);
			config.setCategoryRequiresWorldRestart("Logging", false);
			config.load();
		}
		STARTING_BALANCE = config.getFloat("starting_balance", "General", 100, 0, 1000000, "Starting balance for a new player.");
		DEFAULT_BANK = UUID.fromString(config.getString("default_bank", "General", "00000000-0000-0000-0000-000000000000", "Default Bank the player will have an account in.\nMust be an valid UUID!"));
		DEBUG = config.getBoolean("debug", "Logging", false, "Prints some maybe useful data into console, suggested for bug-hunting.");
		config.save();
	}
	
	private static class EventHandler {
		@SubscribeEvent
		public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
			if(event.getModID().equals("fsmm")){
				resync();
			}
		}
	}

	public static Configuration getConfig(){
		return config;
	}
	
}