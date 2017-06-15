package net.fexcraft.mod.frsm.blocks.rail.station;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.util.ResourceLocation;

@fTESR
public class Station2Render extends FTESR_4R<Station2Entity> {
	
	private static final Station2Model model = new Station2Model();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/station.png");
	}

	@Override
	public void renderModel(Station2Entity tileentity, float partialticks, int destroystage){
		this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
	
}