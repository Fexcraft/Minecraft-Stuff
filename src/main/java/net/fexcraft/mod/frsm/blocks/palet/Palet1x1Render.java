package net.fexcraft.mod.frsm.blocks.palet;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class Palet1x1Render extends FTESR_4R {
	
	public Palet1x1Model model;
	
	public Palet1x1Render() {
		this.model = new Palet1x1Model();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/Palet1x1.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}