package net.fexcraft.mod.extensions.ie.util;

import net.minecraft.util.EnumFacing;

public class EFIO{
	
	public EnumFacing facing;
	public EnumIO io;
	public int cthickness;
	
	public static enum EnumIO{
		INPUT(1), OUTPUT(0), NULL(-1);
		
		private int id;
		
		EnumIO(int id){
			this.id = id;
		}

		public int getId(){
			return id;
		}
		
		public static EnumIO get(int i){
			for(EnumIO e : values()){
				if(e.id == i){
					return e;
				}
			}
			return NULL;
		}
		
		public boolean equals(EnumIO e){
			if(id == e.id){
				return true;
			}
			return false;
		}
	}
	
	public EFIO(EnumFacing ef, EnumIO io, int cthinkness){
		this.facing = ef;
		this.io = io;
		this.cthickness = cthinkness;
	}
	
	public boolean equals(EFIO e){
		if(this == e){
			return true;
		}
		else if(facing.equals(e.facing) && io.equals(e.io) && cthickness == e.cthickness){
			return true;
		}
		else return false;
	}
	
	public static EnumFacing ef_fromString(String s){
		switch(s){
			case "north":
				return EnumFacing.NORTH;
			case "south":
				return EnumFacing.SOUTH;
			case "west":
				return EnumFacing.WEST;
			case "east":
				return EnumFacing.EAST;
			case "up":
				return EnumFacing.UP;
			case "down":
				return EnumFacing.DOWN;
		}
		return EnumFacing.UP;
	}
}