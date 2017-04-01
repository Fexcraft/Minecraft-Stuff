package net.fexcraft.mod.fvm.models;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.data.PartType;
import net.fexcraft.mod.fvm.data.VehicleType;
import net.fexcraft.mod.fvm.util.FvmTickHandler;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.util.math.Vec3d;

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
	public ModelRendererTurbo track_wheels[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo track_wheels_right[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo track_wheels_left[] = new ModelRendererTurbo[0];
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
		//
		render(track_wheels);
		render(track_wheels_right);
		render(track_wheels_left);
		
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
			submodel.rotateAngleY = vehicle.wheelsYaw * 3.14159265F / 180F * 3F;
			submodel.render();
		}
		
		//Render Wheels
		for(ModelRendererTurbo element : wheel_back_left){
			element.rotateAngleZ = data.rotateWheels ? vehicle.wheelsAngle : 0;
			element.render();
		}
		for(ModelRendererTurbo element : wheel_back_right){
			element.rotateAngleZ = data.rotateWheels ? vehicle.wheelsAngle : 0;
			element.render();
		}
		for(ModelRendererTurbo element : wheel_back){
			element.rotateAngleZ = data.rotateWheels ? vehicle.wheelsAngle : 0;
			element.render();
		}
		for(ModelRendererTurbo element : wheel_front_left){
			element.rotateAngleZ = data.rotateWheels ? vehicle.wheelsAngle : 0;
			element.rotateAngleY = vehicle.wheelsYaw * Static.rad180 / 180F * 3F;
			element.render();
		}
		for(ModelRendererTurbo element : wheel_front_right){
			element.rotateAngleZ = data.rotateWheels ? vehicle.wheelsAngle : 0;
			element.rotateAngleY = vehicle.wheelsYaw * Static.rad180 / 180F * 3F;
			element.render();
		}
		for(ModelRendererTurbo element : wheel_front){
			element.rotateAngleZ = data.rotateWheels ? vehicle.wheelsAngle : 0;
			element.rotateAngleY = vehicle.wheelsYaw * Static.rad180 / 180F * 3F;
			element.render();
		}
		for(ModelRendererTurbo element : wheels){
			element.rotateAngleZ = data.rotateWheels ? vehicle.wheelsAngle : 0;
			element.render();
		}
		for(ModelRendererTurbo element : track_wheels){
			element.rotateAngleZ = data.rotateWheels ? vehicle.wheelsAngle : 0;
			element.render();
		}
		for(ModelRendererTurbo element : track_wheels_right){
			element.rotateAngleZ = data.rotateWheels ? vehicle.wheelsAngle : 0;
			element.render();
		}
		for(ModelRendererTurbo element : track_wheels_left){
			element.rotateAngleZ = data.rotateWheels ? vehicle.wheelsAngle : 0;
			element.render();
		}
		
		//Particles
		if(vehicle.throttle != 0 && data.parts.get(usedAS).pspawners != null){
			PartType part = data.parts.get(usedAS);
			for(int i = 0; i < part.pspawners.length; i++){
				if(FvmTickHandler.getClientTick() % part.pspawners[i].freq == 0){
					Vec3d vec = calculatePos(vehicle, part.pspawners[i].pos);
					vehicle.world.spawnParticle(part.pspawners[i].type, vec.xCoord, vec.yCoord, vec.zCoord, part.pspawners[i].sx, part.pspawners[i].sy, part.pspawners[i].sz);
				}
			}
		}
		
		//Render Other
		render(OTHER);
		render(TEST);
	}
	
	protected static Vec3d calculatePos(com.flansmod.fvm.LandVehicle vehicle, Pos pos){
		com.flansmod.common.vector.Vector3f loc = new com.flansmod.common.vector.Vector3f(pos.to16FloatX(), pos.to16FloatY(), pos.to16FloatZ());
		com.flansmod.common.vector.Vector3f rel = vehicle.axes.findLocalVectorGlobally(loc);
		return new Vec3d(vehicle.posX + rel.x, vehicle.posY + rel.y, vehicle.posZ + rel.z);
	}
	
	public void rotate(ModelRendererTurbo[] part, float x, float y, float z, boolean mode){
		if(!mode){
			super.rotate(part, x, y, z);
		}
		else{
			for(ModelRendererTurbo model : part){
				model.rotateAngleX = x;
				model.rotateAngleY = y;
				model.rotateAngleZ = z;
			}
		}
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
	
	public void flip(ModelRendererTurbo[] mod){
		for(ModelRendererTurbo sub : mod){
			sub.doMirror(false, true, true);
			sub.setRotationPoint(sub.rotationPointX, - sub.rotationPointY, - sub.rotationPointZ);
		}
	}

	public void flipAll(){
		flip(body);
		flip(bodyColoredPrimary);
		flip(bodyColoredSecondary);
		flip(bodyDoorOpen);
		flip(bodyDoorClose);
		flip(bodyDoorOpenColoredPrimary);
		flip(bodyDoorCloseColoredPrimary);
		flip(turret);
		flip(steering);
		flip(wheels);
		flip(wheel_front);
		flip(wheel_back);
		flip(wheel_front_left);
		flip(wheel_front_right);
		flip(wheel_back_left);
		flip(wheel_back_right);
		flip(track_wheels);
		flip(track_wheels_right);
		flip(track_wheels_left);
	}
	
	public void def_renderWheels4(VehicleType type, String us){
		switch(us){
			case "left_front_wheel":
				render(wheel_front_left);
				break;
			case "right_front_wheel":
				render(wheel_front_right);
				break;
			case "left_back_wheel":
				render(wheel_back_left);
				break;
			case "right_back_wheel":
				render(wheel_back_right);
				break;
		}
	}
	
	public void def_renderWheels4(VehicleType type, String us, com.flansmod.fvm.LandVehicle vehicle){
		switch(us){
			case "left_front_wheel":
				for(ModelRendererTurbo element : wheel_front_left){
					element.rotateAngleZ = type.rotateWheels ? vehicle.wheelsAngle : 0;
					element.rotateAngleY = vehicle.wheelsYaw * Static.rad180 / 180F * 3F;
					element.render();
					element.rotateAngleY = 0;
				}
				break;
			case "right_front_wheel":
				for(ModelRendererTurbo element : wheel_front_right){
					element.rotateAngleZ = type.rotateWheels ? vehicle.wheelsAngle : 0;
					element.rotateAngleY = vehicle.wheelsYaw * Static.rad180 / 180F * 3F;
					element.render();
					element.rotateAngleY = 0;
				}
				break;
			case "left_back_wheel":
				for(ModelRendererTurbo element : wheel_back_left){
					element.rotateAngleZ = type.rotateWheels ? vehicle.wheelsAngle : 0;
					element.render();
				}
				break;
			case "right_back_wheel":
				for(ModelRendererTurbo element : wheel_back_right){
					element.rotateAngleZ = type.rotateWheels ? vehicle.wheelsAngle : 0;
					element.render();
				}
				break;
		}
	}
	
}