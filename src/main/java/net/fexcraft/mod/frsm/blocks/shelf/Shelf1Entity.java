package net.fexcraft.mod.frsm.blocks.shelf;

import net.fexcraft.mod.frsm.util.PrintChat;
import net.fexcraft.mod.frsm.util.block.FRSMTE;
import net.fexcraft.mod.frsm.util.java.BoolUtil;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.cls.ApiUtil;
import net.fexcraft.mod.lib.util.cls.EnumColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Shelf1Entity extends FRSMTE implements IPacketReceiver{

	private EnumColor color;
	private boolean open;
	
	public Shelf1Entity(){
		color = EnumColor.WHITE;
		open = false;
	}
	
	public void toggle(){
		this.open = BoolUtil.reverse(open);
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
	
	public void onPaintItemUse(EnumColor color, ItemStack stack, EntityPlayer player, BlockPos pos, World world){
		this.color = color;
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("color", color.toString());
		ApiUtil.sendTileEntityUpdatePacket(this.getWorld(), this.getPos(), nbt);
		PrintChat.print(player, "Color set to " + color.toString() + "!");
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
}