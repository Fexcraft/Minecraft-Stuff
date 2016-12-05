package net.fexcraft.mod.frsm.blocks.furnace;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class Furnance1Render extends FTESR_4R{
	
	public ModelFurnance1 model;
	
	public Furnance1Render() {
		this.model = new ModelFurnance1();
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