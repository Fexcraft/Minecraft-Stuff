package net.fexcraft.mod.nvr.server.data;

import java.io.File;
import java.util.List;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.lang.ArrayList;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.nvr.server.NVR;
import scala.actors.threadpool.Arrays;

public class Province {
	
	public int id;
	public String name, icon, colour;
	public Nation nation;
	public UUID ruler;
	public UUID creator;
	public long created, changed;
	public double previncome;
	public ArrayList<Integer> neighbors = new ArrayList<Integer>();
	public ArrayList<UUID> rebels = new ArrayList<UUID>();
	public ArrayList<UUID> sepers = new ArrayList<UUID>();
	//public ArrayList<Integer> districts = new ArrayList<Integer>();
	public String ruler_title;
	
	public Province(){}
	
	public static final Province load(JsonObject obj){
		if(obj == null || !obj.has("id")){
			return null;
		}
		Province prov = new Province();
		prov.id = obj.get("id").getAsInt();
		prov.name = JsonUtil.getIfExists(obj, "name", "Unnamed Province");
		prov.icon = JsonUtil.getIfExists(obj, "icon", "");
		prov.nation = NVR.getNation(JsonUtil.getIfExists(obj, "nation", -1).intValue());
		prov.ruler = obj.has("ruler") && !obj.get("ruler").getAsString().equals("") ? UUID.fromString(JsonUtil.getIfExists(obj, "ruler", NVR.DEF_UUID)) : null;
		prov.creator = UUID.fromString(JsonUtil.getIfExists(obj, "creator", NVR.DEF_UUID));
		prov.created = JsonUtil.getIfExists(obj, "created", 0).longValue();
		prov.changed = JsonUtil.getIfExists(obj, "changed", 0).longValue();
		prov.previncome = JsonUtil.getIfExists(obj, "previncome", 0).doubleValue();
		prov.neighbors = JsonUtil.jsonArrayToIntegerArray(JsonUtil.getIfExists(obj, "neighbors", new JsonArray()).getAsJsonArray());
		prov.rebels = JsonUtil.jsonArrayToUUIDArray(JsonUtil.getIfExists(obj, "rebels", new JsonArray()).getAsJsonArray());
		prov.sepers = JsonUtil.jsonArrayToUUIDArray(JsonUtil.getIfExists(obj, "sepers", new JsonArray()).getAsJsonArray());
		prov.ruler_title = JsonUtil.getIfExists(obj, "ruler_title", "Landlord");
		prov.colour = JsonUtil.getIfExists(obj, "color", "#f0f0f0");
		return prov;
	}
	
	public static final File getFile(int id){
		return new File(NVR.PROVINCE_DIR, id + ".json");
	}

	public void save(){
		try{
			JsonObject obj = new JsonObject();
			obj.addProperty("id", id);
			obj.addProperty("name", name);
			obj.addProperty("icon", icon == null ? "" : icon);
			obj.addProperty("nation", nation.id);
			obj.addProperty("ruler", ruler == null ? "" : ruler.toString());
			obj.addProperty("creator", creator.toString());
			obj.addProperty("created", created);
			obj.addProperty("changed", changed);
			obj.addProperty("previncome", previncome);
			obj.add("neighbors", JsonUtil.getArrayFromIntegerList(neighbors));
			obj.add("rebels", JsonUtil.getArrayFromUUIDList(rebels));
			obj.add("sepers", JsonUtil.getArrayFromUUIDList(sepers));
			obj.addProperty("ruler_title", ruler_title);
			obj.addProperty("color", colour);
			//
			obj.addProperty("last_save", Time.getDate());
			JsonUtil.write(getFile(id), obj);
		}
		catch(Exception e){
			e.printStackTrace();
			Static.halt();
		}
	}

	public float rebelper100(){
		int[] citizen = new int[]{0};
		List<Municipality> list = Arrays.asList(NVR.MUNICIPALITIES.values().stream().filter((pre) -> pre.province.id == this.id).toArray());
		list.forEach((mun) -> citizen[0] += mun.citizens.size());
		return citizen[0] == 0 ? 0 : (rebels.size() / citizen[0]) * 100;
	}

	public float seperper100(){
		int[] citizen = new int[]{0};
		List<Municipality> list = Arrays.asList(NVR.MUNICIPALITIES.values().stream().filter((pre) -> pre.province.id == this.id).toArray());
		list.forEach((mun) -> citizen[0] += mun.citizens.size());
		return citizen[0] == 0 ? 0 : (sepers.size() / citizen[0]) * 100;
	}
	
}