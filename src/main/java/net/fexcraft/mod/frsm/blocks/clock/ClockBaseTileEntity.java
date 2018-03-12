package net.fexcraft.mod.frsm.blocks.clock;

import java.time.LocalTime;
import java.time.ZoneId;

import net.fexcraft.mod.frsm.util.block.PaintableTileEntity;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.EnumColor;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.ResourceLocation;

public class ClockBaseTileEntity extends PaintableTileEntity {
	
	private Class<? extends ClockBase> clazz;
	private EnumClock clocktype;
	private int offset = 0;
	
	public ClockBaseTileEntity(){
		super(EnumColor.BLACK);
	}

	public ClockBaseTileEntity(Class<? extends ClockBase> clazz){
		super(EnumColor.BLACK);
		this.clazz = clazz;
		this.clocktype = EnumClock.fromClass(this.clazz);
	}

	public ClockBaseModel getModel(){
		return (ClockBaseModel)clocktype.getModel();
	}

	public ResourceLocation getTexture(){
		return clocktype.getTexture();
	}

	public boolean isOffset(){
		return clocktype.hasOffset();
	}

	public int getOffset(){
		return offset;
	}
	
	public int changeOffset(){
		return ++offset > 12 ? offset = -11 : offset;
	}

	public boolean twoSided(){
		return clocktype.hasBackSide();
	}
	
	private int hour(){
		int h = getGMTOffset(offset).getHour();
		return h >= 12 ? h - 12 : h;
	}
	
	public int getHour12(){
		return clocktype.isWorldTime() ? worldHour() : clocktype.hasOffset() ? hour() : Time.getHour12();
	}

	private int worldHour(){
        long hours = world.getWorldTime() / 1000 + 6;
        if(hours >= 12){ hours -= 12; }
        if(hours >= 12){ hours -= 12; }
        return (int)hours;
	}

	public int getMinute(){
		return clocktype.isWorldTime() ? worldMinute() : clocktype.hasOffset() ? getGMTOffset(offset).getMinute() : Time.getMinute();
	}

	private int worldMinute(){
        return (int)((world.getWorldTime() % 1000) * 60 / 1000);
	}

	public int getSecond(){
		return clocktype.isWorldTime() ? -66 : clocktype.hasOffset() ? getGMTOffset(offset).getSecond() : Time.getSecond();
	}
	
	@Override
	public void processServerPacket(IPacket pkt){
		//
	}

	@Override
	public void processClientPacket(IPacket pkt){
		PacketTileEntityUpdate packet = (PacketTileEntityUpdate) pkt;
		color.readFromNBT(packet.nbt, null);
		offset = packet.nbt.getInteger("frsm:offset");
	}
	
	public void sendUpdatePacket(){
		ApiUtil.sendTileEntityUpdatePacket(world, pos, this.writeToNBT(new NBTTagCompound()), 64);
	}
	
	@Override
	public NBTTagCompound getUpdateTag(){
		return this.writeToNBT(new NBTTagCompound());
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket(){
		return new SPacketUpdateTileEntity(this.getPos(), 2, this.writeToNBT(new NBTTagCompound()));
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
		this.readFromNBT(pkt.getNbtCompound());
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag){
		tag = super.writeToNBT(tag);
		tag.setInteger("frsm:offset", offset);
		tag.setString("frsm:clocktype", clocktype.getRegistryName());
		return tag;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag){
		super.readFromNBT(tag);
		offset = tag.getInteger("frsm:offset");
		clocktype = EnumClock.fromString(tag.getString("frsm:clocktype"));
	}
	
	public static LocalTime getGMTOffset(int i){
		return getGMTOffset(i, false);
	}
	
	public static LocalTime getGMTOffset(int i, boolean control){
		if(control){ i = i > 12 ? i = 12 : i < -11 ? i = -11 : i; }
		return LocalTime.now(ZoneId.of("GMT" + (i >= 0 ? "+" + i : i)));
	}
	
}