package net.fexcraft.mod.extensions.fve.renderers;

import net.fexcraft.mod.extensions.fve.models.ModelC6R;
import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class C6LRenderer extends FTESR_4R {
	
	public ModelC6R model;
	
	public C6LRenderer(String texture) {
		this.model = new ModelC6R();
		this.texture = texture;
	}
	
	public String texture;// = "fve:textures/blocks/C6.png";
    
	@Override
	public final String getTexturePath(){
		return texture;
	}
	
	@Override
	public void ModelRender(){
		this.model.render();
	}
}