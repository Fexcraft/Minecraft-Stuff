package net.fexcraft.mod.addons.gep.fuels;

import net.fexcraft.mod.fvtm.api.Fuel;
import net.minecraft.util.ResourceLocation;

public class Gasoline implements Fuel {
	
	private static final ResourceLocation registryname = new ResourceLocation(/*"fvtm:*/"fvtm:gasoline");

	@Override
	public Fuel setRegistryName(ResourceLocation name){
		return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return registryname;
	}
	
}