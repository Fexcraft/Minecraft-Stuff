package net.fexcraft.mod.frsm.blocks.palet;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R_F;
import net.fexcraft.mod.lib.api.block.öBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@öBlock(modid = FI.MODID, name = "palet1x1_2", tileentity = Palet1x1_2Entity.class)
public class Palet1x1_2 extends FBC_4R_F {
	
	public Palet1x1_2() {
    	super(Material.GLASS);this.setHarvestLevel("pickaxe", 1);
    	this.setHardness(1.0F);
    	this.setResistance(10.0F);
    	this.setCreativeTab(CD.BLOCKS);
	}
    
    @Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new Palet1x1_2Entity();
	}
	
}