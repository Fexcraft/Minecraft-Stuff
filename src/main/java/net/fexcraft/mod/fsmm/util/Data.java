package net.fexcraft.mod.fsmm.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.network.Network;

public class Data{
	
	//private static File file;
	public static JsonObject data;
	
	public static void getDataFromServer() {
		/*file = new File(FSMM.temp_path, "Temp_FSMM_Data.fd");
		file.deleteOnExit();
		try {
			URL url = new URL("http://www.fexcraft.net/files/TXT/" + FI.MCV + "/fsmm.fd");
			FileUtils.copyURLToFile(url, file);
			obj = read(file).getAsJsonObject();
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
			System.out.print("[UpdateChecker]: Failed to get data from Server, creating dummy temp-file to prevent crashes.");
			obj = new JsonObject();
			obj.addProperty("latest_version", FI.VERSION);
			obj.addProperty("latest_mc_version", FI.MCV);
			obj.addProperty("type", "error.could.not.connect.to.server\nNo Internet?");
		}*/
		JsonObject json = Network.getModData("fsmm");
		if(json == null){
			data = new JsonObject();
			data.addProperty("latest_version", FI.VERSION);
			data.addProperty("latest_mc_version", FI.MCV);
			data.addProperty("type", "error.could.not.connect.to.server\nNo Internet?");
		}
		else{
			for(JsonElement elm : json.get("versions").getAsJsonArray()){
				if(elm.getAsJsonObject().get("version").getAsString().equals(FI.MCV)){
					data = elm.getAsJsonObject();
				}
			}
		}
	}
	
}