package net.fexcraft.mod.extensions.fve.blocks;

import net.fexcraft.mod.extensions.fve.FVE;
import net.fexcraft.mod.extensions.fve.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


/**
 * @author Ferdinand
 * @comment FVE Block Base
 */
public class FVEBB extends FBC_4R {
	
	private String cname;
	static TileEntity te;
	
    public FVEBB(String name) {
    	super(Material.IRON);
    	cname = name;
    	this.setCreativeTab(FVE.tabFVE);
    	BlockUtil.register(FI.MODID, this);
    	BlockUtil.registerFIB(this);
    	
    	this.setHarvestLevel("pickaxe", 1);
    	this.setHardness(5.0F);
    	this.setResistance(32.0F);
	}
	
	public String getName(){
		return cname;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return te;
	}
}