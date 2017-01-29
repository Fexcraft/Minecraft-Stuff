package net.fexcraft.mod.frsm.blocks.furnace;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

@fTESR(tileentity = Furnace1bEntity.class)
public class Furnace1bRender extends FTESR_4R{
	
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
	public void renderModel(TileEntity tileentity, float partialticks, int destroystage){
		this.model.render();
	}
	
}