package net.fexcraft.mod.fvm.render.block;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvm.blocks.ConstructorControllerEntity.Button;
import net.fexcraft.mod.fvm.model.ModelConstructorController;
import net.fexcraft.mod.fvm.model.ModelHitbox;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

@fTESR
public class ConstructorControllerRender extends TileEntitySpecialRenderer<ConstructorControllerEntity> {
	
	private static final ModelConstructorController model = new ModelConstructorController();
	
	@Override
	public void func_192841_a(ConstructorControllerEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
    	GL11.glPushMatrix();
		GL11.glTranslated(posX, posY, posZ);
		Minecraft.getMinecraft().renderEngine.bindTexture(model.getTexture());
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		double d = 60;
		switch(te.getBlockMetadata()){
			case 2:
				GL11.glTranslated(-1, 0, 0);
				d = 0;
				break;
			case 3:
				d = 180;
				GL11.glTranslated(0, 0, 1);
				GL11.glRotated(180d, 0, 1, 0);
				break;
			case 4:
				d = 270;
				GL11.glRotated(270d, 0, 1, 0);
				break;
			case 5:
				d = 90;
				GL11.glTranslated(-1, 0, 1);
				GL11.glRotated( 90d, 0, 1, 0);
				break;
		}
		model.render(model.bodyModel);
		//Buttons
		for(int i = 0; i < te.buttons.length; i++){
			Button button = te.buttons[i];
			if(button.pressed){
				GL11.glTranslatef(0, -0.1f, 0);
			}
			if(button.state){
				button.color.glColorApply();
			}
			else{
				RGB.BLACK.glColorApply();
			}
			model.turretModel[i].render();
			RGB.glColorReset();
			if(button.pressed){
				GL11.glTranslatef(0, 0.1f, 0);
			}
		}
		model.render(model.steeringWheelModel);
		//DEBUG
		if(te.hitX != 0 && te.hitY != 0 && te.hitZ != 0){
			GL11.glRotated(-d, 0, 1, 0);
			GL11.glRotatef(-180F, 0.0F, 0.0F, 1.0F);
			GL11.glTranslated(te.hitX, te.hitY, te.hitZ);
			Minecraft.getMinecraft().renderEngine.bindTexture(FvmResources.NULL_TEXTURE);
			ModelHitbox.instance().render();
		}
		//
		GL11.glPopMatrix();
		GL11.glPopMatrix();
    }
	
}