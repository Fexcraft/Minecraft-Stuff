package net.fexcraft.mod.frsm.util.block;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public abstract class FTESR extends TileEntitySpecialRenderer {
	
	public int angle = 0;
        
	public abstract ResourceLocation getResourceLocation();
	
	public abstract void renderModel(TileEntity tileentity, float partialticks, int destroystage);
	
	public int adjustAngle(){
		return angle;
	}
	
	@Override
	public void func_192841_a(TileEntity tileentity, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
    	GL11.glPushMatrix();
		GL11.glTranslated(posX + 0.5F, posY + 1.5F, posZ + 0.5F);
		Minecraft.getMinecraft().renderEngine.bindTexture(this.getResourceLocation());
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotated(0 + adjustAngle(), 0, 1D, 0);
		//this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		this.renderModel(tileentity, partialticks, destroystage);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
	
}