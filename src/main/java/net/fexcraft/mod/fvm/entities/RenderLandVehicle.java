package net.fexcraft.mod.fvm.entities;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvm.data.PartType;
import net.fexcraft.mod.fvm.models.VehicleModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderLandVehicle extends Render implements IRenderFactory{
	
	public RenderLandVehicle(RenderManager renderManager) {
		super(renderManager);
		shadowSize = 0.5F;
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	public void bindTexture(Entity ent){
		super.bindEntityTexture(ent);
	}
	
	public void render(EntityLandVehicle vehicle, double d, double d1, double d2, float f, float f1){
		bindEntityTexture(vehicle);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d, (float)d1, (float)d2);
		GL11.glRotatef(90f + vehicle.rotationYaw,   0, 1, 0);
		GL11.glRotatef(vehicle.rotationPitch, 0, 0, 1);
		//GL11.glRotatef(90f - vehicle.rotationRoll,  1, 0, 0);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
	
		float scale = vehicle.data.scale;
		GL11.glPushMatrix();
		GL11.glScalef(scale, scale, scale);				
		
		GL11.glTranslatef(0, vehicle.data.construction_height_offset * -0.0625f, 0);
		VehicleModel modvec = (VehicleModel)vehicle.data.getModel();
		modvec.render(vehicle.data);
		if(vehicle.data.parts.size() > 0){
			for(PartType part : vehicle.data.parts.values()){
				Minecraft.getMinecraft().renderEngine.bindTexture(part.textures.get(vehicle.data.current_texture));
				part.translate(vehicle.data.registryname);
				part.getModel().render(vehicle.data);
				part.translateR(vehicle.data.registryname);
			}
		}
		GL11.glTranslatef(0, vehicle.data.construction_height_offset * 0.0625f, 0);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float ticks){
		//render((EntityVehicle)entity, x, y, z, yaw, ticks);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity){
		return ((EntityLandVehicle)entity).data.getTexture();
	}
	
	@SubscribeEvent
	public void renderWorld(RenderWorldLastEvent event){
		World world = Minecraft.getMinecraft().world;
		if(world == null){
			return;
		}
		
		Entity camera = Minecraft.getMinecraft().getRenderViewEntity();
		double x = camera.lastTickPosX + (camera.posX - camera.lastTickPosX) * event.getPartialTicks();
		double y = camera.lastTickPosY + (camera.posY - camera.lastTickPosY) * event.getPartialTicks();
		double z = camera.lastTickPosZ + (camera.posZ - camera.lastTickPosZ) * event.getPartialTicks();
		
		GL11.glPushMatrix();
		Minecraft.getMinecraft().entityRenderer.enableLightmap();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);
		RenderHelper.enableStandardItemLighting();
		GL11.glTranslatef(-(float)x, -(float)y, -(float)z);
		for(Entity entity : world.loadedEntityList){
			if(entity instanceof EntityLandVehicle){
				EntityLandVehicle vehicle = (EntityLandVehicle)entity;
				int i = vehicle.getBrightnessForRender(event.getPartialTicks());
				if (vehicle.isBurning()){
					i = 15728880;
				}
				int j = i % 65536;
				int k = i / 65536;
				OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
				GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
				render(vehicle, vehicle.prevPosX + (vehicle.posX - vehicle.prevPosX) * event.getPartialTicks(), vehicle.prevPosY + (vehicle.posY - vehicle.prevPosY) * event.getPartialTicks(), vehicle.prevPosZ + (vehicle.posZ - vehicle.prevPosZ) * event.getPartialTicks(), 0F, event.getPartialTicks());
			}
		}
		Minecraft.getMinecraft().entityRenderer.disableLightmap();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}

	@Override
	public Render createRenderFor(RenderManager manager){
		return new RenderLandVehicle(manager);
	}
	
}

