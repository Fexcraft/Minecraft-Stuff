package net.fexcraft.mod.frsm.blocks.redstone;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.BlockCompressedPowered;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class RedstonePillar2 extends BlockCompressedPowered implements IBlock {
	
	public RedstonePillar2(){
        super(Material.IRON, MapColor.RED);
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(2.0F);
        this.setResistance(32.0F);
        this.setCreativeTab(CD.DEV.getCreativeTab());
        BlockUtil.register(FI.MODID, this);
        BlockUtil.registerFIB(this);
    }
    
    @Override
	public String getName(){
		return "redstone_pillar2";
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