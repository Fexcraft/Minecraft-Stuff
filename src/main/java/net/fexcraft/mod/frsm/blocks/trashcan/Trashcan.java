package net.fexcraft.mod.frsm.blocks.trashcan;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R_F;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

@fBlock(modid = FI.MODID, name = "trashcan", tileentity = TrashcanEntity.class)
public class Trashcan extends FBC_4R_F {

	public Trashcan(){
		super(Material.ANVIL);
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(5.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.BLOCKS);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TrashcanEntity();
	}
	
}