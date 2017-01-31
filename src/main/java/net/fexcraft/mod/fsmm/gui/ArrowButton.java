package net.fexcraft.mod.fsmm.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class ArrowButton extends GuiButton {
	
	private static ResourceLocation texture = new ResourceLocation("fsmm:textures/gui/GuiATM.png");
	private EnumSide type;
	
	public ArrowButton(int buttonID, int x, int y, EnumSide type){
		super(buttonID, x, y, 10, 15, "");
		this.type = type;
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY){
		if(this.visible){
			int ytp = type.getPosition();
			mc.getTextureManager().bindTexture(texture);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			if(this.enabled){
				if(!this.hovered){
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 178, ytp, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 190, ytp, this.width, this.height);
				}
			}
			else{
				this.drawTexturedModalRect(this.xPosition, this.yPosition, 202, ytp, this.width, this.height);
			}
		}
	}
	
	public static enum EnumSide{
		RIGHT(2, "right"), LEFT(21, "left");

		public int pos;
		public String id;
		
		private EnumSide(int pos, String id){
			this.pos = pos;
			this.id = id;
		}
		
		public int getPosition(){
			return pos;
		}
		
		public String getId(){
			return id;
		}
	}
}