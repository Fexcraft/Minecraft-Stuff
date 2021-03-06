package net.fexcraft.mod.famm.blocks;

import net.fexcraft.mod.famm.FAMM;
import net.fexcraft.mod.famm.util.FI;
import net.fexcraft.mod.lib.util.registry.RegistryUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class FAMMBLK extends Block {
	
    public FAMMBLK(String name){
        super(Material.WOOD);
		setCreativeTab(FAMM.tabFAMM);
        this.setHarvestLevel("axe", 1);
        this.setHardness(1.0F);
        this.setResistance(10.0F);
        RegistryUtil.get(FI.MODID).addBlock(name, this, null, 0, null);
    }
	
}
