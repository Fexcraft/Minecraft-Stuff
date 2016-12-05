package net.fexcraft.mod.extensions.ie.tileentities;

import net.fexcraft.mod.extensions.ie.util.EFIO;
import net.fexcraft.mod.extensions.ie.util.EFIOC;
import net.fexcraft.mod.extensions.ie.util.Static;
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

public class CableType4BridgeEntity extends TileEntity implements ICableTileEntity, ITickable, IPacketReceiver {
	
	private int p1, p2;
	private int p1ls, p2ls;
	private EFIOC io, copy;
	
	public CableType4BridgeEntity(){
		p1 = p2 = 0;
		p1ls = p2ls = -1;
		io = new EFIOC(4);
		copy = new EFIOC(4);
	}
	
	@Override
	public String getContainerName(){
		return "Cable Type 4 Bridge";
	}

	@Override
	public String getContainerId(){
		return "cabletype4_bridge";
	}

	@Override
	public boolean isMashine(){
		return false;
	}

	@Override
	public int fpu_get(EnumFacing ef){
		switch(ef){
			case NORTH: case SOUTH:
				return p1;
			case WEST: case EAST:
				return p2;
			default:
				return 0;
		}
	}

	@Override
	public void fpu_set(EnumFacing ef, int e) {
		switch(ef){
			case NORTH: case SOUTH:
				p1 = e;
			case WEST: case EAST:
				p2 = e;
			default: return;
		}
	}

	@Override
	public void fpu_add(EnumFacing ef, int e) {
		switch(ef){
			case NORTH: case SOUTH:
				p1 += e;
			case WEST: case EAST:
				p2 += e;
			default: return;
		}
	}

	@Override
	public void fpu_subtract(EnumFacing ef, int e) {
		switch(ef){
			case NORTH: case SOUTH:
				p1 -= e;
			case WEST: case EAST:
				p2 -= e;
			default: return;
		}
	}

	@Override
	public int fpu_max(EnumFacing ef){
		return 34;
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
		switch(ef){
			case EAST:
				io.east().io = EnumIO.INPUT;
				io.east().cthickness = i;
				io.west().io = EnumIO.OUTPUT;
				io.west().cthickness = i;
				break;
			case NORTH:
				io.north().io = EnumIO.INPUT;
				io.north().cthickness = i;
				io.south().io = EnumIO.OUTPUT;
				io.south().cthickness = i;
				break;
			case SOUTH:
				io.south().io = EnumIO.INPUT;
				io.south().cthickness = i;
				io.north().io = EnumIO.OUTPUT;
				io.north().cthickness = i;
				break;
			case WEST:
				io.west().io = EnumIO.INPUT;
				io.west().cthickness = i;
				io.east().io = EnumIO.OUTPUT;
				io.east().cthickness = i;
				break;
			default:
				break;
		}
	}

	@Override
	public void fpu_setOutput(EnumFacing ef, int i){
		this.fpu_setInput(ef.getOpposite(), i);
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
			if(p1 <= this.fpu_min(null) || p2 <= this.fpu_min(null)){
				return;
			}
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
		compound.setInteger("fpu1", p1);
		compound.setInteger("fpu2", p2);
		compound = io.writeToNBT(compound);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		p1 = compound.getInteger("fpu1");
		p2 = compound.getInteger("fpu2");
		io.readFromNBT(compound);
	}

	@Override
	public void processServerPacket(IPacket pkt) {
		//
	}

	@Override
	public void processClientPacket(IPacket pkt) {
		NBTTagCompound nbt = ((PacketTileEntityUpdate)pkt).nbt;
		if(nbt.hasKey("power1")){
			p1 = nbt.getInteger("power1");
		}
		if(nbt.hasKey("power2")){
			p2 = nbt.getInteger("power2");
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
		if(!Static.MODE){
			return;
		}
		update = new NBTTagCompound();
		if(p1ls != p1){
			update.setInteger("power1", p1);
			p1ls = p1;
		}
		if(p2ls != p2){
			update.setInteger("power1", p2);
			p2ls = p2;
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