package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.frsm.util.block.FTESR;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class StreetLamp1Render extends FTESR{
	
	private static final ModelStreetLamp1 model = new ModelStreetLamp1();
	
	@Override
	public int adjustAngle(){
		return 90;
	}

	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/StreetLamp1.png");
	}

	@Override
	public void renderModel(TileEntity tileentity, float partialticks, int destroystage){
		this.model.render();
	}
	
}