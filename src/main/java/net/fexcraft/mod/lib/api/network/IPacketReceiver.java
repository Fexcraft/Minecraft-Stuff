package net.fexcraft.mod.lib.api.network;

public interface IPacketReceiver{
	
	public void processServerPacket(IPacket pkt);
	
	public void processClientPacket(IPacket pkt);
	
}