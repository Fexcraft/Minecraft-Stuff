package net.fexcraft.mod.extensions.ie.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.extensions.ie.models.ModelCabelType4Bridge;
import net.fexcraft.mod.extensions.ie.tileentities.CableType4BridgeEntity;
import net.fexcraft.mod.extensions.ie.util.EFIO;
import net.fexcraft.mod.extensions.ie.util.EFIO.EnumIO;
import net.fexcraft.mod.frsm.util.block.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class RenderCT4CopperBridge extends TileEntitySpecialRenderer {
	
	public ModelCabelType4Bridge model;
	
	public RenderCT4CopperBridge() {
		this.model = new ModelCabelType4Bridge();
	}
	
	private static ResourceLocation texture = new ResourceLocation("frsm_ie:textures/blocks/CableType4Copper.png");
	
	@Override
	public void renderTileEntityAt(TileEntity TE, double posX, double posY, double posZ, float p_180535_8_, int p_180535_9_){
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) posX + 0.5F, (float) posY + 0.5F, (float) posZ + 0.5F);
		ResourceLocation textures = (texture);
		Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		CableType4BridgeEntity te = (CableType4BridgeEntity)TE;
		
		this.model.render(this.model.base);
		
		for(EFIO e : te.getIO().get()){
			if(e.io != EnumIO.NULL){
				switch(e.facing){
					case NORTH:
						this.model.render(this.model.r1);
						if(e.cthickness > 2){
							this.model.render(this.model.r2);
						}
						if(e.io == EnumIO.OUTPUT){
							this.model.render(this.model.r9);
						}
						break;
					case SOUTH:
						GL11.glRotatef( 180f, 0f, 1f, 0f);
						this.model.render(this.model.r1);
						if(e.cthickness > 2){
							this.model.render(this.model.r2);
						}
						if(e.io == EnumIO.OUTPUT){
							this.model.render(this.model.r9);
						}
						GL11.glRotatef(-180f, 0f, 1f, 0f);
						break;
					case WEST:
						GL11.glRotatef(-90f, 0f, 1f, 0f);
						this.model.render(this.model.r3);
						if(e.cthickness > 2){
							this.model.render(this.model.r4);
						}
						if(e.io == EnumIO.OUTPUT){
							this.model.render(this.model.r0);
						}
						GL11.glRotatef( 90f, 0f, 1f, 0f);
						break;
					case EAST:
						GL11.glRotatef( 90f, 0f, 1f, 0f);
						this.model.render(this.model.r3);
						if(e.cthickness > 2){
							this.model.render(this.model.r4);
						}
						if(e.io == EnumIO.OUTPUT){
							this.model.render(this.model.r0);
						}
						GL11.glRotatef(-90f, 0f, 1f, 0f);
						break;
					default:
						GL11.glRotatef( 60f, 0f, 1f, 0f);
						this.model.render(this.model.r1);
						if(e.cthickness > 2){
							this.model.render(this.model.r2);
						}
						if(e.io == EnumIO.OUTPUT){
							this.model.render(this.model.r0);
						}
						GL11.glRotatef(-60f, 0f, 1f, 0f);
						break;
				}
			}
		}
		
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		RenderUtil.renderLabel(TE, "FPU: " + te.fpu_get(EnumFacing.NORTH) + "[D] | " + te.fpu_get(EnumFacing.EAST) + "[U]", posX + 0.5, posY + 0.5, posZ + 0.5, 16, this.getFontRenderer(), rendererDispatcher);
    }
}