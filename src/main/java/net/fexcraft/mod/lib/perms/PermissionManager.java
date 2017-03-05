package net.fexcraft.mod.lib.perms;

import java.util.TreeMap;

import net.fexcraft.mod.lib.perms.PermissionNode.Type;

public class PermissionManager {
	
	public static TreeMap<String, PermissionNode> permissionnodes = new TreeMap<String, PermissionNode>();
	
	public static void initialize(){
		add(Permissions.GENRAL_BLOCK_BREAK, Type.BOOLEAN, true);
		add(Permissions.GENRAL_BLOCK_PLACE, Type.BOOLEAN, true);
	}
	
	public static final void add(String id, Type type, Object default_value){
		switch(type){
			case BOOLEAN:
				permissionnodes.put(id, new PermissionBool(id, type, default_value));
				break;
			case NUMBER:
				permissionnodes.put(id, new PermissionNumber(id, type, default_value));
				break;
			case STRING:
				permissionnodes.put(id, new PermissionString(id, type, default_value));
				break;
			default:
				break;
		}
	}
	
}