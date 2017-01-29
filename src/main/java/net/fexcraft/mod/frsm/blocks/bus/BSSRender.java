package net.fexcraft.mod.frsm.blocks.bus;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

@fTESR(tileentity = BSSEntity.class)
public class BSSRender extends FTESR_4R {
       
	private static final BusStop model = new BusStop();
		
	@Override
	public void renderModel(TileEntity tileentity, float partialticks, int destroystage){
		this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}

	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/busstop_0.png");
	}
	
}