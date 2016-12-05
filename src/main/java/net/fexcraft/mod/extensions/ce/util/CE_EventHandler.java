package net.fexcraft.mod.extensions.ce.util;

import net.fexcraft.mod.extensions.ce.CE;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class CE_EventHandler {
	
	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
		if(UpdateHandler.status != null){
			event.player.addChatMessage(new TextComponentString(UpdateHandler.status));
		}
		if(!UpdateHandler.nMCV.equals(CE.mcv)){
			event.player.addChatMessage(new TextComponentString(UpdateHandler.CE_ + " Now avaible for " + UpdateHandler.nMCV + " Minecraft!"));
		}
	}
}