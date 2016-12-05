package net.fexcraft.mod.frsm.blocks.tv;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.frsm.FRSM;
import net.fexcraft.mod.frsm.blocks.tv.TVS2.TVS2TE;
import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.frsm.util.block.TemtUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TVS2Render extends FTESR_4R {
	
	public TVS2Model model;
	
	public TVS2Render() {
		this.model = new TVS2Model();
	}
    
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/TVS2.png";
	}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float p_180535_8_, int p_180535_9_){
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) posX + 0.5F, (float) posY + 1.5F, (float) posZ + 0.5F);
		TemtUtil.render(te);
		ResourceLocation textures = (new ResourceLocation(getTexturePath()));
		Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		if(te.getBlockMetadata() == 2){GL11.glRotated(   0 + FRSM.angle + adjustAngleBy(), 0, 1D, 0);}
		if(te.getBlockMetadata() == 3){GL11.glRotated(-180 + FRSM.angle + adjustAngleBy(), 0, 1D, 0);}
		if(te.getBlockMetadata() == 4){GL11.glRotated( -90 + FRSM.angle + adjustAngleBy(), 0, 1D, 0);}
		if(te.getBlockMetadata() == 5){GL11.glRotated(-270 + FRSM.angle + adjustAngleBy(), 0, 1D, 0);}
		//
		GL11.glRotated(180, 0F, 1F, 0F);
		GL11.glTranslatef(-0.5F, 1.5F, -0.5F);
		int i = ((TVS2TE)te).getRotation();
		GL11.glRotatef(Math.round(22.5F * i), 0F, 1F, 0F);
		this.model.render();
		//
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}