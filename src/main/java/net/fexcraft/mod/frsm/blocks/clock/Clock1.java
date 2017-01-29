package net.fexcraft.mod.frsm.blocks.clock;

import java.util.List;

import net.fexcraft.mod.frsm.util.CCS;
import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.frsm.util.block.PaintableTileEntity;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.util.common.EnumColor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@fBlock(modid = FI.MODID, name = "clock1", tileentity = Clock1.TE.class, item = Clock1.I.class)
public class Clock1 extends FBC_4R {
    
	public Clock1() {
		super(Material.WOOD);
		this.setHarvestLevel("axe", 1);
		this.setHardness(1.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.TECHNIC);
	}
        
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TE();
	}
	
	public static class TE extends PaintableTileEntity {
		public TE(){
			super(EnumColor.BLACK);
		}
	}
	
	public static class I extends ItemBlock{
		public I(Block block) {
			super(block);
		}
		@Override
		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean shift){
	    	list.add(CCS.GRAY + "SYSTEM TIME");
	    }
	}
	
	private static final AxisAlignedBB CLOCK_EAST_AABB  = new AxisAlignedBB(0.0D,    0.0D, 0.0D,    0.1875D, 1.0D, 1.0D   );
    private static final AxisAlignedBB CLOCK_WEST_AABB  = new AxisAlignedBB(0.8125D, 0.0D, 0.0D,    1.0D,    1.0D, 1.0D   );
    private static final AxisAlignedBB CLOCK_SOUTH_AABB = new AxisAlignedBB(0.0D,    0.0D, 0.0D,    1.0D,    1.0D, 0.1875D);
    private static final AxisAlignedBB CLOCK_NORTH_AABB = new AxisAlignedBB(0.0D,    0.0D, 0.8125D, 1.0D,    1.0D, 1.0D   );
	
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        switch ((EnumFacing)state.getValue(FACING)){
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
    
}