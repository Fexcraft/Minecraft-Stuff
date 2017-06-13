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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

@fItem(modid = FI.MODID, name = "cupwithcacao")
public class CupWithCacao extends ItemFood {

	public CupWithCacao() {
		super(4, 0.4F, false);
		this.setMaxStackSize(6);
		this.setCreativeTab(CD.EATABLES);
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> tooltip, ITooltipFlag advanced){
		tooltip.add("Refreshing cacao drink.");
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player){
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(10), 360));
		player.inventory.addItemStackToInventory(new ItemStack(Registry.getItem("frsm:cup"), 1, 0));
	}
	
}