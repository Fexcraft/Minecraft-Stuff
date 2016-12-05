package net.fexcraft.mod.frsm.entities.R2;

import net.fexcraft.mod.lib.api.entity.RoboType;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class R2HRender extends RenderLiving{
	
	private RoboType type;
	
    public R2HRender(RenderManager rm, RoboType type) {
		super(rm, new R2HModel(), 0.5F);
		this.type = type;
	}
    
    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity){
    	switch(type){
		case BLUE:
			return new ResourceLocation("frsm:textures/entity/Robo2HB.png");
		case GREEN:
			return new ResourceLocation("frsm:textures/entity/Robo2HG.png");
		case GUARD:
			return new ResourceLocation("frsm:textures/entity/Robo2HP.png");
		case RED:
			return new ResourceLocation("frsm:textures/entity/Robo2HR.png");
		case YELLOW:
			return new ResourceLocation("frsm:textures/entity/Robo2HY.png");
		default: break;
	}
	return null;
    }
}