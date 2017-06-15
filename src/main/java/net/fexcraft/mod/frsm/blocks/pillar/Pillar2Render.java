package net.fexcraft.mod.frsm.blocks.pillar;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.util.ResourceLocation;

@fTESR
public class Pillar2Render extends FTESR_4R<Pillar2Entity> {
	
	private static final Pillar2Model model = new Pillar2Model();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/pillar2.png");
	}

	@Override
	public void renderModel(Pillar2Entity tileentity, float partialticks, int destroystage){
		tileentity.getColor().glColorApply();
		this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		RGB.glColorReset();
	}
	
}