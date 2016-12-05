package net.fexcraft.mod.frsm.blocks.shelf;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.frsm.FRSM;
import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.util.cls.EnumColor;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class Shelf1Renderer extends FTESR_4R{
	
	public Shelf1Model model = new Shelf1Model();
	
	public static ResourceLocation getFromColor(EnumColor color){
		return new ResourceLocation("frsm:textures/blocks/shelf1_" + color.toInt() + ".png");
	}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float p_180535_8_, int p_180535_9_){
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) posX + 0.5F, (float) posY + 0.5F, (float) posZ + 0.5F);
		
		boolean open = ((Shelf1Entity)te).getState();
		EnumColor color = ((Shelf1Entity)te).getColor();
		Minecraft.getMinecraft().renderEngine.bindTexture(getFromColor(color));
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		if(te.getBlockMetadata() == 2){GL11.glRotated(   0 + FRSM.angle + adjustAngleBy(), 0, 1D, 0);}
		if(te.getBlockMetadata() == 3){GL11.glRotated(-180 + FRSM.angle + adjustAngleBy(), 0, 1D, 0);}
		if(te.getBlockMetadata() == 4){GL11.glRotated( -90 + FRSM.angle + adjustAngleBy(), 0, 1D, 0);}
		if(te.getBlockMetadata() == 5){GL11.glRotated(-270 + FRSM.angle + adjustAngleBy(), 0, 1D, 0);}
		
		this.model.render(this.model.base);
		if(open == true){
			this.model.render(this.model.open);
		}
		if(open == false){
			this.model.render(this.model.closed);
		}

		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
	}
}