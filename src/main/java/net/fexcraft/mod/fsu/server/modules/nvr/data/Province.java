package net.fexcraft.mod.fsu.server.modules.nvr.data;

import java.sql.ResultSet;
import java.util.UUID;

import net.fexcraft.mod.fsu.server.modules.nvr.NVR;

public class Province {
	
	public final int id;
	public Nation nation;
	public String name;
	public UUID ruler;
	public UUID creator;
	public long created;
	public float lastincome;
	
	public Province(int id){
		this.id = id;
		try{
			ResultSet set = NVR.SQL.query("");
			if(set.first()){
				//TODO
			}
			else{
				
			}
		}
		catch(Exception e){
			//
		}
	}
	
	public void save(){
		//TODO
	}
	
}
