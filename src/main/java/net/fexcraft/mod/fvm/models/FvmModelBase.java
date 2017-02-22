package net.fexcraft.mod.fvm.models;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.tmt.Model;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class FvmModelBase extends Model {
	
	public ArrayList<String> creators = new ArrayList<String>();
	protected static final float def = 0f;
	protected static final int idef = 0;
	
	private static final float get(String s, JsonObject obj, float def){
		if(obj.has(s)){
			return obj.get(s).getAsFloat();
		}
		return def;
	}
	
	private static final int get(String s, JsonObject obj, int def){
		if(obj.has(s)){
			return obj.get(s).getAsInt();
		}
		return def;
	}
	
	protected ModelRendererTurbo[] parse(String string, JsonObject object, int tx, int ty){
		if(object.has(string)){
			JsonArray array = object.get(string).getAsJsonArray();
			ModelRendererTurbo[] model = new ModelRendererTurbo[array.size()];
			for(int i = 0; i < array.size(); i++){
				JsonObject obj = array.get(i).getAsJsonObject();
				model[i] = new ModelRendererTurbo(this, get("texture_x", obj, idef), get("texture_y", obj, idef), tx, ty);
				//
				float x = get("pos_x", obj, def);
				float y = get("pos_y", obj, def);
				float z = get("pos_z", obj, def);
				int w = get("width", obj, idef);
				int h = get("height", obj, idef);
				int d = get("depth", obj, idef);
				//
				switch(obj.get("type").getAsString()){
					case "box":
						model[i].addBox(x, y, z, w, h, d, get("expansion", obj, def));
						break;
					case "shapebox":
						model[i].addShapeBox(x, y, z, w, h, d, get("scale", obj, def),
								get("x0", obj, def), get("y0", obj, def), get("z0", obj, def),
								get("x1", obj, def), get("y1", obj, def), get("z1", obj, def),
								get("x2", obj, def), get("y2", obj, def), get("z2", obj, def),
								get("x3", obj, def), get("y3", obj, def), get("z3", obj, def),
								get("x4", obj, def), get("y4", obj, def), get("z4", obj, def),
								get("x5", obj, def), get("y5", obj, def), get("z5", obj, def),
								get("x6", obj, def), get("y6", obj, def), get("z6", obj, def),
								get("x7", obj, def), get("y7", obj, def), get("z7", obj, def)
							);
						break;
				}
				model[i].setRotationPoint(get("rotation_point_x", obj, def), get("rotation_point_y", obj, def), get("rotation_point_z", obj, def));
			}
			return model;
		}
		return new ModelRendererTurbo[0];
	}
	
	@Override
	public void render(){
		//
	}

	@Override
	public void render(ModelRendererTurbo[] model){
		for(ModelRendererTurbo mrt : model){
			mrt.render();
		}
	}

	@Override
	protected void translate(ModelRendererTurbo[] model, float x, float y, float z) {
		for(ModelRendererTurbo mod : model){
			mod.rotationPointX += x;
			mod.rotationPointY += y;
			mod.rotationPointZ += z;
		}
	}

	@Override
	protected void rotate(ModelRendererTurbo[] model, float x, float y, float z) {
		for(ModelRendererTurbo mod : model){
			mod.rotateAngleX += x;
			mod.rotateAngleY += y;
			mod.rotateAngleZ += z;
		}
	}
	
	protected void rotate(ModelRendererTurbo[] model, double x, double y, double z) {
		rotate(model, (float)x, (float)y, (float)z);
	}
	
}