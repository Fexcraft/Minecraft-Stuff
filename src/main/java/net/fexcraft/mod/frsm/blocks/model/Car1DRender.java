package net.fexcraft.mod.frsm.blocks.model;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class Car1DRender extends FTESR_4R {
	
	public Car1DModel model;
	
	public Car1DRender() {
		this.model = new Car1DModel();
	}

	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/Car1D.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}