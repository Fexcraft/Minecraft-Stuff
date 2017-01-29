package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

@fTESR(tileentity = StreetLampBaseEntity.class)
public class StreetLampBaseRender extends FTESR_4R {
	
	private static final ModelStreetLampBase model = new ModelStreetLampBase();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("minecraft:textures/blocks/anvil_base.png");
	}

	@Override
	public void renderModel(TileEntity tileentity, float partialticks, int destroystage){
		model.render();
	}
	
}