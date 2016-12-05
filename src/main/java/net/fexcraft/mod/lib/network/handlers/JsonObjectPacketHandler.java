package net.fexcraft.mod.lib.network.handlers;

import java.util.HashSet;

import net.fexcraft.mod.lib.api.network.IPacketListener;
import net.fexcraft.mod.lib.network.packet.PacketJsonObject;
import net.fexcraft.mod.lib.util.cls.Print;
import net.minecraft.client.Minecraft;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class JsonObjectPacketHandler{
	
	private static HashSet<IPacketListener> sls = new HashSet<IPacketListener>();
	private static HashSet<IPacketListener> cls = new HashSet<IPacketListener>();
	
	public static class Server implements IMessageHandler<PacketJsonObject, IMessage> {
		@Override
		public IMessage onMessage(final PacketJsonObject packet, final MessageContext ctx) {
			IThreadListener ls = FMLCommonHandler.instance().getMinecraftServerInstance();
			ls.addScheduledTask(new Runnable(){
				@Override
				public void run(){
					if(!packet.obj.has("target_listener")){
						Print.log("[FCL] Received JSON Packet, but had no target listener, ignoring!");
						return;
					}
					String target = packet.obj.get("target_listener").getAsString();
					for(IPacketListener pktls : sls){
						if(pktls.getId().equals(target)){
							pktls.process(packet, null);
						}
					}
				}
			});
			return null;
		}
	}
	
	public static class Client implements IMessageHandler<PacketJsonObject, IMessage> {
		@Override
		public IMessage onMessage(final PacketJsonObject packet, final MessageContext ctx) {
			IThreadListener ls = Minecraft.getMinecraft();
			ls.addScheduledTask(new Runnable(){
				@Override
				public void run(){
					if(!packet.obj.has("target_listener")){
						Print.log("[FCL] Received JSON Packet, but had no target listener, ignoring!");
						return;
					}
					String target = packet.obj.get("target_listener").getAsString();
					for(IPacketListener pktls : cls){
						if(pktls.getId().equals(target)){
							pktls.process(packet, null);
						}
					}
				}
			});
			return null;
		}
	}
	
	public static void addListener(Side side, IPacketListener listener) {
		if(side.isClient()){
			cls.add(listener);
		}
		else{
			sls.add(listener);
		}
	}
	
}