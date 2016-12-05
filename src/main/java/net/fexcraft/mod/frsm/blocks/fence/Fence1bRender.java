package net.fexcraft.mod.frsm.blocks.fence;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class Fence1bRender extends FTESR_4R {
	
	public Fence1bModel model;
	
	public Fence1bRender() {
		this.model = new Fence1bModel();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/fence1b.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}