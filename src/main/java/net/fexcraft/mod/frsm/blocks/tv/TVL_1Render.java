package net.fexcraft.mod.frsm.blocks.tv;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class TVL_1Render extends FTESR_4R {
	
	public TVL_1Model model;
	
	public TVL_1Render() {
		this.model = new TVL_1Model();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/TVL_1.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render();
	}
	
	@Override
	public int adjustAngleBy(){
		return 0;
	}
}