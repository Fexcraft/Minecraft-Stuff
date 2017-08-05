package net.fexcraft.mod.fsu.server.modules.nvr.data;

import java.sql.ResultSet;
import java.util.UUID;

import net.fexcraft.mod.fsu.server.modules.nvr.NVR;
import net.fexcraft.mod.lib.util.common.Sql;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.lang.ArrayList;

public class Province {
	
	public final int id;
	public Nation nation;
	public String name;
	public UUID ruler;
	public UUID creator;
	public long created;
	public long lastchange;
	public float lastincome;
	public ArrayList<Integer> neighbors;
	public ArrayList<UUID> rebels;
	public ArrayList<UUID> separationists;
	
	public Province(int id){
		this.id = id;
		try{
			ResultSet set = NVR.SQL.query("SELECT * FROM provinces WHERE id='" + id + "';");
			if(set.first()){
				this.nation = NVR.nations.get(set.getInt("nation"));
				this.name = set.getString("name");
				this.ruler = UUID.fromString(set.getString("ruler"));
				this.creator = UUID.fromString(set.getString("creator"));
				this.created = set.getLong("created");
				this.lastchange = set.getLong("lastchange");
				this.lastincome = set.getFloat("lastincome");
				this.neighbors = JsonUtil.jsonArrayToIntegerArray(JsonUtil.getFromString(set.getString("neighbors")).getAsJsonArray());
				this.rebels = JsonUtil.jsonArrayToUUIDArray(JsonUtil.getFromString(set.getString("rebels")).getAsJsonArray());
				this.separationists = JsonUtil.jsonArrayToUUIDArray(JsonUtil.getFromString(set.getString("separationists")).getAsJsonArray());
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
			sql.update("provinces", "nation='" + nation.id + "'", "id", id);
			sql.update("provinces", "name='" + name + "'", "id", id);
			sql.update("provinces", "ruler='" + ruler.toString()+ "'", "id", id);
			sql.update("provinces", "creator='" + creator.toString() + "'", "id", id);
			sql.update("provinces", "created='" + created + "'", "id", id);
			sql.update("provinces", "lastchange='" + lastchange + "'", "id", id);
			sql.update("provinces", "lastincome='" + lastincome + "'", "id", id);
			sql.update("provinces", "neighbors='" + JsonUtil.getArrayFromIntegerList(neighbors).toString() + "'", "id", id);
			sql.update("provinces", "rebels='" + JsonUtil.getArrayFromUUIDList(rebels).toString() + "'", "id", id);
			sql.update("provinces", "separationists='" + JsonUtil.getArrayFromUUIDList(separationists).toString() + "'", "id", id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
