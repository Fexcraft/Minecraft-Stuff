package net.fexcraft.mod.extensions.cae.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class ButtonSubmit extends GuiButton{
	
	private static ResourceLocation texture = new ResourceLocation("frsm_asphalt:textures/gui/cae_buttons.png");
	
	public ButtonSubmit(int buttonID, int x, int y, String string){
		super(buttonID, x, y, 71, 12, string);
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY){
		if(this.visible){
			mc.getTextureManager().bindTexture(texture);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			if(this.enabled){
				if(!this.hovered){
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 30, 0, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 30, 12, this.width, this.height);
				}
			}
			else{
				this.drawTexturedModalRect(this.xPosition, this.yPosition, 30, 24, this.width, this.height);
			}
			this.drawCenteredString(mc.fontRendererObj, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, 0x99BAC4);
		}
	}
}
	