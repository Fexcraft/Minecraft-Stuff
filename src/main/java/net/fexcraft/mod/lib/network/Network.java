package net.fexcraft.mod.lib.network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Network{
	
	/** Checks if connection (to main server) is avaible. */
	public static boolean isConnected(){
		try{
			URL url = new URL("http://www.fexcraft.net/files/TXT/connection.test");
			url.openConnection().connect();
			return true;
		}
		catch(IOException e){
			return false;
		}
	}
	
	/** Requests a JsonObject from the given adress and parameters, using the POST HTML method. */
	public static JsonObject request(String adress, String parameters){
		if(!isConnected()){
			return null;
		}
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
	
	/** One-Time-Use method to register the mod in the FCL database.<br>
	 * NOTE: Non-donators can register up to 3 mods, multi-accounting ("alts") tollerated up to 2 accounts per physical person.
	 * Suspicious registry entries will be deleted if the person doesn't reply in time.
	 * **/
	public static void registerMod(String modid, int userid, String rawpassword, UUID[] authors) throws Exception {
		if(!isConnected()){
			Print.log("[FCL] Failed to register Mod '" + modid + "'! No internet connection avaible.");
			return;
		}
		if(authors.length < 1){
			Print.log("[FCL] Failed to register Mod '" + modid + "'! Author list is empty.");
			return;
		}
		JsonObject request = new JsonObject();
		request.addProperty("modid", modid);
		request.addProperty("user", userid);
		request.addProperty("rpwd", rawpassword);
		request.add("authors", new JsonArray());
		for(UUID id : authors){
			request.get("authors").getAsJsonArray().add(new JsonPrimitive(id.toString()));
		}
		JsonObject reply = request("http://fexcraft.net/minecraft/fcl/request", "mode=register&modid=" + modid + "&obj=" + request.toString());
		Print.log("[FCL] Registry state of '" + modid + "' = [" + reply.get("registered").getAsBoolean() + "]");
		Print.log("[FCL] ERROR-CODE: " + reply.get("error_message").getAsString());
	}
	
	public static JsonObject getModData(String modid){
		return request("http://fexcraft.net/minecraft/fcl/request", "mode=requestdata&modid=" + modid);
	}
	
	public static boolean isModRegistered(String modid){
		return request("http://fexcraft.net/minecraft/fcl/request", "mode=exists&modid=" + modid).get("exists").getAsBoolean();
	}
	
	public static boolean isDonator(UUID id){
		return DonorValidator.isDonor(id);
	}
	
	public static boolean isBanned(UUID id){
		return BlackList.getInstance().isBanned(id);
	}

	public static boolean isDonator(EntityPlayer p) {
		return DonorValidator.isDonor(p.getGameProfile().getId());
	}

	public static MinecraftServer getMinecraftServer(){
		return FMLCommonHandler.instance().getMinecraftServerInstance();
	}
	
}