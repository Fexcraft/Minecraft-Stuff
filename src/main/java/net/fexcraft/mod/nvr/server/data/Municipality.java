package net.fexcraft.mod.nvr.server.data;

import java.sql.ResultSet;
import java.util.UUID;

import net.fexcraft.mod.fsmm.account.AccountManager.Account;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.lang.ArrayList;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.nvr.server.NVR;

public class Municipality {
	
	public final int id;
	public String name;
	public Type type;
	public Province province;
	public ArrayList<UUID> management = new ArrayList<UUID>();
	public ArrayList<Integer> neighbors = new ArrayList<Integer>();
	public UUID creator;
	public long created;
	public long changed;
	public double previncome;
	public ArrayList<UUID> citizens = new ArrayList<UUID>();
	public double citizentax;
	public Account account;
	
	public Municipality(int id, UUID creatorid){
		this.id = id;
		this.account = Account.getAccountManager().getAccountOf("municipality", "municipality:" + id);
		try{
			ResultSet set = NVR.SQL.query("SELECT * FROM municipalities WHERE id='" + id + "';");
			if(set.first()){
				name = set.getString("name");
				type = Type.fromString(set.getString("type"));
				province = NVR.getProvince(set.getInt("province"));
				management = JsonUtil.jsonArrayToUUIDArray(JsonUtil.getFromString(set.getString("management")).getAsJsonArray());
				neighbors = JsonUtil.jsonArrayToIntegerArray(JsonUtil.getFromString(set.getString("neighbors")).getAsJsonArray());
				creator = UUID.fromString(set.getString("creator"));
				created = set.getLong("created");
				changed = set.getLong("changed");
				previncome = set.getDouble("prev_income");
				citizens = JsonUtil.jsonArrayToUUIDArray(JsonUtil.getFromString(set.getString("citizens")).getAsJsonArray());
				citizentax = set.getDouble("citizentax");
			}
			else {
				name = "Unnamed Place";
				type = Type.ABANDONED;
				province = NVR.getProvince(-1);
				management.clear();
				neighbors.clear();
				creator = creatorid == null ? UUID.fromString(NVR.DEF_UUID) : creatorid;
				created = Time.getDate();
				changed = Time.getDate();
				previncome = 0;
				citizens.clear();
				citizentax = 1;
				NVR.SQL.update("INSERT INTO " + NVR.SQL.getDataBaseId() + ".municipalities (id) VALUES ('" + id + "');");
				NVR.SQL.update("municipalities", "creator", creator, "id", id);
				NVR.SQL.update("municipalities", "created", created, "id", id);
				save();
				log(this, "created", creator, "", Time.getDate());
			}
		}
		catch(Exception e){
			e.printStackTrace();
			Static.halt();
		}
	}
	
	public static final void log(Municipality municipality, String string, UUID who, String data, long time){
		try{
			NVR.SQL.update("INSERT INTO " + NVR.SQL.getDataBaseId() + ".municipality_log (id, action, uuid, data, time) VALUES ("
					+ "'" + municipality.id + "',"
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
	
	public final void save(){
		account.getAccountManager().saveAccount(account);
		try{
			String m = "municipalities";
			NVR.SQL.update(m, "name", name, "id", id);
			NVR.SQL.update(m, "type", type.name(), "id", id);
			NVR.SQL.update(m, "province", province.id, "id", id);
			NVR.SQL.update(m, "management", JsonUtil.getArrayFromUUIDList(management), "id", id);
			NVR.SQL.update(m, "neighbors", JsonUtil.getArrayFromIntegerList(neighbors), "id", id);
			NVR.SQL.update(m, "changed", changed, "id", id);
			NVR.SQL.update(m, "prev_income", previncome, "id", id);
			NVR.SQL.update(m, "citizens", JsonUtil.getArrayFromUUIDList(citizens), "id", id);
			NVR.SQL.update(m, "citizentax", citizentax, "id", id);
			NVR.SQL.update(m, "saved", Time.getDate(), "id", id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static enum Type {
		
		HAMLET    (  0,  3, "Hamlet"),
		VILLAGE   (  8,  4, "Village"),
		SMALL_TOWN( 16,  8, "Small Town"),
		TOWN      ( 24, 12, "Town"),
		LARGE_TOWN( 32, 16, "Large Town"),
		CITY      ( 40, 20, "City"),
		LARGE_CITY( 60, 28, "Large City"),
		METROPOLIS(120, 36, "Metropolis"),
		TOO_LARGE (160, 50, "TOO LARGE OF A CITY"),
		INVALID   (  0,  0, "Invalid"),
		ABANDONED (  0,  0, "(Abandoned)");
		
		private int req;//required citizen to expand district amount
		private int dis;//district limit
		private String title;
		
		Type(int i, int j, String name){
			req = i; dis = j;
			this.title = name;
		}
		
		public static Type fromString(String string){
			Type type = valueOf(string);
			return type == null ? INVALID : type;
		}
		
	}
	
}