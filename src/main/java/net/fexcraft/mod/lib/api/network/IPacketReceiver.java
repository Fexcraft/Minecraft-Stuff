package net.fexcraft.mod.lib.api.network;

public interface IPacketReceiver<PACKET extends IPacket>{
	
	public void processServerPacket(PACKET pkt);
	
	public void processClientPacket(PACKET pkt);
	
}