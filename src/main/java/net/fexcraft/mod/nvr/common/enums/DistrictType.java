package net.fexcraft.mod.nvr.common.enums;

public enum DistrictType {
	
	MIXED,
	CENTER,
	VILLAGE,
	RESIDENTAL,
	COMMERCIAL,
	INDUSTRIAL,
	AGRICULTURAL,
	MINERAL,
	MILITARY,
	WASTELAND,
	UNSPECIFIED;
	
	public static DistrictType fromString(String string){
		for(DistrictType type : values()){
			if(type.name().equals(string)){
				return type;
			}
		}
		return WASTELAND;
	}
	
}