package net.fexcraft.mod.fvm.blocks;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvm.data.PartType;
import net.fexcraft.mod.fvm.data.VehicleType;
import net.fexcraft.mod.fvm.models.VehicleModel;
import net.fexcraft.mod.fvm.models.block.ModelDisplayBlock;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

@fTESR(tileentity = DisplayBlockEntity.class)
public class DisplayBlockRenderer extends TileEntitySpecialRenderer {
	
	private static final ModelDisplayBlock model = new ModelDisplayBlock();
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double posX, double posY, double posZ, float partialticks, int destroystage){
    	GL11.glPushMatrix();
		GL11.glTranslated(posX + 0.5F, posY + 1.5F, posZ + 0.5F);
		Minecraft.getMinecraft().renderEngine.bindTexture(model.getTexture());
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		DisplayBlockEntity te = (DisplayBlockEntity)tileentity;
		//
		model.render(model.base);
		GL11.glRotated((te.getRotation() * 10) - 90, 0, 1D, 0);
		model.render(model.r0);
		GL11.glRotatef(90, 0, 1f, 0);
		if(te.hasType()){
			VehicleModel modvec = te.getType().getModel();
			if(modvec != null){
				VehicleType type = te.getType();
				Minecraft.getMinecraft().renderEngine.bindTexture(type.textures.get(type.current_texture));
				GL11.glTranslatef(0, (type.construction_height_offset + 2) * 0.0625f, 0);
				modvec.render(type, null);
				if(type.parts.size() > 0){
					for(String key : type.parts.keySet()){
						PartType part = type.parts.get(key);
						Minecraft.getMinecraft().renderEngine.bindTexture(part.textures.get(type.current_texture));
						part.translate(type.registryname);
						part.getModel().render(type, key);
						part.translateR(type.registryname);
					}
				}
				GL11.glTranslatef(0, (type.construction_height_offset + 2) * -0.0625f, 0);
				Minecraft.getMinecraft().renderEngine.bindTexture(model.getTexture());
			}
			else{
				Static.exception(4, "Model is null.");
			}
		}
		//
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
	
}