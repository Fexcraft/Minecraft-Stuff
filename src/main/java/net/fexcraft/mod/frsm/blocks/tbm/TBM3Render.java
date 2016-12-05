package net.fexcraft.mod.frsm.blocks.tbm;

import java.util.Calendar;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class TBM3Render extends FTESR_4R {
       
	private final ModelTBM3 model;
       
	public TBM3Render() {
		this.model = new ModelTBM3();
	}

	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/TBM3.png";
	}
	
	@Override
	public void ModelRender(){
		int i = Calendar.getInstance().get(Calendar.SECOND);
		GL11.glRotatef(i * 6, 0.0F, 1.0F, 0.0F);
		//GL11.glRotated(180, 0F, 1F, 0F);
		GL11.glTranslatef(-0.5F, 1.5F, -0.5F);
		this.model.render(this.model.base);
		GL11.glRotatef(i * -6, 0.0F, 1.0F, 0.0F);
		this.model.render(this.model.r1);
	}
}