package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.frsm.util.block.FTESR;

public class StreetLamp1bRender extends FTESR{
	
	public ModelStreetLamp1b model;
	
	public StreetLamp1bRender() {
		this.model = new ModelStreetLamp1b();
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