package net.fexcraft.mod.frsm.blocks.tbm;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@fBlock(modid = FI.MODID, name = "tbm")
public class TBM extends BlockFalling {
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public TBM() {super(Material.WOOD);
		this.setHarvestLevel("axe", 1);
		this.setHardness(1.0F);
		this.setResistance(10.0F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setCreativeTab(CD.EXPERIMENTAL);
    }

    @Override
    public boolean isFullCube(IBlockState state){
    	return false;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state){
    	return false;
    }
		
    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state){
    	pos = new BlockPos(pos.getX(), pos.getY() + 5, pos.getZ());
    	if(world.getBlockState(pos).getBlock() == Blocks.AIR){
        	world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 5, pos.getZ()), Blocks.COBBLESTONE.getDefaultState());
    	}
    }
    
    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
    	return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }
    
    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
    	worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, BlockPos pos) {
    	if(world.isRemote){
    		if (world.getTileEntity(pos) != null){
    			//TODO player.openGui(FRSM.instance, GuiHandler.TEST, world, x, y, z);
    			return true;
    		}
    	}
    	return false;
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta){
    	EnumFacing enumfacing = EnumFacing.getFront(meta);
    	if (enumfacing.getAxis() == EnumFacing.Axis.Y){
    		enumfacing = EnumFacing.NORTH;
    	}
    	return this.getDefaultState().withProperty(FACING, enumfacing);
    }
    
    @Override
    public int getMetaFromState(IBlockState state){
    	return ((EnumFacing)state.getValue(FACING)).getIndex();
    }
    
    @Override
    protected BlockStateContainer createBlockState(){
    	return new BlockStateContainer(this, new IProperty[] {FACING});
    }
    
}