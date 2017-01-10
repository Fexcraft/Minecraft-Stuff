package net.fexcraft.mod.extensions.ce.util;

import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;


public class ClockModelBase extends ModelBase {
	
	public ModelRendererTurbo base[] = new ModelRendererTurbo[0];
	
	public ModelRendererTurbo second[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo minute[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo hour[] = new ModelRendererTurbo[0];
	
	public ModelRendererTurbo secondR[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo minuteR[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo hourR[] = new ModelRendererTurbo[0];
	   
	public void render(){
		render(base);
		render(second);
		render(minute);
		render(hour);
		render(secondR);
		render(minuteR);
		render(hourR);
	}

	public void render(ModelRendererTurbo[] part){
		for(ModelRendererTurbo bit : part){
			bit.render(0.0625F);
		}
	}
	
	protected void translate(ModelRendererTurbo[] model, float x, float y, float z){
		for(ModelRendererTurbo mod : model){
			mod.rotationPointX += x;
			mod.rotationPointY += y;
			mod.rotationPointZ += z;
		}
	}
	
	public void translateAll(float x, float y, float z){
		translate(base, x, y, z);
		translate(second, x, y, z);
		translate(minute, x, y, z);
		translate(hour, x, y, z);
		translate(secondR, x, y, z);
		translate(minuteR, x, y, z);
		translate(hourR, x, y, z);
	}
}
