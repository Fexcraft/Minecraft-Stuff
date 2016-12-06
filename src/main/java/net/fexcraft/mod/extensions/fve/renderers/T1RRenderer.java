package net.fexcraft.mod.extensions.fve.renderers;

import net.fexcraft.mod.extensions.fve.models.ModelT1;
import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class T1RRenderer extends FTESR_4R {
	
	public ModelT1 model;
	
	public T1RRenderer(String texture) {
		this.model = new ModelT1();
		this.texture = texture;
	}
	
	public String texture;// = "fve:textures/blocks/T1.png";
    
	@Override
	public final String getTexturePath(){
		return texture;
	}
	
	@Override
	public void ModelRender(){
		this.model.render();
	}
}