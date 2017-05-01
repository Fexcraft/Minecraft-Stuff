package net.fexcraft.mod.fvm.models;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.data.TextObject;
import net.fexcraft.mod.fvm.data.VehicleType;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.entity.Entity;

public class VehicleModel extends FvmModelBase {
	
	public ModelRendererTurbo chassis[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo body[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyColoredPrimary[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyColoredSecondary[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyDoorOpen[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyDoorClose[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyDoorOpenColoredPrimary[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyDoorCloseColoredPrimary[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo turret[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo steering[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo wheels_import[] = new ModelRendererTurbo[0];
	
	private int tx, ty;
	
	public VehicleModel(){}
	
	public VehicleModel(JsonObject obj){
		if(obj == null || (obj.has("type") && obj.get("type").getAsString().equals("class"))){
			return;
		}
		creators = JsonUtil.jsonArrayToStringArray(obj.get("creators").getAsJsonArray());
		tx = obj.get("texture_size_x").getAsInt();
		ty = obj.get("texture_size_y").getAsInt();
		chassis = parse("chassis", obj, tx, ty);
		body = parse("body", obj, tx, ty);
		bodyColoredPrimary = parse("body_colored_primary", obj, tx, ty);
		bodyColoredSecondary= parse("body_colored_secondary", obj, tx, ty);
		bodyDoorOpen = parse("body_door_open", obj, tx, ty);
		bodyDoorClose = parse("body_door_close", obj, tx, ty);
		bodyDoorOpenColoredPrimary = parse("body_door_open_colored_primary", obj, tx, ty);
		bodyDoorCloseColoredPrimary = parse("body_door_close_colored_primary", obj, tx, ty);
		turret = parse("turret", obj, tx, ty);
		wheels_import = parse("wheels_import", obj, tx, ty);
	}
	

	public void render(VehicleType data){
		render(data, null);
	}
	
	public void render(VehicleType data, @Nullable Entity entity){
		//Vehicle Chassis
		render(chassis);
		
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
		render(steering);
		
		//Other
		render(wheels_import);
		
		if(entity != null){
			TextObject.render(data, entity.rotationYaw, entity.rotationPitch);
		}
	}
	
	@Override
	public void rotate(ModelRendererTurbo[] mod, float d, float d1, float d2){
		for(ModelRendererTurbo model : mod){
			model.rotateAngleX = d;
			model.rotateAngleY = d1;
			model.rotateAngleZ = d2;
		}
	}

	public void translateAll(float x, float y, float z){
		translate(chassis, x, y, z);
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
		flip(chassis);
		flip(body);
		flip(bodyColoredPrimary);
		flip(bodyColoredSecondary);
		flip(bodyDoorOpen);
		flip(bodyDoorClose);
		flip(bodyDoorOpenColoredPrimary);
		flip(bodyDoorCloseColoredPrimary);
		flip(turret);
		flip(steering);
		flip(wheels_import);
	}
	
}