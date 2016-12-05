package net.fexcraft.mod.frsm.entities.R2;

import net.fexcraft.mod.lib.api.entity.RoboType;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class R2JRender extends RenderLiving{
	
	private RoboType type;
    
    public R2JRender(RenderManager rm, RoboType type){
        super(rm, new R2JModel(), 0.5F);
        this.type = type;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity){
        return new ResourceLocation("frsm:textures/entity/Robo2J" + type.getChar() + ".png");
    }
}