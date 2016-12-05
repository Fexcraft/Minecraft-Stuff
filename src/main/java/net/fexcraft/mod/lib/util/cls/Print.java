package net.fexcraft.mod.lib.util.cls;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.command.ICommandSender;
import net.minecraft.util.text.TextComponentString;

public class Print{
	
	private static final Logger logger = LogManager.getLogger("FCL");
	
	public static void log(Object obj){
		/*if(obj instanceof Primitive){
			System.out.println(obj);
		}
		else{
			System.out.println(obj.toString());
		}*/
		logger.info(String.valueOf(obj));
	}
	
	public static void chat(ICommandSender sender, Object obj){
		sender.addChatMessage(new TextComponentString("[DEBUG]: " + obj.toString()));
	}
	
	public static void chat(ICommandSender sender, String string){
		sender.addChatMessage(new TextComponentString(string));
	}
	
	private static int sec = -1;
	
	public static void logOAS(String string){
		int i = Calendar.getInstance().get(Calendar.SECOND);
		if(i != sec){
			sec = i;
			//System.out.println(string);
			logger.info(string);
		}
	}

	public static void spam(int l, String string) {
		for(int i = 0; i < l; i++){
			//System.out.println(string);
			logger.error(string);
		}
	}
}