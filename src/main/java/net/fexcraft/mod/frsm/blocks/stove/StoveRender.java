package net.fexcraft.mod.frsm.blocks.stove;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class StoveRender extends FTESR_4R {
       
	private final StoveModel model;
       
	public StoveRender() {
		this.model = new StoveModel();
	}

	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/Stove.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}