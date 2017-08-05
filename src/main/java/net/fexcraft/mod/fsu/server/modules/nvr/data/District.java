package net.fexcraft.mod.fsu.server.modules.nvr.data;

import java.sql.ResultSet;
import java.util.UUID;

import net.fexcraft.mod.fsu.server.modules.nvr.NVR;
import net.fexcraft.mod.lib.util.common.Sql;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.lang.ArrayList;

public class District {

	public final int id;
	public String name;
	public Municipality municipality;
	public UUID manager, creator;
	public long created = 0, lastchange = 0;
	public Type type;
	public ArrayList<Integer> neighbors;
	public float lastincome;
	
	public District(int id){
		this.id = id;
		try{
			ResultSet set = NVR.SQL.query("SELECT * FROM districts WHERE id='" + id + "';");
			if(set.first()){
				this.name = set.getString("name");
				this.municipality = NVR.municipalities.get(set.getInt("municipality"));
				this.manager = UUID.fromString(set.getString("manager"));
				this.creator = UUID.fromString(set.getString("creator"));
				this.created = set.getLong("created");
				this.lastchange = set.getLong("lastchange");
				this.type = Type.fromString(set.getString("type"));
				this.neighbors = JsonUtil.jsonArrayToIntegerArray(JsonUtil.getFromString(set.getString("neighbors")).getAsJsonArray());
				this.lastincome = set.getFloat("lastincome");
			}
			else{
				throw new Exception();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void save(Sql sql){
		try{
			sql.update("districts", "name='" + name + "'", "id", id);
			sql.update("districts", "municipality='" + municipality.id + "'", "id", id);
			sql.update("districts", "manager='" + manager.toString() + "'", "id", id);
			sql.update("districts", "lastchange='" + lastchange + "'", "id", id);
			sql.update("districts", "type='" + type.name() + "'", "id", id);
			sql.update("districts", "neighbors='" + JsonUtil.getArrayFromIntegerList(neighbors).toString() + "'", "id", id);
			sql.update("districts", "lastincome='" + lastincome + "'", "id", id);
			//NVR.SQL.update("UPDATE districts SET name='" + name + "', municipality='" + municipality.id + "', manager='" + manager + "', lastchange='" + lastchange + "', type='" + type.name() + "', neighbors='" + JsonUtil.getArrayFromIntegerList(neighbors).toString() + "', lastincome='" + lastincome + "' WHERE id='" + id + "';");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static enum Type {
		MIXED,
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
