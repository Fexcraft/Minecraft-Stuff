package net.fexcraft.mod.frsm.blocks.common;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;

@fBlock(modid = FI.MODID, name = "placeholder")
public class Placeholder extends Block {
	
	public Placeholder(){
        super(Material.BARRIER);
		this.setCreativeTab(CD.EXPERIMENTAL);
    }
    
    @Override
    public boolean isFullBlock(IBlockState state) {
    	return false;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state){
        return false;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.INVISIBLE;
    }
    
}