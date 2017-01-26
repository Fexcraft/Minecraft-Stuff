package net.fexcraft.mod.frsm.blocks.stove;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R_F;
import net.fexcraft.mod.lib.api.block.öBlock;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

@öBlock(modid = FI.MODID, name = "stove", tileentity = StoveEntity.class)
public class Stove extends FBC_4R_F {
	
	public Stove(){
    	super(Material.GLASS);
    	this.setHarvestLevel("pickaxe", 1);
    	this.setHardness(3.0F);
    	this.setResistance(32.0F);
    	this.setCreativeTab(CD.TECHNIC);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new StoveEntity();
	}
	
}