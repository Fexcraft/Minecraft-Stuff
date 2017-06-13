package net.fexcraft.mod.fsmm.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.FCL;
import net.fexcraft.mod.lib.network.Network;

public class UpdateHandler {

	private static String CV = FI.VERSION, NV, LMCV;
	public static String Status = null;
	private static String type;
	
	//Color Stuff
	private static String FSMM = CCS.BLACK + "[" + CCS.AQUA + "FSMM" + CCS.BLACK + "]";
	private static String grayBracket = CCS.GRAY + ").";
	
	public static void initialize(){
		getDataFromServer();
		sync();
		
		if(NV != null) {
			if(!NV.equalsIgnoreCase(CV)) {
				Status = FSMM + CCS.GRAY + " New Version avaible! (" + CCS.DGREEN + NV + grayBracket
				+ "\n" + FSMM + CCS.GRAY + " Your Client version: (" + CCS.RED    + CV + grayBracket
				+ "\n" + FSMM + CCS.GRAY + " Update type: (" + CCS.AQUA + type + grayBracket;
			}
		}
		if(LMCV != null && !LMCV.equals(FCL.mcv)){
			if(Status == null){
				Status = FSMM + CCS.GRAY + " Now avaible for MC " + LMCV + "!";
			}
			else{
				Status += "\n" + FSMM + CCS.GRAY + " Now avaible for MC " + LMCV + "!";
			}
		}
	}

	private static void sync() {
		NV = data.get("latest_version").getAsString();
		LMCV = data.get("latest_mc_version").getAsString();
		type = data.get("type").getAsString();
	}
	
	private static JsonObject data;
	
	public static void getDataFromServer(){
		JsonObject json = Network.getModData("fsmm");
		if(json == null){
			data = new JsonObject();
			data.addProperty("latest_version", FI.VERSION);
			data.addProperty("latest_mc_version", FCL.mcv);
			data.addProperty("type", "error.could.not.connect.to.server;\nNo Internet?");
		}
		else{
			boolean found = false;
			for(JsonElement elm : json.get("versions").getAsJsonArray()){
				if(elm.getAsJsonObject().get("version").getAsString().equals(FCL.mcv)){
					data = elm.getAsJsonObject();
					found = true; break;
				}
			}
			if(!found){
				data = new JsonObject();
				data.addProperty("latest_version", FI.VERSION);
				data.addProperty("latest_mc_version", FCL.mcv);
				data.addProperty("type", "mc.version.not.found;");
			}
		}
	}
	
}