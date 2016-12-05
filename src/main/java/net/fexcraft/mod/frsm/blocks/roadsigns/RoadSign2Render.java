package net.fexcraft.mod.frsm.blocks.roadsigns;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class RoadSign2Render extends FTESR_4R {
	
	public ModelRoadSign2 model;
	
	public RoadSign2Render() {
		this.model = new ModelRoadSign2();
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