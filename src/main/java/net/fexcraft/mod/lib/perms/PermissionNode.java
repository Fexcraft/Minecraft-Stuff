package net.fexcraft.mod.lib.perms;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class PermissionNode {
	
	protected String id;
	protected Type type;
	protected Object value;
	
	public PermissionNode(String id, Type type, Object value){
		this.id = id;
		this.type = type;
		switch(type){
			case BOOLEAN:
				this.value = (boolean)value;
				break;
			case NUMBER:
				this.value = (Number)value;
				break;
			case STRING:
				this.value = (String)value;
				break;
			default:
				break;
		}
	}
	
	public PermissionNode(String id, JsonElement elm){
		this.id = id;
		if(elm.isJsonPrimitive()){
			JsonPrimitive prim = elm.getAsJsonPrimitive();
			if(prim.isBoolean()){
				type = type.BOOLEAN;
				value = elm.getAsBoolean();
			}
			else if(prim.isNumber()){
				type = type.NUMBER;
				value = elm.getAsNumber();
			}
			else if(prim.isString()){
				type = type.STRING;
				value = elm.getAsString();
			}
			else{
				type = null;
				value = null;
				return;
			}
		}
		else{
			return;
		}
	}	
	
	protected static enum Type {
		BOOLEAN("boolean"),
		NUMBER("number"),
		STRING("string");
		
		private String id;
		
		Type(String name){
			id = name;
		}
		
		@Override
		public String toString(){
			return id;
		}
		
		public static Type fromString(String s){
			for(Type type : values()){
				if(type.id.equals(s)){
					return type;
				}
			}
			return null;
		}
		
		public boolean isString(){
			return this == STRING;
		}

		public boolean isBoolean(){
			return this == BOOLEAN;
		}

		public boolean isNumber(){
			return this == NUMBER;
		}
		
	}
	
	/**
	 * To be overriden by extending classes.
	 * @param node PermissionNode to be compared to.
	 * @return if the other PermissionNode's value equals
	 */
	public boolean equals(PermissionNode node){
		return false;
	}

	public boolean isString(){
		return type == Type.STRING;
	}

	public boolean isBoolean(){
		return type == Type.BOOLEAN;
	}

	public boolean isNumber(){
		return type == Type.NUMBER;
	}
	
	public Type getType(){
		return type;
	}
	
	public String getId(){
		return id;
	}
	
	public Object getValue(){
		return value;
	}

	public String getStringValue(){
		return (String)value;
	}

	public Number getNumberValue(){
		return (Number)value;
	}

	public Boolean getBooleanValue(){
		return (Boolean)value;
	}
	
}