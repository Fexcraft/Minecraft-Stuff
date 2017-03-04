package net.fexcraft.mod.fvm.models;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.data.VehicleType;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.json.JsonUtil;

public class PartModel extends FvmModelBase {
	
	public ModelRendererTurbo body[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyColoredPrimary[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyColoredSecondary[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyDoorOpen[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyDoorClose[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyDoorOpenColoredPrimary[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyDoorCloseColoredPrimary[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo turret[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo steering[] = new ModelRendererTurbo[0];
	//
	public ModelRendererTurbo wheels[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo wheel_front[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo wheel_back[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo wheel_front_left[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo wheel_back_left[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo wheel_front_right[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo wheel_back_right[] = new ModelRendererTurbo[0];
	//
	public ModelRendererTurbo OTHER[] = new ModelRendererTurbo[0];//GRMS
	public ModelRendererTurbo TEST[] = new ModelRendererTurbo[0];
	
	
	private int tx, ty;
	
	public PartModel(){}
	
	public PartModel(JsonObject obj){
		if(obj == null){
			return;
		}
		creators = JsonUtil.jsonArrayToStringArray(obj.get("creators").getAsJsonArray());
		tx = obj.get("texture_size_x").getAsInt();
		ty = obj.get("texture_size_y").getAsInt();
		body = parse("body", obj, tx, ty);
		bodyColoredPrimary = parse("body_colored_primary", obj, tx, ty);
		bodyColoredSecondary= parse("body_colored_secondary", obj, tx, ty);
		bodyDoorOpen = parse("body_door_open", obj, tx, ty);
		bodyDoorClose = parse("body_door_close", obj, tx, ty);
		bodyDoorOpenColoredPrimary = parse("body_door_open_colored_primary", obj, tx, ty);
		bodyDoorCloseColoredPrimary = parse("body_door_close_colored_primary", obj, tx, ty);
		turret = parse("turret", obj, tx, ty);
		//
		steering = parse("steering", obj, tx, ty);
		wheels = parse("wheels", obj, tx, ty);
		wheel_front = parse("wheel_front", obj, tx, ty);
		wheel_back = parse("wheel_back", obj, tx, ty);
		wheel_front_left = parse("wheel_front_left", obj, tx, ty);
		wheel_back_left = parse("wheel_back_left", obj, tx, ty);
		wheel_front_right = parse("wheel_front_right", obj, tx, ty);
		wheel_back_right = parse("wheel_back_right", obj, tx, ty);
	}

	public void render(VehicleType data, String usedAS){
		//Vehicle Body
		render(body);
		if(data.doors){
			render(bodyDoorOpen);
		}
		else{
			render(bodyDoorClose);
		}
		
		//Render Primary Color Things
		data.primaryColor.glColorApply();
		render(bodyColoredPrimary);
		if(data.doors){
			render(bodyDoorOpenColoredPrimary);
		}
		else{
			render(bodyDoorCloseColoredPrimary);
		}
		data.primaryColor.glColorReset();
		
		//Render Secondary Color Things
		data.secondaryColor.glColorApply();
		render(bodyColoredSecondary);
		data.secondaryColor.glColorReset();
		
		//Render Turret
		render(turret);
		
		//TODO
		//rotateSteeringWheel();
		render(steering);
		
		//Render Wheels
		render(wheels);
		render(wheel_front);
		render(wheel_back);
		render(wheel_front_right);
		render(wheel_back_right);
		render(wheel_front_left);
		render(wheel_back_left);
		
		//Render Other
		render(OTHER);
		render(TEST);
	}
	
	public void render(VehicleType data, String usedAS, com.flansmod.fvm.LandVehicle vehicle){
		//Vehicle Body
		render(body);
		if(data.doors){
			render(bodyDoorOpen);
		}
		else{
			render(bodyDoorClose);
		}
		
		//Render Primary Color Things
		data.primaryColor.glColorApply();
		render(bodyColoredPrimary);
		if(data.doors){
			render(bodyDoorOpenColoredPrimary);
		}
		else{
			render(bodyDoorCloseColoredPrimary);
		}
		data.primaryColor.glColorReset();
		
		//Render Secondary Color Things
		data.secondaryColor.glColorApply();
		render(bodyColoredSecondary);
		data.secondaryColor.glColorReset();
		
		//Render Turret
		render(turret);
		
		//Render Steering
		for (ModelRendererTurbo submodel : steering) {
			submodel.rotateAngleX = vehicle.wheelsYaw * 3.14159265F / 180F * 3F;
			submodel.render();
		}
		
		//Render Wheels
		for(ModelRendererTurbo element : wheel_back_left){
			element.rotateAngleZ = data.rotateWheels ? vehicle.wheelsAngle : 0;
			element.render();
			element.rotateAngleZ = 0;
		}
		for(ModelRendererTurbo element : wheel_back_right){
			element.rotateAngleZ = data.rotateWheels ? vehicle.wheelsAngle : 0;
			element.render();
			element.rotateAngleZ = 0;
		}
		for(ModelRendererTurbo element : wheel_back){
			element.rotateAngleZ = data.rotateWheels ? vehicle.wheelsAngle : 0;
			element.render();
			element.rotateAngleZ = 0;
		}
		for(ModelRendererTurbo element : wheel_front_left){
			element.rotateAngleZ = data.rotateWheels ? vehicle.wheelsAngle : 0;
			element.render();
			element.rotateAngleZ = 0;
		}
		for(ModelRendererTurbo element : wheel_front_right){
			element.rotateAngleZ = data.rotateWheels ? vehicle.wheelsAngle : 0;
			element.render();
			element.rotateAngleZ = 0;
		}
		for(ModelRendererTurbo element : wheel_front){
			element.rotateAngleZ = data.rotateWheels ? vehicle.wheelsAngle : 0;
			element.render();
			element.rotateAngleZ = 0;
		}
		for(ModelRendererTurbo element : wheels){
			element.rotateAngleZ = data.rotateWheels ? vehicle.wheelsAngle : 0;
			element.render();
			element.rotateAngleZ = 0;
		}
		
		//Render Other
		render(OTHER);
		render(TEST);
	}

	public void translateAll(float x, float y, float z){
		translate(body, x, y, z);
		translate(bodyColoredPrimary, x, y, z);
		translate(bodyColoredSecondary, x, y, z);
		translate(bodyDoorOpen, x, y, z);
		translate(bodyDoorClose, x, y, z);
		translate(bodyDoorOpenColoredPrimary, x, y, z);
		translate(bodyDoorCloseColoredPrimary, x, y, z);
		translate(turret, x, y, z);
		translate(steering, x, y, z);
	}
	
}