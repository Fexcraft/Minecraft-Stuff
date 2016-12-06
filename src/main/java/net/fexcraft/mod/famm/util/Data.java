package net.fexcraft.mod.famm.util;

import java.io.File;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.network.Network;

public class Data{
	
	private static File file;
	public static JsonObject obj;
	
	public static void getDataFromServer(){
		JsonObject json = Network.getModData("famm");
		if(json == null){
			setDefault();
		}
		else{
			boolean found = false;
			for(JsonElement elm : json.get("versions").getAsJsonArray()){
				if(elm.getAsJsonObject().get("version").getAsString().equals(FI.MCV)){
					obj = elm.getAsJsonObject();
					found = true; break;
				}
			}
			if(!found){
				setDefault();
			}
		}
	}

	private static void setDefault(){
		obj = new JsonObject();
		obj.addProperty("latest_version", FI.VERSION);
		obj.addProperty("latest_mc_version", FI.MCV);
	}
	
}