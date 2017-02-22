package net.fexcraft.mod.fvm.data;

import java.util.ArrayList;
import java.util.Arrays;

public enum DriveType {
	
	FWD("fwd", new String[]{"front", "Front"}),
	RWD("rwd", new String[]{"rear", "Rear"}),
	AWD("4wd", new String[]{"4wd", "Four"}),
	TRACK("track", new String[]{"tracked", "tank"}),
	NULL("null", new String[]{});
	
	private String string;
	private ArrayList<String> alternative = new ArrayList<String>();
	
	DriveType(String s, String[] arr){
		string = s;
		alternative.addAll(Arrays.asList(arr));
	}
	
	@Override
	public String toString(){
		return string;
	}
	
	public static DriveType fromString(String s){
		for(DriveType type : values()){
			if(type.string.equals(s) || type.alternative.contains(s)){
				return type;
			}
		}
		return NULL;
	}
	
}