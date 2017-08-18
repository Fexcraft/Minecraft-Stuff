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
	
}