package net.fexcraft.mod.frsm.blocks.pipes;

import net.fexcraft.mod.frsm.util.block.FTESR;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class Pipe1Render extends FTESR{
	
	private static final ModelStovePipe1 model = new ModelStovePipe1();
	
	@Override
	public int adjustAngle(){
		return 90;
	}

	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/StovePipe1.png");
	}

	@Override
	public void renderModel(TileEntity tileentity, float partialticks, int destroystage){
		this.model.render();
	}
	
}