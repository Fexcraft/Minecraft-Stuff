package net.fexcraft.mod.extensions.ie.tileentities;

import net.fexcraft.mod.extensions.ie.util.EFIO;
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

public class CableType4VerticalEntity extends TileEntity implements ICableTileEntity, ITickable, IPacketReceiver {
	
	private int power;
	private int powerls;
	
	private EFIOC io, copy;
	
	public CableType4VerticalEntity(){
		power = 0;
		powerls = -1;
		io = new EFIOC(4);
		copy = new EFIOC(4);
	}
	
	public static class EFIOC extends net.fexcraft.mod.extensions.ie.util.EFIOC {
		
		private boolean[] vert;
		
		public EFIOC(int a) {
			super(a);
			vert = new boolean[4];
			vert[0] = false;
			vert[1] = false;
			vert[2] = false;
			vert[3] = false;
		}
		
		public boolean northVert(){
			return vert[2];
		}
		
		public boolean southVert(){
			return vert[0];
		}
		
		public boolean westVert(){
			return vert[1];
		}
		
		public boolean eastVert(){
			return vert[3];
		}
		
		public boolean vertByFacing(EnumFacing ef){
			switch(ef){
				case EAST:
					return vert[3];
				case NORTH:
					return vert[2];
				case SOUTH:
					return vert[0];
				case WEST:
					return vert[1];
				default:
					return false;
			}
		}
		
		public void vertByFacingSet(EnumFacing ef, boolean b){
			switch(ef){
				case EAST:
					vert[3] = b;
				case NORTH:
					vert[2] = b;
				case SOUTH:
					vert[0] = b;
				case WEST:
					vert[1] = b;
				default:
					return;
			}
		}

		public void vertFromNBT(NBTTagCompound compound) {
			for(int i = 0; i < vert.length; i++){
				vert[i] = compound.getBoolean("frsm_fpu_efio_" + i + "_vert");
			}
		}
		
		public NBTTagCompound vertToNBT(NBTTagCompound compound){
			for(int i = 0; i < vert.length; i++){
				compound.setBoolean("frsm_fpu_efio_" + i + "_vert", vert[i]);
			}
			return compound;
		}
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
			for(int i = 0; i < io.get().length; i++){
				if(io.get()[i].io == EnumIO.OUTPUT){
					if(io.vertByFacing(io.get()[i].facing)){
						ApiUtil.tryTransfer(this, worldObj, pos.up(), io.get()[i].facing);
					}
					else{

						ApiUtil.tryTransfer(this, worldObj, pos, io.get()[i].facing);
					}
				}
				/*if(io.get()[i].io == EnumIO.INPUT){
					if(io.vertByFacing(io.get()[i].facing)){
						tryTransferRev(pos.up(), io.get()[i].facing);
					}
				}*/
			}
			detectAndSendChanges(null);
		}
	}

	/*private void tryTransferRev(BlockPos up, EnumFacing facing) {
		TileEntity rte = worldObj.getTileEntity(ApiUtil.getPosFromFacing(facing, pos));
		if(rte != null && rte instanceof ICableTileEntity){
			ICableTileEntity te = (ICableTileEntity)rte;
			EnumFacing side = facing.getOpposite();
			if(te.fpu_get(side) > te.fpu_min(side) && te.fpu_get(side) > te.fpu_min_transfer_speed(side)){
				if(this.fpu_get(facing) >= this.fpu_max(facing)){
					return;
				}
				int t = ApiUtil.getTransferSpeed(te, side, this);
				if(t <= 0){
					return;
				}
				boolean b = ApiUtil.hasSpaceForFullTransfer(facing, this, t);
				if(b){
					te.fpu_subtract(side, t);
					this.fpu_add(side, t);
				}
				if(!b){
					int fs = ApiUtil.getFreeSpace(side.getOpposite(), this);
					if((t - fs) == 0){
						return;
					}
					te.fpu_subtract(side, fs);
					this.fpu_add(side, fs);
				}
			}
		}
	}*/

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
		compound = io.vertToNBT(compound);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		power = compound.getInteger("fpu");
		io.readFromNBT(compound);
		io.vertFromNBT(compound);
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
			if(nbt.hasKey(facing + "_vert")){
				io.vertByFacingSet(e.facing, nbt.getBoolean(facing + "_vert"));
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
			if(copy.vert[i] != io.vert[i]){
				update.setBoolean(facing + "_vert", io.vert[i]);
				copy.vert[i] = io.vert[i];
			}
		}
		if(update.getSize() > 0){
			ApiUtil.sendTileEntityUpdatePacket(worldObj, pos, update);
		}
	}
	
}