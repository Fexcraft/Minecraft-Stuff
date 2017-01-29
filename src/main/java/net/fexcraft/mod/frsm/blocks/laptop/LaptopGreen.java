package net.fexcraft.mod.frsm.blocks.laptop;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBN_4R;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.minecraft.block.material.Material;

@fBlock(modid = FI.MODID, name = "laptop_green")
public class LaptopGreen extends FBN_4R {
    
	public LaptopGreen() {
		super(Material.GLASS);
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(2.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.TECHNIC);
	}
	
}