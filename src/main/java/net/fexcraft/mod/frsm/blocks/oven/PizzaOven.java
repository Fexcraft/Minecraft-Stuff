package net.fexcraft.mod.frsm.blocks.oven;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

@fBlock(modid = FI.MODID, name = "electric_pizza_oven", tileentity = PizzaOvenEntity.class)
public class PizzaOven extends FBC_4R {

	public PizzaOven() {
		super(Material.IRON);
		this.setCreativeTab(CD.TECHNIC);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new PizzaOvenEntity();
	}
	
}