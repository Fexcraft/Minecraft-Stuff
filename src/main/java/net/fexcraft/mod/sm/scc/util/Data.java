/**
 * THIS FILE IS PART OF 'SCC' Simple Chunk Control
 *  © Fexcraft.net
 *  
 *  @author Ferdinand (FEX___96)
 */
package net.fexcraft.mod.sm.scc.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Data {
	
	public static File path, chunk, player, config;
	public static Set<Chunk> chunks = new HashSet<Chunk>();
	public static Set<Player> players = new HashSet<Player>();
	public static JsonObject updatedata = new JsonObject();
	
	public static void initalize(File file){
		path = new File(file, "/scc");
		if(!path.exists()){
			path.mkdirs();
		}
		chunk = new File(path, "/chunks/");
		if(!chunk.exists()){
			chunk.mkdirs();
		}
		player = new File(path, "/players/");
		if(!player.exists()){
			player.mkdirs();
		}
		config = new File(path, "scc.cfg");
		updatedata = getDataFromServer();
		UpdateHandler.initalize();
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
				wr.writeBytes("mode=requestdata&modid=scc");
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
			objj.addProperty("version", "1.10.2");
			objj.addProperty("latest_version", Config.version);
			objj.addProperty("latest_mc_version", "1.10.2");
			JsonArray array = new JsonArray();
			array.add(objj);
			obj.add("versions", array);
			return obj;
		}
	}

	public static Chunk getChunk(int x, int z) {
		for(Chunk chunk : chunks){
			if(chunk.x == x && chunk.z == z){
				return chunk;
			}
		}
		return null;
	}

	public static Chunk getChunk(World world, BlockPos pos) {
		net.minecraft.world.chunk.Chunk ck = world.getChunkFromBlockCoords(pos);
		return getChunk(ck.xPosition, ck.zPosition);
	}

	public static Player getPlayer(UUID id) {
		for(Player player : players){
			if(player.uuid.toString().equals(id.toString())){
				return player;
			}
		}
		return null;
	}
	
	
}