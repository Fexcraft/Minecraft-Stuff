package net.fexcraft.mod.frsm.blocks.barrel;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class IronBarrel extends Block implements IBlock {
	
	public IronBarrel() {
    	super(Material.WOOD);
    	this.setHarvestLevel("pickaxe", 1);
    	this.setHardness(3.0F);
    	this.setResistance(32.0F);
    	this.setCreativeTab(CD.BLOCKS.getCreativeTab());
    	BlockUtil.register(FI.MODID, this);
    	BlockUtil.registerFIB(this);
    	BlockUtil.registerFIBRender(this);
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
    
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F);
	}

	@Override
	public String getName(){
		return "iron_barrel";
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
	
}