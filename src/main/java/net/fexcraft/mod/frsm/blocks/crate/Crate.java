package net.fexcraft.mod.frsm.blocks.crate;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R_F;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Crate extends FBC_4R_F{

	public Crate() {
		super(Material.WOOD);
		this.setHarvestLevel("axe", 1);
		this.setHardness(1.0F);
		this.setResistance(32.0F);
		
		this.setCreativeTab(CD.BLOCKS.getCreativeTab());
		BlockUtil.register(FI.MODID, this);
		BlockUtil.registerFIB(this);
	}
	
	@Override
	public String getName(){
		return "crate";
	}
        
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new CrateEntity();
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState blockstate) {
	    CrateEntity te = (CrateEntity) world.getTileEntity(pos);
	    InventoryHelper.dropInventoryItems(world, pos, te);
	    super.breakBlock(world, pos, blockstate);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
	    if (stack.hasDisplayName()) {
	        ((CrateEntity) worldIn.getTileEntity(pos)).setCustomName(stack.getDisplayName());
	    }
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
	    if (!world.isRemote) {
	        //TODO player.openGui(frsm.instance, GuiHandler.Crate, world, pos.getX(), pos.getY(), pos.getZ());
	    }
	    return true;
	}
}