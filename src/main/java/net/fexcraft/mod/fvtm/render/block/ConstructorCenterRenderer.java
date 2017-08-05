package net.fexcraft.mod.fvtm.render.block;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleData;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.blocks.ConstructorCenterEntity;
import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvtm.model.block.ModelConstructorCenter;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
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
			VehicleModel modvec = ConstructorControllerEntity.Client.vehicledata.getVehicle().getModel();
			if(modvec != null){
				LandVehicleData data = ConstructorControllerEntity.Client.vehicledata;
				Minecraft.getMinecraft().renderEngine.bindTexture(data.getTexture());
				GL11.glTranslated(0, (data.getVehicle().getYAxisConstructorOffset() * 0.0625f) - ConstructorControllerEntity.Client.liftstate, 0);
				modvec.render(data, null, te.getBlockMetadata());
				if(data.getParts().size() > 0){
					for(String key : data.getInstalledParts()){
						PartData part = data.getParts().get(key);
						Minecraft.getMinecraft().renderEngine.bindTexture(part.getTexture());
						part.getPart().getOffsetFor(data.getVehicle().getRegistryName()).translate();
						part.getPart().getModel().render(data, key);
						part.getPart().getOffsetFor(data.getVehicle().getRegistryName()).translateR();
					}
				}
				GL11.glTranslated(0, (data.getVehicle().getYAxisConstructorOffset() * -0.0625f) + ConstructorControllerEntity.Client.liftstate, 0);
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
		renderLP(te, ConstructorControllerEntity.Client.vehicledata, model.bodyModel);
		GL11.glTranslatef(0, 0, -(te.getRenderOffset() * 2));
		GL11.glRotated(180, 0, 1, 0);
		renderLP(te, ConstructorControllerEntity.Client.vehicledata, model.bodyModel);
		//
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
	
	private static final void renderLP(ConstructorCenterEntity te, LandVehicleData data, ModelRendererTurbo[] turbo){
		if(data != null){
			for(int i = 0; i < 5; i++){
				turbo[0].render();
				turbo[1].render();
				turbo[2].render();
				data.getSecondaryColor().glColorApply();
				turbo[3].render();
				turbo[4].render();
				data.getSecondaryColor().glColorReset();
				data.getPrimaryColor().glColorApply();
				turbo[5].render();
				data.getPrimaryColor().glColorReset();
				if(i != 4){
					GL11.glTranslated(0, -1, 0);
				}
			}
			GL11.glTranslated(0, 4, 0);
		}
		GL11.glTranslated(0, -ConstructorControllerEntity.Client.liftstate, 0);
		model.render(model.trailerModel);
		GL11.glTranslatef(te.getLength() + 1, 0, 0);
		for(int i = 0; i < te.getRenderLength(); i++){
			GL11.glTranslatef(-1, 0, 0);
			model.render(model.turretModel);
		}
		GL11.glTranslatef(te.getLength(), 0, 0);
		GL11.glTranslated(0, ConstructorControllerEntity.Client.liftstate, 0);
		
	}
	
}