/**
 * THIS FILE IS PART OF 'SCC' Simple Chunk Control
 *  © Fexcraft.net
 *  
 *  @author Ferdinand (FEX___96)
 */
package net.fexcraft.mod.sm.scc.events;

import net.fexcraft.mod.sm.scc.util.Data;
import net.fexcraft.mod.sm.scc.util.Player;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;

public class PlayerEvents {
	
	@SubscribeEvent
	public void onPlayerJoined(PlayerLoggedInEvent event){
		if(event.player == null){
			return;
		}
		Player player = new Player(event.player.getGameProfile().getId());
		Data.players.add(player);
	}
	
	@SubscribeEvent
	public void onPlayerLeft(PlayerLoggedOutEvent event){
		if(event.player == null){
			return;
		}
		Player player = Data.getPlayer(event.player.getGameProfile().getId());
		if(player != null){
			player.save();
			Data.players.remove(player);
		}
	}
	
}