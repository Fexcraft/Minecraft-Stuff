package net.fexcraft.mod.frsm.blocks.roadsigns;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.util.ResourceLocation;

@fTESR
public class RoadSign6Render extends FTESR_4R<RoadSign6.TE> {
	
	private static final ModelRoadSign6 model = new ModelRoadSign6();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/RoadSign6.png");
	}

	@Override
	public void renderModel(RoadSign6.TE tileentity, float partialticks, int destroystage){
		this.model.render();
	}
	
}