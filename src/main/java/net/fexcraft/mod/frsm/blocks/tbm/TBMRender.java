package net.fexcraft.mod.frsm.blocks.tbm;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TBMRender extends FTESR_4R {
       
	private static final ModelRS1 model = new ModelRS1();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return new ResourceLocation("frsm:textures/blocks/RS1.png");
	}

	@Override
	public void renderModel(TileEntity tileentity, float partialticks, int destroystage){
		GL11.glRotated( 180, 0F, 1F, 0F);
		GL11.glTranslatef(-0.5F, 1.5F, -0.5F);
		this.model.render();
		GL11.glRotated(-180, 0F, 1F, 0F);
		GL11.glTranslatef(-0.95F, -0.58F, -0.58F);
		byte b0 = 0;
		GlStateManager.scale(0.02F, 0.02F, 0.02F);
		GL11.glTranslatef(-0.5F, 0.0F, -1.0F);
		FontRenderer fontrenderer = this.getFontRenderer();
		String s = "TEST v.2";
		s = s.substring(0, 9);
		fontrenderer.drawString(s, 0.0F, 0.0F, b0, false);
		
		//fontrenderer.drawString("TEST", 0F, 0F, b0, true);
	}
	
}