package net.fexcraft.mod.nvr.client.util;

import net.fexcraft.mod.lib.api.network.IPacketListener;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.lib.util.render.ExternalTextureHelper;
import net.fexcraft.mod.nvr.client.gui.ChunkViewGui;
import net.fexcraft.mod.nvr.client.gui.LocationGui;
import net.minecraft.entity.player.EntityPlayer;

public class Receiver implements IPacketListener<PacketNBTTagCompound>{

	@Override
	public String getId(){
		return "nvr-cl";
	}
	
	@Override
	public void process(PacketNBTTagCompound packet, Object[] objs){
		if(!packet.nbt.hasKey("task")){
			return;
		}
		EntityPlayer player = (EntityPlayer)objs[0];
		switch(packet.nbt.getString("task")){
			case "show":{
				int t = packet.nbt.hasKey("time") ? packet.nbt.getInteger("time") : 5;
				LocationGui.till = Time.getDate() + (t * 1000);
				//
				LocationGui.up = packet.nbt.hasKey("up") ? packet.nbt.getString("up") : "null";
				LocationGui.down = packet.nbt.hasKey("down") ? packet.nbt.getString("down") : "null";
				for(int i = 0; i < 3; i++){
					LocationGui.icon[i] = packet.nbt.hasKey("icon_" + i) ? ExternalTextureHelper.get(packet.nbt.getString("icon_" + i)) : null;
					LocationGui.x[i] = packet.nbt.hasKey("x_" + i) ? packet.nbt.getInteger("x_" + i) : 0;
					LocationGui.y[i] = packet.nbt.hasKey("y_"+ i) ? packet.nbt.getInteger("y_" + i) : 0;
					if(packet.nbt.hasKey("color_" + i)){
						switch(packet.nbt.getString("color_" + i)){
							case "green":{
								LocationGui.x[i] =  0; LocationGui.y[i] = 224;
								break;
							}
							case "yellow":{
								LocationGui.x[i] = 32; LocationGui.y[i] = 224;
								break;
							}
							case "red":{
								LocationGui.x[i] = 64; LocationGui.y[i] = 224;
								break;
							}
							case "blue":{
								LocationGui.x[i] = 96; LocationGui.y[i] = 224;
								break;
							}
						}
					}
				}
				break;
			}
			case "ckv":{
				ChunkViewGui.load(packet.nbt, (EntityPlayer)objs[1]);
			}
		}
	}
	
}