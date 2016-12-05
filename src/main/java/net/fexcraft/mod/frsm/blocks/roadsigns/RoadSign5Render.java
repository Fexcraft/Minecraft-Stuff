package net.fexcraft.mod.frsm.blocks.roadsigns;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class RoadSign5Render extends FTESR_4R {
	
	public ModelRoadSign5 model;
	
	public RoadSign5Render() {
		this.model = new ModelRoadSign5();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/RoadSign5.png";
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