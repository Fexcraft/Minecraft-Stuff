package net.fexcraft.mod.nvr.server.data;

import java.sql.ResultSet;
import java.util.UUID;

import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.lang.ArrayList;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.nvr.server.NVR;

public class District {
	
	public final int id;
	public Type type;
	public String name;
	//TODO Municipality;
	public UUID manager, creator;
	public long created, changed;
	public ArrayList<Integer> neighbors = new ArrayList<Integer>();
	public double previncome, tax;
	
	public District(int id, UUID creatorid){
		this.id = id;
		try{
			ResultSet set = NVR.SQL.query("SELECT * FROM districts WHERE id='" + id + "';");
			if(set.first()){
				String temp = null;
				name = set.getString("name");
				manager = (temp = set.getString("manager")) == null || temp.equals("") ? null : UUID.fromString(temp);
				creator = UUID.fromString(set.getString("creator"));
				created = set.getLong("created");
				changed = set.getLong("changed");
				neighbors = JsonUtil.jsonArrayToIntegerArray(JsonUtil.getFromString(set.getString("neighbors")).getAsJsonArray());
				previncome = set.getDouble("prev_income");
				tax = set.getDouble("tax");
			}
			else{
				type = Type.UNSPECIFIED;
				name = "Unnamed District";
				manager = null;
				creator = creatorid == null ? UUID.fromString(NVR.DEF_UUID) : creatorid;
				created = Time.getDate();
				changed = Time.getDate();
				neighbors.clear();
				previncome = 0;
				tax = 0;
				NVR.SQL.update("INSERT INTO " + NVR.SQL.getDataBaseId() + ".districts (id) VALUES ('" + id + "');");
				NVR.SQL.update("districts", "name='" + name + "'", "id", id);
				NVR.SQL.update("districts", "manager='" + (manager == null ? "" : manager.toString()) + "'", "id", id);
				NVR.SQL.update("districts", "creator='" + creator.toString() + "'", "id", id);
				NVR.SQL.update("districts", "created='" + created + "'", "id", id);
				NVR.SQL.update("districts", "changed='" + changed + "'", "id", id);
				NVR.SQL.update("districts", "neighbors='" + JsonUtil.getArrayFromIntegerList(neighbors).toString() + "'", "id", id);
				NVR.SQL.update("districts", "prev_income='" + previncome + "'", "id", id);
				NVR.SQL.update("districts", "saved='" + Time.getDate() + "'", "id", id);
				NVR.SQL.update("districts", "tax='" + tax + "'", "id", id);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			Static.halt();
		}
	}
	
	public static final void log(District district, String string, UUID who, String data, long time){
		try{
			NVR.SQL.update("INSERT INTO " + NVR.SQL.getDataBaseId() + ".common_log (id, action, uuid, data, time) VALUES ("
					+ "'" + district.id + "',"
					+ "'" + string + "',"
					+ "'" + (who == null ? "" : who) + "',"
					+ "'" + data + "',"
					+ "'" + time + "'"
					+ ");");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void save(){
		try{
			NVR.SQL.update("UPDATE districts SET name='" + name + "', manager='" + (manager == null ? "" : manager.toString()) + "', creator='" + creator.toString() + "', changed='" + changed + "', neighbors='" + JsonUtil.getArrayFromIntegerList(neighbors).toString() + "', prev_income='" + previncome + "', saved='" + Time.getDate() + "', tax='" + tax + "' WHERE id='" + id + "';");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static enum Type {
		MIXED,
		CENTER,
		RESIDENTAL,
		COMMERCIAL,
		INDUSTRIAL,
		AGRICULTURAL,
		MINERAL,
		MILITARY,
		WASTELAND,
		UNSPECIFIED;
		
		public static Type fromString(String string){
			for(Type type : values()){
				if(type.name().equals(string)){
					return type;
				}
			}
			return WASTELAND;
		}
	}
	
}