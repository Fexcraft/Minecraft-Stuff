package net.fexcraft.mod.frsm.blocks.shelf;

import net.fexcraft.mod.lib.api.common.PaintableObject;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.EnumColor;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Shelf1Entity extends TileEntity implements IPacketReceiver, PaintableObject {

	private EnumColor color;
	private boolean open;
	
	public Shelf1Entity(){
		color = EnumColor.WHITE;
		open = false;
	}
	
	public void toggle(){
		this.open = !open;
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setBoolean("open", open);
		ApiUtil.sendTileEntityUpdatePacket(this.getWorld(), this.getPos(), nbt);
	}
	
	public void toggle(boolean bool){
		this.open = bool;
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setBoolean("open", open);
		ApiUtil.sendTileEntityUpdatePacket(this.getWorld(), this.getPos(), nbt);
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket(){
		NBTTagCompound nbt = this.writeToNBT(new NBTTagCompound());		
		return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), nbt);
	}

	@Override
	public void processServerPacket(IPacket pkt){
		//
	}

	@Override
	public void processClientPacket(IPacket pkt){
		PacketTileEntityUpdate packet = (PacketTileEntityUpdate)pkt;
		if(packet.nbt.hasKey("color")){
			this.color = EnumColor.fromString(packet.nbt.getString("color"));
		}
		if(packet.nbt.hasKey("open")){
			this.open = packet.nbt.getBoolean("open");
		}
	}
	
	@Override
	public NBTTagCompound getUpdateTag(){
		NBTTagCompound nbt = this.writeToNBT(new NBTTagCompound());
		return nbt;
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
		this.readFromNBT(pkt.getNbtCompound());
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		compound.setString("frsm_color", color.toString());
		compound.setBoolean("frsm_open", open);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		color = EnumColor.fromString(compound.getString("frsm_color"));
		open = compound.getBoolean("frsm_open");
	}

	public boolean getState(){
		return open;
	}

	public EnumColor getColor(){
		return color;
	}

	@Override
	public void onPaintItemUse(RGB color, EnumColor dye, ItemStack stack, EntityPlayer player, BlockPos pos, World world) {
		this.color = dye;
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("color", color.toString());
		ApiUtil.sendTileEntityUpdatePacket(this.getWorld(), this.getPos(), nbt);
		Print.chat(player, "Color set to " + color.toString() + "!");
	}
	
}