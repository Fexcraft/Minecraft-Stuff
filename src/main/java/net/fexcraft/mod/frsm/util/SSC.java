package net.fexcraft.mod.frsm.util;

import net.fexcraft.mod.lib.network.PacketHandler;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

/** Static ShortCuts Class*/
public class SSC{
	
	private static PacketHandler packet_handler;
	
	public static SimpleNetworkWrapper getPacketHandler(){
		return PacketHandler.getInstance();
	}
	
	public static MinecraftServer getServer(){
		return FMLCommonHandler.instance().getMinecraftServerInstance().getServer();
	}
}