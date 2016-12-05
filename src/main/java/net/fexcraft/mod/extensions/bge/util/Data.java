package net.fexcraft.mod.extensions.bge.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.extensions.bge.BGE;
import net.fexcraft.mod.lib.network.Network;

public class Data{
	
	public static JsonObject obj;
	
	public static void getDataFromServer(){
		JsonObject json = Network.getModData("frsm_bge");
		if(json == null){
			obj = new JsonObject();
			obj.addProperty("latest_version", BGE.version);
			obj.addProperty("latest_mc_version", BGE.mcv);
		}
		else{
			for(JsonElement elm : json.get("versions").getAsJsonArray()){
				if(elm.getAsJsonObject().get("version").getAsString().equals(BGE.mcv)){
					obj = elm.getAsJsonObject();
				}
			}
		}
	}
	
}