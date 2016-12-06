package net.fexcraft.mod.frsm.entities.R3;

import net.fexcraft.mod.lib.api.entity.RoboType;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class R3JRender extends RenderLiving{
	
	private RoboType type;
	
	public R3JRender(RenderManager rm, RoboType type){
        super(rm, new R3JModel(), 0.5F);
        this.type = type;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity){
        return new ResourceLocation("frsm:textures/entity/Robo3J" + type.getChar() + ".png");
    }
}