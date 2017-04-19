package net.fexcraft.mod.fvm.blocks;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvm.models.block.ModelConstructorController;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

@fTESR(tileentity = ConstructorControllerEntity.class)
public class ConstructorControllerRender extends TileEntitySpecialRenderer {
	
	private static final ModelConstructorController model = new ModelConstructorController();
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double posX, double posY, double posZ, float partialticks, int destroystage){
    	GL11.glPushMatrix();
		GL11.glTranslated(posX + 0.5F, posY + 1.5F, posZ + 0.5F);
		Minecraft.getMinecraft().renderEngine.bindTexture(model.getTexture());
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		double d = 60;
		switch(tileentity.getBlockMetadata()){
			case 2:
				d = -180d;
				break;
			case 3:
				d = 0;
				break;
			case 4:
				d = -270d;
				break;
			case 5:
				d = -90d;
				break;
		}
		GL11.glRotated(d, 0, 1, 0);
		model.render(model.bodyModel);			
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
	
}