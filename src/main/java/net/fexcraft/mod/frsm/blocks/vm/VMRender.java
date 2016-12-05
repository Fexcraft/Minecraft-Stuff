package net.fexcraft.mod.frsm.blocks.vm;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class VMRender extends FTESR_4R {
	
	public VMModel model;
	
	public VMRender() {
		this.model = new VMModel();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/vendingmachine.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}