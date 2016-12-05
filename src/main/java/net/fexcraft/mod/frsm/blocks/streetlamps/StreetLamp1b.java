package net.fexcraft.mod.frsm.blocks.streetlamps;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class StreetLamp1b extends BlockContainer implements IBlock {
	
	public StreetLamp1b() {
    	super(Material.IRON);
    	this.setHarvestLevel("pickaxe", 1);
    	this.setHardness(3.0F);
    	this.setResistance(32.0F);
    	this.setCreativeTab(CD.STREETS.getCreativeTab());
    	BlockUtil.register(FI.MODID, this);
    	BlockUtil.registerFIB(this);
	}
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
    	return new AxisAlignedBB(0.4F, 0.0F, 0.4F, 0.6F, 1.0F, 0.6F);
    }
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new StreetLamp1bEntity();
	}
	
	@Override
	public String getName() {
		return "streetLamp1b";
	}
	
	@Override
	public boolean isFullyOpaque(IBlockState state) {
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
	public int getVariantAmount(){
		return default_variant;
	}
}