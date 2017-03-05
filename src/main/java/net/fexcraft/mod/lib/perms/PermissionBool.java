package net.fexcraft.mod.lib.perms;

public class PermissionBool extends PermissionNode {

	public PermissionBool(String id, Type type, Object def_value){
		super(id, type, def_value);
	}

	@Override
	public boolean equals(PermissionNode node){
		if(node.isBoolean()){
			return this.getBooleanValue().equals(node.getBooleanValue());
		}
		if(node.isString()){
			return this.getBooleanValue().equals(Boolean.parseBoolean(node.getStringValue()));
		}
		if(node.isNumber()){
			try{
				return this.getBooleanValue() == (node.getNumberValue().intValue() == 1);
			}
			catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	public boolean get(){
		return this.getBooleanValue();
	}
	
}