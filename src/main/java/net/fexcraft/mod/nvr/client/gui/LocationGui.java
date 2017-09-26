package net.fexcraft.mod.nvr.client.gui;

import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LocationGui extends GuiScreen {
	
	public LocationGui(){
		mc = Minecraft.getMinecraft();
	}
	
	public static long till = Time.getDate();
	public static String up = "null > UP", down = "null < DOWN";
	public static final ResourceLocation texture = new ResourceLocation("nvr:textures/guis/location_gui.png");
	public static ResourceLocation[] icon = new ResourceLocation[3];
	public static int[] x = new int[]{96, 64, 32}, y = new int[]{224, 224, 224};
	
	@SubscribeEvent
	public void displayLocationUpdate(RenderGameOverlayEvent event){
		if(event.getType() == ElementType.HOTBAR && till >= Time.getDate()){
			mc.getTextureManager().bindTexture(texture);
			this.drawTexturedModalRect(0, 0, 0, 0, 256, 38);
			//
			if(icon[0] == null){
				this.drawTexturedModalRect(22, 3, x[0], y[0], 32, 32);
			}
			else{
				int x = 22, y = 3, width = 32, height = 32;
				mc.getTextureManager().bindTexture(icon[0]);
				Tessellator tessellator = Tessellator.getInstance();
		        BufferBuilder bufferbuilder = tessellator.getBuffer();
		        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
		        bufferbuilder.pos((double)(x + 0), (double)(y + height), (double)this.zLevel).tex(0, 1).endVertex();
		        bufferbuilder.pos((double)(x + width), (double)(y + height), (double)this.zLevel).tex(1, 1).endVertex();
		        bufferbuilder.pos((double)(x + width), (double)(y + 0), (double)this.zLevel).tex(1, 0).endVertex();
		        bufferbuilder.pos((double)(x + 0), (double)(y + 0), (double)this.zLevel).tex(0, 0).endVertex();
		        tessellator.draw();
			}
			//
			if(icon[1] == null){
				this.drawTexturedModalRect(6, 18, x[1], y[1], 16, 16);
			}
			else{
				int x = 6, y = 19, width = 16, height = 16;
				mc.getTextureManager().bindTexture(icon[1]);
				Tessellator tessellator = Tessellator.getInstance();
		        BufferBuilder bufferbuilder = tessellator.getBuffer();
		        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
		        bufferbuilder.pos((double)(x + 0), (double)(y + height), (double)this.zLevel).tex(0, 1).endVertex();
		        bufferbuilder.pos((double)(x + width), (double)(y + height), (double)this.zLevel).tex(1, 1).endVertex();
		        bufferbuilder.pos((double)(x + width), (double)(y + 0), (double)this.zLevel).tex(1, 0).endVertex();
		        bufferbuilder.pos((double)(x + 0), (double)(y + 0), (double)this.zLevel).tex(0, 0).endVertex();
		        tessellator.draw();
			}
			if(icon[2] == null){
				this.drawTexturedModalRect(6, 2, x[2], y[2], 16, 16);
			}
			else{
				int x = 6, y = 3, width = 16, height = 16;
				mc.getTextureManager().bindTexture(icon[2]);
				Tessellator tessellator = Tessellator.getInstance();
		        BufferBuilder bufferbuilder = tessellator.getBuffer();
		        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
		        bufferbuilder.pos((double)(x + 0), (double)(y + height), (double)this.zLevel).tex(0, 1).endVertex();
		        bufferbuilder.pos((double)(x + width), (double)(y + height), (double)this.zLevel).tex(1, 1).endVertex();
		        bufferbuilder.pos((double)(x + width), (double)(y + 0), (double)this.zLevel).tex(1, 0).endVertex();
		        bufferbuilder.pos((double)(x + 0), (double)(y + 0), (double)this.zLevel).tex(0, 0).endVertex();
		        tessellator.draw();
			}
			mc.fontRenderer.drawString(up  , 59, 8, MapColor.GRAY.colorValue);
			mc.fontRenderer.drawString(down, 59, 22, MapColor.GRAY.colorValue);
		}
	}
	
}