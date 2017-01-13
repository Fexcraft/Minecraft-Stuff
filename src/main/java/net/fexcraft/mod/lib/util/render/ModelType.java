package net.fexcraft.mod.lib.util.render;

public enum ModelType {
	
	JSON("json"), JAVA("java"), TMT("tmt"), OBJ("obj"), NONE("");
	
	private String name;
	
	ModelType(String s){
		name = s;
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	public static ModelType fromString(String s){
		for(ModelType type : values()){
			if(type.name.equals(s)){
				return type;
			}
		}
		return NONE;
	}
}