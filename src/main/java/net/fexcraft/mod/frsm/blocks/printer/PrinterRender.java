package net.fexcraft.mod.frsm.blocks.printer;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.util.ResourceLocation;

@fTESR
public class PrinterRender extends FTESR_4R<PrinterEntity> {
	
	private static final PrinterModel model = new PrinterModel();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/printer.png");
	}

	@Override
	public void renderModel(PrinterEntity tileentity, float partialticks, int destroystage){
		this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
	
}