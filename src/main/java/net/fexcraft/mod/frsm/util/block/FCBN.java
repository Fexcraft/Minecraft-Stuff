package net.fexcraft.mod.frsm.util.block;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumBlockRenderType;

public class FCBN extends Block implements IBlock{
	
	private boolean opaque;
	private String name;

	public FCBN(String name, boolean opaque, String material, String tool, int harverestlevel, float hardness, float resistance, CreativeTabs creativetab) {
		super(BlockUtil.getMaterial(material));
		this.name = name;
		this.setHarvestLevel(tool, harverestlevel);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setCreativeTab(creativetab);
		BlockUtil.register(FI.MODID, this);
		BlockUtil.registerFIB(this);
		this.opaque = opaque;
	}
	
    @Override
	public boolean isFullyOpaque(IBlockState state) {
		return opaque;
	}
	
	@Override
	public boolean isFullCube(IBlockState state){
        return opaque;
    }
	
	@Override
	public boolean isOpaqueCube(IBlockState state){
        return opaque;
    }
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.MODEL;
    }

	@Override
	public String getName(){
		return name;
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
	
}