package net.fexcraft.mod.lib.perms;

import java.math.BigDecimal;

public class PermissionNumber extends PermissionNode {

	public PermissionNumber(String id, Type type, Object value){
		super(id, type, value);
	}

	@Override
	public boolean equals(PermissionNode node){
		if(node.isNumber()){
			return compare(this.get(), node.getNumberValue());
		}
		if(node.isBoolean()){
			return compare(this.get(), node.getBooleanValue() == true ? 1 : 0);
		}
		if(node.isString()){
			return compare(this.get(), node.getStringValue());
		}
		return false;
	}
	
	public Number get(){
		return this.getNumberValue();
	}
	
	private boolean compare(Number n, Number i){
		BigDecimal nn = new BigDecimal(n.doubleValue());
		BigDecimal ii = new BigDecimal(i.doubleValue());
		return nn.compareTo(ii) == 1;
	}
	
	private boolean compare(Number n, String i){
		BigDecimal nn = new BigDecimal(n.doubleValue());
		BigDecimal ii = new BigDecimal(i);
		return nn.compareTo(ii) == 1;
	}
	
}