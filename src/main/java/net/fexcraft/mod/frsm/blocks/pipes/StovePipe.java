package net.fexcraft.mod.frsm.blocks.pipes;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@fBlock(modid = FI.MODID, name = "stove_pipe", tileentity = StovePipeEntity.class)
public class StovePipe extends BlockContainer {

	public StovePipe(){
		super(Material.IRON);
    	this.setHarvestLevel("pickaxe", 1);
    	this.setHardness(3.0F);
    	this.setResistance(32.0F);
    	this.setCreativeTab(CD.PIPES);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new StovePipeEntity();
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state){
        return false;
    }
	
	@Override
    public boolean isFullCube(IBlockState state){
        return false;
    }
	
	@Override
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos){
        return false;
    }
	
	@Override
    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos change){
        /*if(world.getTileEntity(change) != null){
        	((StovePipeEntity)world.getTileEntity(pos)).onChange(change);
        	((StovePipeEntity)world.getTileEntity(change)).onChange(pos);
        }
        else{
        	((StovePipeEntity)world.getTileEntity(pos)).onChange(change, true);
        }*/
		((StovePipeEntity)world.getTileEntity(pos)).onChange(change, true);
		if(world.getTileEntity(change) != null){
			((StovePipeEntity)world.getTileEntity(change)).onChange(pos);
    	}
    }
	
}