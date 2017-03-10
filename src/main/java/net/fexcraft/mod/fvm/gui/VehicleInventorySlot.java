package net.fexcraft.mod.fvm.gui;

import java.util.ArrayList;

import net.fexcraft.mod.fvm.items.VehicleItem;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class VehicleInventorySlot extends Slot {
	
	private ArrayList<String> disc = new ArrayList<String>();
	
	public VehicleInventorySlot(ArrayList<String> type, IInventory inventoryIn, int index, int xPosition, int yPosition){
		super(inventoryIn, index, xPosition, yPosition);
		if(type != null && type instanceof ArrayList){
			disc = type;
		}
	}
    public boolean isItemValid(ItemStack stack){
    	Print.debug("DEBUG: " + stack.getItem().getRegistryName());
    	if(disc.size() > 0){
    		boolean found = false;
    		for(String s : disc){
    			if(s.equals(stack.getItem().getRegistryName().toString())){
    				found = true;
    				break;
    			}
    		}
    		return found;
    	}
    	if(stack.getItem() instanceof VehicleItem){
    		return false;
    	}
    	return true;
    }
    
}