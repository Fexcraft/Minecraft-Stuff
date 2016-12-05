package net.fexcraft.mod.frsm.blocks.chair;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class OfficechairGRender extends FTESR_4R {
	
	public OfficechairModel model;
	
	public OfficechairGRender() {
		this.model = new OfficechairModel();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/officechairG.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}