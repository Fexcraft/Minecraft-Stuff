package net.fexcraft.mod.frsm.blocks.tbm;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class TBM2Render extends FTESR_4R {
       
	private final ModelTBM2 model;
	private float t;
       
	public TBM2Render() {
		this.model = new ModelTBM2();
	}

	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/TBM2.png";
	}
	
	@Override
	public void ModelRender(){
		//int i = Calendar.getInstance().get(Calendar.MILLISECOND);
		if(t == 360){t = 0;}
		t = t + 0.1F;		
		GL11.glRotatef(t, 0.0F, 1.0F, 0.0F);
		//GL11.glRotated(180, 0F, 1F, 0F);
		GL11.glTranslatef(-0.5F, 1.5F, -0.5F);
		this.model.render(this.model.base);
	}
}