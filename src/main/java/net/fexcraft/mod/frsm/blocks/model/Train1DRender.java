package net.fexcraft.mod.frsm.blocks.model;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class Train1DRender extends FTESR_4R {
	
	public Train1DModel model;
	
	public Train1DRender() {
		this.model = new Train1DModel();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/Train1D.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}