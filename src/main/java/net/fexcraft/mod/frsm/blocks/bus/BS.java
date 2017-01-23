package net.fexcraft.mod.frsm.blocks.bus;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.lib.api.block.öBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@öBlock(modid = FI.MODID, name = "busstation", tileentity = BSEntity.class)
public class BS extends FBC_4R {
	
	public BS() {
		super(Material.IRON);
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(3.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.BLOCKS);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.05F, 1.0F);
    }
	
	@Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState blockState, World worldIn, BlockPos pos){
        return FULL_BLOCK_AABB;
    }
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new BSEntity();
	}

}