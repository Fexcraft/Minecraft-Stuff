package net.fexcraft.mod.frsm.blocks.common;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.util.registry.ItemBlock16;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@fBlock(modid = FI.MODID, name = "framedglowstone", variants = 6, item = FramedGlowstone.IB.class)
public class FramedGlowstone extends Block {
	
	public static final PropertyInteger TYPE = PropertyInteger.create("type", 0, 5);
	
    public FramedGlowstone(){
        super(Material.WOOD);
        this.setLightLevel(1.0F);
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(1.0F);
        this.setResistance(10.0F);
        this.setCreativeTab(CD.BLOCKS);
    }
    
	public static class IB extends ItemBlock16 {
		public IB(Block block) {
			super(block);
		}
		
		@Override
		public int getMetadata(int meta){
			return meta >= 6 ? 0 : meta;
		}
	}
	
    @Override
    public int damageDropped(IBlockState state){
        return state.getValue(TYPE);
    }
    
    @Override
    protected BlockStateContainer createBlockState(){
    	return new BlockStateContainer(this, new IProperty[] {TYPE});
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta){
    	return this.getDefaultState().withProperty(TYPE, Integer.valueOf(meta));
    }
    
    @Override
    public int getMetaFromState(IBlockState state){
    	return state.getValue(TYPE).intValue();
    }
    
    @SideOnly(Side.CLIENT) @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list){
    	for (int i = 0; i < 6; ++i){
    		list.add(new ItemStack(this, 1, i));
    	}
    }
    
}