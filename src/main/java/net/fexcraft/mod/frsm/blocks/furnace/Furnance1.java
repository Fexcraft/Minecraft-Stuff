package net.fexcraft.mod.frsm.blocks.furnace;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Furnance1 extends FBC_4R {
	
	public Furnance1() {
    	super(Material.IRON);
    	this.setHarvestLevel("pickaxe", 1);
    	this.setHardness(3.0F);
    	this.setResistance(32.0F);
    	this.setCreativeTab(CD.BLOCKS.getCreativeTab());
    	BlockUtil.register(FI.MODID, this);
    	BlockUtil.registerFIB(this);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new Furnance1Entity();
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F);
	}
	
    @Override
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
    	EnumFacing ef = (EnumFacing)state.getValue(FACING);
		if(p.getHeldItemMainhand() != null && p.getHeldItemMainhand().getItem() == Items.FLINT_AND_STEEL){
			w.setBlockState(pos, FRSM_Blocks.furnace1b.getDefaultState().withProperty(FACING, ef));
			p.getHeldItemMainhand().damageItem(1, p);
			return true;
		}
		return false;
    }
    
    @Override
    public String getName(){
		return "furnace1";
	}

	
}