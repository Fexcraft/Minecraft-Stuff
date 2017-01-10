package net.fexcraft.mod.extensions.ce.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.extensions.ce.blocks.ClockTileEntityBase;
import net.fexcraft.mod.extensions.ce.util.ClockModelBase;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class ClockRenderBase extends TileEntitySpecialRenderer {
	
	private static final float y = 1f, n = 0f;
	
	@Override
	public void renderTileEntityAt(TileEntity TE, double posX, double posY, double posZ, float p_180535_8_, int p_180535_9_){
    	GL11.glPushMatrix();
		GL11.glTranslated(posX + 0.5F, posY + 1.5F, posZ + 0.5F);
		
		ClockTileEntityBase te = (ClockTileEntityBase)TE;
		Minecraft.getMinecraft().renderEngine.bindTexture(te.getTexture());
		ClockModelBase model = (ClockModelBase)te.getModel();
		
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		if(te.getBlockMetadata() == 2){GL11.glRotated(  90, 0, 1D, 0);}
		if(te.getBlockMetadata() == 3){GL11.glRotated( -90, 0, 1D, 0);}
		if(te.getBlockMetadata() == 4){GL11.glRotated(   0, 0, 1D, 0);}
		if(te.getBlockMetadata() == 5){GL11.glRotated(-180, 0, 1D, 0);}
		//
		model.render(model.base);
		GL11.glTranslatef(0F, 1F, 0F);
		GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
		int h = Time.getHour12();
		int m = Time.getMinute();
		int s = Time.getSecond();
		switch(te.getType()){
			case REAL_CUSTOM:
				h = Time.getGMTCalendar().get(0xa) + te.h;
				if(h >= 12){
					h -= 12;
				}
				m = Time.getGMTCalendar().get(0xc) + te.m;
				if(m >= 60){
					m -= 60;
				}
				s = Time.getGMTCalendar().get(0xd) + te.s;
				if(s >= 60){
					s -= 60;
				}
				renderHour(model, false, h, m, te.rs);
				renderMinute(model, false, m, te.rs);
				renderSecond(model, false, s, te.rs);
				break;
			case REAL_CUSTOM_REVERSE:
				h = Time.getGMTCalendar().get(0xa) + te.h;
				if(h >= 12){
					h -= 12;
				}
				m = Time.getGMTCalendar().get(0xc) + te.m;
				if(m >= 60){
					m -= 60;
				}
				s = Time.getGMTCalendar().get(0xd) + te.s;
				if(s >= 60){
					s -= 60;
				}
				renderHour(model, true, h, m, te.rs);
				renderMinute(model, true, m, te.rs);
				renderSecond(model, true, s, te.rs);
				break;
			case REAL_SYSTEM:
				renderHour(model, false, h, m, te.rs);
				renderMinute(model, false, m, te.rs);
				renderSecond(model, false, s, te.rs);
				break;
			case REAL_SYSTEM_REVERSE:
				renderHour(model, true, h, m, te.rs);
				renderMinute(model, true, m, te.rs);
				renderSecond(model, true, s, te.rs);
				break;
			case MINECRAFT_WORLD:
			case MINECRAFT_WORLD_REVERSE:
			case NULL:
			default:
				model.render(model.hour);
				model.render(model.minute);
				model.render(model.second);
				break;
		}
		//
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }

	private void renderSecond(ClockModelBase model, boolean b, int s, int rs){
		int r = s * 6;
		if(b){
			r = -r;
		}
		GL11.glRotatef(-r, y, n, n);
		model.render(model.second);
		GL11.glRotatef( r, y, n, n);
		if(rs > 1){
			GL11.glRotatef(180f, 0, 1, 0);
			GL11.glRotatef(-r, y, n, n);
			model.render(model.second);
			GL11.glRotatef( r, y, n, n);
		}
	}

	private void renderMinute(ClockModelBase model, boolean b, int m, int rs){
		int r = m * 6;
		if(b){
			r = -r;
		}
		GL11.glRotatef(-r, y, n, n);
		model.render(model.minute);
		GL11.glRotatef( r, y, n, n);
		if(rs > 1){
			GL11.glRotatef(180f, 0, 1, 0);
			GL11.glRotatef(-r , y, n, n);
			model.render(model.minute);
			GL11.glRotatef( r, y, n, n);
		}
	}

	private void renderHour(ClockModelBase model, boolean b, int h, int m, int rs){
		int a = 0;
		if(m == 0){
			a = 0;
		}
		else{
			a = Math.round(m / 2);
		}
		int r = (h * 30) + a;
		if(b){
			r = -r;
		}
		GL11.glRotatef(-r, y, n, n);
		model.render(model.hour);
		GL11.glRotatef( r, y, n, n);
		if(rs > 1){
			GL11.glRotatef(180f, 0, 1, 0);
			GL11.glRotatef(-r, y, n, n);
			model.render(model.hour);
			GL11.glRotatef( r, y, n, n);
		}
	}
	
}