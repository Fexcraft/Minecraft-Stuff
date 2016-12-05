package net.fexcraft.mod.extensions.cae.util;

import net.fexcraft.mod.lib.util.cls.Static;

public enum Type{
	
	x2("x2", 2), x4("x4", 4), x8("x8", 8), x16("x16", 16), x32("x32", 32), x64("x64", 64);
	
	private String id;
	private int n;
	
	Type(String id, int i){
		this.id = id;
		this.n = i;
	}
    	
    	@Override
    	public String toString(){
    		return id;
    	}
    	
    	public int N(){
    		return n;
    	}
    	
    	public static Type fromString(String s){
    		for(Type type : Type.values()){
    			if(type.toString().equals(s)){
    				return type;
    			}
    		}
    		return x16;
    	}

		public char[] getEmptyArray(){
			switch(this){
			case x2:
				return "0000".toCharArray();
			case x4:
				return Static.Null_16.toCharArray();
			case x8:
				return Static.Null_64.toCharArray();
			case x16:
				return Static.Null_256.toCharArray();
			case x32:
				return Static.Null_1024.toCharArray();
			case x64:
				return Static.Null_4096.toCharArray();
			default:
				return Static.Null_256.toCharArray();
			
			}
		}
    }