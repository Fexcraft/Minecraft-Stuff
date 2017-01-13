package net.fexcraft.mod.extensions.bge.util;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class BGEEventHandler {
	
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
    	if(UpdateHandler.status != null){
    		event.player.sendMessage(new TextComponentString(UpdateHandler.status));
    	}
    }
    
}