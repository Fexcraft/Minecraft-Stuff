package net.fexcraft.mod.frsm.blocks.cup;

import net.fexcraft.mod.frsm.util.block.FTESR;

public class Year1Render extends FTESR{
	
	public Year1Model model;
	
	public Year1Render() {
		this.model = new Year1Model();
	}
	
	public void ModelRender(){
		this.model.render();
	}
    
	public String getTexturePath(){
		return "frsm:textures/blocks/year1.png";
	}
	
	@Override
	public int adjustAngleBy(){
		return 90;
	}
}