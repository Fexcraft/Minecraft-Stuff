package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.util.ResourceLocation;

@fTESR
public class StreetLampTopRender extends FTESR_4R<StreetLampEntity> {
	
	private static final ModelStreetLampTop model = new ModelStreetLampTop();
	
	@Override
	public int adjustAngle(){
		return 90;
	}
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/streetlamp1e.png");
	}

	@Override
	public void renderModel(StreetLampEntity tileentity, float partialticks, int destroystage){
		model.render();
	}
	
}