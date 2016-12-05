package net.fexcraft.mod.extensions.cae.util;

import net.fexcraft.mod.lib.util.cls.Print;

public class CAEUtil{
	
	public static int[][] intXZfromCharArray(Type type, char[] ca){
		if(ca.length == 0){
			for(int i = 0; i < 50; i++){
				Print.log("CHAR ARRAY LENGHT IS ZERO, THIS IS AN ERROR");
			}
			ca = type.getEmptyArray();
		}
		int[][] arr = new int[type.N()][type.N()];
		for(int i = 0; i < type.N(); i++){
			for(int j = 0; j < type.N(); j++){
				int k = i * type.N();				
				arr[i][j] = prs(ca[k + j]);
			}
		}
		return arr;
	}
	
	private static int prs(char c){
		return Integer.parseInt(c + "");
	}
	
}