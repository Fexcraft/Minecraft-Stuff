package net.fexcraft.mod.fvtm.api;

import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface Fuel extends IForgeRegistryEntry<Fuel> {
    
	@Override
	public default Class<Fuel> getRegistryType(){
		return Fuel.class;
	}
	
	public String getName();
	
	public boolean isValidFuelContainer(ItemStack stack);
	
	// Fuel - Item //
	
	public static interface FuelItem {
		
		public Fuel getFuel(ItemStack stack);
		
		public double getContent(ItemStack stack);
		
		public void setContent(ItemStack stack, double amount);
		
		public int maxCapacity(ItemStack stack);
		
	}
	
}