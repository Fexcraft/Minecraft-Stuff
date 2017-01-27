package net.fexcraft.mod.frsm.blocks.tv;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.öTESR;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

@öTESR(tileentity = TVS2Entity.class)
public class TVS2Render extends FTESR_4R {
	
	private static final TVS2Model model = new TVS2Model();

	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/TVS2.png");
	}

	@Override
	public void renderModel(TileEntity tileentity, float partialticks, int destroystage){
		GL11.glRotated(180, 0F, 1F, 0F);
		GL11.glTranslatef(-0.5F, 1.5F, -0.5F);
		GL11.glRotatef(Math.round(22.5F * ((TVS2Entity)tileentity).getRotation()), 0F, 1F, 0F);
		this.model.render();
	}
	
}