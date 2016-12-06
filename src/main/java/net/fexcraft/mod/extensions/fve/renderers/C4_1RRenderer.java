package net.fexcraft.mod.extensions.fve.renderers;

import net.fexcraft.mod.extensions.fve.models.ModelC4_1L;
import net.fexcraft.mod.frsm.util.block.FTESR_4R;

public class C4_1RRenderer extends FTESR_4R {
	
	public ModelC4_1L model;
	
	public C4_1RRenderer(String texture) {
		this.model = new ModelC4_1L();
		this.texture = texture;
	}
	
	public String texture;// = "fve:textures/blocks/C4_1.png";
    
	@Override
	public final String getTexturePath(){
		return texture;
	}
	
	@Override
	public void ModelRender(){
		this.model.render();
	}
}