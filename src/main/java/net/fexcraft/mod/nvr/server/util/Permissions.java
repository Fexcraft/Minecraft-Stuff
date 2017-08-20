package net.fexcraft.mod.nvr.server.util;

import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.perms.PermissionNode.Type;

public class Permissions {
	
	public static final String ADMIN = "nvr.admin";
	public static final String CHAT_SEND = "general.chat_message.send";
	public static final String BLOCK_BREAK = net.fexcraft.mod.lib.perms.Permissions.GENERAL_BLOCK_BREAK;
	public static final String BLOCK_PLACE = net.fexcraft.mod.lib.perms.Permissions.GENERAL_BLOCK_PLACE;
	
	
	public static void register(){
		Type type = Type.BOOLEAN;
		PermManager.add(ADMIN, type, false, false);
		PermManager.add(CHAT_SEND, type, true, true);
	}
	
}