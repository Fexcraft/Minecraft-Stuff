package net.fexcraft.mod.fsmm.util;

import net.fexcraft.mod.fsmm.FSMM;
import net.fexcraft.mod.fsmm.account.AccountManager.Account;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class FSMMEventHandler {
	
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
    	if(UpdateHandler.Status != null){
        	event.player.sendMessage(new TextComponentString(UpdateHandler.Status));
    	}
    }
    
    @SubscribeEvent
    public void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event){
    	Account account = FSMM.getInstance().getAccountManager().getAccountOf(event.player.getUUID(event.player.getGameProfile()));
    	FSMM.getInstance().getAccountManager().saveAccount(account);
    }
    
    @SubscribeEvent
    public void onWorldSave(WorldEvent.Unload event){
    	FSMM.getInstance().getAccountManager().saveAll();
    }
    
    @EventHandler
    public static void onShutdown(FMLServerStoppingEvent event){
    	FSMM.getInstance().getAccountManager().saveAll();
    }
    
}