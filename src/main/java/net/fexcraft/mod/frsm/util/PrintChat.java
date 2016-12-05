package net.fexcraft.mod.frsm.util;

import net.fexcraft.mod.frsm.util.text.CCS;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.text.TextComponentString;

public class PrintChat{
	
	public static void print(ICommandSender player, String text){
		player.addChatMessage(new TextComponentString(CCS.GRAY + text));
	}
	
	public static void print(ICommandSender player, String prefix, String text){
		player.addChatMessage(new TextComponentString(prefix + " " + text));
	}
}