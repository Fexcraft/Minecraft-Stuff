package net.fexcraft.mod.frsm.items.eatable;

import java.util.List;

import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class CupWithCacao extends ItemFood implements IItem{

	public CupWithCacao() {
		super(4, 0.4F, false);
		this.setMaxStackSize(6);
		this.setCreativeTab(CD.FOOD.getCreativeTab());
		ItemUtil.register(FI.MODID, this);
	}

	@Override
	public String getName(){
		return "cupWithCacao";
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced){
		tooltip.add("Refreshing cacao drink.");
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player){
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(10), 360));
		player.inventory.addItemStackToInventory(new ItemStack(FRSM_Items.cup, 1, 0));
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
	
}