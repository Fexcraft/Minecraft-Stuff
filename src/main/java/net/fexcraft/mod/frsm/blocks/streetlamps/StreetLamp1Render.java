package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.frsm.util.block.FTESR;

public class StreetLamp1Render extends FTESR{
	
	public ModelStreetLamp1 model;
	
	public StreetLamp1Render() {
		this.model = new ModelStreetLamp1();
	}
	
	public void ModelRender(){
		this.model.render();
	}
    
	public String getTexturePath(){
		return "frsm:textures/blocks/StreetLamp1.png";
	}
	
	@Override
	public int adjustAngleBy(){
		return 90;
	}
}