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
	private static ResourceLocation icon;
	private static int x = 96, y = 224;
	
	@SubscribeEvent
	public void addDebugInfo(RenderGameOverlayEvent event){
		if(event.getType() == ElementType.HOTBAR && till < Time.getDate()){
			mc.getTextureManager().bindTexture(texture);
			this.drawTexturedModalRect(0, 0, 0, 0, 256, 36);
			if(icon == null){
				this.drawTexturedModalRect(6, 2, x, y, 32, 32);
			}
			else{
				mc.getTextureManager().bindTexture(icon);
				this.drawTexturedModalRect(6, 2, 0, 0, 32, 32);
			}
			mc.fontRenderer.drawString(up  , 41, 7, MapColor.GRAY.colorValue);
			mc.fontRenderer.drawString(down, 41, 21, MapColor.GRAY.colorValue);
		}
	}
	
	public static class LGReceiver implements IPacketListener<PacketNBTTagCompound>{

		@Override
		public String getId(){
			return "nvr_lg";
		}

		@Override
		public void process(PacketNBTTagCompound packet, Object[] objs){
			if(!packet.nbt.hasKey("task")){
				return;
			}
			switch(packet.nbt.getString("task")){
				case "show":{
					int i = packet.nbt.hasKey("time") ? packet.nbt.getInteger("time") : 5;
					till = Time.getDate() + (i * 1000);
					//
					icon = packet.nbt.hasKey("icon") ? ExternalTextureHelper.get(packet.nbt.getString("icon")) : null;
					x = packet.nbt.hasKey("x") ? packet.nbt.getInteger("x") : 0;
					y = packet.nbt.hasKey("y") ? packet.nbt.getInteger("y") : 0;
					up = packet.nbt.hasKey("up") ? packet.nbt.getString("up") : "null";
					down = packet.nbt.hasKey("down") ? packet.nbt.getString("down") : "null";
					if(packet.nbt.hasKey("color")){
						switch(packet.nbt.getString("color")){
							case "green":{
								x =  0; y = 224;
								break;
							}
							case "yellow":{
								x = 32; y = 224;
								break;
							}
							case "red":{
								x = 64; y = 224;
								break;
							}
							case "blue":{
								x = 96; y = 224;
								break;
							}
						}
					}
					break;
				}
			}
		}
		
	}
	
}