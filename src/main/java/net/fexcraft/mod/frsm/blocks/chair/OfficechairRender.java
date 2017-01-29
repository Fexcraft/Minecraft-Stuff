package net.fexcraft.mod.frsm.blocks.chair;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

@fTESR(tileentity = OfficechairEntity.class)
public class OfficechairRender extends FTESR_4R {
	
	private static final OfficechairModel model = new OfficechairModel();

	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/officechair.png");
	}

	@Override
	public void renderModel(TileEntity tileentity, float partialticks, int destroystage){
		model.render(model.base);
		GL11.glRotated(((OfficechairEntity)tileentity).rotation * 10, 0, 1, 0);
		model.render(model.r1);
		((OfficechairEntity)tileentity).primary.glColorApply();
		model.render(model.r0);
		RGB.glColorReset();
	}
	
}