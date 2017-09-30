package net.fexcraft.mod.nvr.common.enums;

import java.awt.Color;

public enum ChunkType {
	
	PUBLIC    ("#F2F2F2"),//anyone
	NEUTRAL   ("#A3A3A3"),//unclaimed
	CLAIMED   ("#8CDBB8"),//citizen only
	PRIVATE   ("#A936AD"),//owner/s only
	COMPANY   ("#289BB5"),//company only
	PROTECTED ("#FFD103");//manager and up only
	
	public Color color;
	
	ChunkType(String color){
		this.color = Color.decode(color);
	}
	
	public static ChunkType fromString(String string){
		for(ChunkType type : values()){
			if(type.name().equals(string)){
				return type;
			}
		}
		return NEUTRAL;
	}

	public Color getColor(){
		return color;
	}
	
}