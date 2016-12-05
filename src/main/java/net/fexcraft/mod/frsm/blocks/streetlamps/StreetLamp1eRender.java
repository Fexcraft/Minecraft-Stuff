package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class StreetLamp1eRender extends FTESR_4R{
	
	public ModelStreetLamp1e model;
	
	public StreetLamp1eRender() {
		this.model = new ModelStreetLamp1e();
	}
	
	public void ModelRender(){
		this.model.render();
	}
    
	public String getTexturePath(){
		return "frsm:textures/blocks/StreetLamp1e.png";
	}
	
	@Override
	public int adjustAngleBy(){
		return 90;
	}
}