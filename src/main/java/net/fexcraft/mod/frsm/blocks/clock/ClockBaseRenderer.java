package net.fexcraft.mod.frsm.blocks.clock;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.frsm.blocks.clock.ClockBaseTileEntity;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

@fTESR(tileentity = ClockBaseTileEntity.class)
public class ClockBaseRenderer extends TileEntitySpecialRenderer<ClockBaseTileEntity> {
	
	@Override
	public void renderTileEntityAt(ClockBaseTileEntity tileentity, double posX, double posY, double posZ, float partialticks, int destroystage){
    	GL11.glPushMatrix();
		GL11.glTranslated(posX + 0.5F, posY + 1.5F, posZ + 0.5F);
		Minecraft.getMinecraft().renderEngine.bindTexture(tileentity.getTexture());
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		if(tileentity.getBlockMetadata() == 2){GL11.glRotated(  90, 0, 1D, 0);}
		if(tileentity.getBlockMetadata() == 3){GL11.glRotated( -90, 0, 1D, 0);}
		if(tileentity.getBlockMetadata() == 4){GL11.glRotated(   0, 0, 1D, 0);}
		if(tileentity.getBlockMetadata() == 5){GL11.glRotated(-180, 0, 1D, 0);}
		tileentity.getModel().render(tileentity);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
	
}