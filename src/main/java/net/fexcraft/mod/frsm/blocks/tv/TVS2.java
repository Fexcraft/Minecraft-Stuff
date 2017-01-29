package net.fexcraft.mod.frsm.blocks.tv;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@fBlock(modid = FI.MODID, name = "tvs2", tileentity = TVS2Entity.class)
public class TVS2 extends FBC_4R {
    
	public TVS2() {
		super(Material.GRASS);
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(3.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.TECHNIC);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TVS2Entity();
	}
	
	@Override
	public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
	    if(!w.isRemote && hand == EnumHand.MAIN_HAND){
	    	int i = ((TVS2Entity)w.getTileEntity(pos)).rotation;
	    	i += 1;
	    	if(i >= 16){
	    		i = 0;
	    	}
	    	//22,5
	    	NBTTagCompound nbt = new NBTTagCompound();
	    	nbt.setInteger("rotation", i);
	    	ApiUtil.sendTileEntityUpdatePacket(w, pos, nbt, 64);
	    }
		return true;
	}
}