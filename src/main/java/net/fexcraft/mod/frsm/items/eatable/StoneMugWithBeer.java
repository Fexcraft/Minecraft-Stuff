package net.fexcraft.mod.frsm.items.eatable;

import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.custom.CT.CD;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class StoneMugWithBeer extends ItemFood implements IItem{

	public StoneMugWithBeer() {
		super(4, 0.4F, false);
		this.setMaxStackSize(4);
		this.setCreativeTab(CD.FOOD.getCreativeTab());
		ItemUtil.register(FI.MODID, this);
	}

	@Override
	public String getName(){
		return "stoneMugWithBeer";
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player){
		player.inventory.addItemStackToInventory(new ItemStack(FRSM_Items.stone_mug, 1, 0));
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
	
}