package net.fexcraft.mod.frsm.blocks.pipes;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class Pipe1eRender extends FTESR_4R{
	
	public ModelStovePipe1e model;
	
	public Pipe1eRender() {
		this.model = new ModelStovePipe1e();
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