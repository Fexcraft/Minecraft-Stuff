package net.fexcraft.mod.frsm.entities.R2;

import net.fexcraft.mod.lib.api.entity.RoboType;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class R2LRender extends RenderLiving{
	
	private RoboType type;
	
    public R2LRender(RenderManager rendermanagerIn, RoboType type) {
		super(rendermanagerIn, new R2LModel(), 0.5F);
		this.type = type;
	}
    
    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity){
        return new ResourceLocation("frsm:textures/entity/Robo2L" + type.getChar() + ".png");
    }
}