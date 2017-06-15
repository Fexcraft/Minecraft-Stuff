package net.fexcraft.mod.frsm.blocks.pchardware;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.util.ResourceLocation;

@fTESR
public class PCHardware2Render extends FTESR_4R<PCHardware2Entity> {
	
	private static final ModelPCHardware2 model = new ModelPCHardware2();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/pchardware2.png");
	}

	@Override
	public void renderModel(PCHardware2Entity tileentity, float partialticks, int destroystage){
		model.render(model.base);
		tileentity.getColor().glColorApply();
		model.render(model.r0);
		RGB.glColorReset();
	}
	
}