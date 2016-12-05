package net.fexcraft.mod.famm.blocks;

import net.fexcraft.mod.famm.FAMM;
import net.fexcraft.mod.famm.util.FI;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class FAMMBLK extends Block implements IBlock {

    private String name = "a";
    
    public FAMMBLK(String name){
        super(Material.WOOD);
		setCreativeTab(FAMM.tabFAMM);
        this.setHarvestLevel("axe", 1);
        this.setHardness(1.0F);
        this.setResistance(10.0F);
        this.name = name;
        BlockUtil.register(FI.MODID, this);
        BlockUtil.registerFIB(this);
        BlockUtil.registerFIBRender(this);
    }
    
	public String getName(){
		return name;
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
	
}
