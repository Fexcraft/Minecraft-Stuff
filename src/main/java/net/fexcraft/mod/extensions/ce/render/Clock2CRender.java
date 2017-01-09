package net.fexcraft.mod.extensions.ce.render;

import java.util.Calendar;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.extensions.ce.blocks.CE_Blocks;
import net.fexcraft.mod.extensions.ce.models.ModelClock2;
import net.fexcraft.mod.frsm.FRSM;
import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class Clock2CRender extends FTESR_4R {
	
	public ModelClock2 model;
	
	public Clock2CRender() {
		this.model = new ModelClock2();
	}
	
	public String texture = "frsm:textures/blocks/clock1.png";
	
	@Override
	public final String getTexturePath(){
		return texture;
	}
	
	@Override
	public int adjustAngleBy(){
		return 90;
	}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float p_180535_8_, int p_180535_9_){
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) posX + 0.5F, (float) posY + 1.5F, (float) posZ + 0.5F);
		ResourceLocation textures = (new ResourceLocation(getTexturePath()));
		Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		if(te.getBlockMetadata() == 2){GL11.glRotated(   0 + FRSM.angle + adjustAngleBy(), 0, 1D, 0);}
		if(te.getBlockMetadata() == 3){GL11.glRotated(-180 + FRSM.angle + adjustAngleBy(), 0, 1D, 0);}
		if(te.getBlockMetadata() == 4){GL11.glRotated( -90 + FRSM.angle + adjustAngleBy(), 0, 1D, 0);}
		if(te.getBlockMetadata() == 5){GL11.glRotated(-270 + FRSM.angle + adjustAngleBy(), 0, 1D, 0);}
		//
		this.model.renderPart(this.model.base);
		GL11.glTranslatef(0F, 1F, 0F);
		GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
		int h = Calendar.getInstance().get(Calendar.HOUR);;
		int m = Calendar.getInstance().get(Calendar.MINUTE);
		int s = Calendar.getInstance().get(Calendar.SECOND);
		CE_Blocks.Clock2C.TEC TE = (CE_Blocks.Clock2C.TEC)te;
		int h2 = TE.getTileData().getInteger("frsm_ce_hour");
		int m2 = TE.getTileData().getInteger("frsm_ce_minute");
		int s2 = TE.getTileData().getInteger("frsm_ce_second");
		renderH (h + h2, m + m2);
		renderM (m + m2);
		renderS (s + s2);
		renderHR(h + h2, m + m2);
		renderMR(m + m2);
		renderSR(s + s2);
		//
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
	
	public void renderH(int h, int m){
		int a = 0;
		if(m == 0){a = 0;}
		else{a = Math.round(m / 2);}
		//PrintLog.printIn("a = " + a);
		GL11.glRotatef((h * -30) - a, 1.0F, 0.0F, 0.0F);
		this.model.renderPart(this.model.hour);
		GL11.glRotatef((h * +30) + a, 1.0F, 0.0F, 0.0F);
	}
	
	public void renderM(int m){
		GL11.glRotatef(m * -6, 1.0F, 0.0F, 0.0F);
		this.model.renderPart(this.model.minute);
		GL11.glRotatef(m * +6, 1.0F, 0.0F, 0.0F);
	}
	
	public void renderS(int s){
		GL11.glRotatef(s * -6, 1.0F, 0.0F, 0.0F);
		this.model.renderPart(this.model.second);
		GL11.glRotatef(s * +6, 1.0F, 0.0F, 0.0F);
	}
	
	public void renderHR(int h, int m){
		int a = 0;
		if(m == 0){a = 0;}
		else{a = Math.round(m / 2);}
		//PrintLog.printIn("a = " + a);
		GL11.glRotatef((h * +30) + a, 1.0F, 0.0F, 0.0F);
		this.model.renderPart(this.model.hourR);
		GL11.glRotatef((h * -30) - a, 1.0F, 0.0F, 0.0F);
	}
	
	public void renderMR(int m){
		GL11.glRotatef(m * +6, 1.0F, 0.0F, 0.0F);
		this.model.renderPart(this.model.minuteR);
		GL11.glRotatef(m * -6, 1.0F, 0.0F, 0.0F);
	}
	
	public void renderSR(int s){
		GL11.glRotatef(s * +6, 1.0F, 0.0F, 0.0F);
		this.model.renderPart(this.model.secondR);
		GL11.glRotatef(s * -6, 1.0F, 0.0F, 0.0F);
	}
}