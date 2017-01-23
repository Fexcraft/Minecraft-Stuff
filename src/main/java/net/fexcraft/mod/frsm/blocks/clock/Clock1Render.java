package net.fexcraft.mod.frsm.blocks.clock;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.öTESR;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

@öTESR(tileentity = Clock1.TE.class)
public class Clock1Render extends FTESR_4R {
	
	private static final ModelClock1 model = new ModelClock1();
	
	@Override
	public int adjustAngle(){
		return 90;
	}

	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/clock1.png");
	}

	@Override
	public void renderModel(TileEntity tileentity, float partialticks, int destroystage){
		this.model.render(this.model.bodyModel);
		((Clock1.TE)tileentity).getColor().glColorApply();
		this.model.render(this.model.bodyDoorOpenModel);
		RGB.glColorReset();
		GL11.glTranslatef(0F, 1F, 0F);
		GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
		//
		int h = Time.getHour12();
		int m = Time.getMinute();
		int s = Time.getSecond();
		//
		int a = 0;
		if(m == 0){
			a = 0;
		}
		else{
			a = Math.round(m / 2);
		}
		GL11.glRotatef((h * -30) - a, 1.0F, 0.0F, 0.0F);
		this.model.render(this.model.trailerModel);
		GL11.glRotatef((h * +30) + a, 1.0F, 0.0F, 0.0F);
		//
		GL11.glRotatef(m * -6, 1.0F, 0.0F, 0.0F);
		this.model.render(this.model.steeringWheelModel);
		GL11.glRotatef(m * +6, 1.0F, 0.0F, 0.0F);
		//
		GL11.glRotatef(s * -6, 1.0F, 0.0F, 0.0F);
		this.model.render(this.model.turretModel);
		GL11.glRotatef(s * +6, 1.0F, 0.0F, 0.0F);
		//
	}
	
}