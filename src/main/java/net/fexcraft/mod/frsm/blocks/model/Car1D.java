package net.fexcraft.mod.frsm.blocks.model;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@fBlock(modid = FI.MODID, name = "Car1D", tileentity = Car1DEntity.class)
public class Car1D extends FBC_4R {

	public Car1D() {
    	super(Material.GLASS);
    	this.setHarvestLevel("pickaxe", 1);
    	this.setHardness(1.0F);
    	this.setResistance(10.0F);
    	this.setCreativeTab(CD.MODELS);
	}
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
    	return new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new Car1DEntity();
	}
    
}