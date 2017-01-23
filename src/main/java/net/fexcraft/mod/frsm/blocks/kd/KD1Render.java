package net.fexcraft.mod.frsm.blocks.kd;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.öTESR;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

@öTESR(tileentity = KD1Entity.class)
public class KD1Render extends FTESR_4R {
	
	private static final KD1Model model = new KD1Model();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/KD1.png");
	}

	@Override
	public void renderModel(TileEntity tileentity, float partialticks, int destroystage){
		this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
	
}