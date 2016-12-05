package net.fexcraft.mod.extensions.ie.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.extensions.ie.models.ModelElectricFurnace;
import net.fexcraft.mod.extensions.ie.tileentities.ElectricalFurnaceEntity;
import net.fexcraft.mod.extensions.ie.util.Ticker;
import net.fexcraft.mod.extensions.ie.util.Util;
import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.frsm.util.block.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class ElectricFurnaceRenderer extends FTESR_4R{
	
	public ModelElectricFurnace model;
	
	public ElectricFurnaceRenderer() {
		this.model = new ModelElectricFurnace();
	}
	
	public ResourceLocation texture = new ResourceLocation("frsm_ie:textures/blocks/ElectricFurnace.png");
	
	@Override
	public void renderTileEntityAt(TileEntity TE, double posX, double posY, double posZ, float p_180535_8_, int p_180535_9_){
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) posX + 0.5F, (float) posY + 0.5F, (float) posZ + 0.5F);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		if(TE.getBlockMetadata() == 2){GL11.glRotated(   0, 0, 1D, 0);}
		if(TE.getBlockMetadata() == 3){GL11.glRotated(-180, 0, 1D, 0);}
		if(TE.getBlockMetadata() == 4){GL11.glRotated( -90, 0, 1D, 0);}
		if(TE.getBlockMetadata() == 5){GL11.glRotated(-270, 0, 1D, 0);}
		//this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		ElectricalFurnaceEntity te = (ElectricalFurnaceEntity)TE;
		
		this.model.render(this.model.base);
		this.model.render(this.model.closed);
		for(int i = 0; i < 360; i++){
			int j = (i * 10) + (Ticker.tick360 * 2);
			GL11.glRotatef( j, 0, 0, 1);
			this.model.render(this.model.r0);
			GL11.glRotatef(-j, 0, 0, 1);
		}
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		RenderUtil.renderLabel(TE, "FPU: " + te.fpu_get(null) + " " + Util.s(null, te), posX + 0.5, posY + 1.2, posZ + 0.5, 16, this.getFontRenderer(), rendererDispatcher);
    }
}