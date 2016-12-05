package net.fexcraft.mod.lib.network.packet;

import java.io.IOException;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketTileEntityUpdate extends Packet implements IPacket, IMessage{
	
	public BlockPos pos;
	public NBTTagCompound nbt;
	
	public PacketTileEntityUpdate(){}
	
	public PacketTileEntityUpdate(BlockPos pos, NBTTagCompound nbt){
		this.pos = pos;
		this.nbt = nbt;
	}

	@Override
	public void toBytes(ByteBuf bbuf){
		PacketBuffer buf = new PacketBuffer(bbuf);
		buf.writeBlockPos(pos);
		buf.writeNBTTagCompoundToBuffer(nbt);
	}

	@Override
	public void fromBytes(ByteBuf bbuf){
		PacketBuffer buf = new PacketBuffer(bbuf);
		pos = buf.readBlockPos();
		try {
			nbt = buf.readNBTTagCompoundFromBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}