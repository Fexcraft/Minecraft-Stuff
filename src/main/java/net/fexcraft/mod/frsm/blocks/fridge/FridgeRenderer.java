package net.fexcraft.mod.frsm.blocks.fridge;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.util.ResourceLocation;

@fTESR
public class FridgeRenderer extends FTESR_4R<FridgeTileEntity> {
	
	private static final FridgeModel model = new FridgeModel();
	
	private static final  ResourceLocation texture = new ResourceLocation("frsm:textures/blocks/fridge.png");

	@Override
	public ResourceLocation getResourceLocation(){
		return texture;
	}

	@Override
	public void renderModel(FridgeTileEntity tileentity, float partialticks, int destroystage) {
		boolean open = tileentity.getState();
		RGB color = tileentity.getColor();
		
		this.model.render(this.model.base);
		if(open == true){
			this.model.render(this.model.open);
		}
		if(open == false){
			this.model.render(this.model.closed);
		}
		color.glColorApply();
		this.model.render(this.model.r0);
		if(open == true){
			this.model.render(this.model.r2);
		}
		if(open == false){
			this.model.render(this.model.r1);
		}
		RGB.glColorReset();
	}
	
}