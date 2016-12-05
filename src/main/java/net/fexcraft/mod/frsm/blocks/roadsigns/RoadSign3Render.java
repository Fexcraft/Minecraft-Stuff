package net.fexcraft.mod.frsm.blocks.roadsigns;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class RoadSign3Render extends FTESR_4R {
	
	public ModelRoadSign3 model;
	
	public RoadSign3Render() {
		this.model = new ModelRoadSign3();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/RoadSign3.png";
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