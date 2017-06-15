package net.fexcraft.mod.frsm.blocks.trashcan;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.util.ResourceLocation;

@fTESR
public class TrashcanRender extends FTESR_4R<TrashcanEntity> {
	
	private static final TrashcanModel model = new TrashcanModel();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/trashcan.png");
	}

	@Override
	public void renderModel(TrashcanEntity tileentity, float partialticks, int destroystage){
		this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
	
}