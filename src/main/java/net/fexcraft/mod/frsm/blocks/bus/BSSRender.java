package net.fexcraft.mod.frsm.blocks.bus;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class BSSRender extends FTESR_4R {
       
	private final busstop model;
       
	public BSSRender() {
		this.model = new busstop();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/busstop_0.png";
	}
		
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}