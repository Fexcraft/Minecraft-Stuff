package net.fexcraft.mod.frsm.blocks.fridge;

import net.fexcraft.mod.frsm.util.block.FTESR_4R;
import net.fexcraft.mod.lib.util.cls.EnumColor;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class FridgeRenderer extends FTESR_4R{
	
	private static final FridgeModel model = new FridgeModel();
	
	private static final  ResourceLocation texture = new ResourceLocation("frsm:textures/blocks/fridge.png");
	private static final  ResourceLocation texture_black = new ResourceLocation("frsm:textures/blocks/fridge_black.png");
	private static final  ResourceLocation texture_gray = new ResourceLocation("frsm:textures/blocks/fridge_gray.png");
	private static final  ResourceLocation texture_blue = new ResourceLocation("frsm:textures/blocks/fridge_blue.png");
	private static final  ResourceLocation texture_red = new ResourceLocation("frsm:textures/blocks/fridge_red.png");
	private static final  ResourceLocation texture_green = new ResourceLocation("frsm:textures/blocks/fridge_green.png");

	@Override
	public ResourceLocation getResourceLocation(){
		return texture;
	}

	@Override
	public void renderModel(TileEntity tileentity, float partialticks, int destroystage) {
		boolean open = ((FridgeTileEntity)tileentity).getState();
		EnumColor color = ((FridgeTileEntity)tileentity).getColor();
		ResourceLocation textures = null;
		switch(color){
			case BLACK:
				textures = texture_black;
				break;
			case BLUE:
				textures = texture_blue;
				break;
			case GRAY:
				textures = texture_gray;
				break;
			case GREEN:
				textures = texture_green;
				break;
			case RED:
				textures = texture_red;
				break;
			case WHITE:
				textures = texture;
				break;
			default:
				break;
		}
		Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		
		this.model.render(this.model.base);
		if(open == true){
			this.model.render(this.model.open);
		}
		if(open == false){
			this.model.render(this.model.closed);
		}
	}
	
}