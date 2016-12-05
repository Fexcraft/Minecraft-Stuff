package net.fexcraft.mod.frsm.blocks.kd;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class KD1Render extends FTESR_4R {
	
	public KD1Model model;
	
	public KD1Render() {
		this.model = new KD1Model();
	}

	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/KD1.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}