package net.fexcraft.mod.extensions.cae.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.extensions.cae.model.Models.Modelx16;
import net.fexcraft.mod.extensions.cae.model.Models.Modelx8;
import net.fexcraft.mod.extensions.cae.tileentities.CABTE;
import net.fexcraft.mod.extensions.cae.util.Type;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class CustomAsphaltBlockRenderer extends TileEntitySpecialRenderer {
    
	private static ResourceLocation getTexturePath(Type type){
		switch(type){
			case x2:
			case x4:
				return rs1;
			case x8:
			case x16:
			case x32:
			case x64:
				return rs0;
			default: return null;
		}
	}
	
	private static ResourceLocation rs0 = new ResourceLocation("frsm:textures/blocks/asphalt2.png");
	private static ResourceLocation rs1 = new ResourceLocation("frsm:textures/blocks/asphalt2_large.png");
	
	private static ModelBase activeModel;
	private static Modelx16 modelx16 = new Modelx16();
	private static Modelx8 modelx8 = new Modelx8();
	
	@Override
	public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float p_180535_8_, int p_180535_9_){
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) posX + 0.5F, (float) posY + 1.5F, (float) posZ + 0.5F);
		CABTE t = (CABTE)te;
		t.isSynchronized();
		Minecraft.getMinecraft().renderEngine.bindTexture(getTexturePath(t.getType()));
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0F, 0F, 1F);
		GL11.glRotatef(-90F, 0F, 1F, 0F);
		
		activeModel = getModelFromType(t.getType());
		int[][] arr = t.getArr();
		int tpl = t.getType().N();
		int k = 0;
		for(int i = 0; i < tpl; i++){
			for(int j = 0; j < tpl; j++){
				if(arr[i][j] == 1){
					this.render(t.getType(), k, t.getBlockMetadata());
				}
				k++;
			}
		}
		
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
	
	private ModelBase getModelFromType(Type type){
		switch(type){
			case x16:
				return modelx16;
			case x2:
				break;
			case x32:
				break;
			case x4:
				break;
			case x64:
				break;
			case x8:
				return modelx8;
			default:
				break;
		}
		return modelx16;
	}

	public void render(Type type, int k, int y){
		switch(type){
			case x2:
				// * 8F
				break;
			case x4:
				// * 4F
				break;
			case x8:
				((Modelx8)activeModel).render(k, y);
				break;
			case x16:
				((Modelx16)activeModel).render(k, y);
				break;
			case x32:
				// * 0.5F
				break;
			case x64:
				// * 0.25F
				break;
			default:
				((Modelx16)activeModel).render(k, y);
				break;
		}
	}
}