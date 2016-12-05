package net.fexcraft.mod.frsm.blocks.common;

import java.util.List;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.fexcraft.mod.lib.util.item.FIB;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FramedGlowstone extends Block implements IBlock{
	
	public static final PropertyInteger TYPE = PropertyInteger.create("type", 0, 5);
	
    public FramedGlowstone(){
        super(Material.WOOD);
        this.setLightLevel(1.0F);
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(1.0F);
        this.setResistance(10.0F);
        this.setCreativeTab(CD.BLOCKS.getCreativeTab());
		BlockUtil.register(FI.MODID, this);
		BlockUtil.registerCustomFIB(new IB(this));
    }
    
	public static class IB extends FIB {

		public IB(Block block) {
			super(block, ((IBlock)block).getName(), ((IBlock)block).getVariantAmount());
		}
		
		@Override
		public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
	        IBlockState iblockstate = worldIn.getBlockState(pos);
	        Block block = iblockstate.getBlock();
	        if(!block.isReplaceable(worldIn, pos)){
	            pos = pos.offset(facing);
	        }
	        if(stack.stackSize != 0 && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.canBlockBePlaced(this.block, pos, false, facing, (Entity)null, stack)){
	            int i = stack.getItemDamage();
	            IBlockState iblockstate1 = FRSM_Blocks.framed_glowstone.getDefaultState().withProperty(TYPE, i);
	            if(placeBlockAt(stack, playerIn, worldIn, pos, facing, hitX, hitY, hitZ, iblockstate1)){
	                SoundType soundtype = this.block.getSoundType();
	                worldIn.playSound(playerIn, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
	                --stack.stackSize;
	            }
	            return EnumActionResult.SUCCESS;
	        }
	        else{
	            return EnumActionResult.FAIL;
	        }
	    }
	}
    
    @Override
    public String getName(){
    	return "framedGlowstone";
    }

	@Override
	public int getVariantAmount() {
		return 6;
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
    public void getSubBlocks(Item item, CreativeTabs tab, List list){
    	for (int i = 0; i < 6; ++i){
    		list.add(new ItemStack(item, 1, i));
    	}
    }
    
}