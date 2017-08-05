package net.fexcraft.mod.fvtm.api;

import net.minecraftforge.registries.IForgeRegistryEntry;

public interface Fuel extends IForgeRegistryEntry<Fuel> {
    
	@Override
	public default Class<Fuel> getRegistryType(){
		return Fuel.class;
	}
	
}