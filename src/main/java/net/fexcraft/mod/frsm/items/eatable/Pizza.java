package net.fexcraft.mod.frsm.items.eatable;

import java.util.List;

import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class Pizza extends ItemFood implements IItem{

	public Pizza() {
		super(10, 1F, true);
		this.setMaxStackSize(1);
		this.setCreativeTab(CD.FOOD.getCreativeTab());
		ItemUtil.register(FI.MODID, this);
	}

	@Override
	public String getName(){
		return "pizza";
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced){
		tooltip.add("Default.");
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
	
}