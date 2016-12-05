package net.fexcraft.mod.frsm.util;

public class PrintLog{
	
	//private static Logger logger = Logger.getLogger("FRSM");
	
	public static void print(String prefix, String log){
		System.out.println("[" + prefix + "]: " + log);
		//logger.log(Level.INFO, "[" + prefix + "]: " + log);
	}
	
	public static void printIn(String prefix, String log){
		System.out.println(prefix + " " + log);
		//logger.log(Level.INFO, log);
	}
}