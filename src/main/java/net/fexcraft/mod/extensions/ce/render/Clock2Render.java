package net.fexcraft.mod.extensions.ce.render;

import java.util.Calendar;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.extensions.ce.models.ModelClock2;
import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class Clock2Render extends FTESR_4R {
	
	public ModelClock2 model;
	
	public Clock2Render() {
		this.model = new ModelClock2();
	}
	
	public String texture = "frsm:textures/blocks/Clock1.png";
	
	@Override
	public final String getTexturePath(){
		return texture;
	}
	
	@Override
	public int adjustAngleBy(){
		return 90;
	}
	
	@Override
	public void ModelRender(){
		this.model.renderPart(this.model.base);
		GL11.glTranslatef(0F, 1F, 0F);
		GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
		int h = Calendar.getInstance().get(Calendar.HOUR);;
		int m = Calendar.getInstance().get(Calendar.MINUTE);
		int s = Calendar.getInstance().get(Calendar.SECOND);
		renderH(h, m);
		renderM(m);
		renderS(s);
		renderHR(h, m);
		renderMR(m);
		renderSR(s);
	}
	
	public void renderH(int h, int m){
		int a = 0;
		if(m == 0){a = 0;}
		else{a = Math.round(m / 2);}
		//PrintLog.printIn("a = " + a);
		GL11.glRotatef((h * -30) - a, 1.0F, 0.0F, 0.0F);
		this.model.renderPart(this.model.hour);
		GL11.glRotatef((h * +30) + a, 1.0F, 0.0F, 0.0F);
	}
	
	public void renderM(int m){
		GL11.glRotatef(m * -6, 1.0F, 0.0F, 0.0F);
		this.model.renderPart(this.model.minute);
		GL11.glRotatef(m * +6, 1.0F, 0.0F, 0.0F);
	}
	
	public void renderS(int s){
		GL11.glRotatef(s * -6, 1.0F, 0.0F, 0.0F);
		this.model.renderPart(this.model.second);
		GL11.glRotatef(s * +6, 1.0F, 0.0F, 0.0F);
	}
	
	public void renderHR(int h, int m){
		int a = 0;
		if(m == 0){a = 0;}
		else{a = Math.round(m / 2);}
		//PrintLog.printIn("a = " + a);
		GL11.glRotatef((h * +30) + a, 1.0F, 0.0F, 0.0F);
		this.model.renderPart(this.model.hourR);
		GL11.glRotatef((h * -30) - a, 1.0F, 0.0F, 0.0F);
	}
	
	public void renderMR(int m){
		GL11.glRotatef(m * +6, 1.0F, 0.0F, 0.0F);
		this.model.renderPart(this.model.minuteR);
		GL11.glRotatef(m * -6, 1.0F, 0.0F, 0.0F);
	}
	
	public void renderSR(int s){
		GL11.glRotatef(s * +6, 1.0F, 0.0F, 0.0F);
		this.model.renderPart(this.model.secondR);
		GL11.glRotatef(s * -6, 1.0F, 0.0F, 0.0F);
	}
}