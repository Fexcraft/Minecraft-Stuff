package net.fexcraft.mod.frsm.blocks.roadsigns;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.util.ResourceLocation;

@fTESR
public class RoadSign1Render extends FTESR_4R<RoadSign1.TE> {
	
	private static final ModelRoadSign1 model = new ModelRoadSign1();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/RoadSign1.png");
	}

	@Override
	public void renderModel(RoadSign1.TE tileentity, float partialticks, int destroystage){
		this.model.render();
	}
	
}