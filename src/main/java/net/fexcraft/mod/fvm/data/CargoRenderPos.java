package net.fexcraft.mod.fvm.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.util.math.Pos;

public class CargoRenderPos {
	
	public Pos pos;
	public String id;
	public boolean renderAlways;
	public float scale;
	
	public CargoRenderPos(JsonObject obj, int i){
		pos = Pos.fromJSON(obj);
		id = obj.has("id") ? obj.get("id").getAsString() : "id" + i;
		renderAlways = obj.has("render_always") ? obj.get("render_always").getAsBoolean() : true;
		scale = obj.has("scale") ? getScale(obj.get("scale")) : 1f;
		
		//pos.x -= 8;//* scale;
		pos.z += 16;//* scale;
	}

	private float getScale(JsonElement elm){
		if(elm.getAsJsonPrimitive().isNumber()){
			scale = elm.getAsFloat();
		}
		else if(elm.getAsJsonPrimitive().isString()){
			switch(elm.getAsString()){
				case "normal":
					return 1f;
				case "half":
					return 0.5f;
				case "quarter":
					return 0.25f;
			}
		}
		return 1f;
	}
	
}