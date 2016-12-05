/**
 * THIS FILE IS PART OF 'SCC' Simple Chunk Control
 *  © Fexcraft.net
 *  
 *  @author Ferdinand (FEX___96)
 */
package net.fexcraft.mod.sm.scc.util;

import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Chunk {
	
	private JsonObject object;
	public int x;
	public int z;
	public JsonArray whitelist;
	public boolean hasOwner;
	public UUID owner;
	public long claimed;
	
	public Chunk(int x, int z){
		object = Util.getObject(x, z);
		this.x = x;
		this.z = z;
		if(object.has("x") && object.has("z")){
			load();
		}
		else{
			object.addProperty("x", x);
			object.addProperty("z", z);
			object.add("whitelist", new JsonArray());
			object.addProperty("hasOwner", false);
			owner = UUID.fromString("00000000-0000-0000-0000-000000000000");
			claimed = 0;
			
			whitelist = new JsonArray();
			hasOwner = false;
		}
	}
	
	public void load(){
		x = object.get("x").getAsInt();
		z = object.get("z").getAsInt();
		whitelist = object.get("whitelist").getAsJsonArray();
		hasOwner = object.get("hasOwner").getAsBoolean();
		owner = UUID.fromString(object.get("owner").getAsString());
		claimed = object.get("claimed").getAsLong();
	}
	
	public void save(){
		object.addProperty("x", x);
		object.addProperty("z", z);
		object.add("whitelist", whitelist);
		object.addProperty("hasOwner", hasOwner);
		object.addProperty("owner", owner.toString());
		object.addProperty("claimed", claimed);
		Util.writeJson(object);
	}

	public boolean isWhitelisted(UUID uuid){
		String id = uuid.toString();
		for(JsonElement elm : whitelist){
			if(elm.getAsString().equals(id)){
				return true;
			}
		}
		return false;
	}

	public JsonElement getObject(){
		return object;
	}
	
}