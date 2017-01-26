package net.fexcraft.mod.frsm.blocks.pchardware;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.öTESR;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

@öTESR(tileentity = PCHardware1Entity.class)
public class PCHardware1Render extends FTESR_4R {
	
	private static final ModelPCHardware1 model = new ModelPCHardware1();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/pchardware1.png");
	}

	@Override
	public void renderModel(TileEntity tileentity, float partialticks, int destroystage){
		int i = ((PCHardware1Entity)tileentity).getPosition();
		if(i == 1){
			GL11.glTranslatef(0.375f, 0, 0);
		}
		else if(i == 2){
			GL11.glTranslatef(-0.375f, 0, 0);
		}
		model.render(model.base);
		((PCHardware1Entity)tileentity).getColor().glColorApply();
		model.render(model.r0);
		RGB.glColorReset();
		if(i == 1){
			GL11.glTranslatef(-0.375f, 0, 0);
		}
		else if(i == 2){
			GL11.glTranslatef(0.375f, 0, 0);
		}
	}
	
}