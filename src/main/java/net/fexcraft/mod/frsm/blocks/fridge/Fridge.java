package net.fexcraft.mod.frsm.blocks.fridge;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@fBlock(modid = FI.MODID, name = "fridge", tileentity = FridgeTileEntity.class)
public class Fridge extends FBC_4R {
	
	public Fridge() {
		super(Material.IRON);
		this.setHarvestLevel("pickaxe", 1);
    	this.setHardness(5.0F);
    	this.setResistance(32.0F);
		this.setCreativeTab(CD.TECHNIC);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if(!world.isRemote){
        	FridgeTileEntity te = (FridgeTileEntity)world.getTileEntity(pos);
            te.setState(!te.getState());
            te.sendUpdatePacket();
        }
		return true;
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new FridgeTileEntity();
	}
	
}