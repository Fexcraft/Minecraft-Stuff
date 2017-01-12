package net.fexcraft.mod.frsm.blocks.cup;

import net.fexcraft.mod.frsm.util.block.FTESR;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class Year1Render extends FTESR {
	
	private static final Year1Model model = new Year1Model();
	
	@Override
	public int adjustAngle(){
		return 90;
	}

	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/year1.png");
	}

	@Override
	public void renderModel(TileEntity tileentity, float partialticks, int destroystage){
		this.model.render();
	}
	
}