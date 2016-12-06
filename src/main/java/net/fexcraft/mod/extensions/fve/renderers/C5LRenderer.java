package net.fexcraft.mod.extensions.fve.renderers;

import net.fexcraft.mod.extensions.fve.models.ModelC5R;
import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class C5LRenderer extends FTESR_4R {
	
	public ModelC5R model;
	
	public C5LRenderer(String texture) {
		this.model = new ModelC5R();
		this.texture = texture;
	}
	
	public String texture;// = "fve:textures/blocks/C5.png";
    
	@Override
	public final String getTexturePath(){
		return texture;
	}
	
	@Override
	public void ModelRender(){
		this.model.render();
	}
}