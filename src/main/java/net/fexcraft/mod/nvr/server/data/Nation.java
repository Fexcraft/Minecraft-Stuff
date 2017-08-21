package net.fexcraft.mod.nvr.server.data;

import java.sql.ResultSet;
import java.util.UUID;

import net.fexcraft.mod.fsmm.account.AccountManager.Account;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.lang.ArrayList;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.nvr.server.NVR;

public class Nation {
	
	public final int id;
	public String name;
	public Type type;
	public ArrayList<UUID> gov = new ArrayList<UUID>();
	public String gov_title, gov_name;
	public UUID incharge;
	public String incharge_title;
	public UUID creator;
	public long created, changed;
	public double prev_income;
	public ArrayList<Integer> neighbors = new ArrayList<Integer>();
	public Account account;
	public Nation parent;
	
	public Nation(int id, UUID creatorid){
		this.id = id;
		account = Account.getAccountManager().getAccountOf("nation", "nation:" + id);
		try{
			ResultSet set = NVR.SQL.query("SELECT * FROM nations WHERE id='" + id + "';");
			if(set.first()){
				String str = null;
				int i = -1;
				name = set.getString("name");
				type = Type.fromString(set.getString("type"));
				gov = JsonUtil.jsonArrayToUUIDArray(JsonUtil.getFromString(set.getString("gov")).getAsJsonArray());
				gov_title = set.getString("gov_title");
				gov_name = set.getString("gov_name");
				incharge = (str = set.getString("incharge")) == null || str.equals("") ? null : UUID.fromString(str);
				incharge_title = set.getString("incharge_title");
				creator = UUID.fromString("creator");
				created = set.getLong("created");
				changed = set.getLong("changed");
				prev_income = set.getDouble("prev_income");
				neighbors = JsonUtil.jsonArrayToIntegerArray(JsonUtil.getFromString(set.getString("neighbors")).getAsJsonArray());
				parent = (i = set.getInt("parent")) == -10 ? null : NVR.getNation(i);
			}
			else{
				name = "Unnamed Nation";
				type = Type.ANARCHY;
				gov.clear();
				gov_title = "Finest Anarchy";
				gov_name = "Anarchist";
				incharge = creatorid == null ? UUID.fromString(NVR.DEF_UUID) : creatorid;
				incharge_title = "Leader";
				creator = creatorid == null ? UUID.fromString(NVR.DEF_UUID) : creatorid;
				created = Time.getDate();
				changed = Time.getDate();
				prev_income = 0;
				neighbors.clear();
				parent = null;
				NVR.SQL.update("INSERT INTO " + NVR.SQL.getDataBaseId() + ".nations (id) VALUES ('" + id + "');");
				NVR.SQL.update("nations", "creator", creator, "id", id);
				NVR.SQL.update("nations", "created", created, "id", id);
				save();
				log(this, "created", creator, "", Time.getDate());
			}
		}
		catch(Exception e){
			e.printStackTrace();
			Static.halt();
		}
	}
	
	public static final void log(Nation nation, String string, UUID who, String data, long time){
		try{
			NVR.SQL.update("INSERT INTO " + NVR.SQL.getDataBaseId() + ".nation_log (id, action, uuid, data, time) VALUES ("
					+ "'" + nation.id + "',"
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
		Account.getAccountManager().saveAccount(account);
		try{
			String n = "nations";
			NVR.SQL.update(n, "name", name, "id", id);
			NVR.SQL.update(n, "type", type.name(), "id", id);
			NVR.SQL.update(n, "gov", JsonUtil.getArrayFromUUIDList(gov), "id", id);
			NVR.SQL.update(n, "gov_title", gov_title, "id", id);
			NVR.SQL.update(n, "gov_name", gov_name, "id", id);
			NVR.SQL.update(n, "incharge", incharge, "id", id);
			NVR.SQL.update(n, "incharge_title", incharge_title, "id", id);
			NVR.SQL.update(n, "changed", changed, "id", id);
			NVR.SQL.update(n, "prev_income", prev_income, "id", id);
			NVR.SQL.update(n, "neighbors", JsonUtil.getArrayFromIntegerList(neighbors), "id", id);
			NVR.SQL.update(n, "parent", parent == null ? "" : parent.id, "id", id);
			NVR.SQL.update(n, "saved", Time.getDate(), "id", id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static enum Type {
		
		MONARCHY (true , false),//current ruler selects next ruler, sets goverment positions, no voting
		DEMOCRACY(false, true ),//all important things need to get a vote from majority of the goverment, where the current ruler suggest stuff, goverment selected via vote
		AUTOCRACY(true , true ),//hybrid of the 2 above
		ANARCHY  (false, false);//any one rules over one self.
		
		public final boolean singleruler;
		public final boolean voting;
		
		Type(boolean sr, boolean v){
			this.singleruler = sr;
			this.voting = v;
		}
		
		public static Type fromString(String string){
			Type type = valueOf(string);
			return type == null ? ANARCHY : type;
		}
		
	}
	
}