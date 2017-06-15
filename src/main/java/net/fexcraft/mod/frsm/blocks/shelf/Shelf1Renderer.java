package net.fexcraft.mod.frsm.blocks.shelf;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.util.common.EnumColor;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

@fTESR
public class Shelf1Renderer extends FTESR_4R<Shelf1Entity> {
	
	private static final Shelf1Model model = new Shelf1Model();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return getFromColor(EnumColor.BLACK);
	}
	
	private static ResourceLocation getFromColor(EnumColor color){
		return new ResourceLocation("frsm:textures/blocks/shelf1_" + color.toInt() + ".png");
	}

	@Override
	public void renderModel(Shelf1Entity tileentity, float partialticks, int destroystage){
		boolean open = tileentity.getState();
		EnumColor color = tileentity.getColor();
		Minecraft.getMinecraft().renderEngine.bindTexture(getFromColor(color));
		this.model.render(this.model.base);
		if(open == true){
			this.model.render(this.model.open);
		}
		if(open == false){
			this.model.render(this.model.closed);
		}
	}
	
}