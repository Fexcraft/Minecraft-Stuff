package net.fexcraft.mod.frsm.blocks.chair;

import java.util.List;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.api.block.IPaintableBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.fexcraft.mod.lib.util.cls.EnumColor;
import net.fexcraft.mod.lib.util.item.FIB;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class OfficechairG extends FBC_4R implements IPaintableBlock{
	
	public OfficechairG() {
		super(Material.GLASS);
		this.setHarvestLevel("axe", 1);
		this.setHardness(2.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.BLOCKS.getCreativeTab());
		BlockUtil.register(FI.MODID, this);
		BlockUtil.registerCustomFIB(new IB(this));
	}
	
	public static class IB extends FIB{
		public IB(Block block) {
			super(block, ((IBlock)block).getName(), ((IBlock)block).getVariantAmount());
		}
    	
		@Override
		public void addInformation(ItemStack itemstack, EntityPlayer player, List ls, boolean par4){
			ls.add(CCS.GRAY + "Gray");
		}
    }
    	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new OfficechairGEntity();
	}
	
	@Override
	public String getName(){
		return "officechairG";
	}

	@Override
	public void onPaintItemUse(EnumColor color, ItemStack stack, EntityPlayer player, BlockPos pos, World world) {
		IBlockState state = world.getBlockState(pos);
		switch(color){
			case WHITE: world.setBlockState(pos, FRSM_Blocks.officechair_white.getDefaultState().withProperty(FACING, state.getValue(FACING))); return;
			case GRAY: world.setBlockState(pos, FRSM_Blocks.officechair_gray.getDefaultState().withProperty(FACING, state.getValue(FACING))); return;
			case BLACK: world.setBlockState(pos, FRSM_Blocks.officechair_black.getDefaultState().withProperty(FACING, state.getValue(FACING))); return;
			case ORANGE: world.setBlockState(pos, FRSM_Blocks.officechair.getDefaultState().withProperty(FACING, state.getValue(FACING))); return;
			default: return;
		}
	}
	
}