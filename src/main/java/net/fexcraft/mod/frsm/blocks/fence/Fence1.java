package net.fexcraft.mod.frsm.blocks.fence;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Fence1 extends FBC_4R {
	
	public Fence1() {
    	super(Material.IRON);
    	this.setHarvestLevel("pickaxe", 1);
    	this.setHardness(5.0F);
    	this.setResistance(32.0F);
    	this.setCreativeTab(CD.BLOCKS.getCreativeTab());
    	BlockUtil.register(FI.MODID, this);
    	BlockUtil.registerFIB(this);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new Fence1Entity();
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		EnumFacing enumfacing = state.getValue(FACING);
        if(enumfacing.equals(EnumFacing.NORTH)){
        	return new AxisAlignedBB(0.0F, 0.0F, 0.4F, 1.0F, 1.5F, 0.6F);
        }
        if(enumfacing.equals(EnumFacing.SOUTH)){
        	return new AxisAlignedBB(0.4F, 0.0F, 0.0F, 0.6F, 1.5F, 1.0F);
        }
        
        if(enumfacing.equals(EnumFacing.WEST)){
        	return new AxisAlignedBB(0.0F, 0.0F, 0.4F, 1.0F, 1.5F, 0.6F);
        }
        
        if(enumfacing.equals(EnumFacing.EAST)){
        	return new AxisAlignedBB(0.4F, 0.0F, 0.0F, 0.6F, 1.5F, 1.0F);
        }
        else{
        	return FULL_BLOCK_AABB;
        }
    }
	
	@Override
	public String getName() {
		return "fence1";
	}
}