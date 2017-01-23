package net.fexcraft.mod.frsm.util.block;

import net.fexcraft.mod.lib.api.block.PaintableBlock;
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

public class PaintableTileEntity extends TileEntity implements IPacketReceiver, PaintableBlock {
	
	private RGB color = new RGB();
	
	public PaintableTileEntity(EnumColor def_color){
		color.fromDyeColor(def_color.toDyeColor());
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
	}
	
	public void sendUpdatePacket(){
		ApiUtil.sendTileEntityUpdatePacket(world, pos, color.writeToNBT(new NBTTagCompound(), null), 64);
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
		return tag;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag){
		super.readFromNBT(tag);
		color.readFromNBT(tag, null);
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
	
	//
}