package net.fexcraft.mod.fsu.server.modules.nvr.data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import net.fexcraft.mod.fsmm.account.AccountManager.Account;
import net.fexcraft.mod.fsu.server.modules.nvr.NVR;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;

public class Municipality {
	
	public final int id;
	public Province province;
	public String name;
	public ArrayList<UUID> management;
	public ArrayList<Integer> neighbors;
	public UUID creator;
	public long created = 0;
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
				this.lastincome = set.getLong("lastincome");
				this.citizen = JsonUtil.jsonArrayToUUIDArray(JsonUtil.getFromString(set.getString("citizen")).getAsJsonArray());
				this.citizentax = set.getFloat("citizentax");
			}
			else{
				populate(false);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			populate(false);
		}
		populate(true);
		account = account.getAccountManager().getAccountOf("municipality", "m_" + id);
	}
	
	public void save(){
		try{
			NVR.SQL.update("UPDATE municipalities SET name='" + name + "', province='" + province.id + "', management='" + JsonUtil.getArrayFromUUIDList(management).toString() + "', neighbors='" + JsonUtil.getArrayFromIntegerList(neighbors).toString() + "', lastincome='" + lastincome + "', citizen='" + JsonUtil.getArrayFromUUIDList(citizen).toString() + "', citizentax='" + citizentax + "' WHERE id='" + id + "';");
		}
		catch(Exception e){
			e.printStackTrace();
			Static.halt();
		}
		account.getAccountManager().saveAccount(account);
	}
	
	private void populate(boolean bool){
		if(name == null){
			name = "Nameless Place";
		}
		if(management == null){
			this.management = new ArrayList<UUID>();
		}
		if(this.province == null){
			this.province = NVR.provinces.get(-1);
		}
		if(bool){
			return;
		}
		if(neighbors == null){
			this.neighbors = new ArrayList<Integer>();
		}
		if(citizen == null){
			citizen = new ArrayList<UUID>();
		}
	}
	
}
