package net.fexcraft.mod.extensions.ce.blocks;

import net.fexcraft.mod.extensions.ce.CE;
import net.fexcraft.mod.frsm.util.block.ETE;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CEBBC extends FBC_4R {
	
    private String name = "CEBB";
    
	public CEBBC(String name) {
		super(Material.IRON);
		this.setCreativeTab(CE.tabCE);
		this.name = name;

		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(1.0F);
		this.setResistance(32.0F);
		
		BlockUtil.register("frsm_ce", this);
		BlockUtil.registerFIB(this);
		BlockUtil.registerFIBRender(this);
	}
       
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
        
	public String getName(){
		return name;
	}
        
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new ETE();
	}
	
}