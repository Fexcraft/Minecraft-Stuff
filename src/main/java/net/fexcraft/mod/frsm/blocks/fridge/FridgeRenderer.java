package net.fexcraft.mod.frsm.blocks.fridge;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.frsm.FRSM;
import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.util.cls.EnumColor;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class FridgeRenderer extends FTESR_4R{
	
	public FridgeModel model;
	
	public FridgeRenderer() {
		this.model = new FridgeModel();
	}
	
	public String texture = "frsm:textures/blocks/fridge.png";
	public String texture_black = "frsm:textures/blocks/fridge_black.png";
	public String texture_gray = "frsm:textures/blocks/fridge_gray.png";
	public String texture_blue = "frsm:textures/blocks/fridge_blue.png";
	public String texture_red = "frsm:textures/blocks/fridge_red.png";
	public String texture_green = "frsm:textures/blocks/fridge_green.png";
	
	@Override
	public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float p_180535_8_, int p_180535_9_){
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) posX + 0.5F, (float) posY + 1.5F, (float) posZ + 0.5F);
		
		boolean open = ((FridgeTileEntity)te).getState();
		EnumColor color = ((FridgeTileEntity)te).getColor();
		
		ResourceLocation textures = null;
		switch(color){
		case BLACK:
			textures = new ResourceLocation(texture_black);
			break;
		case BLUE:
			textures = new ResourceLocation(texture_blue);
			break;
		case GRAY:
			textures = new ResourceLocation(texture_gray);
			break;
		case GREEN:
			textures = new ResourceLocation(texture_green);
			break;
		case RED:
			textures = new ResourceLocation(texture_red);
			break;
		case WHITE:
			textures = new ResourceLocation(texture);
			break;
		default:
			break;
		}
		Minecraft.getMinecraft().renderEngine.bindTexture(textures);
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