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
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class WaterWheelTileEntity extends TileEntity implements ITickable, IPacketReceiver, ICableTileEntity{

	private int power, powerls;
	private EFIO output, ols;
	public boolean on, onls;
	
	public WaterWheelTileEntity(){
		power = 0;
		powerls = -1;
		output = ols = new EFIO(EnumFacing.UP, EnumIO.OUTPUT, 8);
		on = onls = false;
	}
	
	private int sec = -1;
	
	@Override
	public void update(){
		while(worldObj.isRemote){
			return;
		}
		if(sec != Ticker.sec){
			sec = Ticker.sec;
			
			if(!isValid()){
				on = false;
				return;
			}
			on = true;
			
			power += 500;
			if(power >= fpu_max(null)){
				power = fpu_max(null);
			}
			
			ApiUtil.tryTransfer(this, worldObj, pos, output.facing);
			detectAndSendChanges(null);
		}
	}
	
	public boolean isValid(){
		if(output.facing == EnumFacing.UP){
			EnumFacing ef = EnumFacing.UP;
			switch(getBlockMetadata()){
				case 2:
					ef = EnumFacing.NORTH;
					break;
				case 3:
					ef = EnumFacing.SOUTH;
					break;
				case 4:
					ef = EnumFacing.WEST;
					break;
				case 5:
					ef = EnumFacing.EAST;
					break;
			}
			output.facing = ef;
		}
		BlockPos[] ps = new BlockPos[9];
		int x = pos.getX(), y = pos.getY(), z = pos.getZ();
		int blk = 0;
		int blkw = 0;
		switch(output.facing.getOpposite()){
			case NORTH:
				ps[0] = new BlockPos(x + 1, y + 1, z - 1);
				ps[1] = new BlockPos(x + 1, y    , z - 1);
				ps[2] = new BlockPos(x + 1, y - 1, z - 1);
				ps[3] = new BlockPos(x    , y + 1, z - 1);
				ps[4] = new BlockPos(x    , y    , z - 1);
				ps[5] = new BlockPos(x    , y - 1, z - 1);
				ps[6] = new BlockPos(x - 1, y + 1, z - 1);
				ps[7] = new BlockPos(x - 1, y    , z - 1);
				ps[8] = new BlockPos(x - 1, y - 1, z - 1);
				break;
			case SOUTH:
				ps[0] = new BlockPos(x + 1, y + 1, z + 1);
				ps[1] = new BlockPos(x + 1, y    , z + 1);
				ps[2] = new BlockPos(x + 1, y - 1, z + 1);
				ps[3] = new BlockPos(x    , y + 1, z + 1);
				ps[4] = new BlockPos(x    , y    , z + 1);
				ps[5] = new BlockPos(x    , y - 1, z + 1);
				ps[6] = new BlockPos(x - 1, y + 1, z + 1);
				ps[7] = new BlockPos(x - 1, y    , z + 1);
				ps[8] = new BlockPos(x - 1, y - 1, z + 1);
				break;
			case WEST:
				ps[0] = new BlockPos(x - 1, y + 1, z + 1);
				ps[1] = new BlockPos(x - 1, y    , z + 1);
				ps[2] = new BlockPos(x - 1, y - 1, z + 1);
				ps[3] = new BlockPos(x - 1, y + 1, z    );
				ps[4] = new BlockPos(x - 1, y    , z    );
				ps[5] = new BlockPos(x - 1, y - 1, z    );
				ps[6] = new BlockPos(x - 1, y + 1, z - 1);
				ps[7] = new BlockPos(x - 1, y    , z - 1);
				ps[8] = new BlockPos(x - 1, y - 1, z - 1);
				break;
			case EAST:
				ps[0] = new BlockPos(x + 1, y + 1, z + 1);
				ps[1] = new BlockPos(x + 1, y    , z + 1);
				ps[2] = new BlockPos(x + 1, y - 1, z + 1);
				ps[3] = new BlockPos(x + 1, y + 1, z    );
				ps[4] = new BlockPos(x + 1, y    , z    );
				ps[5] = new BlockPos(x + 1, y - 1, z    );
				ps[6] = new BlockPos(x + 1, y + 1, z - 1);
				ps[7] = new BlockPos(x + 1, y    , z - 1);
				ps[8] = new BlockPos(x + 1, y - 1, z - 1);
				break;
			default: break;
		}
		for(BlockPos p : ps){
			IBlockState state = worldObj.getBlockState(p);
			//Print.log(p.toString() + " " + state.getBlock().getUnlocalizedName());
			if(state.getBlock() == Blocks.AIR){
				blk++;
			}
			else if(state.getBlock() == Blocks.WATER || state.getBlock() == Blocks.FLOWING_WATER){
				blk++;
				blkw++;
			}
			else continue;
		}
		boolean r = false;
		if(blk >= 9  && blkw > 2){
			r = true;
		}
		//Print.log(blk + " " + blkw);
		return r;
	}

	@Override
	public void processServerPacket(IPacket pkt) {
		//
	}

	@Override
	public void processClientPacket(IPacket packet) {
		PacketTileEntityUpdate pkt = (PacketTileEntityUpdate)packet;
		if(pkt.nbt.hasKey("fpu")){
			power = pkt.nbt.getInteger("fpu");
		}
		if(pkt.nbt.hasKey("on")){
			on = pkt.nbt.getBoolean("on");
		}
	}
	
	private NBTTagCompound update;
	
	@Override
	public void detectAndSendChanges(EnumFacing ef) {
		update = new NBTTagCompound();
		if(powerls != power){
			update.setInteger("fpu", power);
			powerls = power;
		}
		if(onls != on){
			update.setBoolean("on", on);
			onls = on;
		}
		if(update.getSize() > 0){
			ApiUtil.sendTileEntityUpdatePacket(worldObj, pos, update);
		}
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
		compound.setString("frsm_fpu_facing", output.facing.getName());
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		power = compound.getInteger("fpu");
		output.facing = EnumFacing.byName(compound.getString("frsm_fpu_facing"));
	}

	@Override
	public String getContainerName() {
		return "Water Wheel";
	}

	@Override
	public String getContainerId() {
		return "frsm_water_wheel";
	}

	@Override
	public boolean isMashine() {
		return true;
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
		return 2500;
	}

	@Override
	public int fpu_min(EnumFacing ef){
		return 0;
	}

	@Override
	public int fpu_transfer_speed(EnumFacing ef) {
		return 500;
	}

	@Override
	public int fpu_min_transfer_speed(EnumFacing ef) {
		return 20;
	}

	@Override
	public EnumFacing fpu_input(){
		return null;
	}

	@Override
	public boolean fpu_isInput(EnumFacing ef){
		return false;
	}

	@Override
	public EnumFacing fpu_output(){
		return output.facing;
	}

	@Override
	public boolean fpu_isOutput(EnumFacing ef){
		return output.facing.equals(ef);
	}

	@Override
	public void fpu_setInput(EnumFacing ef, int i) {
		return;
	}

	@Override
	public void fpu_setOutput(EnumFacing ef, int i) {
		//output.facing = ef;
		//output is based on metadata
	}

	@Override
	public int fpu_resistivity(EnumFacing ef){
		return 10;
	}

	@Override
	public void onEditorItemInteract(EnumFacing ef, ICableEditorItem edit, ItemStack item, EntityPlayer player) {
		// TODO Auto-generated method stub
	}
	
}