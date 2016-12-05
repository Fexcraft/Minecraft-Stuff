package net.fexcraft.mod.fsmm.util;

public class UpdateHandler {

	private static String CV = FI.VERSION, NV, LMCV;
	public static String Status = null;
	private static String type;
	
	//Color Stuff
	private static String FSMM = CCS.BLACK + "[" + CCS.AQUA + "FSMM" + CCS.BLACK + "]";
	private static String grayBracket = CCS.GRAY + ").";
	
	public static void init() {
		sync();
		
		if(NV != null) {
			if(!NV.equalsIgnoreCase(CV)) {
				Status = FSMM + CCS.GRAY + " New Version avaible! (" + CCS.DGREEN + NV + grayBracket
				+ "\n" + FSMM + CCS.GRAY + " Your Client version: (" + CCS.RED    + CV + grayBracket
				+ "\n" + FSMM + CCS.GRAY + " Update type: (" + CCS.AQUA + type + grayBracket;
			}
		}
		if(LMCV != null && !LMCV.equals(FI.MCV)){
			if(Status == null){
				Status = FSMM + CCS.GRAY + " Now avaible for MC " + LMCV + "!";
			}
			else{
				Status += "\n" + FSMM + CCS.GRAY + " Now avaible for MC " + LMCV + "!";
			}
		}
	}

	private static void sync() {
		NV = Data.data.get("latest_version").getAsString();
		LMCV = Data.data.get("latest_mc_version").getAsString();
		type = Data.data.get("type").getAsString();
	}
}