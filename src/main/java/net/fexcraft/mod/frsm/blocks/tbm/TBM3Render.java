package net.fexcraft.mod.frsm.blocks.tbm;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TBM3Render extends FTESR_4R {
       
	private static final ModelTBM3 model = new ModelTBM3();

	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/TBM3.png");
	}

	@Override
	public void renderModel(TileEntity tileentity, float partialticks, int destroystage){
		int i = Time.getSecond();
		GL11.glRotatef(i * 6, 0.0F, 1.0F, 0.0F);
		//GL11.glRotated(180, 0F, 1F, 0F);
		GL11.glTranslatef(-0.5F, 1.5F, -0.5F);
		this.model.render(this.model.base);
		GL11.glRotatef(i * -6, 0.0F, 1.0F, 0.0F);
		this.model.render(this.model.r1);
	}
	
}