package net.fexcraft.mod.frsm.blocks.flag;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class Flag0Render extends FTESR_4R {
	
	public FlagModel model;
	
	public Flag0Render() {
		this.model = new FlagModel();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/flag0.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}