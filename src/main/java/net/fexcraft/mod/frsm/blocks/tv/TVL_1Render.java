package net.fexcraft.mod.frsm.blocks.tv;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

@fTESR(tileentity = TVL_1.TE.class)
public class TVL_1Render extends FTESR_4R {
	
	private static final TVL_1Model model = new TVL_1Model();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/TVL_1.png");
	}

	@Override
	public void renderModel(TileEntity tileentity, float partialticks, int destroystage){
		this.model.render();
	}
	
}