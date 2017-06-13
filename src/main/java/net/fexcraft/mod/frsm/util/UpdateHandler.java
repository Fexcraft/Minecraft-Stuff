package net.fexcraft.mod.frsm.util;

import com.google.gson.JsonObject;

import net.fexcraft.mod.frsm.util.CCS;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.FCL;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class UpdateHandler {
	
	private static String newest_version;
	public static String Status = null;
	public static String wm;
	public static String nMCV = FCL.mcv;
	
	public static void load() {
		
		refresh();
		
		if(Data.getData().get("welcome_message").getAsString().length() > 4){
			wm = FI.PREFIX + " " + CCS.format(Data.getData().get("welcome_message").getAsString());
		}
		if(newest_version != null) {
			if(FI.VERSION.equals(newest_version)) {
				Status  = null;
			}
			else {
				Status  = FI.PREFIX + CCS.GRAY + " New Version avaible! (" + CCS.DGREEN  + newest_version + CCS.GRAY + ")"
				 + "\n" + FI.PREFIX + CCS.GRAY + " Your Client version: (" + CCS.RED + FI.VERSION + CCS.GRAY + ")"
				 + "\n" + FI.PREFIX + CCS.GRAY + " Use '/frsm download' to get the link.";
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
	    		Print.chat(event.player, UpdateHandler.wm);
	    		Print.chat(event.player, FI.PREFIX + CCS.DGRAY + "================");
	    	}
	    	if(UpdateHandler.Status != null){
	    		Print.chat(event.player, UpdateHandler.Status);
	    	}
			if(!UpdateHandler.nMCV.equals(FCL.mcv)){
				Print.chat(event.player, FI.PREFIX + CCS.DGRAY + "================");
				Print.chat(event.player, FI.PREFIX + " Now avaible for Minecraft " + UpdateHandler.nMCV + "!");
			}
	    }
	}
	
}