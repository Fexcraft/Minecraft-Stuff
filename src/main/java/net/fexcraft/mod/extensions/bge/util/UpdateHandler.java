package net.fexcraft.mod.extensions.bge.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.extensions.bge.BGE;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.fexcraft.mod.lib.network.Network;

public class UpdateHandler {

	private static String nv;
	public static String status = null;
	public static String nMCV = BGE.mcv;
	
	public static void load(){		
		getDataFromServer();
		if(nv != null) {
			if(BGE.version.equals(nv)) {
				status  = null;
			}
			else {
				status  = BGE.BGE + CCS.GRAY + " New Version avaible! (" + CCS.DGREEN  + nv + CCS.GRAY + ")"
				 + "\n" + BGE.BGE + CCS.GRAY + " Your Client version: (" + CCS.RED + BGE.version + CCS.GRAY + ")";
			}
		}
		else {
			status = null;
		}
	}
	
	private static JsonObject obj;
	
	private static void getDataFromServer(){
		JsonObject json = Network.getModData("frsm_bge");
		if(json == null){
			obj = new JsonObject();
			obj.addProperty("latest_version", BGE.version);
			obj.addProperty("latest_mc_version", BGE.mcv);
		}
		else{
			boolean found = false;
			for(JsonElement elm : json.get("versions").getAsJsonArray()){
				if(elm.getAsJsonObject().get("version").getAsString().equals(BGE.mcv)){
					obj = elm.getAsJsonObject();
					found = true;
				}
			}
			if(!found){
				obj = new JsonObject();
				obj.addProperty("latest_version", BGE.version);
				obj.addProperty("latest_mc_version", BGE.mcv);
			}
		}
		nv = obj.get("latest_version").getAsString();
		nMCV = obj.get("latest_mc_version").getAsString();
	}
}