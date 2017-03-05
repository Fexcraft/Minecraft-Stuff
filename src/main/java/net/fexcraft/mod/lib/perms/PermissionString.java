package net.fexcraft.mod.lib.perms;

public class PermissionString extends PermissionNode {

	public PermissionString(String id, Type type, Object value){
		super(id, type, value);
	}

	@Override
	public boolean equals(PermissionNode node){
		if(!node.isBoolean()){
			if(node.isString()){
				return this.getStringValue().equals(node.getStringValue());
			}
			if(node.isNumber()){
				return this.getStringValue().equals(node.getNumberValue() + "");
			}
		}
		return this.get().equals(node.getValue() + "");
	}
	
	public String get(){
		return this.getStringValue();
	}
	
}