package net.fexcraft.mod.frsm.util.block;

import java.io.File;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.frsm.FRSM;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public abstract class FTESR_4R_URL extends TileEntitySpecialRenderer {
	
	public String texture = "frsm:textures/blocks/blockname.png";
	public String url = "http://fexcraft.net/files/SharedImages/testblock.png";
	public int angle = 0;
        
	public String getTexturePath(){
		return texture;
	}
	
	public void ModelRender(){
	}
	
	public int adjustAngleBy(){
		return angle;
	}
	
	public String getTextureURL(){
		return url;
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
		ResourceLocation texture = (new ResourceLocation(getTexturePath()));
		ThreadDownloadImageData tdid = new ThreadDownloadImageData((File)null, getTextureURL(), null, null);
		TextureManager tm = Minecraft.getMinecraft().renderEngine;
		Object object = tm.getTexture(texture);
        if(object == null){
        	object = tdid;
        	tm.loadTexture(texture, (ITextureObject)object);
        }
        tm.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		if(te.getBlockMetadata() == 2){GL11.glRotated(   0 + FRSM.angle + adjustAngleBy(), 0, 1D, 0);}
		if(te.getBlockMetadata() == 3){GL11.glRotated(-180 + FRSM.angle + adjustAngleBy(), 0, 1D, 0);}
		if(te.getBlockMetadata() == 4){GL11.glRotated( -90 + FRSM.angle + adjustAngleBy(), 0, 1D, 0);}
		if(te.getBlockMetadata() == 5){GL11.glRotated(-270 + FRSM.angle + adjustAngleBy(), 0, 1D, 0);}
		//this.model.render();
		this.ModelRender();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
}