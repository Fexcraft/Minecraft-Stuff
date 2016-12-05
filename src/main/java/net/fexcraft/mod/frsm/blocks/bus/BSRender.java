package net.fexcraft.mod.frsm.blocks.bus;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class BSRender extends FTESR_4R {
       
	private final busstation model;
       
	public BSRender() {
		this.model = new busstation();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/busstation.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}