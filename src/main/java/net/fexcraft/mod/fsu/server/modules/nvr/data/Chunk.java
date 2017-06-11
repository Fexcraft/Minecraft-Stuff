package net.fexcraft.mod.fsu.server.modules.nvr.data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import net.fexcraft.mod.fsu.server.modules.nvr.NVR;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.math.Time;

public class Chunk {
	
	public int x, z, district_id;
	//private District district;
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
		district_id = -1;
		//district = NVR.districts.get(district_id);
		claimed = Time.getDate();
		claimer = UUID.fromString(NVR.DEF_UUID);
		owner = null;
		type = Type.NEUTRAL;
		whitelist = new ArrayList<UUID>();
		tax = 0f;
		if(!errored){
			try{
				NVR.SQL.update("INSERT INTO `fsu_nvr`.`chunks` (`x`, `z`, `district`, `type`, `claimer`, `claimed`, `owner`, `whitelist`, `tax`)"
						+ "VALUES ('" + x + "', '" + z + "', '" + district_id + "', '" + type.name() + "', '" + claimer.toString() + "', '" + claimed + "', '', '{}', '" + tax + "');");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		Print.debug("X:" + x + " | Z:" + z);
		Static.stop();
	}

	public void save(){
		//TODO
	}
	
	public static enum Type {
		NEUTRAL,
		CLAIMED,
		PRIVATE,
		COMPANY,
		PROTECTED;
		
		public Type fromString(String string){
			for(Type type : values()){
				if(type.name().equals(string)){
					return type;
				}
			}
			return NEUTRAL;
		}
	}

}