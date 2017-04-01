package net.fexcraft.mod.fvm.models;

import net.fexcraft.mod.fvm.data.VehicleType;
import net.fexcraft.mod.lib.util.math.Pos;

public abstract class AdjustableWheelModel extends PartModel {
	
	private Pos pos;
	
	@Override
	public void render(VehicleType data, String usedAS){
		pos = Pos.fromJSON(data.parts.get(usedAS).modelsettings.get(data.registryname).get(usedAS).getAsJsonObject());
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
	
	public abstract void renderExchangeWheel(VehicleType data, String usedAS);

	public abstract void renderRightBack(VehicleType data, String usedAS);

	public abstract void renderLeftBack(VehicleType data, String usedAS);

	public abstract void renderRightFront(VehicleType data, String usedAS);

	public abstract void renderLeftFront(VehicleType data, String usedAS);

	@Override
	public void render(VehicleType data, String usedAS, com.flansmod.fvm.LandVehicle vehicle){
		pos = Pos.fromJSON(data.parts.get(usedAS).modelsettings.get(data.registryname).get(usedAS).getAsJsonObject());
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
	
	public abstract void renderExchangeWheel(VehicleType data, String usedAS, com.flansmod.fvm.LandVehicle vehicle);

	public abstract void renderRightBack(VehicleType data, String usedAS, com.flansmod.fvm.LandVehicle vehicle);

	public abstract void renderLeftBack(VehicleType data, String usedAS, com.flansmod.fvm.LandVehicle vehicle);

	public abstract void renderRightFront(VehicleType data, String usedAS, com.flansmod.fvm.LandVehicle vehicle);

	public abstract void renderLeftFront(VehicleType data, String usedAS, com.flansmod.fvm.LandVehicle vehicle);
	
}