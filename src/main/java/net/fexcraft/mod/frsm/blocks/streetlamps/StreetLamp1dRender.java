package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class StreetLamp1dRender extends FTESR_4R{
	
	public ModelStreetLamp1d model;
	
	public StreetLamp1dRender() {
		this.model = new ModelStreetLamp1d();
	}
	
	public void ModelRender(){
		this.model.render();
	}
    
	public String getTexturePath(){
		return "frsm:textures/blocks/StreetLamp1d.png";
	}
	
	@Override
	public int adjustAngleBy(){
		return 90;
	}
}