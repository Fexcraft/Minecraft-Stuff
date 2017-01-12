package net.fexcraft.mod.frsm.blocks.tv;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TVLRender extends TileEntitySpecialRenderer {
	
	private static final TVLModel model = new TVLModel();
			
	public int adjustAngleBy(){
		return 0;
	}
	
	public String getTexturePath(){
		return "frsm:textures/blocks/TVL.png";
	}
	
	private static final ResourceLocation texture = new ResourceLocation("frsm:textures/blocks/TVL.png");
	
	@Override
	public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float p_180535_8_, int p_180535_9_){
    	GL11.glPushMatrix();
		GL11.glTranslated(posX + 0.5F, posY + 1.5F, posZ + 0.5F);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		TVL.TEB TE = (TVL.TEB)te;
		if(TE.facing == "north"){GL11.glRotated(   0, 0, 1D, 0);}
		if(TE.facing == "south"){GL11.glRotated(-180, 0, 1D, 0);}
		if(TE.facing == "west") {GL11.glRotated( -90, 0, 1D, 0);}
		if(TE.facing == "east") {GL11.glRotated(-270, 0, 1D, 0);}
		if(TE.facing == null)   {GL11.glRotated(  60, 0, 1D, 0);}
		this.model.render();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
}