package net.fexcraft.mod.frsm.blocks.laptop;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.frsm.util.CCS;
import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.block.FBN_4R;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.util.registry.ItemBlock16;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@fBlock(modid = FI.MODID, name = "laptop_black", item = LaptopBlack.IB.class)
public class LaptopBlack extends FBN_4R {
    
	public LaptopBlack() {
		super(Material.GLASS);
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(2.0F);
		this.setResistance(32.0F);
		this.setCreativeTab(CD.TECHNIC);
	}
	
	public static class IB extends ItemBlock16 {
		public IB(Block block) {
			super(block);
		}

		@Override
		public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> tooltip, ITooltipFlag advanced){
			tooltip.add(CCS.AQUA + "Finux OS");
			tooltip.add(CCS.DGRAY + "Unknown Version");
			tooltip.add(CCS.DGRAY + "Upgraded");
		}
	}
	
}