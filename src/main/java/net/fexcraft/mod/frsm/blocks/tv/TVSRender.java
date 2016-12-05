package net.fexcraft.mod.frsm.blocks.tv;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class TVSRender extends FTESR_4R {
	
	public TVSModel model;
	
	public TVSRender() {
		this.model = new TVSModel();
	}

	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/tvs.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}