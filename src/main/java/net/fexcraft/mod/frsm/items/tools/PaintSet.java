package net.fexcraft.mod.frsm.items.tools;

import static net.fexcraft.mod.frsm.util.text.CCS.GOLD;

import java.util.List;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.block.IPaintableBlock;
import net.fexcraft.mod.lib.api.item.IPaintItem;
import net.fexcraft.mod.lib.util.cls.EnumColor;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.block.BlockCarpet;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PaintSet extends Item implements IPaintItem {
	
	private EnumColor color;
	private String name;
	
	public PaintSet(String name, EnumColor c){
		this.name = name;
		this.color = c;
		this.setCreativeTab(CD.TOOLS.getCreativeTab());
		this.setMaxStackSize(1);
		ItemUtil.register(FI.MODID, this);
	}

	@Override
	public EnumColor getColor() {
		return color;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			return EnumActionResult.PASS;
		}
		else{
			IBlockState state = world.getBlockState(pos);
			if(state.getBlock() instanceof IPaintableBlock){
				((IPaintableBlock)state.getBlock()).onPaintItemUse(this.getColor(), player.getHeldItem(hand), player, pos, world);
			}
			else if(state.getBlock() == Blocks.WOOL){
				world.setBlockState(pos, Blocks.WOOL.getDefaultState().withProperty(BlockColored.COLOR, color.toDyeColor()));
			}
			else if(state.getBlock() == Blocks.STAINED_HARDENED_CLAY){
				world.setBlockState(pos, Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, color.toDyeColor()));
			}
			else if(state.getBlock() instanceof BlockStainedGlass){
				world.setBlockState(pos, Blocks.STAINED_GLASS.getDefaultState().withProperty(BlockColored.COLOR, color.toDyeColor()));
			}
			else if(state.getBlock() instanceof BlockStainedGlassPane){
				world.setBlockState(pos, Blocks.STAINED_GLASS_PANE.getDefaultState().withProperty(BlockColored.COLOR, color.toDyeColor()));
			}
			else if(state.getBlock() instanceof BlockCarpet){
				world.setBlockState(pos, Blocks.CARPET.getDefaultState().withProperty(BlockColored.COLOR, color.toDyeColor()));
			}
			else{
				return EnumActionResult.PASS;
			}
			return EnumActionResult.SUCCESS;
		}
    }
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean advanced){
		list.add(GOLD + color.getName());
    }

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
}