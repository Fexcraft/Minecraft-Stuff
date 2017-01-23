package net.fexcraft.mod.frsm.blocks.chair;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.lib.api.block.öBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemDye;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@öBlock(modid = FI.MODID, name = "officechair", tileentity = OfficechairEntity.class)
public class Officechair extends FBC_4R{
	
	public Officechair() {
    	super(Material.GLASS);
    	this.setHarvestLevel("axe", 1);
    	this.setHardness(2.0F);
    	this.setResistance(32.0F);
    	this.setCreativeTab(CD.BLOCKS);
	}
    	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new OfficechairEntity();
	}
	
	@Override
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(!w.isRemote){
    		if(!p.getHeldItemMainhand().isEmpty() && p.getHeldItemMainhand().getItem() instanceof ItemDye){
    			((OfficechairEntity)w.getTileEntity(pos)).applyColor(EnumDyeColor.byDyeDamage(p.getHeldItemMainhand().getMetadata()));
    		}
    		else{
    			((OfficechairEntity)w.getTileEntity(pos)).applyRotation();
    		}
    		return true;
    	}
		return false;
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
	}
	
}