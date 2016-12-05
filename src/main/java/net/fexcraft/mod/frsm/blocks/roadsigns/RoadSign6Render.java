package net.fexcraft.mod.frsm.blocks.roadsigns;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class RoadSign6Render extends FTESR_4R {
	
	public ModelRoadSign6 model;
	
	public RoadSign6Render() {
		this.model = new ModelRoadSign6();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/RoadSign6.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render();
	}
	
	@Override
	public int adjustAngleBy(){
		return 0;
	}
}