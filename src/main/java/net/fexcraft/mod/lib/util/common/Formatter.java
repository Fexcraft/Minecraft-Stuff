package net.fexcraft.mod.lib.util.common;

public class Formatter {
	
	public static String format(String string){
		string = string.replace("&", "\u00a7");
		return string;
	}
	
}