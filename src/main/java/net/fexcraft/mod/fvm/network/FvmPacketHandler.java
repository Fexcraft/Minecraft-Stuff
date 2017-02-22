package net.fexcraft.mod.fvm.network;

import net.fexcraft.mod.fvm.util.FvmResources;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class FvmPacketHandler {
	
	private static final SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel(FvmResources.MODID);
	private static final int id = -1;
	
	public static SimpleNetworkWrapper getInstance(){
		return instance;
	}
	
	public static void initialize(){
		//instance.registerMessage(ExamplePacketHandler.class, Packet.class, id++, Side.SERVER);
	}
	
}