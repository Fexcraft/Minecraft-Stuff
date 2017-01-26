package net.fexcraft.mod.frsm.blocks.window;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.lib.api.block.öBlock;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

@öBlock(modid = FI.MODID, name = "window1", tileentity = WindowEntity.class)
public class Window extends FBC_4R {
	
	public Window() {
		super(Material.GLASS);
		this.setHarvestLevel("axe", 1);
		this.setHardness(1.0F);
		this.setResistance(10.0F);
		this.setCreativeTab(CD.BLOCKS);
	}
    
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new WindowEntity();
	}
	
}