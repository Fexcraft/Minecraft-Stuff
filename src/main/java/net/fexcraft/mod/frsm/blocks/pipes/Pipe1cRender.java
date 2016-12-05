package net.fexcraft.mod.frsm.blocks.pipes;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class Pipe1cRender extends FTESR_4R{
	
	public ModelStovePipe1c model;
	
	public Pipe1cRender() {
		this.model = new ModelStovePipe1c();
	}
	
	public void ModelRender(){
		this.model.render();
	}
    
	public String getTexturePath(){
		return "frsm:textures/blocks/StovePipe1.png";
	}
	
	@Override
	public int adjustAngleBy(){
		return 0;
	}
}