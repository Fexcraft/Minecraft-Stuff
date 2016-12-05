package net.fexcraft.mod.frsm.util.java;

import java.util.Random;

public class FR{
	
	static Random r = new Random();
	
	public static int nextInt(int i){
		return r.nextInt(i);
	}
	
	public static float nextFloat(){
		return r.nextFloat();
	}
}