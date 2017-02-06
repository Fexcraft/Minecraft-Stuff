package net.fexcraft.mod.sm.scc.util;

import java.util.UUID;

import com.google.gson.JsonObject;

public class Player {
	
	private JsonObject object;
	public UUID uuid;
	public int chunks;
	
	public Player(UUID id){
		uuid = id;
		object = Util.getObject(uuid);
		if(object.has("uuid")){
			load();
		}
		else{
			object.addProperty("uuid", uuid.toString());
			object.addProperty("owned_chunks", 0);
			chunks = 0;
		}
	}
	
	public void load(){
		chunks = object.get("owned_chunks").getAsInt();
	}
	
	public void save(){
		object.addProperty("uuid", uuid.toString());
		object.addProperty("owned_chunks", chunks);
		Util.writeJson(uuid, object);
	}
	
}