package net.fexcraft.mod.extensions.ve.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.frsm.blocks.model.C5Model;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class EntityVehicleRender extends Render{

	public C5Model model = new C5Model();
	
	public EntityVehicleRender(RenderManager renderManager) {
		super(renderManager);		
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("frsm:textures/blocks/C5.png");
	}
	
	//@Override
    protected void preRenderCallback(EntityLivingBase entity, float f){
		GL11.glPushMatrix();
		//GL11.glTranslatef((float) posX + 0.5F, (float) posY + 1.5F, (float) posZ + 0.5F);
		//ResourceLocation textures = (new ResourceLocation(getTexturePath()));
		Minecraft.getMinecraft().renderEngine.bindTexture(getEntityTexture(entity));
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		//this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		this.model.render();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	
}