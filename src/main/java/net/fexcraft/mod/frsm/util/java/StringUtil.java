package net.fexcraft.mod.frsm.util.java;

public class StringUtil{
	
	public static String firstToUpperCase(String string){
		String s1 = string.substring(0, 1);
		String s2 = string.substring(1);
		s1.toUpperCase();
		return s1 + s2;
	}
}