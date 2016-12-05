package net.fexcraft.mod.frsm.blocks.roadsigns;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class RoadSign4Render extends FTESR_4R {
	
	public ModelRoadSign4 model;
	
	public RoadSign4Render() {
		this.model = new ModelRoadSign4();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/RoadSign4.png";
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