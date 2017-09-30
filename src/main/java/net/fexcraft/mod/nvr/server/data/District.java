package net.fexcraft.mod.nvr.server.data;

import java.io.File;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.lang.ArrayList;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.nvr.common.enums.DistrictType;
import net.fexcraft.mod.nvr.server.NVR;

public class District {
	
	public int id;
	public DistrictType type;
	public String name, colour;
	public Municipality municipality;
	public UUID manager, creator;
	public long created, changed;
	public ArrayList<Integer> neighbors = new ArrayList<Integer>();
	public double previncome, tax;
	
	public District(){}
	
	public static final District load(JsonObject obj){
		if(obj == null || !obj.has("id")){
			return null;
		}
		District dis = new District();
		//
		dis.id = JsonUtil.getIfExists(obj, "id", -100).intValue();
		dis.type = DistrictType.fromString(JsonUtil.getIfExists(obj, "type", DistrictType.UNSPECIFIED.name()));
		dis.name = JsonUtil.getIfExists(obj, "name", "Unnamed District");
		dis.municipality = NVR.getMunicipality(JsonUtil.getIfExists(obj, "municipality", -1).intValue());
		dis.manager = obj.has("manager") && !obj.get("manager").getAsString().equals("") ? UUID.fromString(JsonUtil.getIfExists(obj, "manager", NVR.DEF_UUID)) : null;
		dis.creator = UUID.fromString(JsonUtil.getIfExists(obj, "creator", NVR.DEF_UUID));
		dis.created = JsonUtil.getIfExists(obj, "created", 0).longValue();
		dis.changed = JsonUtil.getIfExists(obj, "changed", 0).longValue();
		dis.neighbors = JsonUtil.jsonArrayToIntegerArray(JsonUtil.getIfExists(obj, "neighbors", new JsonArray()).getAsJsonArray());
		dis.previncome = JsonUtil.getIfExists(obj, "previncome", 0).doubleValue();
		dis.tax = JsonUtil.getIfExists(obj, "tax", 0).doubleValue();
		dis.colour = JsonUtil.getIfExists(obj, "color", "#f0f0f0");
		//
		return dis;
	}
	
	public static final File getFile(int id){
		return new File(NVR.DISTRICT_DIR, id + ".json");
	}

	public void save(){
		try{
			JsonObject obj = new JsonObject();
			obj.addProperty("type", type.name());
			obj.addProperty("name", name);
			obj.addProperty("municipality", municipality.id);
			obj.addProperty("manager", manager == null ? "" : manager.toString());
			obj.addProperty("creator", creator.toString());
			obj.addProperty("created", created);
			obj.addProperty("changed", changed);
			obj.add("neighbors", JsonUtil.getArrayFromIntegerList(neighbors));
			obj.addProperty("previncome", previncome);
			obj.addProperty("tax", tax);
			obj.addProperty("color", colour);
			//
			obj.addProperty("last_save", Time.getDate());
			JsonUtil.write(getFile(id), obj);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}