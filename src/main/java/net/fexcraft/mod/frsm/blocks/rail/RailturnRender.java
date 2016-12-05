package net.fexcraft.mod.frsm.blocks.rail;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class RailturnRender extends FTESR_4R {
	
	public RailturnModel model;
	
	public RailturnRender() {
		this.model = new RailturnModel();
	}
	
	public String texture = "frsm:textures/blocks/railturn.png";
    
	@Override
	public final String getTexturePath(){
		return texture;
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}