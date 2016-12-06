package net.fexcraft.mod.extensions.fve.util;

import net.fexcraft.mod.frsm.util.text.CCS;

public class UpdateHandler {

	private static String nv;
	public static String status = null;
	public static String nMCV = FI.MCV;
	
	public static void load(){
		
		refresh();
		
		if(nv != null) {
			if(FI.VERSION.equals(nv)) {
				status  = null;
			}
			else {
				status  = FI.FVEs + CCS.GRAY + " New Version avaible! (" + CCS.DGREEN  + nv + CCS.GRAY + ")"
				 + "\n" + FI.FVEs + CCS.GRAY + " Your Client version: (" + CCS.RED + FI.VERSION + CCS.GRAY + ")";
			}
		}
		else {
			status = null;
		}
	}

	private static void refresh(){
		nv = Data.obj_c.get("latest_version").getAsString();
		nMCV = Data.obj_c.get("latest_mc_version").getAsString();
	}
}