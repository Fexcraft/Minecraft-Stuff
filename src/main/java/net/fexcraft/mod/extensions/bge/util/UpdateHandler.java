package net.fexcraft.mod.extensions.bge.util;

import net.fexcraft.mod.extensions.bge.BGE;
import net.fexcraft.mod.frsm.util.text.CCS;

public class UpdateHandler {

	private static String nv;
	public static String status = null;
	public static String nMCV = BGE.mcv;
	
	public static void load(){
		
		refresh();
		
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

	private static void refresh(){
		nv = Data.obj.get("latest_version").getAsString();
		nMCV = Data.obj.get("latest_mc_version").getAsString();
	}
}