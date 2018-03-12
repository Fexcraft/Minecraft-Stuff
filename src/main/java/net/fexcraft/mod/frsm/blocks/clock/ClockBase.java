package net.fexcraft.mod.frsm.blocks.clock;

import net.fexcraft.mod.frsm.items.common.TVController;
import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemClock;
import net.minecraft.item.ItemCompass;
import net.minecraft.item.ItemTool;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class ClockBase extends FBC_4R {

	public ClockBase(){
		super(Material.IRON);
		this.setHarvestLevel("axe", 1);
		this.setHardness(1.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.TECHNIC);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new ClockBaseTileEntity(this.getClass());
	}
	
	private static final AxisAlignedBB CLOCK_EAST_AABB  = new AxisAlignedBB(0.0D,    0.0D, 0.0D,    0.1875D, 1.0D, 1.0D   );
    private static final AxisAlignedBB CLOCK_WEST_AABB  = new AxisAlignedBB(0.8125D, 0.0D, 0.0D,    1.0D,    1.0D, 1.0D   );
    private static final AxisAlignedBB CLOCK_SOUTH_AABB = new AxisAlignedBB(0.0D,    0.0D, 0.0D,    1.0D,    1.0D, 0.1875D);
    private static final AxisAlignedBB CLOCK_NORTH_AABB = new AxisAlignedBB(0.0D,    0.0D, 0.8125D, 1.0D,    1.0D, 1.0D   );
	
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        switch((EnumFacing)state.getValue(FACING)){
            case NORTH:
                return CLOCK_NORTH_AABB;
            case SOUTH:
                return CLOCK_SOUTH_AABB;
            case WEST:
                return CLOCK_WEST_AABB;
            case EAST:
            default:
                return CLOCK_EAST_AABB;
        }
    }
    
    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World world, BlockPos pos){
    	return getBoundingBox(state, world, pos);
    }
    
    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        if(facing.getAxis().isHorizontal() && this.canBlockStay(worldIn, pos, facing)){
            return this.getDefaultState().withProperty(FACING, facing);
        }
        else{
            for(EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL){
                if(this.canBlockStay(worldIn, pos, enumfacing)){
                    return this.getDefaultState().withProperty(FACING, enumfacing);
                }
            }
            return this.getDefaultState();
        }
    }
    
    protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing){
        return worldIn.getBlockState(pos.offset(facing.getOpposite())).isSideSolid(worldIn, pos.offset(facing.getOpposite()), facing);
    }
    
    @Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float x, float y, float z){
    	if(!world.isRemote && hand != EnumHand.OFF_HAND){
    		ClockBaseTileEntity entity = (ClockBaseTileEntity)world.getTileEntity(pos);
    		if(entity.isOffset() && (player.getHeldItem(hand).getItem() instanceof ItemTool || player.getHeldItem(hand).getItem() instanceof TVController || player.getHeldItem(hand).getItem() instanceof ItemCompass || player.getHeldItem(hand).getItem() instanceof ItemClock)){
    			int i = entity.changeOffset();
    			Print.chat(player, "GMT" + (i >= 0 ? "+" + i : i));
    			entity.sendUpdatePacket();
    			return true;
    		}
    	}
    	return false;
	}
	
}