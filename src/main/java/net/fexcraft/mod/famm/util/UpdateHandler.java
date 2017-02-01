package net.fexcraft.mod.famm.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.network.Network;
import net.minecraft.util.text.TextFormatting;

public class UpdateHandler {

	private static String CV = FI.VERSION, NV, LMCV;
	public static String Status = null;
	
	private static String FAMM = TextFormatting.BLACK+ "[" + TextFormatting.YELLOW + "FAMM" + TextFormatting.BLACK + "]";
	private static String grayBracket = TextFormatting.GRAY + ").";
	
	public static void init(){
		getDataFromServer();
		sync();
		
		if(NV != null) {
			if(!NV.equalsIgnoreCase(CV)) {
				Status = FAMM + TextFormatting.GRAY + " New Version avaible! (" + TextFormatting.DARK_GREEN + NV + grayBracket
				+ "\n" + FAMM + TextFormatting.GRAY + " Your Client version: (" + TextFormatting.RED    + CV + grayBracket;
			}
		}
		if(LMCV != null && !LMCV.equals(FI.MCV)){
			if(Status == null){
				Status = FAMM + TextFormatting.GRAY + " Now avaible for MC " + LMCV + "!";
			}
			else{
				Status += "\n" + FAMM + TextFormatting.GRAY + " Now avaible for MC " + LMCV + "!";
			}
		}
	}

	private static void sync() {
		NV = obj.get("latest_version").getAsString();
		LMCV = obj.get("latest_mc_version").getAsString();
	}
	
	private static JsonObject obj;
	
	public static void getDataFromServer(){
		JsonObject json = Network.getModData("famm");
		if(json == null){
			setDefault();
		}
		else{
			boolean found = false;
			for(JsonElement elm : json.get("versions").getAsJsonArray()){
				if(elm.getAsJsonObject().get("version").getAsString().equals(FI.MCV)){
					obj = elm.getAsJsonObject();
					found = true; break;
				}
			}
			if(!found){
				setDefault();
			}
		}
	}

	private static void setDefault(){
		obj = new JsonObject();
		obj.addProperty("latest_version", FI.VERSION);
		obj.addProperty("latest_mc_version", FI.MCV);
	}
	
}