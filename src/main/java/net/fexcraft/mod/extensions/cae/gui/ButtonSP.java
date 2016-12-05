package net.fexcraft.mod.extensions.cae.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class ButtonSP extends GuiButton{
	
	private static ResourceLocation texture = new ResourceLocation("frsm_asphalt:textures/gui/cae_buttons.png");
	public boolean sp;
	
	public ButtonSP(int buttonID, int x, int y){
		super(buttonID, x, y, getSize(), getSize(), "");
		this.sp = false;
	}
	
	static int getSize(){
		switch(GuiCAE.getType()){
			case x2: return 64;
			case x4: return 32;
			case x8: return 16;
			case x16: return 8;
			case x32: return 4;
			case x64: return 2;
			default:  return 8;
		}
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY){
		if(this.visible){
			mc.getTextureManager().bindTexture(texture);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			if(this.enabled){
				if(!this.hovered){
					if(sp){
						this.drawTexturedModalRect(this.xPosition, this.yPosition, getSize(), get(), this.width, this.height);
					}
					else{
						this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, get(), this.width, this.height);
					}
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, (getSize() * 2), get(), this.width, this.height);
				}
			}
		}
	}
	
	public static int get(){
		switch(GuiCAE.getType()){
			case x16: return 136;
			case x2:  return 192;
			case x32: return 132;
			case x4:  return 160;
			case x64: return 130;
			case x8:  return 144;
			default:  return 136;
		}
	}
	
}