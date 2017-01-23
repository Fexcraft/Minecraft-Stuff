package net.fexcraft.mod.frsm.blocks.laptop;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBN_4R;
import net.fexcraft.mod.lib.api.block.öBlock;
import net.minecraft.block.material.Material;

@öBlock(modid = FI.MODID, name = "laptop_white")
public class LaptopWhite extends FBN_4R {
	
	public LaptopWhite() {
		super(Material.GLASS);
		this.setHarvestLevel("axe", 1);
		this.setHardness(2.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.TECHNIC);
    }
	
}