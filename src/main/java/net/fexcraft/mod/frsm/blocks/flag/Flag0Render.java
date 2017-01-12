package net.fexcraft.mod.frsm.blocks.flag;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class Flag0Render extends FTESR_4R {
	
	private static final FlagModel model = new FlagModel();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/flag0.png");
	}

	@Override
	public void renderModel(TileEntity tileentity, float partialticks, int destroystage){
		this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
	
}