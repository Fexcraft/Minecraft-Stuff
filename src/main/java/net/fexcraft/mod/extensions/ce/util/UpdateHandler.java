package net.fexcraft.mod.extensions.ce.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.extensions.ce.CE;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.fexcraft.mod.lib.network.Network;

public class UpdateHandler {

	private static String nv;
	public static String status = null;
	public static String nMCV = CE.MCV;
	public static String CE_ = CCS.BLACK + "[" + CCS.DPURPLE + "CE_" + CCS.BLACK + "]";
	
	public static void initialize(){
		getDataFromServer();
		refresh();
		
		if(nv != null) {
			if(nv.equals(CE.VERSION)) {
				status  = null;
			}
			else {
				status  = CE_ + CCS.GRAY + " New Version avaible! (" + CCS.DGREEN  + nv + CCS.GRAY + ")"
				+ "\n" + CE_ + CCS.GRAY + " Your Client version: (" + CCS.RED + CE.VERSION + CCS.GRAY + ")";
			}
		}
		else {
			status  = CE_ + CCS.GRAY + " Failed to check for Updates.";
		}
	}

	private static void refresh(){
		try{
			nv = obj.get("latest_version").getAsString();
			nMCV = obj.get("latest_mc_version").getAsString();
			CE.e = obj.get("lock").getAsBoolean();
		}
		catch(Exception e){
			nv = CE.VERSION;
			nMCV = CE.MCV;
			CE.e = true;
		}
	}
	
	public static JsonObject obj;
	
	public static void getDataFromServer(){
		JsonObject json = Network.getModData("frsm_ce");
		if(json == null){
			obj = new JsonObject();
			obj.addProperty("latest_version", CE.VERSION);
			obj.addProperty("latest_mc_version", CE.MCV);
			obj.addProperty("lock", true);
		}
		else{
			for(JsonElement elm : json.get("versions").getAsJsonArray()){
				if(elm.getAsJsonObject().get("version").getAsString().equals(CE.MCV)){
					obj = elm.getAsJsonObject();
				}
			}
		}
	}
	
}