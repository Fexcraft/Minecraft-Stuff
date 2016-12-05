package net.fexcraft.mod.fsmm.account;

import java.util.ArrayList;

import net.fexcraft.mod.fsmm.items.IMoneyItem;
import net.fexcraft.mod.fsmm.items.MoneyItems;
import net.fexcraft.mod.fsmm.util.Util;
import net.fexcraft.mod.lib.util.cls.Print;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemManager {
	
	public static float countMoneyInInventoryOf(EntityPlayer player){
		float value = 0.00F;
		for(int in = 0; in < 36; in++){
			ItemStack[] is = player.inventory.mainInventory;
			if(is[in] != null && is[in].getItem() instanceof IMoneyItem){
				value = value + (((IMoneyItem) is[in].getItem()).getWorth() * is[in].stackSize);
			}
		}
		return Util.round(value);
	}
	
	public static boolean hasSpace(EntityPlayer player, boolean countMoneyItemAsSpace){
		int i = 0;
		for(ItemStack stack : player.inventory.mainInventory){
			while(i >= 1){
				break;
			}
			if(stack == null){
				i++;
			}
			else if(stack.getItem() instanceof IMoneyItem && countMoneyItemAsSpace){
				i++;
			}
			else{
				continue;
			}
		}
		return i == 0 ? false : true;
	}
	
	public static void addToInventory(EntityPlayer player, float amount){
		float old = countMoneyInInventoryOf(player);
		amount += old;
		amount = Util.round(amount);
		removeFromInventory(player, old);
		ArrayList<Float> list = MoneyItems.getList();
		list = Util.reverse(list);
		for(int i = 0; i < list.size(); i++){
			while(amount - list.get(i) >= 0){
				amount = Util.round(amount);
				ItemStack stack = new ItemStack((Item)MoneyItems.getItem(list.get(i)), 1);
				if(hasSpace(player, false)){
					player.inventory.addItemStackToInventory(stack);
				}
				else{
					player.getEntityWorld().spawnEntityInWorld(new EntityItem(player.getEntityWorld(), player.posX, player.posY, player.posZ, stack));
				}
				amount -= list.get(i);
			}
			continue;
		}
		if(amount > 0){
			Print.chat(player, amount  + "F$ couldn't be added to inventory cause no matching items were found.");
		}
	}

	public static void removeFromInventory(EntityPlayer player, float amount){
		float old = countMoneyInInventoryOf(player);
		old -= amount;
		old = Util.round(old);
		if(old < 0){
			old = 0;
		}
		for(int i = 0; i < player.inventory.mainInventory.length; i++){
			if(player.inventory.mainInventory[i] == null){
				continue;
			}
			if(player.inventory.mainInventory[i].getItem() instanceof IMoneyItem){
				player.inventory.removeStackFromSlot(i);
			}
		}
		setInInventory(player, old);
	}
	
	public static void setInInventory(EntityPlayer player, float amount){
		for(int i = 0; i < player.inventory.mainInventory.length; i++){
			if(player.inventory.mainInventory[i] == null){
				continue;
			}
			if(player.inventory.mainInventory[i].getItem() instanceof IMoneyItem){
				player.inventory.removeStackFromSlot(i);
			}
		}
		
		ArrayList<Float> list = MoneyItems.getList();
		list = Util.reverse(list);
		for(int i = 0; i < list.size(); i++){
			while(amount - list.get(i) >= 0){
				amount = Util.round(amount);
				ItemStack stack = new ItemStack((Item)MoneyItems.getItem(list.get(i)), 1);
				if(hasSpace(player, false)){
					player.inventory.addItemStackToInventory(stack);
				}
				else{
					player.getEntityWorld().spawnEntityInWorld(new EntityItem(player.getEntityWorld(), player.posX, player.posY, player.posZ, stack));
				}
				amount -= list.get(i);
			}
			continue;
		}
		if(amount > 0){
			Print.chat(player, amount  + "F$ couldn't be added to inventory cause no matching items were found.");
		}
	}

}