package net.fexcraft.mod.frsm.network.data;

import java.util.HashMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Links{
	
	private static HashMap<String, String> download_links;
	
	public static void getDownloadLinks(){
		if(download_links == null){
			download_links = new HashMap<String, String>();
		}
		JsonArray array = Data.getData().get("download_links").getAsJsonArray();
		for(JsonElement elm : array){
			JsonObject obj = elm.getAsJsonObject();
			if(obj.has("id") && obj.has("link")){
				download_links.put(obj.get("id").getAsString(), obj.get("link").getAsString());
			}
		}
	}
	
	public static HashMap<String, String> getDownloadLinksMap(){
		return download_links;
	}
	
}
