package net.fexcraft.mod.frsm.entities.LRR2;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderLRR2RT extends RenderLiving{
	
    private static final ResourceLocation texture = new ResourceLocation("frsm:textures/entity/LRR1R.png");
    
    public RenderLRR2RT(RenderManager rm, ModelBase m, float f){
        super(rm, m, f);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity){
        return texture;
    }
}