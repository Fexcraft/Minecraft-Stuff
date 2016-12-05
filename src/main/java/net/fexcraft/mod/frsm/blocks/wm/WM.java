package net.fexcraft.mod.frsm.blocks.wm;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R_F;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class WM extends FBC_4R_F {
	
	public WM() {
		super(Material.IRON);
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(5.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.TECHNIC.getCreativeTab());
		BlockUtil.register(FI.MODID, this);
		BlockUtil.registerFIB(this);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new WMEntity();
	}
	
	@Override
	public String getName() {
		return "washingmashine";
	}
}