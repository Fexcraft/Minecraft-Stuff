package net.fexcraft.mod.japm.util;

import java.util.ArrayList;

import net.minecraftforge.common.config.Configuration;

public class Config {
	
	public static ArrayList<String> fbl;
	public static final String version = "1.0";
	public static final String mcv = "1.11";
	
	public static void initialize(){
		Configuration cfg = new Configuration(Data.config);
		cfg.load();
		
		cfg.save();
	}
}