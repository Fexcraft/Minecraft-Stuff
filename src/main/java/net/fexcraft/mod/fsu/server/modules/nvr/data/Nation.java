package net.fexcraft.mod.fsu.server.modules.nvr.data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import net.fexcraft.mod.fsmm.account.AccountManager.Account;
import net.fexcraft.mod.fsu.server.modules.nvr.NVR;
import net.fexcraft.mod.lib.util.common.Sql;
import net.fexcraft.mod.lib.util.json.JsonUtil;

public class Nation {

	public final int id;
	public String name;
	public ArrayList<UUID> goverment;
	public String goverment_title, goverment_name;
	public UUID incharge;
	public String incharge_title;
	public UUID creator;
	public long created;
	public long lastchange;
	public GovType govtype;
	public int lastincome;
	public ArrayList<Integer> neighbors;
	public Account account;
	public int parent;
	
	public Nation(int id){
		this.id = id;
		try{
			ResultSet set = NVR.SQL.query("SELECT * FROM nations WHERE id='" + id + "';");
			if(set.first()){
				this.name = set.getString("name");
				this.goverment_name = set.getString("govname");
				this.goverment = JsonUtil.jsonArrayToUUIDArray(JsonUtil.getFromString(set.getString("govmembers")).getAsJsonArray());
				this.goverment_title = set.getString("govtitle");
				this.incharge = UUID.fromString(set.getString("incharge"));
				this.incharge_title = set.getString("incharge_title");
				this.creator = UUID.fromString("creator");
				this.created = set.getLong("created");
				this.lastchange = set.getLong("lastchange");
				this.govtype = GovType.fromString(set.getString("govtype"));
				this.lastincome = set.getInt("lastincome");
				this.neighbors = JsonUtil.jsonArrayToIntegerArray(JsonUtil.getFromString(set.getString("neighbors")).getAsJsonArray());
				this.parent = set.getInt("parent");
			}
			else{
				throw new Exception();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		account = Account.getAccountManager().getAccountOf("nation", "n:" + id);
	}
	
	public void save(Sql sql){
		try{
			sql.update("nations", "name='" + name + "'", "id", id);
			sql.update("nations", "goverment_name='" + goverment_name + "'", "id", id);
			sql.update("nations", "goverment_members='" + JsonUtil.getArrayFromUUIDList(goverment).toString() + "'", "id", id);
			sql.update("nations", "govermert_title='" + goverment_title + "'", "id", id);
			sql.update("nations", "incharge='" + incharge.toString() + "'", "id", id);
			sql.update("nations", "incharge_title='" + incharge_title + "'", "id", id);
			sql.update("nations", "lastchange='" + lastchange + "'", "id", id);
			sql.update("nations", "govtype='" + govtype.name() + "'", "id", id);
			sql.update("nations", "lastincome='" + lastincome + "'", "id", id);
			sql.update("nations", "neighbors='" + JsonUtil.getArrayFromIntegerList(neighbors).toString() + "'", "id", id);
			sql.update("nations", "parent='" + parent + "'", "id", id);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		Account.getAccountManager().saveAccount(account);
	}
	
	public static enum GovType {
		MONARCHY,
		DEMOCRACY,
		AUTOCRACY,
		ANARCHY;
		
		public static GovType fromString(String string){
			for(GovType type : values()){
				if(type.name().equals(string)){
					return type;
				}
			}
			return ANARCHY;
		}
	}

	public boolean canInteractWithBlocks(UUID uuid){
		if(govtype != GovType.ANARCHY){
			return this.incharge.equals(uuid) || this.goverment.contains(uuid);
		}
		return false;
	}

	public boolean isInAnarchy(){
		return govtype == GovType.ANARCHY;
	}
	
}
