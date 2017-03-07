package net.fexcraft.mod.fvm.util;

import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.perms.PermissionNode.Type;

public class FvmPerms {
	
	public static final String LAND_VEHICLE_PLACE = "fvm.land_vehicle.place";
	public static final String LAND_VEHICLE_BREAK = "fvm.land_vehicle.break";
	
	public static void register(){
		PermManager.add(LAND_VEHICLE_PLACE, Type.BOOLEAN, true, true);
		PermManager.add(LAND_VEHICLE_BREAK, Type.BOOLEAN, true, true);
	}
	
}