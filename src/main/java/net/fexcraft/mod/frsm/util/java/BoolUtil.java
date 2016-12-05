package net.fexcraft.mod.frsm.util.java;

import net.fexcraft.mod.frsm.util.PrintLog;

public class BoolUtil{
	
	public static int toInt(boolean b){
		if(b == false){
			return 0;
		}
		if(b == true){
			return 1;
		}
		else return 2;
	}
	
	public static boolean reverse(boolean b){
		/*if(b == true){
			return false;
		}
		else if(b == false){
			return true;
		}
		else{
			PrintLog.print("FRSM_BOOL_UTIL", "Could not reverse boolean.");
			return false;
		}*/
		return !b;
	}
	
	public static boolean fromString(String s){
		if(s == null){
			PrintLog.print("FRSM_BOOL_UTIL", "Could not translate '" + s + "' into an boolean! (NULL)");
			return false;
		}
		if(s.toLowerCase().equals("true")  || s.equals("1")){
			return true;
		}
		if(s.toLowerCase().equals("false") || s.equals("0")){
			return false;
		}
		else{
			PrintLog.print("FRSM_BOOL_UTIL", "Could not translate '" + s + "' into an boolean! (!NULL)");
			return false;
		}
	}
}