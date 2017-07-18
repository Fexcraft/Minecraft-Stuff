package net.fexcraft.mod.fvtm.render.block;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvtm.model.block.ModelConstructorController;
import net.fexcraft.mod.fvtm.render.Renderer;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.text.TextComponentString;

@fTESR
public class ConstructorControllerRender extends TileEntitySpecialRenderer<ConstructorControllerEntity> {
	
	private static final ModelConstructorController model = new ModelConstructorController();
	
	@Override
	public void render(ConstructorControllerEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
    	GL11.glPushMatrix();
		GL11.glTranslated(posX, posY, posZ);
		Minecraft.getMinecraft().renderEngine.bindTexture(model.getTexture());
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		//double d = 60;
		switch(te.getBlockMetadata()){
			case 2:
				GL11.glTranslated(-1, 0, 0);
				//d = 0;
				break;
			case 3:
				//d = 180;
				GL11.glTranslated(0, 0, 1);
				GL11.glRotated(180d, 0, 1, 0);
				break;
			case 4:
				//d = 270;
				GL11.glRotated(270d, 0, 1, 0);
				break;
			case 5:
				//d = 90;
				GL11.glTranslated(-1, 0, 1);
				GL11.glRotated( 90d, 0, 1, 0);
				break;
		}
		model.render(model.bodyModel);
		//Buttons
		for(int i = 0; i < te.getStateArray().length; i++){
			if(te.getStateArray()[i] == 1){
				te.GRAY.glColorApply();
			}
			else{
				te.DARKGRAY.glColorApply();
			}
			model.turretModel[i].render();
			RGB.glColorReset();
		}
		{
			model.steeringWheelModel[0].rotateAngleX = te.lift;
			model.steeringWheelModel[1].rotateAngleX = te.lift;
			model.render(model.steeringWheelModel);
		}
		this.setLightmapDisabled(true);
		for(int i = 0; i < 8; i++){
			String str = new TextComponentString(Formatter.format("&" + i + "TEST TEXT")).getFormattedText();
	        //this.drawNameplate(te, new TextComponentString(Formatter.format("&3TEST TEXT")).getFormattedText(), posX, posY + 1, posZ, 12);
            Renderer.drawNameplate(this.getFontRenderer(), str, 0.1f, -1.672f + (i * 0.0655f), 0.81f, 0, 0, 0, false, false);
		}
        this.setLightmapDisabled(false);
		//DEBUG
		/*if(te.hitX != 0 && te.hitY != 0 && te.hitZ != 0){
			GL11.glRotated(-d, 0, 1, 0);
			GL11.glRotatef(-180F, 0.0F, 0.0F, 1.0F);
			GL11.glTranslated(te.hitX, te.hitY, te.hitZ);
			Minecraft.getMinecraft().renderEngine.bindTexture(Resources.NULL_TEXTURE);
			ModelHitbox.instance().render();
		}*/
		//
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
	
}