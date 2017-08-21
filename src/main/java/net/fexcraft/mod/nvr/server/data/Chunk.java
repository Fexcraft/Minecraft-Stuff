package net.fexcraft.mod.nvr.server.data;

import java.sql.ResultSet;
import java.util.UUID;

import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.lang.ArrayList;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.nvr.server.NVR;

public class Chunk {
	
	public final int x, z;
	public Type type;
	public District district;
	public UUID claimer, owner;
	public long claimed, changed;
	public ArrayList<String> whitelist = new ArrayList<String>();
	public ArrayList<DoubleKey> linked = new ArrayList<DoubleKey>();
	public double tax;
	
	public Chunk(int x, int z, UUID claim){
		this.x = x; this.z = z;
		try{
			ResultSet set = NVR.SQL.query("SELECT * FROM chunks WHERE x='" + x + "' AND z='" + z + "';");
			if(set.first()){
				String temp = null;
				type = Type.fromString(set.getString("type"));
				district = NVR.getDistrict(set.getInt("district"));
				claimer = UUID.fromString(set.getString("claimer"));
				owner = (temp = set.getString("owner")) == null || temp.equals("") ? null : UUID.fromString(temp);
				claimed = set.getLong("claimed");
				changed = set.getLong("changed");
				whitelist = JsonUtil.jsonArrayToStringArray(JsonUtil.getFromString(set.getString("whitelist")).getAsJsonArray());
				linked = DoubleKey.getFromStringJsonArray(JsonUtil.jsonArrayToStringArray(JsonUtil.getFromString(set.getString("linked")).getAsJsonArray()));
				tax = set.getDouble("tax");
			}
			else{
				//Create;
				type = Type.NEUTRAL;
				district = NVR.getDistrict(-1);
				claimer = claim == null ? UUID.fromString(NVR.DEF_UUID) : claim;
				owner = null;
				claimed = Time.getDate();
				changed = Time.getDate();
				whitelist.clear();
				linked.clear();
				tax = 0.0f;
				NVR.SQL.update("INSERT INTO " + NVR.SQL.getDataBaseId() + ".chunks (x, z, type, district, claimer, owner, claimed, changed, whitelist, linked, saved, tax) VALUES ("
						+ "'" + x + "',"
						+ "'" + z + "',"
						+ "'" + type.name() + "',"
						+ "'" + district.id + "',"
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
	
	private static final void log(Chunk chunk, String string, UUID claim, String data, long date){
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
			NVR.SQL.update("UPDATE chunks SET type='" + type.name() + "', district='" + district.id + "', claimer='" + claimer.toString() + "', owner='" + (owner == null ? "" : owner.toString()) + "', changed='" + changed + "', whitelist='" + JsonUtil.getArrayFromStringList(whitelist).toString() + "', linked='" + JsonUtil.getArrayFromObjectList(linked).toString() + "', saved='" + Time.getDate() + "', tax='" + tax + "' WHERE x = '" + x + "' AND z = '" + z + "';");
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