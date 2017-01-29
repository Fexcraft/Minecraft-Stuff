package net.fexcraft.mod.frsm.blocks.common;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

@fBlock(modid = FI.MODID, name = "stoneSlabPillar")
public class StoneSlabPillar extends Block {
	
	public StoneSlabPillar(){
        super(Material.ROCK);
        this.setHarvestLevel("pick", 1);
        this.setHardness(1.0F);
        this.setResistance(10.0F);
		this.setCreativeTab(CD.BLOCKS);
    }
	
}