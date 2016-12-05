package net.fexcraft.mod.frsm.blocks.asphalt;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class AsphaltFull extends Block implements IBlock {
	
	public AsphaltFull(){
        super(Material.IRON);
        this.setHarvestLevel("pickaxe", 0);
        this.setHardness(50.0F);
        this.setResistance(300.0F);
        this.setCreativeTab(CD.STREETS.getCreativeTab());
        BlockUtil.register(FI.MODID, this);
        BlockUtil.registerFIB(this);
    }
    
    @Override
    public String getName(){
    	return "asphaltFull";
    }

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
}