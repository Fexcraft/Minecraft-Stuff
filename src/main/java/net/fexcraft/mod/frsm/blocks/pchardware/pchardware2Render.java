package net.fexcraft.mod.frsm.blocks.pchardware;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.frsm.util.block.PaintableTileEntity;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

@fTESR(tileentity = PCHardware2Entity.class)
public class PCHardware2Render extends FTESR_4R {
	
	private static final ModelPCHardware2 model = new ModelPCHardware2();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/pchardware2.png");
	}

	@Override
	public void renderModel(TileEntity tileentity, float partialticks, int destroystage){
		model.render(model.base);
		((PaintableTileEntity)tileentity).getColor().glColorApply();
		model.render(model.r0);
		RGB.glColorReset();
	}
	
}