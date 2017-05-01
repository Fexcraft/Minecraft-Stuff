package net.fexcraft.mod.fvm.blocks;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvm.data.PartType;
import net.fexcraft.mod.fvm.data.VehicleType;
import net.fexcraft.mod.fvm.models.VehicleModel;
import net.fexcraft.mod.fvm.models.block.ModelConstructionBlock;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

@fTESR(tileentity = ConstructorCenterEntity.class)
public class ConstructorCenterRenderer extends TileEntitySpecialRenderer {
	
	private static final ModelConstructionBlock model = new ModelConstructionBlock();
	
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
				d = 0;
				break;
			case 3:
				d = -180d;
				break;
			case 4:
				d = -90;
				break;
			case 5:
				d = -270d;
				break;
		}
		GL11.glRotated(d, 0, 1, 0);
		GL11.glRotated(90 , 0, 1D, 0);
		ConstructorCenterEntity te = (ConstructorCenterEntity)tileentity;
		//
		if(te.hasType()){
			VehicleModel modvec = te.link.type.getModel();
			if(modvec != null){
				VehicleType type = te.link.type;
				Minecraft.getMinecraft().renderEngine.bindTexture(type.textures.get(type.current_texture));
				GL11.glTranslatef(0, type.construction_height_offset * 0.0625f, 0);
				modvec.render(te.link.type, null);
				if(type.parts.size() > 0){
					for(String key : type.parts.keySet()){
						PartType part = type.parts.get(key);
						part.bindTexture();
						part.translate(type.registryname);
						part.render(type, key);
						part.translateR(type.registryname);
					}
				}
				GL11.glTranslatef(0, type.construction_height_offset * -0.0625f, 0);
				Minecraft.getMinecraft().renderEngine.bindTexture(model.getTexture());
			}
			else{
				//Static.exception(4, "Model is null.");
			}
		}
		else{
			if(te.remote != null){
				te.link(te.remote);
			}
		}
		//
		GL11.glTranslatef(0, 0, te.getRenderOffset());
		GL11.glTranslatef(te.getLength() + 1, 0, 0);
		for(int i = 0; i < te.getRenderLength(); i++){
			GL11.glTranslatef(-1, 0, 0);
			model.render(model.turretModel);
		}
		GL11.glTranslatef(0, 0, -(te.getRenderOffset() * 2));
		for(int i = 0; i < te.getRenderLength(); i++){
			model.render(model.turretModel);
			GL11.glTranslatef(1, 0, 0);
		}
		GL11.glTranslatef(-te.getLength(), 0, 0);
		//
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
	
}