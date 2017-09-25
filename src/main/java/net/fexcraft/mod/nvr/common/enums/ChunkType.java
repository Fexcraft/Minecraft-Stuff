package net.fexcraft.mod.nvr.common.enums;

public enum ChunkType {
	
	PUBLIC,//anyone
	NEUTRAL,//unclaimed
	CLAIMED,//citizen only
	PRIVATE,//owner/s only
	COMPANY,//company only
	PROTECTED;//manager and up only
	
	public static ChunkType fromString(String string){
		for(ChunkType type : values()){
			if(type.name().equals(string)){
				return type;
			}
		}
		return NEUTRAL;
	}
	
}