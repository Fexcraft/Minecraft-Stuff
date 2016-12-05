package net.fexcraft.mod.frsm.blocks.common;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;

public class Placeholder extends Block implements IBlock{
	
	public Placeholder(){
        super(Material.BARRIER);
		this.setCreativeTab(CD.DEV.getCreativeTab());
		BlockUtil.register(FI.MODID, this);
		BlockUtil.registerFIB(this);
    }
    
    @Override
    public boolean isFullyOpaque(IBlockState state) {
    	return false;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state){
        return false;
    }
    
    @Override
    public boolean isFullCube(IBlockState state){
        return true;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.INVISIBLE;
    }
    
    @Override
    public String getName(){
    	return "placeholder";
    }

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
}