package net.fexcraft.mod.fvtm.render.block;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleData;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.blocks.ConstructorCenterEntity;
import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvtm.model.block.ModelConstructorCenter;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.render.RemoteTextureRenderHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

@fTESR
public class ConstructorCenterRenderer extends TileEntitySpecialRenderer<ConstructorCenterEntity> {
	
	private static final ModelConstructorCenter model = new ModelConstructorCenter();
	
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
		if(ConstructorControllerEntity.Client.vehicledata != null){
			VehicleModel modvec = (VehicleModel)ConstructorControllerEntity.Client.vehicledata.getVehicle().getModel();
			if(modvec != null){
				LandVehicleData data = ConstructorControllerEntity.Client.vehicledata;
				Minecraft.getMinecraft().renderEngine.bindTexture(data.getSelectedTexture() >= 0 ? data.getVehicle().getTextures().get(data.getSelectedTexture()) : RemoteTextureRenderHelper.get(data.getTextureURL()));
				GL11.glTranslatef(0, data.getVehicle().getYAxisConstructorOffset() * 0.0625f, 0);
				modvec.render(data, null, te.getBlockMetadata());
				if(data.getParts().size() > 0){
					for(String key : data.getInstalledParts()){
						PartData part = data.getParts().get(key);
						Minecraft.getMinecraft().renderEngine.bindTexture(part.getSelectedTexture() >= 0 ? part.getPart().getTextures().get(part.getSelectedTexture()) : RemoteTextureRenderHelper.get(part.getTextureURL()));
						part.getPart().getOffsetFor(data.getVehicle().getRegistryName()).translate();
						((PartModel)part.getPart().getModel()).render(data, key);
						part.getPart().getOffsetFor(data.getVehicle().getRegistryName()).translateR();
					}
				}
				GL11.glTranslatef(0, data.getVehicle().getYAxisConstructorOffset() * -0.0625f, 0);
				Minecraft.getMinecraft().renderEngine.bindTexture(model.getTexture());
			}
			else{
				//Static.exception(4, "Model is null.");
			}
		}
		else{
			if(te.constructor != null){
				te.link(te.constructor);
			}
		}
		//
		GL11.glTranslatef(0, 0, te.getRenderOffset());
		{
			model.render(model.trailerModel);
			render(ConstructorControllerEntity.Client.vehicledata, model.bodyModel);
			GL11.glTranslated(0, -1, 0);
			render(ConstructorControllerEntity.Client.vehicledata, model.bodyModel);
			GL11.glTranslated(0, -1, 0);
			render(ConstructorControllerEntity.Client.vehicledata, model.bodyModel);
			GL11.glTranslated(0, -1, 0);
			render(ConstructorControllerEntity.Client.vehicledata, model.bodyModel);
			GL11.glTranslated(0, -1, 0);
			render(ConstructorControllerEntity.Client.vehicledata, model.bodyModel);

			GL11.glTranslated(0, 4, 0);
		}
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
	
	private static final void render(LandVehicleData data, ModelRendererTurbo[] model){
		if(data == null){
			return;
		}
		model[0].render();
		model[1].render();
		model[2].render();
		data.getSecondaryColor().glColorApply();
		model[3].render();
		model[4].render();
		data.getSecondaryColor().glColorReset();
		data.getPrimaryColor().glColorApply();
		model[5].render();
		data.getPrimaryColor().glColorReset();
	}
	
}