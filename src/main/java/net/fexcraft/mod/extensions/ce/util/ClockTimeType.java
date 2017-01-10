package net.fexcraft.mod.extensions.ce.util;

public enum ClockTimeType {
	
	REAL_SYSTEM("real_system"),
	REAL_CUSTOM("real_custom"),
	MINECRAFT_WORLD("minecraft_world"),
	REAL_SYSTEM_REVERSE("real_system_reverse"),
	REAL_CUSTOM_REVERSE("real_custom_reverse"),
	MINECRAFT_WORLD_REVERSE("minecraft_world_reverse"),
	NULL("null");
	
	private String name;
	
	ClockTimeType(String s){
		name = s;
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	public static ClockTimeType fromString(String s){
		for(ClockTimeType type : values()){
			if(type.name.equals(s)){
				return type;
			}
		}
		return NULL;
	}
}