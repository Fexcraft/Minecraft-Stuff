package net.fexcraft.mod.japm.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.fexcraft.mod.lib.util.json.JsonUtil;

public class Util {
	
	private static final JsonParser parser = new JsonParser();
	private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	
	public static JsonObject request(String adress, String parameters){
		try{
			URL url = new URL(adress);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("POST");
				connection.setRequestProperty("User-Agent", "Mozilla/5.0");
				connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
				connection.setDoOutput(true);
				
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
				wr.writeBytes(parameters);
				wr.flush();
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
			return null;
		}
	}

	public static ArrayList<String> getBL() {
		JsonObject obj = request("http://fexcraft.net/minecraft/fcl/request?mode=blacklist", "");
		ArrayList<String> list = new ArrayList<String>();
		if(obj != null){
			for(JsonElement elm : obj.get("blacklist").getAsJsonArray()){
				list.add(elm.getAsString());
			}
		}
		return list;
	}
	
	public static String getObjectAsString(JsonElement elm){
		return gson.toJson(elm);
	}

	public static JsonObject getObject(UUID uuid) {
		try{
			File file = getFile(uuid);
			JsonElement elm = null;
			FileReader fr = new FileReader(file);
			elm = parser.parse(fr); fr.close();
			return elm.getAsJsonObject();
		}
		catch(IOException e){
			return new JsonObject();
		}
	}

	public static void writeJson(UUID uuid, JsonObject object) {
		try{
			File file = getFile(uuid);
			FileWriter fw = new FileWriter(file);
			fw.write(gson.toJson(object));
			fw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	private static File getFile(UUID uuid) {
		return new File(Data.player, uuid.toString() + ".scc");
	}

	private static SimpleDateFormat date_format = new SimpleDateFormat("dd-MM-yyyy [HH:mm:SS]");

	public static String getTime(long lg){
		return date_format.format(new Date(lg));
	}
	
}