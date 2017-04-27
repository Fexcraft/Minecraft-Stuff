package net.fexcraft.mod.fsu.server.modules.nrr.data;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fsu.server.modules.nrr.NRR;
import net.fexcraft.mod.lib.util.json.JsonUtil;

public class Nation implements DataObject {
	
	public int id;
	public String name;
	public ArrayList<UUID> goverment = new ArrayList<UUID>();
	public int color;
	public String hex = "#EDEDED";
	
	public Nation(int id){
		this.id = id;
		load(JsonUtil.get(getFile()));
		this.id = id;
	}
	
	public Nation(JsonObject obj){
		load(obj);
	}
	

	@Override
	public JsonObject save(){
		JsonObject obj = new JsonObject();
		obj.addProperty("id", id);
		obj.addProperty(hex, hex);
		obj.addProperty("name", name);
		obj.addProperty("color", color);
		obj.add("goverment", JsonUtil.getArrayFromUUIDList(goverment));
		
		
		return obj;
	}

	@Override
	public void load(JsonObject obj){
		id = JsonUtil.getIfExists(obj, "id", -100).intValue();
		hex = JsonUtil.getIfExists(obj, "hex", hex);
		name = JsonUtil.getIfExists(obj, "name", "Nameless Nation");
		color = JsonUtil.getIfExists(obj, "color", 2).intValue();
		if(obj.has("goverment")){
			goverment.clear();
			JsonArray array = obj.get("goverment").getAsJsonArray();
			for(JsonElement elm : array){
				try{
					goverment.add(UUID.fromString(elm.getAsString()));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		//
	}

	@Override
	public File getFile(){
		return NRR.getNationFile(id);
	}

	public String shortName(){
		return name.substring(0, 3);
	}
	
}