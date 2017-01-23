package net.fexcraft.mod.frsm.blocks.asphalt;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.lib.api.block.öBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

@öBlock(modid = FI.MODID, name = "asphaltFull")
public class AsphaltFull extends Block {
	
	public AsphaltFull(){
        super(Material.IRON);
        this.setHarvestLevel("pickaxe", 0);
        this.setHardness(50.0F);
        this.setResistance(300.0F);
        this.setCreativeTab(CD.STREETS);
    }
	
}