/**
 * THIS FILE IS PART OF 'SCC' Simple Chunk Control
 *  © Fexcraft.net
 *  
 *  @author Ferdinand (FEX___96)
 */
package net.fexcraft.mod.sm.scc.util;

import java.io.File;
import java.text.SimpleDateFormat;
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
	
	public static JsonObject getObject(int x, int z){
		return JsonUtil.get(getFile(x, z));
	}
	
	public static void writeJson(JsonObject obj){
		JsonUtil.write(getFile(obj.get("x").getAsInt(), obj.get("z").getAsInt()), obj);
	}
	
	private static File getFile(int x, int z){
		return new File(Data.chunk, x + "_" + z + ".scc");
	}
	
	public static String getObjectAsString(JsonElement elm){
		return gson.toJson(elm);
	}

	public static JsonObject getObject(UUID uuid){
		return JsonUtil.get(getFile(uuid));
	}

	public static void writeJson(UUID uuid, JsonObject object){
		JsonUtil.write(getFile(uuid), object);
	}

	private static File getFile(UUID uuid) {
		return new File(Data.player, uuid.toString() + ".scc");
	}

	private static SimpleDateFormat date_format = new SimpleDateFormat("dd-MM-yyyy [HH:mm:SS]");

	public static String getTime(long lg){
		return date_format.format(new Date(lg));
	}
	
}