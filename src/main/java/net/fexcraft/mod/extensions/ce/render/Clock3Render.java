package net.fexcraft.mod.extensions.ce.render;

import java.util.Calendar;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.extensions.ce.models.ModelClock3;
import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class Clock3Render extends FTESR_4R {
	
	public ModelClock3 model;
	
	public Clock3Render(String type){
		this.model = new ModelClock3();
		this.texture = "frsm_ce:textures/blocks/Clock3_" + type + ".png";
	}
	
	public String texture;// = "frsm_ce:textures/blocks/Clock3_W.png";
	
	@Override
	public final String getTexturePath(){
		return texture;
	}
	
	@Override
	public int adjustAngleBy(){
		return 180;
	}
	
	@Override
	public void ModelRender(){
		this.model.renderPart(this.model.base);
		GL11.glTranslatef(0F, 1F, 0F);
		GL11.glRotatef(180, 1F, 0F, 0F);
		GL11.glRotatef(180, 0F, 1F, 0F);
		GL11.glTranslatef(0F, 0F, 0.1F);
		int s = Calendar.getInstance().get(Calendar.SECOND);
		int m = Calendar.getInstance().get(Calendar.MINUTE);
		int h = Calendar.getInstance().get(Calendar.HOUR);
		renderH(h, m);
		renderM(m);
		renderS(s);
	}
	
	public void renderH(int h, int m){
		int a = 0;
		if(m == 0){a = 0;}
		else{a = Math.round(m / 2);}
		GL11.glRotatef((h * -30) - a, 0.0F, 0.0F, 1.0F);
		this.model.renderPart(this.model.hour);
		GL11.glRotatef((h * +30) + a, 0.0F, 0.0F, 1.0F);
	}
	
	public void renderM(int m){
		GL11.glRotatef(m * -6, 0.0F, 0.0F, 1.0F);
		this.model.renderPart(this.model.minute);
		GL11.glRotatef(m * +6, 0.0F, 0.0F, 1.0F);
	}
	
	public void renderS(int s){
		GL11.glRotatef(s * -6, 0.0F, 0.0F, 1.0F);
		this.model.renderPart(this.model.second);
		GL11.glRotatef(s * +6, 0.0F, 0.0F, 1.0F);
	}
}