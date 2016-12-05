package net.fexcraft.mod.frsm.blocks.common;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DecoBlock2 extends Block implements IBlock{

    public DecoBlock2(){
        super(Material.WOOD);
        this.setHarvestLevel("axe", 1);
        this.setHardness(1.0F);
        this.setResistance(10.0F);
        this.setCreativeTab(CD.BLOCKS.getCreativeTab());
        BlockUtil.register(FI.MODID, this);
        BlockUtil.registerFIB(this);
    }
    
    @Override
    public String getName(){
    	return "decoBlock2";
    }

	@Override
	public int getVariantAmount() {
		return default_variant;
	}
    
}