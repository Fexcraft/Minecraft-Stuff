package net.fexcraft.mod.extensions.fve.util;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class FVEEventHandler {
	
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
    	if(UpdateHandler.status != null){
    		event.player.addChatMessage(new TextComponentString(UpdateHandler.status));
    	}
    }
}