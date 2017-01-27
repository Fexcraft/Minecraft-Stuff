package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class StreetLampPostEntity extends TileEntity implements IPacketReceiver {
	
	private boolean north, south, west, east, up, down;
	private boolean[] array;
	
	public StreetLampPostEntity(){
		north = south = west = east = false;
		up = down = true;
	}

	@Override
	public void processServerPacket(IPacket pkt){
		//
	}

	@Override
	public void processClientPacket(IPacket pkt){
		int[] arr = ((PacketTileEntityUpdate)pkt).nbt.getIntArray("connection");
		north = arr[0] == 0 ? false : true;
		south = arr[1] == 0 ? false : true;
		west  = arr[2] == 0 ? false : true;
		east  = arr[3] == 0 ? false : true;
		up    = arr[4] == 0 ? false : true;
		down  = arr[5] == 0 ? false : true;
		array = null;
	}
	
	public void sendUpdatePacket(){
		NBTTagCompound nbt = new NBTTagCompound();
		int[] arr = new int[6];
		arr[0] = north ? 1 : 0;
		arr[1] = south ? 1 : 0;
		arr[2] = west  ? 1 : 0;
		arr[3] = east  ? 1 : 0;
		arr[4] = up    ? 1 : 0;
		arr[5] = down  ? 1 : 0;
		nbt.setIntArray("connection", arr);
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
		int[] arr = new int[6];
		arr[0] = north ? 1 : 0;
		arr[1] = south ? 1 : 0;
		arr[2] = west  ? 1 : 0;
		arr[3] = east  ? 1 : 0;
		arr[4] = up    ? 1 : 0;
		arr[5] = down  ? 1 : 0;
		compound.setIntArray("Connections", arr);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		int[] arr = compound.getIntArray("Connections");
		north = arr[0] == 0 ? false : true;
		south = arr[1] == 0 ? false : true;
		west  = arr[2] == 0 ? false : true;
		east  = arr[3] == 0 ? false : true;
		up    = arr[4] == 0 ? false : true;
		down  = arr[5] == 0 ? false : true;
		array = null;
	}

	public boolean[] getArray(){
		if(array == null){
			onChange(pos, true);
			array = new boolean[6];
			array[0] = north;
			array[1] = south;
			array[2] = west;
			array[3] = east;
			array[4] = up;
			array[5] = down;
			return array;
		}
		else return array;
	}

	public void onChange(BlockPos change){
		if(world.getTileEntity(change) instanceof StreetLampPostEntity){
			EnumFacing ef = fromPos(change);
			if(ef != null){
				toggle(ef);
			}
		}
		else return;
	}
	
	private void toggle(EnumFacing ef){
		switch(ef){
			case DOWN:
				down = !down;
				break;
			case EAST:
				east = !east;
				break;
			case NORTH:
				north = !north;
				break;
			case SOUTH:
				south = !south;
				break;
			case UP:
				up = !up;
				break;
			case WEST:
				west = !west;
				break;
			default:
				break;
		}
		this.sendUpdatePacket();
	}

	public EnumFacing fromPos(BlockPos bp){
		if(pos.north().equals(bp)){
			return EnumFacing.NORTH;
		}
		if(pos.south().equals(bp)){
			return EnumFacing.SOUTH;
		}
		if(pos.west().equals(bp)){
			return EnumFacing.WEST;
		}
		if(pos.east().equals(bp)){
			return EnumFacing.EAST;
		}
		if(pos.up().equals(bp)){
			return EnumFacing.UP;
		}
		if(pos.down().equals(bp)){
			return EnumFacing.DOWN;
		}
		return null;
	}

	public void onChange(BlockPos change, boolean b){
		if(!b){
			onChange(change);
			return;
		}
		up = world.getTileEntity(pos.up()) instanceof StreetLampPostEntity || world.getBlockState(pos.up()).getBlock() instanceof Connectable;
		down = world.getTileEntity(pos.down()) instanceof StreetLampPostEntity || world.getBlockState(pos.down()).getBlock() instanceof Connectable;
		north = world.getTileEntity(pos.north()) instanceof StreetLampPostEntity || world.getBlockState(pos.north()).getBlock() instanceof Connectable;
		south = world.getTileEntity(pos.south()) instanceof StreetLampPostEntity || world.getBlockState(pos.south()).getBlock() instanceof Connectable;
		west = world.getTileEntity(pos.west()) instanceof StreetLampPostEntity || world.getBlockState(pos.west()).getBlock() instanceof Connectable;
		east = world.getTileEntity(pos.east()) instanceof StreetLampPostEntity || world.getBlockState(pos.east()).getBlock() instanceof Connectable;
		//temp
		if(!up && (!north && !south && !west && !east)){
			up = world.getBlockState(pos.up()).isSideSolid(world, pos.up(), EnumFacing.DOWN);
		}
		if(!down && (!north && !south && !west && !east)){
			down = world.getBlockState(pos.down()).isSideSolid(world, pos.down(), EnumFacing.UP);
		}
		//^^
		this.sendUpdatePacket();
	}
	
	public static interface Connectable {}
	
}