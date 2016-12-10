package net.fexcraft.mod.japm.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.util.json.JsonUtil;

public class Data {
	
	public static File path, chunk, player, region, config;
	public static JsonObject updatedata = new JsonObject();
	
	public static void initalize(File file){
		path = new File(file, "/japm/");
		if(!path.exists()){
			path.mkdirs();
		}
		chunk = new File(path, "chunks/");
		if(!chunk.exists()){
			chunk.mkdirs();
		}
		player = new File(path, "players/");
		if(!player.exists()){
			player.mkdirs();
		}
		region = new File(path, "regions/");
		if(!player.exists()){
			player.mkdirs();
		}
		config = new File(path, "japm.cfg");
		updatedata = getDataFromServer();
	}
	
	/** Modified Copy from FCL 
	 * @return */
	private static JsonObject getDataFromServer() {
		try{
			URL url = new URL("http://fexcraft.net/minecraft/fcl/request");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("POST");
				connection.setRequestProperty("User-Agent", "Mozilla/5.0");
				connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
				connection.setDoOutput(true);
				
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
				wr.writeBytes("mode=requestdata&modid=japm");
				wr.close();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String input;
				StringBuffer response = new StringBuffer();
				while ((input = in.readLine()) != null) {
					response.append(input);
				}
				in.close();
			
			JsonObject obj = JsonUtil.getObjectFromString(response.toString());	
			connection.disconnect();
			return obj;
		}
		catch(Exception e){
			e.printStackTrace();
			JsonObject obj = new JsonObject();
			JsonObject objj = new JsonObject();
			objj.addProperty("version", Config.mcv);
			objj.addProperty("latest_version", Config.version);
			objj.addProperty("latest_mc_version", Config.mcv);
			JsonArray array = new JsonArray();
			array.add(objj);
			obj.add("versions", array);
			return obj;
		}
	}
	
}