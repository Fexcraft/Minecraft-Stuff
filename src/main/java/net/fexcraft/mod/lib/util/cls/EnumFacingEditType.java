package net.fexcraft.mod.lib.util.cls;

import net.minecraft.util.EnumFacing;

public enum EnumFacingEditType {
	
	UP, DOWN, NORTH, SOUTH, WEST, EAST, OPPOSITE, EQUAL, NULL;
	
	EnumFacingEditType(){}
	
	public String getName(){
		String s = null;
		switch(this){
			case UP:       s = "UP"; break;
			case DOWN:     s = "DOWN"; break;
			case NORTH:    s = "NORTH"; break;
			case SOUTH:    s = "SOUTH"; break;
			case WEST:     s = "WEST"; break;
			case EAST:     s = "EAST"; break;
			case OPPOSITE: s = "OPPOSITE"; break;
			case EQUAL:    s = "EQUAL"; break;
			case NULL:     s = "NULL"; break;
		}
		return s;
	}
	
	public EnumFacing toFacing(EnumFacing playerFacing){
		EnumFacing ef = null;
		switch(this){
			case UP:       ef = EnumFacing.UP; break;
			case DOWN:     ef = EnumFacing.DOWN; break;
			case NORTH:    ef = EnumFacing.NORTH; break;
			case SOUTH:    ef = EnumFacing.SOUTH; break;
			case WEST:     ef = EnumFacing.WEST; break;
			case EAST:     ef = EnumFacing.EAST; break;
			case OPPOSITE: ef = playerFacing.getOpposite(); break;
			case EQUAL:    ef = playerFacing; break;
			case NULL:     ef = null; break;
		}
		return ef;
	}
}