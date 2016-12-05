package net.fexcraft.mod.frsm.entities.car;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderCar1 extends RenderLiving{
	
	public RenderCar1(RenderManager rm, float f){
        super(rm, new Car1(), f);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity){
        return new ResourceLocation("frsm:textures/blocks/Car1D.png");
    }
}