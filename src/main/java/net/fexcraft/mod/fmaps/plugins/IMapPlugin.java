package net.fexcraft.mod.fmaps.plugins;

import com.google.gson.JsonObject;

public interface IMapPlugin {
	
	public String getName();
	
	public String getId();

	public default JsonObject toJsonObject(){
		JsonObject obj = new JsonObject();
		obj.addProperty("name", this.getName());
		obj.addProperty("id", this.getId());
		return obj;
	}
	
}