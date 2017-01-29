package net.fexcraft.mod.frsm.blocks.roadsigns;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@fBlock(modid = FI.MODID, name = "roadsign2", tileentity = RoadSign2.TE.class)
public class RoadSign2 extends FBC_4R {
    
	public RoadSign2() {
		super(Material.GRASS);
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(3.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.STREETS);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return new AxisAlignedBB(0.4F, 0.0F, 0.4F, 0.6F, 2.2F, 0.6F);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TE();
	}

	public static class TE extends TileEntity {}
	
}