package net.fexcraft.mod.frsm.network.util;

import com.google.gson.JsonObject;

import net.fexcraft.mod.frsm.FRSM;
import net.fexcraft.mod.frsm.network.data.Data;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.PrintChat;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class UpdateHandler {
	
	private static String newest_version;
	public static String Status = null;
	public static String wm;
	public static String nMCV = FI.MCV;
	
	public static void load() {
		
		refresh();
		
		if(Data.getData().get("welcome_message").getAsString().length() > 4){
			wm = FI.FRSMs + " " + CCS.format(Data.getData().get("welcome_message").getAsString());
		}
		if(newest_version != null) {
			if(FI.VERSION.equals(newest_version)) {
				Status  = null;
			}
			else {
				Status  = FI.FRSMs + CCS.GRAY + " New Version avaible! (" + CCS.DGREEN  + newest_version + CCS.GRAY + ")"
				 + "\n" + FI.FRSMs + CCS.GRAY + " Your Client version: (" + CCS.RED + FI.VERSION + CCS.GRAY + ")"
				 + "\n" + FI.FRSMs + CCS.GRAY + " Use '/frsm download' to get the link.";
				if(Data.getData().get("update_note").getAsString().length() > 4){
					Status = Status + "\n" + CCS.DGRAY + "================";
					Status = Status + "\n" + CCS.GOLD + "[Update Note]: " + CCS.WHITE + Data.getData().get("update_note").getAsString();
				}
			}
		}
		else {
			Status = null;
		}
	}
	
	private static void refresh(){
		JsonObject obj = Data.getData();
		newest_version = obj.get("latest_version").getAsString();
		nMCV = obj.get("latest_mc_version").getAsString();
	}
	
	public static class EventHandler {
	    @SubscribeEvent
	    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
	    	if(UpdateHandler.wm != null){
	    		PrintChat.print(event.player, UpdateHandler.wm);
	    		PrintChat.print(event.player, FI.FRSMs + CCS.DGRAY + "================");
	    	}
	    	/*if(FRSM.librarymode){
	    		PrintChat.print(event.player, FI.FRSMs + CCS.GRAY + " Running in LibraryMode.");
	    	}*/
	    	if(FRSM.custom){
	    		PrintChat.print(event.player, FI.FRSMs + CCS.GRAY + " AddonLoader is " + CCS.GREEN + "enabled" + CCS.GRAY + ".");
	    		PrintChat.print(event.player, FI.FRSMs + CCS.DGRAY + "================");
	    	}
	    	if(UpdateHandler.Status != null){
	    		PrintChat.print(event.player, UpdateHandler.Status);
	    	}
			if(!UpdateHandler.nMCV.equals(FI.MCV)){
				PrintChat.print(event.player, FI.FRSMs + CCS.DGRAY + "================");
				PrintChat.print(event.player, FI.FRSMs + " Now avaible for Minecraft " + UpdateHandler.nMCV + "!");
			}
	    }
	}
}