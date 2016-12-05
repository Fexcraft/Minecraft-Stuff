package net.fexcraft.mod.frsm.blocks.wm;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class WMRender extends FTESR_4R {
       
	private final WMModel model;
       
	public WMRender() {
		this.model = new WMModel();
	}

	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/washingmachine.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
	
}