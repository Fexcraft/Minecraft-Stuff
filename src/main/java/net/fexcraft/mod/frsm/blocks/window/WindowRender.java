package net.fexcraft.mod.frsm.blocks.window;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class WindowRender extends FTESR_4R {
	
	public WindowModel model;
	
	public WindowRender() {
		this.model = new WindowModel();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/window.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}