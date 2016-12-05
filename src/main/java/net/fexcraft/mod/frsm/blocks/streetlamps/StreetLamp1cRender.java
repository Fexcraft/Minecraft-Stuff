package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class StreetLamp1cRender extends FTESR_4R{
	
	public ModelStreetLamp1c model;
	
	public StreetLamp1cRender() {
		this.model = new ModelStreetLamp1c();
	}
	
	public void ModelRender(){
		this.model.render();
	}
    
	public String getTexturePath(){
		return "frsm:textures/blocks/StreetLamp1c.png";
	}
	
	@Override
	public int adjustAngleBy(){
		return 90;
	}
}