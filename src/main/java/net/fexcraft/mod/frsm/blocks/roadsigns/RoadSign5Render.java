package net.fexcraft.mod.frsm.blocks.roadsigns;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.util.ResourceLocation;

@fTESR
public class RoadSign5Render extends FTESR_4R<RoadSign5.TE> {
	
	private static final ModelRoadSign5 model = new ModelRoadSign5();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/RoadSign5.png");
	}

	@Override
	public void renderModel(RoadSign5.TE tileentity, float partialticks, int destroystage){
		this.model.render();
	}
	
}