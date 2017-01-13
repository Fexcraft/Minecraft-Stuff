package net.fexcraft.mod.extensions.bge.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.extensions.bge.models.ModelChessTower;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RCT extends TileEntitySpecialRenderer {

	public ModelChessTower model;
	
	public RCT() {
		this.model = new ModelChessTower();
		textures = new ResourceLocation[16];
		textures[0] = new ResourceLocation("frsm_bge:textures/blocks/ChessTower_0.png");
		textures[1] = new ResourceLocation("frsm_bge:textures/blocks/ChessTower_1.png");
		textures[2] = new ResourceLocation("frsm_bge:textures/blocks/ChessTower_2.png");
		textures[3] = new ResourceLocation("frsm_bge:textures/blocks/ChessTower_3.png");
		textures[4] = new ResourceLocation("frsm_bge:textures/blocks/ChessTower_4.png");
		textures[5] = new ResourceLocation("frsm_bge:textures/blocks/ChessTower_5.png");
		textures[6] = new ResourceLocation("frsm_bge:textures/blocks/ChessTower_6.png");
		textures[7] = new ResourceLocation("frsm_bge:textures/blocks/ChessTower_7.png");
		textures[8] = new ResourceLocation("frsm_bge:textures/blocks/ChessTower_8.png");
		textures[9] = new ResourceLocation("frsm_bge:textures/blocks/ChessTower_9.png");
		textures[10] = new ResourceLocation("frsm_bge:textures/blocks/ChessTower_10.png");
		textures[11] = new ResourceLocation("frsm_bge:textures/blocks/ChessTower_11.png");
		textures[12] = new ResourceLocation("frsm_bge:textures/blocks/ChessTower_12.png");
		textures[13] = new ResourceLocation("frsm_bge:textures/blocks/ChessTower_13.png");
		textures[14] = new ResourceLocation("frsm_bge:textures/blocks/ChessTower_14.png");
		textures[15] = new ResourceLocation("frsm_bge:textures/blocks/ChessTower_15.png");
	}
	
	private ResourceLocation[] textures;
	
	@Override
	public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float p_180535_8_, int p_180535_9_){
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) posX + 0.5F, (float) posY + 1.5F, (float) posZ + 0.5F);
		Minecraft.getMinecraft().renderEngine.bindTexture(textures[te.getBlockMetadata()]);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		this.model.render();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
}