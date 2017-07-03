package net.fexcraft.mod.famm.blocks;

import net.fexcraft.mod.famm.FAMM;
import net.fexcraft.mod.famm.util.FI;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.registry.RegistryUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class FAMMBLKH extends Block {
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyInteger DEPTH = PropertyInteger.create("depth", 0, 3);
    
	public FAMMBLKH(String name){
		super(Material.WOOD);
		setCreativeTab(FAMM.tabFAMM);
        this.setHarvestLevel("axe", 1);
        this.setHardness(1.0F);
        this.setResistance(10.0F);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(DEPTH, 3));
        RegistryUtil.get(FI.MODID).addBlock(name, this, null, 0, null);
	}

	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
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
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return get((EnumFacing)state.getValue(FACING), state.getValue(DEPTH).intValue());
    }
    
    public AxisAlignedBB get(EnumFacing facing, int depth){
    	double dx = 0.5 + (0.375 - (0.125 * depth));//rip dp;
		double dn = (0.625 + (0.125 * depth)) - 0.5;
		double de = 0.125 + (0.125 * depth);
		double dh = 0.5;
		switch(depth){
			case 0: dh += 0.375; break;
			case 1: dh += 0.25;  break;
			case 2: dh += 0.125; break;
			case 3: break;
		}
    	switch(facing){
    		case SOUTH:
    			return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D,   dn);
    		case NORTH:
    			return new AxisAlignedBB(0.0D, 0.0D,   dx, 1.0D, 1.0D, 1.0D);
    		case WEST:
    			return new AxisAlignedBB(  dh, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    		case EAST:
    		default:
    			return new AxisAlignedBB(0.0D, 0.0D, 0.0D,   de, 1.0D, 1.0D);
    	}
    }
	
    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(DEPTH, 3);
    }
    
    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(DEPTH, 3), 2);
    }
    
    @Override
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(!w.isRemote && hand == EnumHand.MAIN_HAND){
    		if(p.getHeldItemMainhand() == ItemStack.EMPTY){
    			int i = state.getValue(DEPTH);
    			i++; if(i > 3){i = 0;}
    			Print.log(state.getValue(DEPTH));
    			w.setBlockState(pos, this.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(DEPTH, i), 2);
    		}
    	}
		return true;
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta){
    	EnumFacing facing; int depth;
    	if(meta < 4){
    		facing = EnumFacing.getHorizontal(meta);
    		depth = 0;
    	}
    	else if(meta < 8){
    		facing = EnumFacing.getHorizontal(meta - 4);
    		depth = 1;
    	}
    	else if(meta < 12){
    		facing = EnumFacing.getHorizontal(meta - 8);
    		depth = 2;
    	}
    	else if(meta < 16){
    		facing = EnumFacing.getHorizontal(meta - 12);
    		depth = 3;
    	}
    	else{
    		facing = EnumFacing.NORTH;
    		depth = 0;
    	}
        return this.getDefaultState().withProperty(FACING, facing).withProperty(DEPTH, depth);
    }
	
	//S 0 4  8 12
	//W 1 5  9 13
	//N 2 6 10 14
	//E 3 7 11 15
    @Override
    public int getMetaFromState(IBlockState state){
        return ((EnumFacing)state.getValue(FACING)).getHorizontalIndex() + (4 * state.getValue(DEPTH).intValue());
    }
	
    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {FACING, DEPTH});
    }
	
}
