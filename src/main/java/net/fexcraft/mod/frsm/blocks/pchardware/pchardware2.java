package net.fexcraft.mod.frsm.blocks.pchardware;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.lib.api.block.öBlock;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

@öBlock(modid = FI.MODID, name = "pchardware2", tileentity = PCHardware2Entity.class)
public class PCHardware2 extends FBC_4R {
    
    public PCHardware2() {
    	super(Material.GLASS);
    	this.setHarvestLevel("pickaxe", 1);
    	this.setHardness(3.0F);
    	this.setResistance(32.0F);
    	this.setCreativeTab(CD.TECHNIC);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new PCHardware2Entity();
	}
	
}