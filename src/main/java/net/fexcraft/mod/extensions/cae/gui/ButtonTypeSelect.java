package net.fexcraft.mod.extensions.cae.gui;

import net.fexcraft.mod.extensions.cae.util.Type;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class ButtonTypeSelect extends GuiButton{
	
	private static ResourceLocation texture = new ResourceLocation("frsm_asphalt:textures/gui/cae_buttons.png");
	
	private Type type;
	
	public ButtonTypeSelect(int buttonID, int x, int y, Type type){
		super(buttonID, x, y, 31, 9, "");
		this.type = type;
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY){
		if(this.visible){
			int ytp = getYpos();
			mc.getTextureManager().bindTexture(texture);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			if(this.enabled){
				if(!this.hovered){
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 101, ytp, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 132, ytp, this.width, this.height);
				}
			}
			else{
				this.drawTexturedModalRect(this.xPosition, this.yPosition, 163, ytp, this.width, this.height);
			}
		}
	}
	
	private int getYpos(){
		switch(type){
			case x2:  return 0;
			case x4:  return 9;
			case x8:  return 18;
			case x16: return 27;
			case x32: return 36;
			case x64: return 45;
			default:  return 27;
		}
	}
}