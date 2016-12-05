package net.fexcraft.mod.frsm.blocks.trashcan;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class TrashcanRender extends FTESR_4R {
	
	public TrashcanModel model;
	
	public TrashcanRender() {
		this.model = new TrashcanModel();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/trashcan.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}