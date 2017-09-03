package net.fexcraft.mod.fmaps.nano;

import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.UUID;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fmaps.FMaps;
import net.fexcraft.mod.fsu.server.FSU;
import net.fexcraft.mod.fsu.server.network.nano_httpd.NanoHTTPD;
import net.fexcraft.mod.fsu.server.network.nano_httpd.NanoHTTPD.Response.Status;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.lang.ArrayList;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;

public class WebServer extends NanoHTTPD {
	
	private int sec = Time.getSecond(), min = Time.getMinute();
	private static final TreeMap<UUID, Key> keys = new TreeMap<UUID, Key>();
	
	public WebServer(int port){
		super(port);
		try{
			start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
			System.out.println("[FMAPS] Running on port " + FSU.PORT + "!");
		}
		catch (IOException e){
			e.printStackTrace();
			System.out.println("[FMAPS] Failed to launch!");
		}
	}
	
	public static void end(int arg){
		FMaps.WEBSERVER.myThread.stop();
		//System.exit(arg);
	}
	
	@Override
	public Response serve(IHTTPSession session){
		try{
			session.parseBody(new HashMap<String, String>());
		}
		catch(IOException | ResponseException e){
			e.printStackTrace();
		}
		try{
			String key = session.getParameters().get("key").get(0);
			JsonObject result = new JsonObject();
			if(key == null || key.equals("")){
				result.addProperty("error", "No Key Provided.");
				return newFixedLengthResponse(Status.OK, NanoHTTPD.MIME_PLAINTEXT, result.toString());
			}
			Key keycode = getKey(key);
			if(keycode == null){
				result.addProperty("error", "Invalid or expired key.");
				return newFixedLengthResponse(Status.OK, NanoHTTPD.MIME_PLAINTEXT, result.toString());
			}
			if(keycode.expired){
				result.addProperty("error", "Key Expired.");
				return newFixedLengthResponse(Status.OK, NanoHTTPD.MIME_PLAINTEXT, result.toString());
			}
			return newFixedLengthResponse(Status.OK, NanoHTTPD.MIME_PLAINTEXT, getResponse(result, keycode, session).toString());
		}
		catch(Exception e){
			JsonObject obj = new JsonObject();
			obj.addProperty("error", e.getMessage());
			return newFixedLengthResponse(Status.OK, NanoHTTPD.MIME_PLAINTEXT, obj.toString());
		}
		//return newFixedLengthResponse(Status.BAD_REQUEST, NanoHTTPD.MIME_PLAINTEXT, "null");
	}
	
	private Key getKey(String code){
		for(Key key : keys.values()){
			if(key.code.equals(code)){
				return key;
			}
		}
		return null;
	}

	private static final JsonObject getResponse(JsonObject result, Key key, IHTTPSession session){
		key.lastuse = Time.getDate();
		EntityPlayer player = Static.getServer().getPlayerList().getPlayerByUUID(key.key);
		if(player == null){
			result.addProperty("error", "Player not found.");
			return result;
		}
		String rq = session.getParameters().get("rq").get(0);
		switch(rq){
			case "test":{
				result.addProperty("received", true);
				break;
			}
		}
		return result;
	}
	
	public static final class Key {
		
		public UUID key;
		public boolean expired;
		public long lastuse;
		public String code;
		
		public Key(UUID key){
			this.key = key;
			code = UUID.randomUUID().toString().substring(0, 9);
			lastuse = Time.getDate();
			expired = false;
		}
	}
	
	@SubscribeEvent
	public void onTick(ServerTickEvent event){
		if(sec != Time.getSecond()){
			sec = Time.getSecond();
			keys.forEach((uuid, key) -> {
				if(Time.getDate() - key.lastuse > FMaps.SESSIONEXPIRY){
					key.expired = true;
				}
			});
			if(min != Time.getMinute()){
				min = Time.getMinute();
				ArrayList<UUID> list = new ArrayList<UUID>();
				keys.forEach((uuid, key) -> {
					if(key.expired){
						list.add(uuid);
					}
				});
				list.forEach((uuid) -> {
					keys.remove(uuid);
				});
			}
		}
	}
}