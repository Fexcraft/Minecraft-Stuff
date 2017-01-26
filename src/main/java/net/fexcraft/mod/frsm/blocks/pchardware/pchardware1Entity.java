package net.fexcraft.mod.frsm.blocks.pchardware;

import net.fexcraft.mod.lib.api.common.PaintableObject;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.EnumColor;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PCHardware1Entity extends TileEntity implements IPacketReceiver, PaintableObject {
	
	private RGB color = new RGB();
	private int ps = 0;
	
	public PCHardware1Entity(){
		color.fromDyeColor(EnumColor.GRAY.toDyeColor());
	}

	public void next(){
		ps++;
		if(ps > 2){
			ps = 0;
		}
		this.sendUpdatePacket();
	}
	
	public void applyColor(RGB color){
		color.copyFrom(color);
		this.sendUpdatePacket();
	}
	
	public void applyColor(EnumDyeColor color){
		this.color.fromDyeColor(color);
		this.sendUpdatePacket();
	}

	@Override
	public void processServerPacket(IPacket pkt){
		//
	}

	@Override
	public void processClientPacket(IPacket pkt){
		color.readFromNBT(((PacketTileEntityUpdate)pkt).nbt, null);
		ps = ((PacketTileEntityUpdate)pkt).nbt.getInteger("position");
	}
	
	public void sendUpdatePacket(){
		NBTTagCompound nbt = color.writeToNBT(new NBTTagCompound(), null);
		nbt.setInteger("position", ps);
		ApiUtil.sendTileEntityUpdatePacket(world, pos, nbt, 64);
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
		super.writeToNBT(tag);
		color.writeToNBT(tag, null);
		tag.setInteger("Position", ps);
		return tag;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag){
		super.readFromNBT(tag);
		color.readFromNBT(tag, null);
		ps = tag.getInteger("Position");
	}
	
	public RGB getColor(){
		return color;
	}

	@Override
	public void onPaintItemUse(RGB color, EnumColor dye, ItemStack stack, EntityPlayer player, BlockPos pos, World world) {
		if(!world.isRemote){
			this.color.copyFrom(color);
			this.sendUpdatePacket();
		}
	}

	public int getPosition(){
		return ps;
	}

}
