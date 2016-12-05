package net.fexcraft.mod.famm.util;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class FAMMEventHandler {
	
	@SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
    	if(UpdateHandler.Status != null){
        	event.player.addChatMessage(new TextComponentString(UpdateHandler.Status));
    	}
    }
}