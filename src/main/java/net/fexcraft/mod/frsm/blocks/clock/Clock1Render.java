package net.fexcraft.mod.frsm.blocks.clock;

import java.util.Calendar;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class Clock1Render extends FTESR_4R {
	
	public ModelClock1 model;
	
	public Clock1Render() {
		this.model = new ModelClock1();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/Clock1.png";
	}
	
	@Override
	public int adjustAngleBy(){
		return 90;
	}
	
	@Override
	public void ModelRender(){
		this.model.render(this.model.bodyModel);
		GL11.glTranslatef(0F, 1F, 0F);
		GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
		renderH();
		renderM();
		renderS();
	}
	
	public void renderH(){
		int h = Calendar.getInstance().get(Calendar.HOUR);
		int m = Calendar.getInstance().get(Calendar.MINUTE);
		int a = 0;
		if(m == 0){a = 0;}
		else{a = Math.round(m / 2);}
		//PrintLog.printIn("a = " + a);
		GL11.glRotatef((h * -30) - a, 1.0F, 0.0F, 0.0F);
		this.model.render(this.model.trailerModel);
		GL11.glRotatef((h * +30) + a, 1.0F, 0.0F, 0.0F);
	}
	
	public void renderM(){
		int m = Calendar.getInstance().get(Calendar.MINUTE);
		GL11.glRotatef(m * -6, 1.0F, 0.0F, 0.0F);
		this.model.render(this.model.steeringWheelModel);
		GL11.glRotatef(m * +6, 1.0F, 0.0F, 0.0F);
	}
	
	public void renderS(){
		int s = Calendar.getInstance().get(Calendar.SECOND);
		GL11.glRotatef(s * -6, 1.0F, 0.0F, 0.0F);
		this.model.render(this.model.turretModel);
	}
}