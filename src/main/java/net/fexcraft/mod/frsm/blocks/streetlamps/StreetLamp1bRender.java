package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.frsm.util.block.FTESR;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class StreetLamp1bRender extends FTESR{
	
	private static final ModelStreetLamp1b model = new ModelStreetLamp1b();
	
	@Override
	public int adjustAngle(){
		return 90;
	}

	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/StreetLamp1b.png");
	}

	@Override
	public void renderModel(TileEntity tileentity, float partialticks, int destroystage){
		this.model.render();
	}
	
}