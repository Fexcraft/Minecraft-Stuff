package net.fexcraft.mod.fvm.model;

import net.fexcraft.mod.fvm.data.Vehicle.VehicleData;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.entity.Entity;

public abstract class AdjustableWheelModel extends PartModel {
	
	@Override
	public void render(VehicleData data, String usedAS){
		Pos pos = Pos.fromJSON(data.parts.get(usedAS).part.modelsettings.get(data.vehicle.registryname).get(usedAS).getAsJsonObject());
		pos.translate();
		switch(usedAS){
			case "left_front_wheel":
				renderLeftFront(data, usedAS);
				break;
			case "right_front_wheel":
				renderRightFront(data, usedAS);
				break;
			case "left_back_wheel":
				renderLeftBack(data, usedAS);
				break;
			case "right_back_wheel":
				renderRightBack(data, usedAS);
				break;
			case "wheel":
			case "cargo":
			case "wheels":
			case "exchange_wheel":
				renderExchangeWheel(data, usedAS);
				break;
		}
		pos.translateR();
	}
	
	public abstract void renderExchangeWheel(VehicleData data, String usedAS);

	public abstract void renderRightBack(VehicleData data, String usedAS);

	public abstract void renderLeftBack(VehicleData data, String usedAS);

	public abstract void renderRightFront(VehicleData data, String usedAS);

	public abstract void renderLeftFront(VehicleData data, String usedAS);

	@Override
	public void render(VehicleData data, String usedAS, Entity vehicle){
		Pos pos = Pos.fromJSON(data.parts.get(usedAS).part.modelsettings.get(data.vehicle.registryname).get(usedAS).getAsJsonObject());
		pos.translate();
		switch(usedAS){
			case "left_front_wheel":
				renderLeftFront(data, usedAS, vehicle);
				break;
			case "right_front_wheel":
				renderRightFront(data, usedAS, vehicle);
				break;
			case "left_back_wheel":
				renderLeftBack(data, usedAS, vehicle);
				break;
			case "right_back_wheel":
				renderRightBack(data, usedAS, vehicle);
				break;
			case "wheel":
			case "cargo":
			case "wheels":
			case "exchange_wheel":
				renderExchangeWheel(data, usedAS, vehicle);
				break;
		}
		pos.translateR();
	}
	
	public abstract void renderExchangeWheel(VehicleData data, String usedAS, Entity vehicle);

	public abstract void renderRightBack(VehicleData data, String usedAS, Entity vehicle);

	public abstract void renderLeftBack(VehicleData data, String usedAS, Entity vehicle);

	public abstract void renderRightFront(VehicleData data, String usedAS, Entity vehicle);

	public abstract void renderLeftFront(VehicleData data, String usedAS, Entity vehicle);
	
}