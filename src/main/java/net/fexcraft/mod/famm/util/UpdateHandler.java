package net.fexcraft.mod.famm.util;

import net.minecraft.util.text.TextFormatting;

public class UpdateHandler {

	private static String CV = FI.VERSION, NV, LMCV;
	public static String Status = null;
	//private static String type;
	
	//Color Stuff
	private static String FAMM = TextFormatting.BLACK+ "[" + TextFormatting.YELLOW + "FAMM" + TextFormatting.BLACK + "]";
	private static String grayBracket = TextFormatting.GRAY + ").";
	
	public static void init() {
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
		NV = Data.obj.get("latest_version").getAsString();
		LMCV = Data.obj.get("latest_mc_version").getAsString();
		//type = Data.obj.get("type").getAsString();
	}
}