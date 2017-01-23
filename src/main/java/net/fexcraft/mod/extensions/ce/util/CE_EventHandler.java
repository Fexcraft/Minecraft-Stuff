package net.fexcraft.mod.extensions.ce.util;

import net.fexcraft.mod.extensions.ce.CE;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class CE_EventHandler {
	
	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
		if(UpdateHandler.status != null){
			Print.chat(event.player, UpdateHandler.status);
		}
		if(!UpdateHandler.nMCV.equals(CE.MCV)){
			Print.chat(event.player, UpdateHandler.CE_ + " Now avaible for " + UpdateHandler.nMCV + " Minecraft!");
		}
	}
}