package net.fexcraft.mod.nvr.server.data;

import java.sql.ResultSet;
import java.util.UUID;

import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.lang.ArrayList;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.nvr.server.NVR;

public class Chunk {
	
	public int x, z;
	public Type type;
	public UUID claimer, owner;
	public long claimed, changed;
	public ArrayList<String> whitelist = new ArrayList<String>();
	public ArrayList<DoubleKey> linked = new ArrayList<DoubleKey>();
	public double tax;
	//TODO district
	
	public Chunk(int x, int z, UUID claim){
		this.x = x; this.z = z;
		try{
			ResultSet set = NVR.SQL.query("SELECT * FROM chunks WHERE x='" + x + "' AND z='" + z + "';");
			if(set.first()){
				type = Type.fromString(set.getString("type"));
				claimer = UUID.fromString(set.getString("claimer"));
				owner = set.getString("owner") == null ? null : UUID.fromString(set.getString("owner"));
				claimed = set.getLong("claimed");
				changed = set.getLong("changed");
				whitelist = JsonUtil.jsonArrayToStringArray(JsonUtil.getFromString(set.getString("whitelist")).getAsJsonArray());
				linked = DoubleKey.getFromStringJsonArray(JsonUtil.jsonArrayToStringArray(JsonUtil.getFromString(set.getString("linked")).getAsJsonArray()));
				tax = set.getDouble("tax");
			}
			else{
				//Create;
				type = Type.NEUTRAL;
				claimer = claim == null ? UUID.fromString(NVR.DEF_UUID) : claim;
				owner = null;
				claimed = Time.getDate();
				changed = Time.getDate();
				whitelist.clear();
				linked.clear();
				tax = 0.0f;
				NVR.SQL.update("INSERT INTO " + NVR.SQL.getDataBaseId() + ".chunks (x, z, type, claimer, owner, claimed, changed, whitelist, linked, saved, tax) VALUES ("
						+ "'" + x + "',"
						+ "'" + z + "',"
						+ "'" + type.name() + "',"
						+ "'" + claimer + "',"
						+ "'" + (owner == null ? "" : owner.toString()) + "',"
						+ "'" + claimed + "',"
						+ "'" + changed + "',"
						+ "'" + JsonUtil.getArrayFromStringList(whitelist).toString() + "',"
						+ "'" + JsonUtil.getArrayFromObjectList(linked).toString() + "',"
						+ "'" + Time.getDate() + "',"
						+ "'" + tax + "'"
						+ ");");
				log(this, "created", claim, "", Time.getDate());
			}
		}
		catch(Exception e){
			e.printStackTrace();
			Static.halt();
		}
	}
	
	private void log(Chunk chunk, String string, UUID claim, String data, long date){
		try{
			NVR.SQL.update("INSERT INTO " + NVR.SQL.getDataBaseId() + ".chunk_log (x, z, action, uuid, data, time) VALUES ("
					+ "'" + chunk.x + "',"
					+ "'" + chunk.z + "',"
					+ "'" + string + "',"
					+ "'" + (claim == null ? "" : claim) + "',"
					+ "'" + data + "',"
					+ "'" + date + "'"
					+ ");");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public final void save(){
		try{
			NVR.SQL.update("UPDATE chunks SET type='" + type.name() + "', claimer='" + claimer.toString() + "', owner='" + (owner == null ? "" : owner.toString()) + "', changed='" + changed + "', whitelist='" + JsonUtil.getArrayFromStringList(whitelist) + "', linked='" + JsonUtil.getArrayFromObjectList(linked) + "', saved='" + Time.getDate() + "', tax='" + tax + "' WHERE x = `" + x + "` AND z = `" + z + "`;");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static enum Type {
		PUBLIC,//anyone
		NEUTRAL,//unclaimed
		CLAIMED,//citizen only
		PRIVATE,//owner/s only
		COMPANY,//company only
		PROTECTED;//manager and up only
		
		public static Type fromString(String string){
			for(Type type : values()){
				if(type.name().equals(string)){
					return type;
				}
			}
			return NEUTRAL;
		}
	}
	
}