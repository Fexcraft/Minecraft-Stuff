package net.fexcraft.mod.frsm.blocks.oven;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.util.ResourceLocation;

@fTESR
public class PizzaOvenRenderer extends FTESR_4R<PizzaOvenEntity> {
	
	private static final ModelPizzaOven model = new ModelPizzaOven();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/pizza_oven.png");
	}

	@Override
	public void renderModel(PizzaOvenEntity tileentity, float partialticks, int destroystage){
		model.render(model.base);
		model.render(model.closed);
		model.render(model.r0);
		model.render(model.r1);
		model.render(model.r2);
		((PizzaOvenEntity)tileentity).getColor().glColorApply();
		model.render(model.r3);
		RGB.glColorReset();
	}
	
}