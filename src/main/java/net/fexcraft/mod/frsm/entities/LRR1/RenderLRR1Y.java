package net.fexcraft.mod.frsm.entities.LRR1;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderLRR1Y extends RenderLiving{
	
    private static final ResourceLocation texture = new ResourceLocation("frsm:textures/entity/LRR1Y.png");
    
    public RenderLRR1Y(RenderManager rm, ModelBase m, float f){
        super(rm, m, f);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity){
        return texture;
    }
}