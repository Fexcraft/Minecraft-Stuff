package net.fexcraft.mod.frsm.util.block;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.frsm.FRSM;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public abstract class FTESR extends TileEntitySpecialRenderer {
	
	public int angle = 0;
        
	public String getTexturePath(){
		return "frsm:textures/blocks/blockname.png";
	}
	
	public void ModelRender(){
		
	}
	
	public int adjustAngleBy(){
		return angle;
	}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float p_180535_8_, int p_180535_9_){
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) posX + 0.5F, (float) posY + 1.5F, (float) posZ + 0.5F);
		/*if(FI.TEMT){
			FRSMTE TE = (FRSMTE)te;
			GL11.glScalef(TE.getTemtValue("scale_x"), TE.getTemtValue("scale_y"), TE.getTemtValue("scale_z"));
			GL11.glTranslatef(TE.getTemtValue("translate_x"), TE.getTemtValue("translate_y"), TE.getTemtValue("translate_z"));
			GL11.glRotatef(TE.getTemtValue("rotation_x"), 1, 0, 0);
			GL11.glRotatef(TE.getTemtValue("rotation_y"), 0, 1, 0);
			GL11.glRotatef(TE.getTemtValue("rotation_z"), 0, 0, 1);
		}*/
		ResourceLocation textures = (new ResourceLocation(getTexturePath()));
		Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotated(   0 + FRSM.angle + adjustAngleBy(), 0, 1D, 0);
		//this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		this.ModelRender();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
}