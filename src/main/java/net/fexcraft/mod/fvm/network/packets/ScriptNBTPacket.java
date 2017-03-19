package net.fexcraft.mod.fvm.network.packets;

import java.io.IOException;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.network.packet.Packet;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class ScriptNBTPacket extends Packet implements IPacket, IMessage {
	
	public NBTTagCompound nbt;
	public int entityId;
	
	public ScriptNBTPacket(){}
	
	public ScriptNBTPacket(Entity vehicle, NBTTagCompound nbt){
		this.entityId = vehicle.getEntityId();
		this.nbt = nbt;
	}

	@Override
	public void toBytes(ByteBuf bbuf){
		PacketBuffer buf = new PacketBuffer(bbuf);
		buf.writeInt(entityId);
		buf.writeCompoundTag(nbt);
	}

	@Override
	public void fromBytes(ByteBuf bbuf){
		PacketBuffer buf = new PacketBuffer(bbuf);
		entityId = buf.readInt();
		try {
			nbt = buf.readCompoundTag();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}