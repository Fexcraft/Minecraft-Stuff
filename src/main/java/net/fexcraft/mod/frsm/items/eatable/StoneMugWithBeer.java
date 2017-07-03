package net.fexcraft.mod.frsm.items.eatable;

import net.fexcraft.mod.frsm.util.CD;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.lib.api.item.fItem;
import net.fexcraft.mod.lib.util.registry.RegistryUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@fItem(modid = FI.MODID, name = "stonemugwithbeer")
public class StoneMugWithBeer extends ItemFood {

	public StoneMugWithBeer(){
		super(4, 0.4F, false);
		this.setMaxStackSize(4);
		this.setCreativeTab(CD.EATABLES);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player){
		player.inventory.addItemStackToInventory(new ItemStack(RegistryUtil.getItem("frsm:stonemug"), 1, 0));
	}
	
}