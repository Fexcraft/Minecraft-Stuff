package net.fexcraft.mod.frsm.blocks.slabs;

import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public  class GlassSlab extends Block implements IBlock{

	public GlassSlab() {
		super(Material.AIR);
		this.setCreativeTab(CD.DEV.getCreativeTab());
		//
	}
	
	@Override
	public String getName() {
		return null;
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
	
}