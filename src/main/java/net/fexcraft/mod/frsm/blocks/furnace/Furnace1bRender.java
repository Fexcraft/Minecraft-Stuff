package net.fexcraft.mod.frsm.blocks.furnace;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.util.ResourceLocation;

@fTESR
public class Furnace1bRender extends FTESR_4R<Furnace1bEntity> {
	
	private static final ModelFurnace1b model = new ModelFurnace1b();
	
	@Override
	public int adjustAngle(){
		return 90;
	}

	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/furnace1.png");
	}

	@Override
	public void renderModel(Furnace1bEntity tileentity, float partialticks, int destroystage){
		this.model.render();
	}
	
}