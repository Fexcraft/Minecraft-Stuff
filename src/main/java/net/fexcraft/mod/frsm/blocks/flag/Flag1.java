package net.fexcraft.mod.frsm.blocks.flag;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Flag1 extends FBC_4R {
	
	public Flag1() {
    	super(Material.IRON);
    	this.setHarvestLevel("axe", 1);
    	this.setHardness(2.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.FLAGS.getCreativeTab());
		BlockUtil.register(FI.MODID, this);
		BlockUtil.registerFIB(this);
	}
	
    @Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new Flag1Entity();
	}
	
	@Override
	public String getName() {
		return "flag1";
	}
}