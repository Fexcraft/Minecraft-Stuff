package net.fexcraft.mod.frsm.blocks.pipes;

import net.fexcraft.mod.frsm.util.block.FTESR;

public class Pipe1Render extends FTESR{
	
	public ModelStovePipe1 model;
	
	public Pipe1Render() {
		this.model = new ModelStovePipe1();
	}
	
	public void ModelRender(){
		this.model.render();
	}
    
	public String getTexturePath(){
		return "frsm:textures/blocks/StovePipe1.png";
	}
	
	@Override
	public int adjustAngleBy(){
		return 90;
	}
}