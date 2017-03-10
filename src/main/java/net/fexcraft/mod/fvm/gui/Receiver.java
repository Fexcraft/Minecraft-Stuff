package net.fexcraft.mod.fvm.gui;
import java.util.UUID;

import net.fexcraft.mod.fvm.FVM;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketListener;
import net.fexcraft.mod.lib.network.packet.PacketJsonObject;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.entity.player.EntityPlayerMP;

public class Receiver implements IPacketListener {

	@Override
	public String getId(){
		return "fvm_gui";
	}

	@Override
	public void process(IPacket packet, Object[] objs){
		PacketJsonObject pkt = (PacketJsonObject)packet;
		if(pkt.obj.has("uuid")){
			UUID uuid = UUID.fromString(pkt.obj.get("uuid").getAsString());
			EntityPlayerMP player = Static.getServer().getPlayerList().getPlayerByUUID(uuid);
			String s = pkt.obj.get("target").getAsString();
			switch(s){
				case "inventory":
					player.openGui(FVM.INSTANCE, 3556, player.world, 0, 0, 0);
					break;
			}
		}
		else{
			Print.debug("Broken GUI Packet!");
		}
	}
	
}