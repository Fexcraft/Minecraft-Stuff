package net.fexcraft.mod.extensions.fve.renderers;

import net.fexcraft.mod.extensions.fve.models.ModelC6;
import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class C6RRenderer extends FTESR_4R {
	
	public ModelC6 model;
	
	public C6RRenderer(String texture) {
		this.model = new ModelC6();
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