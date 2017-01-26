package net.fexcraft.mod.frsm.blocks.fridge;

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

public class FridgeTileEntity extends TileEntity implements IPacketReceiver, PaintableObject {
	
	private RGB color = new RGB();
	private boolean open;
	
	public FridgeTileEntity(){
		color.fromDyeColor(EnumDyeColor.WHITE);
		open = false;
	}
	
	public boolean getState(){
		return open;
	}
	
	public void setState(boolean b){
		this.open = b;
	}
	
	public RGB getColor(){
		return this.color;
	}

	@Override
	public void processServerPacket(IPacket pkt) {
		//
	}

	@Override
	public void processClientPacket(IPacket pkt) {
		PacketTileEntityUpdate packet = (PacketTileEntityUpdate)pkt;
		color.readFromNBT(packet.nbt, null);
		open = packet.nbt.getBoolean("open");
	}
	
	public void sendUpdatePacket(){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt = color.writeToNBT(nbt, null);
		nbt.setBoolean("open", open);
		ApiUtil.sendTileEntityUpdatePacket(world.provider.getDimension(), pos, nbt, 64);
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket(){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt = this.writeToNBT(nbt);
		return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), nbt);
	}
	
	@Override
	public NBTTagCompound getUpdateTag(){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt = this.writeToNBT(nbt);
		return nbt;
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
		this.readFromNBT(pkt.getNbtCompound());
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		color.writeToNBT(compound, null);
		compound.setBoolean("frsm_open", open);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		color.readFromNBT(compound, null);
		open = compound.getBoolean("frsm_open");
	}

	@Override
	public void onPaintItemUse(RGB color, EnumColor dye, ItemStack stack, EntityPlayer player, BlockPos pos, World world) {
		this.color.copyFrom(color);
		this.sendUpdatePacket();
	}
	
}