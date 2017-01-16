package net.fexcraft.mod.fwm.util;

import java.io.File;

import net.fexcraft.mod.fwm.data.Config;

public class Files {
	
	public static File getFile(String loc){
		File file = new File(Config.files, loc);
		if(!file.exists()){
			if(loc.substring(loc.length() -1).equals("/")){
				file.mkdirs();
			}
			else{
				file.getParentFile().mkdirs();
			}
		}
		return file;
	}
	
}