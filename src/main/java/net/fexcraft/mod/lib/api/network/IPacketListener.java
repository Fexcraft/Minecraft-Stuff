package net.fexcraft.mod.lib.api.network;

public interface IPacketListener{
	
	public String getId();
	
	public void process(IPacket packet, Object[] objs);
	
}