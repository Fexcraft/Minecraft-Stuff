package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class StreetLamp1eRender extends FTESR_4R{
	
	private static final ModelStreetLamp1e model = new ModelStreetLamp1e();
	
	@Override
	public int adjustAngle(){
		return 90;
	}

	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/StreetLamp1e.png");
	}

	@Override
	public void renderModel(TileEntity tileentity, float partialticks, int destroystage){
		this.model.render();
	}
	
}