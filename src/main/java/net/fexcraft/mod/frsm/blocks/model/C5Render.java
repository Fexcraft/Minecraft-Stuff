package net.fexcraft.mod.frsm.blocks.model;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class C5Render extends FTESR_4R {
	
	public C5Model model;
	
	public C5Render() {
		this.model = new C5Model();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/C5.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render();
	}
}