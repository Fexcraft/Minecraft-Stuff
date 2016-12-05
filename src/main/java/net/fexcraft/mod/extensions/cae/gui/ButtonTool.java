package net.fexcraft.mod.extensions.cae.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class ButtonTool extends GuiButton{
	
	private static ResourceLocation texture = new ResourceLocation("frsm_asphalt:textures/gui/cae_buttons.png");
	
	private int ix, iy;
	
	public ButtonTool(int buttonID, int x, int y, int ix, int iy){
		super(buttonID, x, y, 24, 24, "");
		this.ix = ix;
		this.iy = iy;
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY){
		if(this.visible){
			mc.getTextureManager().bindTexture(texture);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			if(this.enabled){
				if(!this.hovered){
					this.drawTexturedModalRect(this.xPosition, this.yPosition, ix, iy, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, ix, iy + 24, this.width, this.height);
				}
			}
			else{
				this.drawTexturedModalRect(this.xPosition, this.yPosition, ix, iy + 48, this.width, this.height);
			}
		}
	}
}