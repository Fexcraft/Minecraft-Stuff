package net.fexcraft.mod.extensions.ce.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fexcraft.mod.extensions.ce.CE;
import net.fexcraft.mod.lib.network.Network;

public class Data{
	
	public static JsonObject obj;
	
	public static void getDataFromServer(){
		JsonObject json = Network.getModData("frsm_ce");
		if(json == null){
			obj = new JsonObject();
			obj.addProperty("latest_version", CE.version);
			obj.addProperty("latest_mc_version", CE.mcv);
		}
		else{
			for(JsonElement elm : json.get("versions").getAsJsonArray()){
				if(elm.getAsJsonObject().get("version").getAsString().equals(CE.mcv)){
					obj = elm.getAsJsonObject();
				}
			}
		}
	}
	
}