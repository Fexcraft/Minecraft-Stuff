package net.fexcraft.mod.frsm.blocks.pchardware;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class pchardware2Render extends FTESR_4R {
	
	public pchardware2Model model;
	
	public pchardware2Render() {
		this.model = new pchardware2Model();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/pchardware2.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}