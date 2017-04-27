package net.fexcraft.mod.fsu.server.modules.nrr.data;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fsu.server.modules.nrr.NRR;
import net.fexcraft.mod.lib.util.json.JsonUtil;

public class Province implements DataObject {
	
	public int id;
	public String name, mainbiome;
	public Region region;
	public ArrayList<UUID> leadership = new ArrayList<UUID>();
	public ArrayList<UUID> whitelist = new ArrayList<UUID>();
	public ArrayList<Integer> neighbors = new ArrayList<Integer>();
	public String hex = "#EDEDED";
	
	public Province(int id){
		this.id = id;
		load(JsonUtil.get(getFile()));
		this.id = id;
	}
	
	public Province(JsonObject obj){
		load(obj);
	}

	@Override
	public JsonObject save(){
		JsonObject obj = new JsonObject();
		obj.addProperty("id", id);
		obj.addProperty("name", name);
		obj.addProperty("mainbiome", mainbiome);
		obj.addProperty("region", region.id);
		obj.addProperty("hex", hex);
		obj.add("leadership", JsonUtil.getArrayFromUUIDList(leadership));
		obj.add("whitelist", JsonUtil.getArrayFromUUIDList(whitelist));
		obj.add("neighbors", JsonUtil.getArrayFromIntegerList(neighbors));
		return obj;
	}

	@Override
	public void load(JsonObject obj){
		id = JsonUtil.getIfExists(obj, "id", -100).intValue();
		name = JsonUtil.getIfExists(obj, "name", "Nameless Province");
		mainbiome = JsonUtil.getIfExists(obj, "mainbiome", "Plains");
		region = NRR.regions.get(JsonUtil.getIfExists(obj, "region", -1).intValue());
		hex = JsonUtil.getIfExists(obj, "hex", hex);
		if(obj.has("leadership")){
			leadership.clear();
			JsonArray array = obj.get("leadership").getAsJsonArray();
			for(JsonElement elm : array){
				try{
					leadership.add(UUID.fromString(elm.getAsString()));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		if(obj.has("whitelist")){
			whitelist.clear();
			JsonArray array = obj.get("whitelist").getAsJsonArray();
			for(JsonElement elm : array){
				try{
					whitelist.add(UUID.fromString(elm.getAsString()));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		if(obj.has("neighbors")){
			neighbors = JsonUtil.jsonArrayToIntegerArray(obj.get("neighbors").getAsJsonArray());
		}
		//
	}

	@Override
	public File getFile(){
		return NRR.getProvinceFile(id);
	}

	public String shortName(){
		return name.substring(0, 3);
	}

	public boolean isAbandoned(){
		return !(leadership.size() > 0);
	}

	public boolean isLeader(UUID id){
		for(UUID uuid : leadership){
			if(uuid.toString().equals(id.toString())){
				return true;
			}
		}
		return false;
	}

	public boolean isWhitelisted(UUID id){
		for(UUID uuid : whitelist){
			if(uuid.toString().equals(id.toString())){
				return true;
			}
		}
		return false;
	}
	
}