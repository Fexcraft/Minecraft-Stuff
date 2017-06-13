package net.fexcraft.mod.frsm.items.eatable;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.fItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@fItem(modid = FI.MODID, name = "pizza")
public class Pizza extends ItemFood {

	public Pizza() {
		super(10, 1F, true);
		this.setMaxStackSize(1);
		this.setCreativeTab(CD.EATABLES);
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> tooltip, ITooltipFlag advanced){
		tooltip.add("Default.");
	}
	
}