package net.fexcraft.mod.frsm.util.block;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public abstract class FTESR_4R<T extends TileEntity> extends TileEntitySpecialRenderer<T> {
	
	public int angle = 0;
        
	public abstract ResourceLocation getResourceLocation();
	
	public abstract void renderModel(T tileentity, float partialticks, int destroystage);
	
	public int adjustAngle(){
		return angle;
	}
	
	@Override
	public void render(T tileentity, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
    	GL11.glPushMatrix();
		GL11.glTranslated(posX + 0.5F, posY + 1.5F, posZ + 0.5F);
		Minecraft.getMinecraft().renderEngine.bindTexture(this.getResourceLocation());
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		if(tileentity.getBlockMetadata() == 2){GL11.glRotated(   0 + adjustAngle(), 0, 1D, 0);}
		if(tileentity.getBlockMetadata() == 3){GL11.glRotated(-180 + adjustAngle(), 0, 1D, 0);}
		if(tileentity.getBlockMetadata() == 4){GL11.glRotated( -90 + adjustAngle(), 0, 1D, 0);}
		if(tileentity.getBlockMetadata() == 5){GL11.glRotated(-270 + adjustAngle(), 0, 1D, 0);}
		//this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		this.renderModel(tileentity, partialticks, destroystage);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
	
}