package net.fexcraft.mod.frsm.blocks.chimney;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ChimneyStonebrick extends ChimneyBase {
    private String name = "chimney1";
    
	public ChimneyStonebrick() {
		super(Material.ROCK);
		this.setCreativeTab(CD.BLOCKS.getCreativeTab());
		BlockUtil.register(FI.MODID, this);
		BlockUtil.registerFIB(this);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new ChimneyStonebrickEntity();
	}
	
	@Override
	public String getName(){
		return "chimney1";
	}

}