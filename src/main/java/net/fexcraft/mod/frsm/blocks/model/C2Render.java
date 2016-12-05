package net.fexcraft.mod.frsm.blocks.model;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class C2Render extends FTESR_4R {
	
	public C2Model model;
	
	public C2Render() {
		this.model = new C2Model();
	}

	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/C2.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render();
	}
}