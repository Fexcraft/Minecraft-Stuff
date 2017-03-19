package net.fexcraft.mod.fvm.network;

import net.fexcraft.mod.fvm.network.packets.ScriptNBTPacket;
import net.fexcraft.mod.fvm.network.packets.ScriptNBTPacketHandler;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class FvmPacketHandler {
	
	private static final SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel(FvmResources.MODID);
	private static int id = -1;
	
	public static SimpleNetworkWrapper getInstance(){
		return instance;
	}
	
	public static void initialize(){
		//instance.registerMessage(ExamplePacketHandler.class, Packet.class, id++, Side.SERVER);
		instance.registerMessage(ScriptNBTPacketHandler.Client.class, ScriptNBTPacket.class, id++, Side.CLIENT);
		instance.registerMessage(ScriptNBTPacketHandler.Server.class, ScriptNBTPacket.class, id++, Side.SERVER);
	}
	
}