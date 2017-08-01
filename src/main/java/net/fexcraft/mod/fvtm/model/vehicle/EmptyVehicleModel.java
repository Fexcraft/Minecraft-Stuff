package net.fexcraft.mod.fvtm.model.vehicle;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleData;
import net.minecraft.entity.Entity;

public class EmptyVehicleModel extends VehicleModel {
	
	public static EmptyVehicleModel INSTANCE = new EmptyVehicleModel();

	public void render(LandVehicleData data){
		return;
	}
	
	public void render(LandVehicleData data, @Nullable Entity entity, int meta){
		return;
	}
	
}