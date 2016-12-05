package net.fexcraft.mod.frsm.blocks.cup;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class CupGRender extends FTESR_4R {
	
	public CupGModel model;
	
	public CupGRender() {
		this.model = new CupGModel();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/cupG.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}