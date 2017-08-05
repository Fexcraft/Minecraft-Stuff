package net.fexcraft.mod.fsu.server.modules.nrr.data;

import java.io.File;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fsu.server.modules.nrr.NRR;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.lang.ArrayList;

public class Region implements DataObject {
	
	public int id;
	public String name;
	public Nation nation;
	public ArrayList<UUID> rulership = new ArrayList<UUID>();
	public String hex = "#EDEDED";
	
	public Region(int id){
		this.id = id;
		load(JsonUtil.get(getFile()));
		this.id = id;
	}
	
	public Region(JsonObject obj){
		load(obj);
	}
	

	@Override
	public JsonObject save(){
		JsonObject obj = new JsonObject();
		obj.addProperty("id", id);
		obj.addProperty("hex", hex);
		obj.addProperty("name", name);
		obj.addProperty("nation", nation.id);
		obj.add("rulership", JsonUtil.getArrayFromUUIDList(rulership));
		return obj;
	}

	@Override
	public void load(JsonObject obj){
		id = JsonUtil.getIfExists(obj, "id", -100).intValue();
		name = JsonUtil.getIfExists(obj, "name", "Nameless Region");
		nation = NRR.nations.get(JsonUtil.getIfExists(obj, "nation", -1).intValue());
		hex = JsonUtil.getIfExists(obj, "hex", hex);
		if(obj.has("rulership")){
			rulership.clear();
			JsonArray array = obj.get("rulership").getAsJsonArray();
			for(JsonElement elm : array){
				try{
					rulership.add(UUID.fromString(elm.getAsString()));
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
		return NRR.getRegionFile(id);
	}

	public String shortName(){
		return name.substring(0, 3);
	}
	
}