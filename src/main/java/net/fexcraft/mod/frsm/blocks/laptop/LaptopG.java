package net.fexcraft.mod.frsm.blocks.laptop;

import java.util.List;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBC_4R;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.fexcraft.mod.lib.util.item.FIB;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class LaptopG extends FBC_4R {

	public LaptopG(){
    	super(Material.GLASS);
    	this.setHarvestLevel("pickaxe", 1);
    	this.setHardness(2.0F);
    	this.setResistance(32.0F);
    	this.setCreativeTab(CD.TECHNIC.getCreativeTab());
    	BlockUtil.register(FI.MODID, this);
    	BlockUtil.registerCustomFIB(new IB(this, this.getName(), this.getVariantAmount()));
	}
	
	public static class IB extends FIB{
		public IB(Block block, String name, int va){
			super(block, name, va);
		}
		
		@Override
		public void addInformation(ItemStack itemstack, EntityPlayer player, List ls, boolean par4){
			ls.add(CCS.GOLD + "Gold OS");
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new LaptopGEntity();
	}
	
	@Override
	public String getName(){
		return "laptopG";
	}

	//ADD ON BLOCK ACTIVATED CODE
}