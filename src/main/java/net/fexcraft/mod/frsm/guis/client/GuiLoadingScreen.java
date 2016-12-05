package net.fexcraft.mod.frsm.guis.client;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class GuiLoadingScreen extends GuiScreen{
	
	private static ResourceLocation bg = new ResourceLocation("frsm:textures/gui/frsm_loading.png");
	
	public GuiLoadingScreen(){}
	
	@Override
    public void drawScreen(int mx, int my, float renderPartialTicks){
		this.drawDefaultBackground();
        this.mc.getTextureManager().bindTexture(bg);
        this.drawTexturedModalRect((this.width - 74) / 2, (this.height - 30) / 2, 0, 0, 74, 30);
    }
	
	@Override
    public boolean doesGuiPauseGame(){
        return false;
    }
}