package net.fexcraft.mod.nvr.server.data;

import java.sql.ResultSet;
import java.util.UUID;

import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.lang.ArrayList;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.nvr.server.NVR;

public class Province {
	
	public final int id;
	public String name, icon;
	public Nation nation;
	public UUID ruler;
	public UUID creator;
	public long created, changed;
	public double previncome;
	public ArrayList<Integer> neighbors = new ArrayList<Integer>();
	public ArrayList<UUID> rebels = new ArrayList<UUID>();
	public ArrayList<UUID> sepers = new ArrayList<UUID>();
	//public ArrayList<Integer> districts = new ArrayList<Integer>();
	
	public Province(int id, UUID creatorid){
		this.id = id;
		try{
			ResultSet set = NVR.SQL.query("SELECT * FROM provinces WHERE id='" + id + "';");
			if(set.first()){
				String str = null;
				name = set.getString("name");
				nation = NVR.NATIONS.get(set.getInt("nation"));
				ruler = (str = set.getString("ruler")) == null || str.equals("") ? null : UUID.fromString(str);
				creator = UUID.fromString(set.getString("creator"));
				created = set.getLong("created");
				changed = set.getLong("changed");
				previncome = set.getDouble("prev_income");
				neighbors = JsonUtil.jsonArrayToIntegerArray(JsonUtil.getFromString(set.getString("neighbors")).getAsJsonArray());
				rebels = JsonUtil.jsonArrayToUUIDArray(JsonUtil.getFromString(set.getString("rebels")).getAsJsonArray());
				sepers = JsonUtil.jsonArrayToUUIDArray(JsonUtil.getFromString(set.getString("sepers")).getAsJsonArray());
				icon = (str = set.getString("icon")) == null || str.equals("") ? null : icon;
			}
			else{
				name = "Unnamed Province";
				nation = NVR.NATIONS.get(-1);
				ruler = null;
				creator = creatorid == null ? UUID.fromString(NVR.DEF_UUID) : creatorid;
				created = Time.getDate();
				changed = Time.getDate();
				previncome = 0;
				neighbors.clear();
				rebels.clear();
				sepers.clear();
				icon = null;
				//
				NVR.SQL.update("INSERT INTO " + NVR.SQL.getDataBaseId() + ".provinces (id) VALUES ('" + id + "');");
				NVR.SQL.update("provinces", "creator", creator, "id", id);
				NVR.SQL.update("provinces", "created", created, "id", id);
				save();
				log(this, "created", creator, "", Time.getDate());
			}
		}
		catch(Exception e){
			e.printStackTrace();
			Static.halt();
		}
	}
	
	public static final void log(Province province, String string, UUID who, String data, long time){
		try{
			NVR.SQL.update("INSERT INTO " + NVR.SQL.getDataBaseId() + ".province_log (id, action, uuid, data, time) VALUES ("
					+ "'" + province.id + "',"
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
			String p = "provinces";
			NVR.SQL.update(p, "name", name, "id", id);
			NVR.SQL.update(p, "nation", nation.id, "id", id);
			NVR.SQL.update(p, "ruler", ruler == null ? "" : ruler, "id", id);
			NVR.SQL.update(p, "changed", changed, "id", id);
			NVR.SQL.update(p, "prev_income", previncome, "id", id);
			NVR.SQL.update(p, "neighbors", JsonUtil.getArrayFromIntegerList(neighbors), "id", id);
			NVR.SQL.update(p, "rebels", JsonUtil.getArrayFromUUIDList(rebels), "id", id);
			NVR.SQL.update(p, "sepers", JsonUtil.getArrayFromUUIDList(sepers), "id", id);
			NVR.SQL.update(p, "saved", Time.getDate(), "id", id);
			NVR.SQL.update(p, "icon", icon == null ? "" : icon, "id", id);
		}
		catch(Exception e){
			e.printStackTrace();
			Static.halt();
		}
	}
	
}