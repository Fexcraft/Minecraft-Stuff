package net.fexcraft.mod.extensions.ie.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.extensions.ie.blocks.FireWorkSpawner.FWSTE;
import net.fexcraft.mod.extensions.ie.models.ModelFireWorkSpawner;
import net.fexcraft.mod.extensions.ie.util.Ticker;
import net.fexcraft.mod.extensions.ie.util.Util;
import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.frsm.util.block.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class FWSRenderer extends FTESR_4R{
	
	public ModelFireWorkSpawner model;
	
	public FWSRenderer() {
		this.model = new ModelFireWorkSpawner();
	}
	
	public ResourceLocation texture = new ResourceLocation("frsm_ie:textures/blocks/FireWorkSpawner.png");
	
	@Override
	public void renderTileEntityAt(TileEntity TE, double posX, double posY, double posZ, float p_180535_8_, int p_180535_9_){
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) posX + 0.5F, (float) posY + 0.5F, (float) posZ + 0.5F);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		if(TE.getBlockMetadata() == 2){GL11.glRotated(-180, 0, 1D, 0);}
		if(TE.getBlockMetadata() == 3){GL11.glRotated(   0, 0, 1D, 0);}
		if(TE.getBlockMetadata() == 4){GL11.glRotated(-270, 0, 1D, 0);}
		if(TE.getBlockMetadata() == 5){GL11.glRotated( -90, 0, 1D, 0);}
		//this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		FWSTE te = (FWSTE)TE;
		
		this.model.render(this.model.base);
		for(int i = 0; i < 8; i++){
			int j = (i * 45) + (te.on ? Ticker.tick360 : 0);
			GL11.glRotatef( j, 0, 1, 0);
			this.model.render(this.model.open);
			GL11.glRotatef(-j, 0, 1, 0);
		}
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		RenderUtil.renderLabel(TE, "FPU: " + te.fpu_get(null) + Util.s(null, te), posX + 0.5, posY + 1.2, posZ + 0.5, 16, this.getFontRenderer(), rendererDispatcher);
    }
}