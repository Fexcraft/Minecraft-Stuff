package net.fexcraft.mod.frsm.entities.goat;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGoat extends RenderLiving{
	
	public RenderGoat(RenderManager rm, float f){
        super(rm, new Goat(), f);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity){
        return new ResourceLocation("minecraft:textures/entity/sheep.png");
    }
}