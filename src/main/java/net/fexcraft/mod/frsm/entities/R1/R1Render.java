package net.fexcraft.mod.frsm.entities.R1;

import net.fexcraft.mod.lib.api.entity.RoboType;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class R1Render extends RenderLiving{
	
	private RoboType type;
	
    public R1Render(RenderManager rm, RoboType type) {
		super(rm, new R1Model(), 0.5F);
		this.type = type;
	}
    
    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity){
    	switch(type){
			case BLUE:
				return new ResourceLocation("frsm:textures/entity/Robo1BB.png");
			case GREEN:
				return new ResourceLocation("frsm:textures/entity/Robo1BG.png");
			case GUARD:
				return new ResourceLocation("frsm:textures/entity/Robo1BP.png");
			case RED:
				return new ResourceLocation("frsm:textures/entity/Robo1B.png");
			case YELLOW:
				return new ResourceLocation("frsm:textures/entity/Robo1BY.png");
			default: break;
    	}
		return null;
    }
    
    public static class Blue extends R1Render{
		public Blue(RenderManager rm) {
			super(rm, RoboType.BLUE);
		}
    }
    
    public static class Red extends R1Render{
		public Red(RenderManager rm) {
			super(rm, RoboType.RED);
		}
    }
    
    public static class Green extends R1Render{
		public Green(RenderManager rm) {
			super(rm, RoboType.GREEN);
		}
    }
    
    public static class Yellow extends R1Render{
		public Yellow(RenderManager rm) {
			super(rm, RoboType.YELLOW);
		}
    }
    
    public static class Guard extends R1Render{
		public Guard(RenderManager rm) {
			super(rm, RoboType.GUARD);
		}
    }
    
}