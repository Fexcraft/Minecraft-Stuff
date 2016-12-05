package net.fexcraft.mod.frsm.blocks.trashcan;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R_F;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Trashcan extends FBC_4R_F {

	public Trashcan(){
		super(Material.ANVIL);
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(5.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.BLOCKS.getCreativeTab());
		BlockUtil.register(FI.MODID, this);
		BlockUtil.registerFIB(this);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TrashcanEntity();
	}
	
	/*@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
	    if (!world.isRemote) {
	        player.openGui(FRSM.instance, GuiHandler.trashcan, world, pos.getX(), pos.getY(), pos.getZ());
	    }
	    return true;
	}*/
	
	@Override
	public String getName(){
		return "trashcan";
	}
}