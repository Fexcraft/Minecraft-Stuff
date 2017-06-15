package net.fexcraft.mod.frsm.blocks.furnace;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.util.ResourceLocation;

@fTESR
public class Furnace1Render extends FTESR_4R<Furnace1Entity> {
	
	private static final ModelFurnace1 model = new ModelFurnace1();
	
	@Override
	public int adjustAngle(){
		return 90;
	}

	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/furnace1.png");
	}

	@Override
	public void renderModel(Furnace1Entity tileentity, float partialticks, int destroystage){
		this.model.render();
	}
	
}