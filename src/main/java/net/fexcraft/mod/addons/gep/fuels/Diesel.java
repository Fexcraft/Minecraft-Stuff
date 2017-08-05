package net.fexcraft.mod.addons.gep.fuels;

import net.fexcraft.mod.fvtm.api.Fuel;
import net.minecraft.util.ResourceLocation;

public class Diesel implements Fuel {
	
	private static final ResourceLocation registryname = new ResourceLocation(/*"fvtm:*/"diesel");

	@Override
	public Fuel setRegistryName(ResourceLocation name){
		return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return registryname;
	}
	
}