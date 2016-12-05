package net.fexcraft.mod.frsm.blocks.furnace;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class Furnance1bRender extends FTESR_4R{
	
	public ModelFurnance1b model;
	
	public Furnance1bRender() {
		this.model = new ModelFurnance1b();
	}
	
	public void ModelRender(){
		this.model.render();
	}
    
	public String getTexturePath(){
		return "frsm:textures/blocks/Furnance1.png";
	}
	
	@Override
	public int adjustAngleBy(){
		return 90;
	}
}