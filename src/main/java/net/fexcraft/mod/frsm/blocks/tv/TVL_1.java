package net.fexcraft.mod.frsm.blocks.tv;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R_H;
import net.fexcraft.mod.frsm.util.block.FRSMTE;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TVL_1 extends FBC_4R_H {
    
	public TVL_1() {
		super(Material.GRASS);
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(3.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.TECHNIC.getCreativeTab());
		BlockUtil.register(FI.MODID, this);
		BlockUtil.registerFIB(this);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TE();
	}

	public static class TE extends FRSMTE{}
	
	@Override
	public String getName(){
		return "TVL_1";
	}
	
}