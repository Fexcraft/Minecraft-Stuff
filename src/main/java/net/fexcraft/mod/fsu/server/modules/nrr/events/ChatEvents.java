package net.fexcraft.mod.fsu.server.modules.nrr.events;

import net.fexcraft.mod.fsu.server.modules.nrr.NRR;
import net.fexcraft.mod.fsu.server.modules.nrr.data.PlayerData;
import net.fexcraft.mod.fsu.server.modules.nrr.util.NCCS;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatEvents {
	
	@SubscribeEvent
	public void onMessage(ServerChatEvent event){
		PlayerData data = NRR.getPlayerData(event.getPlayer());
		if(!data.perms.hasPermission("general.chat_message.send")){
			Print.chat(event.getPlayer(), "You have no Permission to send Chat messages.");
			event.setCanceled(true);
			return;
		}
		String msg = "&0["+ NCCS.fromInt(data.province.region.nation.color) + data.province.region.nation.shortName() + "&0|&a" + data.province.region.shortName() + "&0|&2" + data.province.shortName()+ "&0] " + data.getNick(event.getPlayer()) + "&0:&7 " + event.getMessage();
		for(EntityPlayerMP player : Static.getServer().getPlayerList().getPlayers()){
			Print.chat(player, Formatter.format(msg));
		}
		event.setCanceled(true);
	}
	
}