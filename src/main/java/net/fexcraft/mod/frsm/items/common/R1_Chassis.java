package net.fexcraft.mod.frsm.items.common;

import java.util.List;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class R1_Chassis extends Item implements IItem{

	public R1_Chassis(){
		this.setMaxStackSize(16);
		this.setCreativeTab(CD.RC.getCreativeTab());
		ItemUtil.register(FI.MODID, this);
	}
	
	@Override
	public String getName(){
		return "r1_chassis";
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced){
		tooltip.add("Used to Craft T1R1B Robos.");
		tooltip.add("Has inbuild Tracks.");
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
	
}