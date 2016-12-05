package net.fexcraft.mod.frsm.util.block;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.lib.tmt.Tessellator;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.TileEntity;

public class RenderUtil{
	
	/** got code example from minecraftforge forums*/
	public static void renderLabel(TileEntity entity, String s, double d, double d1, double d2, int i, FontRenderer fr, TileEntityRendererDispatcher rendererDispatcher) {
		double f = entity.getDistanceSq(rendererDispatcher.entityX, rendererDispatcher.entityY, rendererDispatcher.entityZ);
	    if (f > i) {
	      return;
	    }
	    
	    float rotation = rendererDispatcher.entityYaw;
	    
	    FontRenderer fontrenderer = fr;//this.getFontRenderer();
	    float f1 = 1.6F;
	    float f2 = 0.01666667F * f1;
	    double angle = Math.toRadians(rotation);
		float sin = (float)(Math.sin(angle));
		float cos = (float)(Math.cos(angle));
		sin = Math.round(sin*100)/100;
		cos = Math.round(cos*100)/100;
	    
	    GL11.glPushMatrix();
	    GL11.glTranslatef((float)d+(float)(sin*0.35), (float)d1, (float)d2-(float)(cos*0.35));
	    GL11.glNormal3f(0.0F, 1.0F, 0.0F);
	    GL11.glRotatef(-1 * rotation, 0, 1, 0);
	    GL11.glScalef(0.3f, 0.3f, 0.3f);
	    //GL11.glRotatef(-this.tileEntityRenderer.playerYaw, 0.0F, 1.0F, 0.0F);
	    //GL11.glRotatef(this.tileEntityRenderer.playerPitch, 1.0F, 0.0F, 0.0F);
	    GL11.glScalef(-f2, -f2, f2);
	    GL11.glDisable(2896);
	    GL11.glDepthMask(false);
	    GL11.glDisable(2929);
	    GL11.glEnable(3042);
	    GL11.glBlendFunc(770, 771);
	    Tessellator tessellator = Tessellator.getInstance();
	    byte byte0 = 0;
	    GL11.glDisable(3553);
	    tessellator.startDrawing(7);
	    int j = fontrenderer.getStringWidth(s) / 2;
	    tessellator.setColorRGBAf(0.0F, 0.0F, 0.0F, 0.5F);
	    tessellator.addVertex(-j - 1, -1 + byte0, 0.0D);
	    tessellator.addVertex(-j - 1, 8 + byte0, 0.0D);
	    tessellator.addVertex(j + 1, 8 + byte0, 0.0D);
	    tessellator.addVertex(j + 1, -1 + byte0, 0.0D);
	    tessellator.draw();
	    //tessellator.func_78381_a();
	    GL11.glEnable(3553);
	    fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, byte0, 553648127);
	    GL11.glEnable(2929);
	    GL11.glDepthMask(true);
	    fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, byte0, -1);
	    GL11.glEnable(2896);
	    GL11.glDisable(3042);
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    GL11.glPopMatrix();
	    
		/*double f = entity.getDistanceSq(rendererDispatcher.entityX, rendererDispatcher.entityY, rendererDispatcher.entityZ);
	    if (f > i) {
	      return;
	    }
	    
	    float rotation = rendererDispatcher.entityYaw;
	    
	    FontRenderer fontrenderer = fr;
	    float f1 = 1.6F;
	    float f2 = 0.01666667F * f1;
	    double angle = Math.toRadians(rotation);
		float sin = (float)(Math.sin(angle));
		float cos = (float)(Math.cos(angle));
		sin = Math.round(sin*100)/100;
		cos = Math.round(cos*100)/100;
	    
	    GL11.glPushMatrix();
	    GL11.glTranslatef((float)d+(float)(sin*0.35), (float)d1, (float)d2-(float)(cos*0.35));
	    GL11.glNormal3f(0.0F, 1.0F, 0.0F);
	    GL11.glRotatef(-1 * rotation, 0, 1, 0);
	    GL11.glScalef(0.3f, 0.3f, 0.3f);
	    //GL11.glRotatef(-this.tileEntityRenderer.playerYaw, 0.0F, 1.0F, 0.0F);
	    //GL11.glRotatef(this.tileEntityRenderer.playerPitch, 1.0F, 0.0F, 0.0F);
	    GL11.glScalef(-f2, -f2, f2);
	    GL11.glDisable(2896);
	    GL11.glDepthMask(false);
	    GL11.glDisable(2929);
	    GL11.glEnable(3042);
	    GL11.glBlendFunc(770, 771);
	    VertexBuffer tessellator = Tessellator.getInstance().getBuffer();
	    byte byte0 = 0;
	    GL11.glDisable(3553);
	    tessellator.noColor();
	    tessellator.begin(7, null);
	    int j = fontrenderer.getStringWidth(s) / 2;
	    tessellator.color(0.0F, 0.0F, 0.0F, 0.35F);
	    tessellator.addVertexData(new int[]{-j - 1, -1 + byte0, 0});
	    tessellator.addVertexData(new int[]{-j - 1, 8 + byte0, 0});
	    tessellator.addVertexData(new int[]{j + 1, 8 + byte0, 0});
	    tessellator.addVertexData(new int[]{j + 1, -1 + byte0, 0});
	    tessellator.finishDrawing();
	    //tessellator.func_78381_a();
	    GL11.glEnable(3553);
	    fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, byte0, 553648127);
	    GL11.glEnable(2929);
	    GL11.glDepthMask(true);
	    fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, byte0, -1);
	    GL11.glEnable(2896);
	    GL11.glDisable(3042);
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    GL11.glPopMatrix();*/
	  }
}