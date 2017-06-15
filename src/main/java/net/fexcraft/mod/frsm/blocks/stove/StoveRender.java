package net.fexcraft.mod.frsm.blocks.stove;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.util.ResourceLocation;

@fTESR
public class StoveRender extends FTESR_4R<StoveEntity> {
       
	private static final StoveModel model = new StoveModel();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/Stove.png");
	}
	
	@Override
	public void renderModel(StoveEntity tileentity, float partialticks, int destroystage){
		this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
	
}