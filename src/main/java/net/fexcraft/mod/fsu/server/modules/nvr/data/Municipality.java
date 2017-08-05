package net.fexcraft.mod.fsu.server.modules.nvr.data;

import java.sql.ResultSet;
import java.util.UUID;

import net.fexcraft.mod.fsmm.account.AccountManager.Account;
import net.fexcraft.mod.fsu.server.modules.nvr.NVR;
import net.fexcraft.mod.lib.util.common.Sql;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.lang.ArrayList;

public class Municipality {
	
	public final int id;
	public Province province;
	public String name;
	public ArrayList<UUID> management;
	public ArrayList<Integer> neighbors;
	public UUID creator;
	public long created = 0;
	public long lastchange;
	public long lastincome = 0;
	public ArrayList<UUID> citizen;
	public float citizentax = 0f;
	/*public boolean allowMixing;//allow companies with whichever type to buy land in any district
	public boolean allowInvenstors;//allow companies to buy land themself
	public boolean allowReselling;//allow players & companies to sell land themself*/
	public Account account;
	
	public Municipality(int id){
		this.id = id;
		try{
			ResultSet set = NVR.SQL.query("SELECT * FROM municipalities WHERE id='" + id + "';");
			if(set.first()){
				this.name = set.getString("name");
				this.province = NVR.provinces.get(set.getInt("province"));
				this.management = JsonUtil.jsonArrayToUUIDArray(JsonUtil.getFromString(set.getString("management")).getAsJsonArray());
				this.neighbors = JsonUtil.jsonArrayToIntegerArray(JsonUtil.getFromString(set.getString("neighbors")).getAsJsonArray());
				this.creator = UUID.fromString(set.getString("creator"));
				this.created = set.getInt("created");
				this.lastchange = set.getLong("lastchange");
				this.lastincome = set.getLong("lastincome");
				this.citizen = JsonUtil.jsonArrayToUUIDArray(JsonUtil.getFromString(set.getString("citizen")).getAsJsonArray());
				this.citizentax = set.getFloat("citizentax");
			}
			else{
				throw new Exception();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		account = Account.getAccountManager().getAccountOf("municipality", "m:" + id);
	}
	
	public void save(Sql sql){
		try{
			sql.update("municipalities", "name='" + name + "'", "id", id);
			sql.update("municipalities", "province='" + province.id + "'", "id", id);
			sql.update("municipalities", "management='" + JsonUtil.getArrayFromUUIDList(management).toString() + "'", "id", id);
			sql.update("municipalities", "neighbors='" + JsonUtil.getArrayFromIntegerList(neighbors).toString() + "'", "id", id);
			sql.update("municipalities", "lastchange='" + lastchange + "'", "id", id);
			sql.update("municipalities", "lastincome='" + lastincome + "'", "id", id);
			sql.update("municipalities", "citizen='" + JsonUtil.getArrayFromUUIDList(citizen).toString() + "'", "id", id);
			sql.update("municipalities", "citizentax='" + citizentax + "'", "id", id);
			//NVR.SQL.update("UPDATE municipalities SET name='" + name + "', province='" + province.id + "', management='" + JsonUtil.getArrayFromUUIDList(management).toString() + "', neighbors='" + JsonUtil.getArrayFromIntegerList(neighbors).toString() + "', lastincome='" + lastincome + "', citizen='" + JsonUtil.getArrayFromUUIDList(citizen).toString() + "', citizentax='" + citizentax + "' WHERE id='" + id + "';");
		}
		catch(Exception e){
			e.printStackTrace();
			Static.halt();
		}
		Account.getAccountManager().saveAccount(account);
	}
	
}
