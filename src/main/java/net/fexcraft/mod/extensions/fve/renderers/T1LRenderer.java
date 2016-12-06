package net.fexcraft.mod.extensions.fve.renderers;

import net.fexcraft.mod.extensions.fve.models.ModelT1R;
import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class T1LRenderer extends FTESR_4R {
	
	public ModelT1R model;
	
	public T1LRenderer(String texture) {
		this.model = new ModelT1R();
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