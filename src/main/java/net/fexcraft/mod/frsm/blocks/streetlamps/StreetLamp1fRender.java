package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class StreetLamp1fRender extends FTESR_4R{
	
	public ModelStreetLamp1f model;
	
	public StreetLamp1fRender() {
		this.model = new ModelStreetLamp1f();
	}
	
	public void ModelRender(){
		this.model.render();
	}
    
	public String getTexturePath(){
		return "frsm:textures/blocks/StreetLamp1b.png";
	}
	
	@Override
	public int adjustAngleBy(){
		return 90;
	}
}