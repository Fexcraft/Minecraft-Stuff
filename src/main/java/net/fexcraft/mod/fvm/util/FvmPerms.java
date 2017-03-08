package net.fexcraft.mod.fvm.util;

import net.fexcraft.mod.fvm.items.VehicleItem;
import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.perms.PermissionNode.Type;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.item.ItemStack;

public class FvmPerms {
	
	public static final String LAND_VEHICLE_PLACE = "fvm.entity.land_vehicle.place";
	public static final String LAND_VEHICLE_BREAK = "fvm.entity.land_vehicle.break";
	public static final String LAND_VEHICLE_CREATE = "fvm.entity.land_vehicle.create";
	
	public static void register(){
		PermManager.add(LAND_VEHICLE_PLACE, Type.BOOLEAN, true, true);
		PermManager.add(LAND_VEHICLE_BREAK, Type.BOOLEAN, true, true);
		PermManager.add(LAND_VEHICLE_CREATE, Type.BOOLEAN, true, true);
	}
	
	public static String permPlace(ItemStack stack){
		String string = ((VehicleItem)stack.getItem()).getType().registryname;
		if(string.equals("item")){
			string = JsonUtil.getFromString(stack.getTagCompound().getString("VehicleType")).getAsJsonObject().get("RegistryName").getAsString();
		}
		return LAND_VEHICLE_PLACE.replace("land_vehicle", "land_vehicle." + string);
	}
	
	public static String permBreak(ItemStack stack){
		String string = ((VehicleItem)stack.getItem()).getType().registryname;
		if(string.equals("item")){
			string = JsonUtil.getFromString(stack.getTagCompound().getString("VehicleType")).getAsJsonObject().get("RegistryName").getAsString();
		}
		return LAND_VEHICLE_BREAK.replace("land_vehicle", "land_vehicle." + string);
	}
	
	public static String permCreate(ItemStack stack){
		String string = ((VehicleItem)stack.getItem()).getType().registryname;
		if(string.equals("item")){
			string = JsonUtil.getFromString(stack.getTagCompound().getString("VehicleType")).getAsJsonObject().get("RegistryName").getAsString();
		}
		return LAND_VEHICLE_CREATE.replace("land_vehicle", "land_vehicle." + string);
	}

	public static void addVehicle(String registryname){
		PermManager.add(LAND_VEHICLE_PLACE.replace("land_vehicle", "land_vehicle." + registryname), Type.BOOLEAN, true, false);
		PermManager.add(LAND_VEHICLE_BREAK.replace("land_vehicle", "land_vehicle." + registryname), Type.BOOLEAN, true, false);
		PermManager.add(LAND_VEHICLE_CREATE.replace("land_vehicle", "land_vehicle." + registryname), Type.BOOLEAN, true, false);
	}
	
}