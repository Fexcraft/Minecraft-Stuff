package net.fexcraft.mod.frsm.blocks.rail.station;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.entity.Entity;

public class StationRender extends FTESR_4R {
	
	public StationModel model;
	
	public StationRender() {
		this.model = new StationModel();
	}
	
	@Override
	public final String getTexturePath(){
		return "frsm:textures/blocks/station.png";
	}
	
	@Override
	public void ModelRender(){
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}