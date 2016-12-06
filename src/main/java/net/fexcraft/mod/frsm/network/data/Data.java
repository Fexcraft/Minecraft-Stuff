package net.fexcraft.mod.frsm.network.data;

import java.io.File;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.network.Network;

public class Data{
	
	private static File tempfile;
	private static JsonObject data;
	
	public static void getDataFromServer(){
		/*tempfile = new File(FRSM.tempdata, "Temp_FRSM_Data.fd");
		try {
			URL url = new URL("http://www.fexcraft.net/files/TXT/" + FI.MCV + "/frsm.fd");
			FileUtils.copyURLToFile(url, tempfile);
			data = JsonUtil.read(tempfile, true).getAsJsonObject();
			
		}
		catch(IOException | JsonSyntaxException ex) {
			ex.printStackTrace();
			PrintLog.print("UpdateChecker", "Failed to get data from Server, creating dummy temp-file to prevent crashes.");
			data = new JsonObject();
			data.addProperty("latest_version", FI.VERSION);
			data.addProperty("latest_mc_version", FI.MCV);
			data.addProperty("changelog", "error.could.not.connect.to.server\nNo Internet?");
			
			JsonObject obj = new JsonObject();
				obj.addProperty("id", "null");
				obj.addProperty("link", "http://localhost");
				obj.addProperty("name", "no.internet.connection");
			
			JsonArray array = new JsonArray();
				array.add(obj);
			
			data.add("download_links", array);
			data.addProperty("update_note", "null");
			data.addProperty("welcome_message", "null");
		}*/
		JsonObject json = Network.getModData("frsm");
		if(json == null){
			setDefault();
		}
		else{
			boolean found = false;
			for(JsonElement elm : json.get("versions").getAsJsonArray()){
				if(elm.getAsJsonObject().get("version").getAsString().equals(FI.MCV)){
					data = elm.getAsJsonObject();
					found = true; break;
				}
			}
			if(!found){
				setDefault();
			}
		}
	}
	
	private static void setDefault(){
		data = new JsonObject();
		data.addProperty("latest_version", FI.VERSION);
		data.addProperty("latest_mc_version", FI.MCV);
		data.addProperty("changelog", "error.could.not.connect.to.server\nNo Internet?");
		
		JsonObject obj = new JsonObject();
			obj.addProperty("id", "null");
			obj.addProperty("link", "http://localhost");
			obj.addProperty("name", "no.internet.connection");
		
		JsonArray array = new JsonArray();
			array.add(obj);
		
		data.add("download_links", array);
		data.addProperty("update_note", "null");
		data.addProperty("welcome_message", "null");
	}

	public static JsonObject getData(){
		return data;
	}
}