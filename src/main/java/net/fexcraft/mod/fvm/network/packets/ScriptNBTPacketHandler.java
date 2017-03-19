package net.fexcraft.mod.fvm.network.packets;

import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class ScriptNBTPacketHandler {
	
	public static class Client implements IMessageHandler<ScriptNBTPacket, IMessage>{
		@Override
		public IMessage onMessage(final ScriptNBTPacket packet, final MessageContext ctx) {
			IThreadListener ls = Minecraft.getMinecraft();
			ls.addScheduledTask(new Runnable(){
				@Override
				public void run(){
					EntityPlayer player = Minecraft.getMinecraft().player;
					if(player == null || player.world == null){
						return;
					}
					com.flansmod.fvm.LandVehicle vehicle = null;
					for(Entity obj : player.world.loadedEntityList){
						if(obj instanceof com.flansmod.fvm.LandVehicle && ((Entity)obj).getEntityId() == packet.entityId){
							vehicle = (com.flansmod.fvm.LandVehicle)obj;
							break;
						}
					}
					if(vehicle != null){
						vehicle.data.scripts.onPacket(vehicle, packet.nbt, Side.CLIENT);
					}
				}
			});
			return null;
		}
	}
	
	public static class Server implements IMessageHandler<ScriptNBTPacket, IMessage>{
		@Override
		public IMessage onMessage(final ScriptNBTPacket packet, final MessageContext ctx) {
			IThreadListener ls = Static.getServer();
			ls.addScheduledTask(new Runnable(){
				@Override
				public void run(){
					EntityPlayerMP player = Static.getServer().getPlayerList().getPlayerByUsername(ctx.getServerHandler().playerEntity.getName());
					com.flansmod.fvm.LandVehicle vehicle = null;
					for(int i = 0; i < player.world.loadedEntityList.size(); i++){
						Entity obj = player.world.loadedEntityList.get(i);
						if(obj instanceof com.flansmod.fvm.LandVehicle && obj.getEntityId() == packet.entityId){
							vehicle = (com.flansmod.fvm.LandVehicle)obj;
							break;
						}
					}
					if(vehicle != null){
						vehicle.data.scripts.onPacket(vehicle, packet.nbt, Side.SERVER);
					}
				}
			});
			return null;
		}
	}
	
}