package net.fexcraft.mod.frsm.blocks.clock;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.render.RGB;

public class ClockBaseModel extends ModelBase {
	
	public ModelRendererTurbo base[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo paintable[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo hour[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo minute[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo second[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo hour_[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo minute_[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo second_[] = new ModelRendererTurbo[0];

	@Override
	public void render(){
		render(base);
		render(paintable);
	}
	
	public void render(ClockBaseTileEntity type){
		render(base);
		//
		type.getColor().glColorApply();
		render(paintable);
		RGB.glColorReset();
		//
		GL11.glTranslatef(0F, 1F, 0F);
		GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
		//
		int h = type.getHour12();
		int m = type.getMinute();
		int s = type.getSecond();
		//
		int a = 0;
		if(m == 0){
			a = 0;
		}
		else{
			a = Math.round(m / 2);
		}
		GL11.glRotatef((h * -30) - a, 1.0F, 0.0F, 0.0F);
		render(hour);
		GL11.glRotatef((h * +30) + a, 1.0F, 0.0F, 0.0F);
		//
		GL11.glRotatef(m * -6, 1.0F, 0.0F, 0.0F);
		render(minute);
		GL11.glRotatef(m * +6, 1.0F, 0.0F, 0.0F);
		//
		if(s != -66){
			GL11.glRotatef(s * -6, 1.0F, 0.0F, 0.0F);
			render(second);
			GL11.glRotatef(s * +6, 1.0F, 0.0F, 0.0F);
		}
		//
		if(type.twoSided()){
			GL11.glRotatef( 180f, 0, 1, 0);
			GL11.glRotatef((h * -30) - a, 1.0F, 0.0F, 0.0F);
			render(hour);
			GL11.glRotatef((h * +30) + a, 1.0F, 0.0F, 0.0F);
			//
			GL11.glRotatef(m * -6, 1.0F, 0.0F, 0.0F);
			render(minute);
			GL11.glRotatef(m * +6, 1.0F, 0.0F, 0.0F);
			//
			if(!(s == -66)){
				GL11.glRotatef(s * -6, 1.0F, 0.0F, 0.0F);
				render(second);
				GL11.glRotatef(s * +6, 1.0F, 0.0F, 0.0F);
			}
		}
		//
	}

	@Override
	public void translateAll(float x, float y, float z){
		translate(base, x, y, z);
		translate(paintable, x, y, z);
		translate(hour, x, y, z);
		translate(minute, x, y, z);
		translate(second, x, y, z);
	}
	
	public void rotateAll(float x, float y, float z){
		rotate(base, x, y, z);
		rotate(paintable, x, y, z);
		rotate(hour, x, y, z);
		rotate(minute, x, y, z);
		rotate(second, x, y, z);
	}

}