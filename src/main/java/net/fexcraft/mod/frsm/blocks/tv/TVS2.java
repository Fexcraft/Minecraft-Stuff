package net.fexcraft.mod.frsm.blocks.tv;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.frsm.util.block.FRSMTE;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TVS2 extends FBC_4R {
	
    private String name = "TVS2";
    
	public TVS2() {
		super(Material.GRASS);
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(3.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.TECHNIC.getCreativeTab());
		BlockUtil.register(FI.MODID, this);
		BlockUtil.registerFIB(this);
	}
	
	@Override
	public String getName(){
		return name;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TVS2TE();
	}

	public static class TVS2TE extends FRSMTE{
		
		private int rotation;
		
		public TVS2TE(){
			rotation = 0;
		}
		
		public int getRotation(){
			return rotation;
		}
		
		@Override
		public NBTTagCompound getUpdateTag(){
			NBTTagCompound nbt = new NBTTagCompound();
			this.writeToNBT(nbt);
			return nbt;
		}
		
		@Override
		public SPacketUpdateTileEntity getUpdatePacket(){
			NBTTagCompound nbt = new NBTTagCompound();
			this.writeToNBT(nbt);
			return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), nbt);
		}
		
		@Override
		public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
			this.readFromNBT(pkt.getNbtCompound());
		}
		
		@Override
		public void readFromNBT(NBTTagCompound nbt){
			super.readFromNBT(nbt);
			rotation = nbt.getInteger("frsm_model_rotation");
		}
		
		@Override
		public NBTTagCompound writeToNBT(NBTTagCompound nbt){
			super.writeToNBT(nbt);
			nbt.setInteger("frsm_model_rotation", rotation);
			return nbt;
		}
	}
	
	@Override
	public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
	    if(!w.isRemote){
	    	int i = w.getTileEntity(pos).getTileData().getInteger("frsm_model_rotation");
	    	if(i < 15){
	    		i++;
	    	}
	    	else{
	    		i = 0;
	    	}
	    	//22,5
	    	w.getTileEntity(pos).getTileData().setInteger("frsm_model_rotation", i);
	    	NBTTagCompound nbt = new NBTTagCompound();
	    	nbt.setInteger("frsm_model_rotation", i);
	    	ApiUtil.sendTileEntityUpdatePacket(w, pos, null);
	    }
		return true;
	}
}