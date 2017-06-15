package net.fexcraft.mod.fsu.server.modules.nvr.data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import net.fexcraft.mod.fsu.server.modules.nvr.NVR;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Time;

public class Chunk {
	
	public final int x, z;
	private District district;
	public long claimed;
	public UUID claimer, owner;
	public Type type;
	public ArrayList<UUID> whitelist;
	public float tax;
	
	public Chunk(int x, int z){
		this.x = x;
		this.z = z;
		try{
			ResultSet set = NVR.SQL.query("SELECT * FROM chunks WHERE x='" + x + "' AND z='" + z + "';");
			if(set.first()){
				this.district = NVR.districts.get(set.getInt("district"));;
				this.type = Type.fromString(set.getString("type"));
				this.claimer = UUID.fromString(set.getString("claimer"));
				this.claimed = set.getLong("claimed");
				try{
					this.owner = UUID.fromString("owner");
				}
				catch(Exception e){
					this.owner = null;
				}
				this.whitelist = JsonUtil.jsonArrayToUUIDArray(JsonUtil.getFromString(set.getString("whitelist")).getAsJsonArray());
				this.tax = set.getFloat("tax");
			}
			else{
				create(x, z, false);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			create(x, z, true);
		}
	}
	
	private void create(int x, int z, boolean errored){
		district = NVR.districts.get(-1);
		claimed = Time.getDate();
		claimer = UUID.fromString(NVR.DEF_UUID);
		owner = null;
		type = Type.NEUTRAL;
		whitelist = new ArrayList<UUID>();
		tax = 0f;
		if(!errored){
			try{
				NVR.SQL.update("INSERT INTO `fsu_nvr`.`chunks` (`x`, `z`, `district`, `type`, `claimer`, `claimed`, `owner`, `whitelist`, `tax`)"
						+ "VALUES ('" + x + "', '" + z + "', '" + district.id + "', '" + type.name() + "', '" + claimer.toString() + "', '" + claimed + "', '', '[]', '" + tax + "');");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		Print.debug("X:" + x + " | Z:" + z);
	}

	public void save(){
		try{
			NVR.SQL.update("UPDATE chunks SET district='" + district.id + "', type='" + type.name() + "', owner='" + (owner == null ? "" : owner.toString()) + "', whitelist='" + JsonUtil.getArrayFromUUIDList(whitelist).toString() + "', tax='" + tax + "' WHERE x='" + x + "' AND z='" + z + "';");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static enum Type {
		NEUTRAL,
		CLAIMED,
		PRIVATE,
		COMPANY,
		PROTECTED;
		
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