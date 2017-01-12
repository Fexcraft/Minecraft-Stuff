package net.fexcraft.mod.frsm.blocks.shelf;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.util.cls.EnumColor;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class Shelf1Renderer extends FTESR_4R{
	
	private static final Shelf1Model model = new Shelf1Model();
	
	@Override
	public ResourceLocation getResourceLocation(){
		return getFromColor(EnumColor.BLACK);
	}
	
	private static ResourceLocation getFromColor(EnumColor color){
		return new ResourceLocation("frsm:textures/blocks/shelf1_" + color.toInt() + ".png");
	}

	@Override
	public void renderModel(TileEntity tileentity, float partialticks, int destroystage){
		boolean open = ((Shelf1Entity)tileentity).getState();
		EnumColor color = ((Shelf1Entity)tileentity).getColor();
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