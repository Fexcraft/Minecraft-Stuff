package net.fexcraft.mod.extensions.fve.util;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.tmt.ModelConverter;

/**
 * @author Ferdinand
 * @comment FVE Renderer
 */
public class FVER extends FTESR_4R {
	
	public ModelConverter model;
	
	public FVER(String texture, ModelConverter model) {
		this.model = model;
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