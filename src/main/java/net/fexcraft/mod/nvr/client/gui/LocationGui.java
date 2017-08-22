package net.fexcraft.mod.nvr.client.gui;

import net.fexcraft.mod.lib.api.network.IPacketListener;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.lib.util.render.ExternalTextureHelper;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LocationGui extends GuiScreen {
	
	public LocationGui(){
		mc = Minecraft.getMinecraft();
	}
	
	private static long till;
	private static String up = "null > UP", down = "null < DOWN";
	private static final ResourceLocation texture = new ResourceLocation("nvr:textures/guis/location_gui.png");
	private static ResourceLocation[] icon = new ResourceLocation[3];
	private static int[] x = new int[]{96, 64, 32}, y = new int[]{224, 224, 224};
	
	@SubscribeEvent
	public void displayLocationUpdate(RenderGameOverlayEvent event){
		if(event.getType() == ElementType.HOTBAR && till < Time.getDate()){
			mc.getTextureManager().bindTexture(texture);
			this.drawTexturedModalRect(0, 0, 0, 0, 256, 36);
			//
			if(icon[0] == null){
				this.drawTexturedModalRect(22, 2, x[0], y[0], 32, 32);
			}
			else{
				mc.getTextureManager().bindTexture(icon[0]);
				this.drawTexturedModalRect(22, 2, 0, 0, 32, 32);
			}
			//
			if(icon[1] == null){
				this.drawTexturedModalRect(6, 18, x[1], y[1], 16, 16);
			}
			else{
				mc.getTextureManager().bindTexture(icon[1]);
				this.drawTexturedModalRect(6, 16, 0, 0, 16, 16);
			}
			if(icon[2] == null){
				this.drawTexturedModalRect(6, 2, x[2], y[2], 16, 16);
			}
			else{
				mc.getTextureManager().bindTexture(icon[2]);
				this.drawTexturedModalRect(6, 2, 0, 0, 16, 16);
			}
			mc.fontRenderer.drawString(up  , 57, 7, MapColor.GRAY.colorValue);
			mc.fontRenderer.drawString(down, 57, 21, MapColor.GRAY.colorValue);
		}
	}
	
	public static class LGReceiver implements IPacketListener<PacketNBTTagCompound>{

		@Override
		public String getId(){
			return "nvr-lg";
		}

		@Override
		public void process(PacketNBTTagCompound packet, Object[] objs){
			if(!packet.nbt.hasKey("task")){
				return;
			}
			switch(packet.nbt.getString("task")){
				case "show":{
					int t = packet.nbt.hasKey("time") ? packet.nbt.getInteger("time") : 5;
					till = Time.getDate() + (t * 1000);
					//
					up = packet.nbt.hasKey("up") ? packet.nbt.getString("up") : "null";
					down = packet.nbt.hasKey("down") ? packet.nbt.getString("down") : "null";
					for(int i = 0; i < 3; i++){
						icon[i] = packet.nbt.hasKey("icon_" + i) ? ExternalTextureHelper.get(packet.nbt.getString("icon_" + i)) : null;
						x[i] = packet.nbt.hasKey("x_" + i) ? packet.nbt.getInteger("x_" + i) : 0;
						y[i] = packet.nbt.hasKey("y_"+ i) ? packet.nbt.getInteger("y_" + i) : 0;
						if(packet.nbt.hasKey("color_" + i)){
							switch(packet.nbt.getString("color_" + i)){
								case "green":{
									x[i] =  0; y[i] = 224;
									break;
								}
								case "yellow":{
									x[i] = 32; y[i] = 224;
									break;
								}
								case "red":{
									x[i] = 64; y[i] = 224;
									break;
								}
								case "blue":{
									x[i] = 96; y[i] = 224;
									break;
								}
							}
						}
					}
					break;
				}
			}
		}
		
	}
	
}