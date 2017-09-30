package net.fexcraft.mod.nvr.server.data;

import java.io.File;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fsmm.account.AccountManager.Account;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.lang.ArrayList;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.nvr.common.enums.NationType;
import net.fexcraft.mod.nvr.server.NVR;

public class Nation {
	
	public int id;
	public String name, icon, colour;
	public NationType type;
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
	
	public Nation(){}
	
	public static final Nation load(JsonObject obj){
		if(obj == null || !obj.has("id")){
			return null;
		}
		Nation nat = new Nation();
		nat.id = obj.get("id").getAsInt();
		nat.name = JsonUtil.getIfExists(obj, "name", "Unnamed Nation");
		nat.icon = JsonUtil.getIfExists(obj, "icon", "");
		nat.type = NationType.fromString(JsonUtil.getIfExists(obj, "type", NationType.ANARCHY));
		nat.gov = JsonUtil.jsonArrayToUUIDArray(JsonUtil.getIfExists(obj, "gov", new JsonArray()).getAsJsonArray());
		nat.gov_title = JsonUtil.getIfExists(obj, "gov_title", "Finest Anarchy");
		nat.gov_name = JsonUtil.getIfExists(obj, "gov_name", "Anarchist");
		nat.incharge = obj.has("incharge") && !obj.get("incharge").getAsString().equals("") ? UUID.fromString(JsonUtil.getIfExists(obj, "incharge", NVR.DEF_UUID)) : null;
		nat.incharge_title = JsonUtil.getIfExists(obj, "incharge_title", "Leader");
		nat.creator = UUID.fromString(JsonUtil.getIfExists(obj, "creator", NVR.DEF_UUID));
		nat.created = JsonUtil.getIfExists(obj, "created", 0).longValue();
		nat.changed = JsonUtil.getIfExists(obj, "changed", 0).longValue();
		nat.prev_income = JsonUtil.getIfExists(obj, "previncome", 0).doubleValue();
		nat.neighbors = JsonUtil.jsonArrayToIntegerArray(JsonUtil.getIfExists(obj, "neighbors", new JsonArray()).getAsJsonArray());
		nat.account = Account.getAccountManager().loadAccount("nation", "nation:" + nat.id);
		nat.parent = NVR.getNation(JsonUtil.getIfExists(obj, "parent", -1).intValue());
		nat.colour = JsonUtil.getIfExists(obj, "color", "#f0f0f0");
		return nat;
	}
	
	public static final File getFile(int id){
		return new File(NVR.NATION_DIR, id + ".json");
	}
	
	public final void save(){
		Account.getAccountManager().saveAccount(account);
		try{
			JsonObject obj = new JsonObject();
			obj.addProperty("id", id);
			obj.addProperty("name", name);
			obj.addProperty("icon", icon == null ? "" : icon);
			obj.addProperty("type", type.toString());
			obj.add("gov", JsonUtil.getArrayFromUUIDList(gov));
			obj.addProperty("gov_title", gov_title);
			obj.addProperty("gov_name", gov_name);
			obj.addProperty("incharge", incharge == null ? "" : incharge.toString());
			obj.addProperty("incharge_title", incharge_title);
			obj.addProperty("creator", creator.toString());
			obj.addProperty("created", created);
			obj.addProperty("changed", changed);
			obj.addProperty("previncome", prev_income);
			obj.add("neighbors", JsonUtil.getArrayFromIntegerList(neighbors));
			obj.addProperty("parent", parent == null ? -1 : parent.id);
			obj.addProperty("color", colour);
			//
			obj.addProperty("last_save", Time.getDate());
			JsonUtil.write(getFile(id), obj);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public boolean isInAnarchy(){
		return type == NationType.ANARCHY;
	}
	
	public boolean isDemocratic(){
		return type == NationType.DEMOCRACY;
	}
	
	public boolean isAutocratic(){
		return type == NationType.AUTOCRACY;
	}
	
	public boolean isMonarchy(){
		return type == NationType.MONARCHY;
	}

	public boolean canClaim(UUID uuid){
		switch(type){
			case ANARCHY: return false;
			case AUTOCRACY: return incharge.equals(uuid);
			case DEMOCRACY: return false;
			case MONARCHY: return incharge.equals(uuid) || gov.contains(uuid);
			default: break;
		}
		return false;
	}
	
}