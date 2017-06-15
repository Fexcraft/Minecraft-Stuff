package net.fexcraft.mod.frsm.blocks.pillar;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.util.ResourceLocation;

@fTESR
public class PillarRender extends FTESR_4R<PillarEntity> {
	
	private static final PillarModel model = new PillarModel();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/pillar.png");
	}

	@Override
	public void renderModel(PillarEntity tileentity, float partialticks, int destroystage){
		tileentity.getColor().glColorApply();
		this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		RGB.glColorReset();
	}
	
}