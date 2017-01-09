package net.fexcraft.mod.extensions.ce.util;

import net.fexcraft.mod.extensions.ce.CE;
import net.fexcraft.mod.frsm.util.text.CCS;

public class UpdateHandler {

	private static String nv;
	public static String status = null;
	public static String nMCV = CE.mcv;
	public static String CE_ = CCS.BLACK + "[" + CCS.DPURPLE + "CE_" + CCS.BLACK + "]";
	
	public static void init() {
		
		refresh();
		
		if(nv != null) {
			if(nv.equals(CE.version)) {
				status  = null;
			}
			else {
				status  = CE_ + CCS.GRAY + " New Version avaible! (" + CCS.DGREEN  + nv + CCS.GRAY + ")"
				+ "\n" + CE_ + CCS.GRAY + " Your Client version: (" + CCS.RED + CE.version + CCS.GRAY + ")";
			}
		}
		else {
			status  = CE_ + CCS.GRAY + " Failed to check for Updates.";
		}
	}

	private static void refresh(){
		try{
			nv = Data.obj.get("latest_version").getAsString();
			nMCV = Data.obj.get("latest_mc_version").getAsString();
		}
		catch(Exception e){
			nv = CE.version;
			nMCV = CE.mcv;
		}
	}
}