package net.fexcraft.mod.frsm.blocks.laptop;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class LaptopGRender extends FTESR_4R {
	
	public LaptopGModel model;
	
	public LaptopGRender() {
		this.model = new LaptopGModel();
	}

	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/laptopG.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
	
}