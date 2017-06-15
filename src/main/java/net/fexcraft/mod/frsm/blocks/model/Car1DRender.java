package net.fexcraft.mod.frsm.blocks.model;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.util.ResourceLocation;

@fTESR
public class Car1DRender extends FTESR_4R<Car1DEntity> {
	
	private static final Car1DModel model = new Car1DModel();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/Car1D.png");
	}

	@Override
	public void renderModel(Car1DEntity tileentity, float partialticks, int destroystage){
		this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
	
}