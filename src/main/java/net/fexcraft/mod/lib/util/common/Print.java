package net.fexcraft.mod.lib.util.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Print{
	
	private static final Logger logger = LogManager.getLogger("FCL");
	
	public static void log(Object obj){
		logger.info(obj == null ? ">> IS null;" : String.valueOf(obj));
	}
	
	public static void log(String prefix, Object obj){
		logger.info("[" + prefix + "]> " + String.valueOf(obj));
	}
	
	public static void chat(ICommandSender sender, Object obj){
		sender.sendMessage(new TextComponentString("[DEBUG]: " + obj.toString()));
	}
	
	public static void chat(ICommandSender sender, String string){
		sender.sendMessage(new TextComponentString(Formatter.format(string)));
	}
	
	public static void link(ICommandSender sender, String string, String link){
		TextComponentString textcomponent = new TextComponentString(Formatter.format(string));
		textcomponent.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, link == null ? string : link));
		sender.sendMessage(textcomponent);
	}
	
	private static int sec = -1;
	
	public static void logOAS(String string){
		if(Time.getSecond() != sec){
			sec = Time.getSecond();
			logger.info(string);
		}
	}

	public static void spam(int l, String string) {
		for(int i = 0; i < l; i++){
			logger.error(string);
		}
	}

	public static void debug(Object obj) {
		if(Static.dev()){
			log(obj);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public static void debugChat(String string){
		if(Static.dev()){
			Minecraft.getMinecraft().player.sendMessage(new TextComponentString(string));
		}
	}
	
}