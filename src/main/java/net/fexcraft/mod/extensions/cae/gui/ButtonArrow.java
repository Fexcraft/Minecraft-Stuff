package net.fexcraft.mod.extensions.cae.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class ButtonArrow extends GuiButton{
	
	private static ResourceLocation texture = new ResourceLocation("frsm_asphalt:textures/gui/cae_buttons.png");
	private EnumArrowType type;
	
	public ButtonArrow(int buttonID, int x, int y, EnumArrowType type){
		super(buttonID, x, y, 10, 10, "");
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
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, ytp, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.xPosition, this.yPosition, 10, ytp, this.width, this.height);
				}
			}
			else{
				this.drawTexturedModalRect(this.xPosition, this.yPosition, 20, ytp, this.width, this.height);
			}
		}
	}
	
	public static enum EnumArrowType{
		EXIT(0, "exit"), UP(10, "up"), DOWN(20, "down"), RIGHT(30, "right"), LEFT(40, "left"), HELP(50, "help"), SLASH(60, "slash"), BACKSLASH(70, "backslash");

		public int pos;
		public String id;
		
		private EnumArrowType(int pos, String id){
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