package net.fexcraft.mod.fvm.data;

import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.util.math.Pos;

public class Seat {
	
	public boolean driver = false;
	public Pos pos;
	
	public Seat(JsonObject obj){
		if(obj.has("driver")){
			driver = obj.get("driver").getAsBoolean();
		}
		pos = Pos.fromJSON(obj);
	}
	
	public void translate(){
		pos.translate();
	}
	
	public void translateR(){
		pos.translateR();
	}

	public boolean isDriver(){
		return driver;
	}
	
	public float x(){
		return pos.to16FloatX();
	}
	
	public float y(){
		return pos.to16FloatY();
	}
	
	public float z(){
		return pos.to16FloatZ();
	}
	
}