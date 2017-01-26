package net.fexcraft.mod.frsm.blocks.chair;

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

public class OfficechairEntity extends TileEntity implements IPacketReceiver, PaintableObject {
	
	public RGB primary = new RGB();
	//RGB secondary = RGB.WHITE;
	public short rotation = 0;
	
	public OfficechairEntity(){
		primary.fromDyeColor(EnumDyeColor.ORANGE);
	}
	
	public void applyColor(RGB color){
		primary.copyFrom(color);
		this.sendUpdatePacket();
	}
	
	public void applyColor(EnumDyeColor color){
		primary.fromDyeColor(color);
		this.sendUpdatePacket();
	}

	@Override
	public void processServerPacket(IPacket pkt){
		//
	}

	@Override
	public void processClientPacket(IPacket pkt){
		NBTTagCompound nbt = ((PacketTileEntityUpdate)pkt).nbt;
		primary.readFromNBT(nbt, null);
		rotation = nbt.getShort("rotation");
	}
	
	public void sendUpdatePacket(){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt = primary.writeToNBT(nbt, null);
		nbt.setShort("rotation", rotation);
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
		primary.writeToNBT(tag, "Primary");
		tag.setShort("frsm_rotation", rotation);
		return tag;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag){
		super.readFromNBT(tag);
		primary.readFromNBT(tag, "Primary");
		rotation = tag.getShort("frsm_rotation");
	}

	public void applyRotation(){
		rotation++;
		if(rotation >= 36){
			rotation = 0;
		}
		this.sendUpdatePacket();
	}

	@Override
	public void onPaintItemUse(RGB color, EnumColor dye, ItemStack stack, EntityPlayer player, BlockPos pos, World world) {
		if(!world.isRemote){
			primary.copyFrom(color);
			this.sendUpdatePacket();
		}
	}
	
	//
}
