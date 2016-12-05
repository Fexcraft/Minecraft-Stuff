package net.fexcraft.mod.frsm.blocks.printer;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class PrinterRender extends FTESR_4R {
	
	public PrinterModel model;
	
	public PrinterRender() {
		this.model = new PrinterModel();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/printer.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}