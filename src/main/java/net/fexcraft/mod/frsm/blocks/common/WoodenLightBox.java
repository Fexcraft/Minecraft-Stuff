package net.fexcraft.mod.frsm.blocks.common;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.block.öBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

@öBlock(modid = FI.MODID, name = "woodenlightbox")
public class WoodenLightBox extends Block {
	
    public WoodenLightBox(){
        super(Material.WOOD);
        this.setLightLevel(0.6F);
        this.setHarvestLevel("axe", 1);
        this.setHardness(1.0F);
        this.setResistance(10.0F);
		this.setCreativeTab(CD.BLOCKS);
    }
	
}