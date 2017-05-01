package net.fexcraft.mod.lib.util.render;

public enum ModelType {
	
	JSON("json"), JAVA("java"), JTMT("jtmt"), TMT("tmt"), OBJ("obj"), NONE("null");
	
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