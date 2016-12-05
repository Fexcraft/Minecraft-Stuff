package net.fexcraft.mod.frsm.blocks.fence;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class Fence1Render extends FTESR_4R {
	
	public Fence1Model model;
	
	public Fence1Render() {
		this.model = new Fence1Model();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/fence1.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}