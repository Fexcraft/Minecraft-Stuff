package net.fexcraft.mod.extensions.ie.tileentities;

import net.fexcraft.mod.extensions.ie.util.EFIO;
import net.fexcraft.mod.extensions.ie.util.EFIOC;
import net.fexcraft.mod.extensions.ie.util.Ticker;
import net.fexcraft.mod.extensions.ie.util.EFIO.EnumIO;
import net.fexcraft.mod.lib.api.item.ICableEditorItem;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.api.tileentity.ICableTileEntity;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.cls.ApiUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class CableType4Entity extends TileEntity implements ICableTileEntity, ITickable, IPacketReceiver {
	
	private int power;
	private int powerls;
	
	private EFIOC io, copy;
	
	public CableType4Entity(){
		power = 0;
		powerls = -1;
		io = new EFIOC(4);
		copy = new EFIOC(4);
	}
	
	@Override
	public String getContainerName(){
		return "Cable Type 4";
	}

	@Override
	public String getContainerId(){
		return "cabletype4";
	}

	@Override
	public boolean isMashine(){
		return false;
	}

	@Override
	public int fpu_get(EnumFacing ef){
		return power;
	}

	@Override
	public void fpu_set(EnumFacing ef, int e) {
		power = e;
	}

	@Override
	public void fpu_add(EnumFacing ef, int e) {
		power += e;
	}

	@Override
	public void fpu_subtract(EnumFacing ef, int e) {
		power -= e;
	}

	@Override
	public int fpu_max(EnumFacing ef){
		return 28;
	}

	@Override
	public int fpu_min(EnumFacing ef){
		return 0;
	}

	@Override
	public int fpu_transfer_speed(EnumFacing ef){
		for(EFIO e : io.get()){
			if(e.facing.equals(ef)){
				switch(e.cthickness){
					case 2:
						return 12;
					case 4:
						return 24;
				}
			}
		}
		return 0;
	}

	@Override
	public int fpu_min_transfer_speed(EnumFacing ef){
		for(EFIO e : io.get()){
			if(e.facing.equals(ef)){
				switch(e.cthickness){
					case 2:
						return 1;
					case 4:
						return 2;
				}
			}
		}
		return 0;
	}

	@Override
	public EnumFacing fpu_input(){
		return null;
	}

	@Override
	public boolean fpu_isInput(EnumFacing ef){
		for(EFIO e : io.get()){
			if(e.io == EnumIO.INPUT && e.facing.equals(ef)){
				return true;
			}
		}
		return false;
	}

	@Override
	public EnumFacing fpu_output(){
		return null;
	}

	@Override
	public boolean fpu_isOutput(EnumFacing ef) {
		for(EFIO e : io.get()){
			if(e.io == EnumIO.OUTPUT && e.facing.equals(ef)){
				return true;
			}
		}
		return false;
	}

	@Override
	public void fpu_setInput(EnumFacing ef, int i){
		for(EFIO e : io.get()){
			if(e.facing.equals(ef)){
				e.io = EnumIO.INPUT;
				e.cthickness = i;
				break;
			}
		}
	}

	@Override
	public void fpu_setOutput(EnumFacing ef, int i){
		for(EFIO e : io.get()){
			if(e.facing.equals(ef)){
				e.io = EnumIO.OUTPUT;
				e.cthickness = i;
				break;
			}
		}
	}

	@Override
	public int fpu_resistivity(EnumFacing ef){
		for(EFIO e : io.get()){
			if(e.facing.equals(ef)){
				switch(e.cthickness){
					case 2:
						return 0;
					case 4:
						return 1;
				}
			}
		}
		return 0;
	}

	@Override
	public void onEditorItemInteract(EnumFacing ef, ICableEditorItem edit, ItemStack item, EntityPlayer player) {
		//
	}
	
	private int sec = -1;
	
	@Override
	public void update(){
		while(worldObj.isRemote){
			return;
		}
		if(sec != Ticker.sec){
			sec = Ticker.sec;
			if(power <= this.fpu_min(null)){
				return;
			}
			//power++;DEBUG/TEST
			for(EFIO e : io.get()){
				if(e.io == EnumIO.OUTPUT){
					ApiUtil.tryTransfer(this, worldObj, pos, e.facing);
				}
			}
			detectAndSendChanges(null);
		}
	}

	public void resetFacing(EnumFacing opposite){
		for(EFIO e : io.get()){
			if(e.facing.equals(opposite)){
				e.io = EnumIO.NULL;
				e.cthickness = 0;
				break;
			}
		}
	}

	public EFIOC getIO(){
		return io;
	}
	
	@Override
	public NBTTagCompound getUpdateTag(){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt = this.writeToNBT(nbt);
		return nbt;
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket(){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt = this.writeToNBT(nbt);
		return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), nbt);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
		this.readFromNBT(pkt.getNbtCompound());
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		compound.setInteger("fpu", power);
		compound = io.writeToNBT(compound);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		power = compound.getInteger("fpu");
		io.readFromNBT(compound);
	}

	@Override
	public void processServerPacket(IPacket pkt) {
		//
	}

	@Override
	public void processClientPacket(IPacket pkt) {
		NBTTagCompound nbt = ((PacketTileEntityUpdate)pkt).nbt;
		if(nbt.hasKey("power")){
			power = nbt.getInteger("power");
		}
		for(EFIO e : io.get()){
			String facing = e.facing.getName();
			if(nbt.hasKey(facing)){
				e.io = EnumIO.get(nbt.getInteger(facing));
			}
			if(nbt.hasKey(facing + "_ct")){
				e.cthickness = nbt.getInteger(facing + "_ct");
			}
		}
	}
	
	private NBTTagCompound update = new NBTTagCompound();
	
	@Override
	public void detectAndSendChanges(EnumFacing ef){
		update = new NBTTagCompound();
		if(powerls != power){
			update.setInteger("power", power);
			powerls = power;
		}
		for(int i = 0; i < copy.get().length; i++){
			String facing = io.get()[i].facing.getName();
			if(copy.get()[i].io != io.get()[i].io){
				update.setInteger(facing, io.get()[i].io.getId());
				copy.get()[i].io = io.get()[i].io;
			}
			if(copy.get()[i].cthickness != io.get()[i].cthickness){
				update.setInteger(facing + "_ct", io.get()[i].cthickness);
				copy.get()[i].cthickness = io.get()[i].cthickness;
			}
		}
		if(update.getSize() > 0){
			ApiUtil.sendTileEntityUpdatePacket(worldObj, pos, update);
		}
	}
	
}