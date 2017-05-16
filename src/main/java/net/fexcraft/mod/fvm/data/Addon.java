package net.fexcraft.mod.fvm.data;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;

public class Addon {
	
	public File file;
	public String id, name;
	public ArrayList<String> dependencies;
	public ArrayList<UUID> authors;
	public boolean enabled;
	
	public Addon(JsonObject obj, File file){
		this.file = file;
		try{
			this.id = obj.get("id").getAsString();
		}
		catch(Exception e){
			e.printStackTrace();
			Static.halt();
		}
		this.name = JsonUtil.getIfExists(obj, "name", "Name Missing.");
		if(obj.has("dependencies")){
			this.dependencies = JsonUtil.jsonArrayToStringArray(obj.get("dependencies").getAsJsonArray());
		}
		if(obj.has("authors")){
			JsonArray array = obj.get("authors").getAsJsonArray();
			for(JsonElement elm : array){
				try{
					authors.add(UUID.fromString(elm.getAsString()));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
}