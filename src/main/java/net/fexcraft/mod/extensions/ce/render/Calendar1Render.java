package net.fexcraft.mod.extensions.ce.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.extensions.ce.models.ModelCalendar1;
import net.fexcraft.mod.extensions.ce.util.RenderUtil;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class Calendar1Render extends TileEntitySpecialRenderer {
	
	public ModelCalendar1 model = new ModelCalendar1();
	
	@Override
	public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float p_180535_8_, int p_180535_9_){
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) posX + 0.5F, (float) posY + 1.5F, (float) posZ + 0.5F);
		Minecraft.getMinecraft().renderEngine.bindTexture(RenderUtil.getCalendar1Texture());
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		if(te.getBlockMetadata() == 2){GL11.glRotated(   0, 0, 1D, 0);}
		if(te.getBlockMetadata() == 3){GL11.glRotated(-180, 0, 1D, 0);}
		if(te.getBlockMetadata() == 4){GL11.glRotated( -90, 0, 1D, 0);}
		if(te.getBlockMetadata() == 5){GL11.glRotated(-270, 0, 1D, 0);}
		GL11.glTranslatef(0.5F, 1.5F, 0.5F);
		GL11.glRotatef(180, 0.0F, 1.0F, 0.0F);
		this.model.renderPart(this.model.base);
		int d = Time.getDay();
		if(d ==  1){ this.model.renderPart(this.model.d01);}
		if(d ==  2){ this.model.renderPart(this.model.d02);}
		if(d ==  3){ this.model.renderPart(this.model.d03);}
		if(d ==  4){ this.model.renderPart(this.model.d04);}
		if(d ==  5){ this.model.renderPart(this.model.d05);}
		if(d ==  6){ this.model.renderPart(this.model.d06);}
		if(d ==  7){ this.model.renderPart(this.model.d07);}
		if(d ==  8){ this.model.renderPart(this.model.d08);}
		if(d ==  9){ this.model.renderPart(this.model.d09);}
		if(d == 10){ this.model.renderPart(this.model.d10);}
		if(d == 11){ this.model.renderPart(this.model.d11);}
		if(d == 12){ this.model.renderPart(this.model.d12);}
		if(d == 13){ this.model.renderPart(this.model.d13);}
		if(d == 14){ this.model.renderPart(this.model.d14);}
		if(d == 15){ this.model.renderPart(this.model.d15);}
		if(d == 16){ this.model.renderPart(this.model.d16);}
		if(d == 17){ this.model.renderPart(this.model.d17);}
		if(d == 18){ this.model.renderPart(this.model.d18);}
		if(d == 19){ this.model.renderPart(this.model.d19);}
		if(d == 20){ this.model.renderPart(this.model.d20);}
		if(d == 21){ this.model.renderPart(this.model.d21);}
		if(d == 22){ this.model.renderPart(this.model.d22);}
		if(d == 23){ this.model.renderPart(this.model.d23);}
		if(d == 24){ this.model.renderPart(this.model.d24);}
		if(d == 25){ this.model.renderPart(this.model.d25);}
		if(d == 26){ this.model.renderPart(this.model.d26);}
		if(d == 27){ this.model.renderPart(this.model.d27);}
		if(d == 28){ this.model.renderPart(this.model.d28);}
		if(d == 29){ this.model.renderPart(this.model.d29);}
		if(d == 30){ this.model.renderPart(this.model.d30);}
		if(d == 31){ this.model.renderPart(this.model.d31);}
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
}