package net.fexcraft.mod.nvr.server.events;

import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.nvr.server.NVR;
import net.fexcraft.mod.nvr.server.data.Player;
import net.fexcraft.mod.nvr.server.util.Permissions;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatEvents {
	
	@SubscribeEvent
	public void onMessage(ServerChatEvent event){
		Player data = NVR.getPlayerData(event.getPlayer());
		if(!data.perms.hasPermission("general.chat_message.send")){
			Print.chat(event.getPlayer(), "You have no Permission to send Chat messages.");
			event.setCanceled(true);
			return;
		}
		String msg = "&0[&" + (data.perms.hasPermission(Permissions.ADMIN) ? "4" : "3") + "#&0] " + data.getNick(event.getPlayer()) + "&0:&7 " + event.getMessage();
		for(EntityPlayerMP player : Static.getServer().getPlayerList().getPlayers()){
			Print.chat(player, Formatter.format(msg));
		}
		event.setCanceled(true);
	}
	
}