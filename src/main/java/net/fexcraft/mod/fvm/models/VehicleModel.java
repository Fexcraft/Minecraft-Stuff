package net.fexcraft.mod.fvm.models;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.data.VehicleType;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.json.JsonUtil;

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
	
}