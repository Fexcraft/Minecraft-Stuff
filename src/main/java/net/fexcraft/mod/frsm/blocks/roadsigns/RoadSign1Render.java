package net.fexcraft.mod.frsm.blocks.roadsigns;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class RoadSign1Render extends FTESR_4R {
	
	public ModelRoadSign1 model;
	
	public RoadSign1Render() {
		this.model = new ModelRoadSign1();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/RoadSign1.png";
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