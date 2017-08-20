package net.fexcraft.mod.nvr.server.util;

import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.util.text.TextComponentString;

public class Sender {
	
	public static final void serverMessage(String string){
		Static.getServer().getPlayerList().sendMessage(new TextComponentString(string));
	}
	
}