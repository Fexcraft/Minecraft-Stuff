package net.fexcraft.mod.extensions.ce.blocks;

import net.fexcraft.mod.extensions.ce.CE;
import net.fexcraft.mod.frsm.util.block.ETE;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CEBB extends FBC_4R {
	
    private String name = "CEBB";
    
	public CEBB(String name) {
		super(Material.IRON);
		this.setCreativeTab(CE.tabCE);
		this.name = name;
		
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(1.0F);
		this.setResistance(32.0F);
		
		BlockUtil.register("frsm_ce", this);
		BlockUtil.registerFIB(this);
		BlockUtil.registerFIBRender(this);
	}
       
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
        
	public String getName(){
		return name;
	}
        
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new ETE();
	}
    
	@Override
    public boolean isFullCube(IBlockState state){
        return false;
    }
    
    protected static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.1875D, 1.0D, 1.0D);
    protected static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.8125D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.1875D);
    protected static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.8125D, 1.0D, 1.0D, 1.0D);
    
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        switch ((EnumFacing)state.getValue(FACING)){
            case NORTH:
                return NORTH_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case WEST:
                return WEST_AABB;
            case EAST:
            default:
                return EAST_AABB;
        }
    }
}