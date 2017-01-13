package net.fexcraft.mod.extensions.bge.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.extensions.bge.models.ModelDice;
import net.fexcraft.mod.extensions.bge.tileentities.DiceTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class DiceRender extends TileEntitySpecialRenderer {

	public ModelDice model;
	
	public DiceRender() {
		this.model = new ModelDice();
		textures = new ResourceLocation[16];
		textures[0] = new ResourceLocation("frsm_bge:textures/blocks/Dice_0.png");
		textures[1] = new ResourceLocation("frsm_bge:textures/blocks/Dice_1.png");
		textures[2] = new ResourceLocation("frsm_bge:textures/blocks/Dice_2.png");
		textures[3] = new ResourceLocation("frsm_bge:textures/blocks/Dice_3.png");
		textures[4] = new ResourceLocation("frsm_bge:textures/blocks/Dice_4.png");
		textures[5] = new ResourceLocation("frsm_bge:textures/blocks/Dice_5.png");
		textures[6] = new ResourceLocation("frsm_bge:textures/blocks/Dice_6.png");
		textures[7] = new ResourceLocation("frsm_bge:textures/blocks/Dice_7.png");
		textures[8] = new ResourceLocation("frsm_bge:textures/blocks/Dice_8.png");
		textures[9] = new ResourceLocation("frsm_bge:textures/blocks/Dice_9.png");
		textures[10] = new ResourceLocation("frsm_bge:textures/blocks/Dice_10.png");
		textures[11] = new ResourceLocation("frsm_bge:textures/blocks/Dice_11.png");
		textures[12] = new ResourceLocation("frsm_bge:textures/blocks/Dice_12.png");
		textures[13] = new ResourceLocation("frsm_bge:textures/blocks/Dice_13.png");
		textures[14] = new ResourceLocation("frsm_bge:textures/blocks/Dice_14.png");
		textures[15] = new ResourceLocation("frsm_bge:textures/blocks/Dice_15.png");
	}
	
	private ResourceLocation[] textures;
	private int tick;
	
	@Override
	public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float p_180535_8_, int p_180535_9_){
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) posX + 0.5F, (float) posY + 1.5F, (float) posZ + 0.5F);
		Minecraft.getMinecraft().renderEngine.bindTexture(textures[te.getBlockMetadata()]);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		//this.model.render();
		
		DiceTileEntity dte = (DiceTileEntity)te;
		
		tick += 20;
		if(tick >= 360){
			tick = 0;
		}
		
		if(dte.getState() == true){
			GL11.glRotatef(tick, 0.0F, 0.0F, 1.0F);
			//GL11.glRotatef(tick, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(tick, 1.0F, 0.0F, 0.0F);
			this.model.render(this.model.base);
		}
		if(dte.getState() == false){
			if(dte.getResult() == 5){//6
				GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(0F, -2.50F, 0F);
			}
			if(dte.getResult() == 4){//5
				GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(0F, -1.25F, 1.25F);
			}
			if(dte.getResult() == 3){//4
				GL11.glRotatef(-90F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(-1.25F, -1.25F, 0F);
			}
			if(dte.getResult() == 2){//3
				GL11.glRotatef( 90F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(1.25F, -1.25F, 0F);
			}
			if(dte.getResult() == 1){//2
				GL11.glRotatef( 90F, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(0F, -1.25F, -1.25F);
			}
			if(dte.getResult() == 0 || dte.getResult() == 6){//1
				//
			}
			this.model.render(this.model.r0);
		}
		
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
}