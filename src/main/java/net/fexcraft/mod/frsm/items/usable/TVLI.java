package net.fexcraft.mod.frsm.items.usable;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TVLI extends Item implements IItem{
	
	private String name = "TVLI";
	
	public TVLI() {
		this.setCreativeTab(CD.TECHNIC.getCreativeTab());
		this.setMaxStackSize(1);
		ItemUtil.register(FI.MODID, this);
	}
    
	@Override
    public String getName(){
    	return name;
    }
    
	@Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
    	if(!worldIn.isRemote){
	        boolean flag = worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos);
	        BlockPos blockpos = flag ? pos : pos.offset(facing);
	
	        if (facing != EnumFacing.UP){
	            return EnumActionResult.FAIL;
	        }
	        else if (!player.canPlayerEdit(blockpos, facing, stack)){
	            return EnumActionResult.FAIL;
	        }
	        else{
	            Block block = worldIn.getBlockState(blockpos).getBlock();
	
	            if (!worldIn.canBlockBePlaced(block, blockpos, false, facing, (Entity)null, stack)){
	                return EnumActionResult.FAIL;
	            }
	            else if (Blocks.REDSTONE_WIRE.canPlaceBlockAt(worldIn, blockpos)){
	                --stack.stackSize;
	            	EnumFacing e = player.getHorizontalFacing().getOpposite();
	            	if(e == EnumFacing.NORTH){
	                	worldIn.setBlockState(blockpos, FRSM_Blocks.TVL.getDefaultState());
	                	return EnumActionResult.SUCCESS;
	                }
	                if(e == EnumFacing.SOUTH){
	                	worldIn.setBlockState(blockpos, FRSM_Blocks.TVL0.getDefaultState());
	                	return EnumActionResult.SUCCESS;
	                }
	                if(e == EnumFacing.WEST){
	                	worldIn.setBlockState(blockpos, FRSM_Blocks.TVL00.getDefaultState());
	                	return EnumActionResult.SUCCESS;
	                }
	                if(e == EnumFacing.EAST){
	                	worldIn.setBlockState(blockpos, FRSM_Blocks.TVL000.getDefaultState());
	                	return EnumActionResult.SUCCESS;
	                }
	                return EnumActionResult.FAIL;
	            }
	        }
        }
		return EnumActionResult.FAIL;
    }

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
}