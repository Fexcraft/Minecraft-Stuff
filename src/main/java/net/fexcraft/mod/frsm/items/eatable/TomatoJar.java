package net.fexcraft.mod.frsm.items.eatable;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.fItem;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@fItem(modid = FI.MODID, name = "tomatojar")
public class TomatoJar extends ItemFood {

	public TomatoJar(){
		super(2, 0.4F, true);
		this.setMaxStackSize(16);
		this.setCreativeTab(CD.EATABLES);
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> tooltip, ITooltipFlag advanced){
		tooltip.add("Filled with Tomatoes.");
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player){
		player.inventory.addItemStackToInventory(new ItemStack(Registry.getItem("frsm:jar"), 1, 0));
	}
	
}