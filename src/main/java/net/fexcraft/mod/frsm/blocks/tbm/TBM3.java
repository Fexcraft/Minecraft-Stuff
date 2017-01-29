package net.fexcraft.mod.frsm.blocks.tbm;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R_F;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

@fBlock(modid = FI.MODID, name = "tbm3", tileentity = TBM3.TE.class)
public class TBM3 extends FBC_4R_F {
	
	public TBM3() {
		super(Material.WOOD);
		this.setHarvestLevel("axe", 1);
		this.setHardness(1.0F);
		this.setResistance(10.0F);
    	this.setCreativeTab(CD.EXPERIMENTAL);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new TE();
	}
	    
	public class TE extends TileEntity {}
	
}