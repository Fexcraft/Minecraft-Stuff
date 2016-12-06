package net.fexcraft.mod.frsm.blocks.radio;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class Radio1Render extends FTESR_4R {
	
	public Radio1Model model;
	
	public Radio1Render() {
		this.model = new Radio1Model();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/Radio1.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}