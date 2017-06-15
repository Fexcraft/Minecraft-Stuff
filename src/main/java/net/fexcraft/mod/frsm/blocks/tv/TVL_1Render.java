package net.fexcraft.mod.frsm.blocks.tv;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.util.ResourceLocation;

@fTESR
public class TVL_1Render extends FTESR_4R<TVL_1.TE> {
	
	private static final TVL_1Model model = new TVL_1Model();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/TVL_1.png");
	}

	@Override
	public void renderModel(TVL_1.TE tileentity, float partialticks, int destroystage){
		this.model.render();
	}
	
}