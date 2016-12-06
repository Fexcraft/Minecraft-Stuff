package net.fexcraft.mod.frsm.blocks.pchardware;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class pchardware2 extends FBC_4R{
    
    public pchardware2() {
    	super(Material.GLASS);
    	this.setHarvestLevel("pickaxe", 1);
    	this.setHardness(3.0F);
    	this.setResistance(32.0F);
    	this.setCreativeTab(CD.TECHNIC.getCreativeTab());
    	BlockUtil.register(FI.MODID, this);
    	BlockUtil.registerFIB(this);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new pchardware2Entity();
	}
	
    @Override
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(!w.isRemote){
    		if (p.getHeldItemMainhand() != null && p.getHeldItemMainhand().getItem() == FRSM_Items.upgradekit){
    			w.setBlockState(pos, FRSM_Blocks.pchardware2b.getDefaultState().withProperty(FACING, p.getHorizontalFacing().getOpposite()));
    			p.getHeldItemMainhand().stackSize--;
    			return true;
    		}
    	}
		return false;
    }

	public String getName() {
		return "pchardware2";
	}
}