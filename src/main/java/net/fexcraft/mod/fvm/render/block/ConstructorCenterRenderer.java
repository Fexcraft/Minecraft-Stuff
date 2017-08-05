package net.fexcraft.mod.fvm.render.block;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvm.blocks.ConstructorCenterEntity;
import net.fexcraft.mod.fvm.data.Part.PartData;
import net.fexcraft.mod.fvm.data.Vehicle.VehicleData;
import net.fexcraft.mod.fvm.model.ModelConstructionBlock;
import net.fexcraft.mod.fvm.model.VehicleModel;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.util.render.ExternalTextureHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

@fTESR
public class ConstructorCenterRenderer extends TileEntitySpecialRenderer<ConstructorCenterEntity> {
	
	private static final ModelConstructionBlock model = new ModelConstructionBlock();
	
	@Override
	public void render(ConstructorCenterEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
    	GL11.glPushMatrix();
		GL11.glTranslated(posX + 0.5F, posY + 1.5F, posZ + 0.5F);
		Minecraft.getMinecraft().renderEngine.bindTexture(model.getTexture());
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		double d = 60;
		switch(te.getBlockMetadata()){
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
		//
		if(te.hasType()){
			VehicleModel modvec = te.link.data.vehicle.model;
			if(modvec != null){
				VehicleData data = te.link.data;
				Minecraft.getMinecraft().renderEngine.bindTexture(data.texture >= 0 ? data.vehicle.textures.get(data.texture) : ExternalTextureHelper.get(data.texture_url));
				GL11.glTranslatef(0, data.vehicle.construction_height_offset * 0.0625f, 0);
				modvec.render(te.link.data, null, te.getBlockMetadata());
				if(data.parts.size() > 0){
					for(String key : data.parts.keySet()){
						PartData part = data.parts.get(key);
						Minecraft.getMinecraft().renderEngine.bindTexture(part.texture >= 0 ? part.part.textures.get(part.texture) : ExternalTextureHelper.get(part.texture_url));
						part.part.translate(data.vehicle.getRegistryName());
						part.part.model.render(data, key);
						part.part.translateR(data.vehicle.getRegistryName());
					}
				}
				GL11.glTranslatef(0, data.vehicle.construction_height_offset * -0.0625f, 0);
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