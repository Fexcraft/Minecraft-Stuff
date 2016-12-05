package net.fexcraft.mod.frsm.blocks.pillar;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class PillarRender extends FTESR_4R {
	
	public PillarModel model;
	
	public PillarRender() {
		this.model = new PillarModel();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/pillar.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}