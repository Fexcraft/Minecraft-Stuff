package net.fexcraft.mod.frsm.blocks.bus;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BSS extends FBC_4R {
	
	private static final AxisAlignedBB AABB = new AxisAlignedBB(0.4F, 0.0F, 0.4F, 0.6F, 2.2F, 0.6F);
	
	public BSS() {
		super(Material.IRON);
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(3.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.DEV.getCreativeTab());
		BlockUtil.register(FI.MODID, this);
		BlockUtil.registerFIB(this);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return new AxisAlignedBB(0.4F, 0.0F, 0.4F, 0.6F, 2.2F, 0.6F);
    }
	
	@Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState blockState, World worldIn, BlockPos pos){
        return FULL_BLOCK_AABB;
    }
       
	@Override
	public boolean isFullyOpaque(IBlockState state) {
		return false;
	}
	
	public String getName(){
		return "busstop";
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new BSSEntity();
	}

}