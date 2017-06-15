package net.fexcraft.mod.fsu.server.modules.nvr.data;

import java.sql.ResultSet;

import net.fexcraft.mod.fsu.server.modules.nvr.NVR;

public class Nation {

	public final int id;
	
	public Nation(int id){
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
