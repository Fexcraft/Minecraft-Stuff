package net.fexcraft.mod.frsm.blocks.roadsigns;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.util.ResourceLocation;

@fTESR
public class RoadSign3Render extends FTESR_4R<RoadSign3.TE> {
	
	private static final ModelRoadSign3 model = new ModelRoadSign3();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/RoadSign3.png");
	}

	@Override
	public void renderModel(RoadSign3.TE tileentity, float partialticks, int destroystage){
		this.model.render();
	}
	
}