package net.fexcraft.mod.extensions.ie.models;

import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class CabelModelBase extends ModelBase {
	
	public ModelRendererTurbo base[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo on[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo off[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo north[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo south[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo west[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo east[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo inN[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo inS[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo inW[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo inE[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo outN[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo outS[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo outW[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo outE[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo rotor[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo load0[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo load1[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo load2[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo load3[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo load4[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo load5[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo load6[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo load7[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo load8[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo load9[] = new ModelRendererTurbo[0];
	   
	public void render(){
		renderPart(base);
		renderPart(on);
		renderPart(off);
		renderPart(north);
		renderPart(south);
		renderPart(west);
		renderPart(east);
	}
	
	public void renderPart(ModelRendererTurbo[] part){
		for(ModelRendererTurbo mrt : part){
			mrt.render(0.0625F);
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
		translate(on, x, y, z);
		translate(off, x, y, z);
		translate(north, x, y, z);
		translate(south, x, y, z);
		translate(west, x, y, z);
		translate(east, x, y, z);
		translate(inN, x, y, z);
		translate(inS, x, y, z);
		translate(inW, x, y, z);
		translate(inE, x, y, z);
		translate(outN, x, y, z);
		translate(outS, x, y, z);
		translate(outW, x, y, z);
		translate(outE, x, y, z);
		translate(load0, x, y, z);
		translate(load1, x, y, z);
		translate(load2, x, y, z);
		translate(load3, x, y, z);
		translate(load4, x, y, z);
		translate(load5, x, y, z);
		translate(load6, x, y, z);
		translate(load7, x, y, z);
		translate(load8, x, y, z);
		translate(load9, x, y, z);
	}
}
