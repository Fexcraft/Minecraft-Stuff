package net.fexcraft.mod.sm.scc.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class UpdateHandler {
	
	private static boolean avaible = false;
	private static boolean updatem = false;
	private static String nv, mcn;
	
	public static void initalize(){
		JsonObject obj = null;
		for(JsonElement elm : Data.updatedata.get("versions").getAsJsonArray()){
			if(elm.getAsJsonObject().get("version").getAsString().equals("1.11")){
				obj = elm.getAsJsonObject();
				break;
			}
		}
		if(!obj.get("latest_mc_version").getAsString().equals("1.11")){
			updatem = true;
			mcn = obj.get("latest_mc_version").getAsString();
		}
		if(!obj.get("latest_version").getAsString().equals(Config.version)){
			avaible = true;
			nv = obj.get("latest_version").getAsString();
		}
	}

	public static void onPlayerJoined(EntityPlayer player){
		if(updatem){
			player.sendMessage(new TextComponentString(TextFormatting.GRAY + "[SCC] Update Avaible! (" + nv + ")"));
		}
		if(avaible){
			player.sendMessage(new TextComponentString(TextFormatting.GRAY + "[SCC] Also avaible for Minecraft " + mcn + "!"));
		}
	}
}