package net.fexcraft.mod.extensions.ie.blocks;

import net.fexcraft.mod.extensions.ie.tileentities.CableType4CopperEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CableType4Copper extends CableType4{

	public CableType4Copper() {
		super();
	}

	@Override
	public String getName(){
		return "cabletype4_copper";
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new CableType4CopperEntity();
	}
	
}