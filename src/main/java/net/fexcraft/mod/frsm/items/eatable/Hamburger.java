package net.fexcraft.mod.frsm.items.eatable;

import java.util.List;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.fItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

@fItem(modid = FI.MODID, name = "hamburger")
public class Hamburger extends ItemFood {

	public Hamburger() {
		super(9, 0.9F, true);
		this.setMaxStackSize(4);
		this.setCreativeTab(CD.EATABLES);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced){
		tooltip.add("Fast food, fastly programmed.");
	}
	
}