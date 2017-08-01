package net.fexcraft.mod.fvtm.impl;

import java.io.File;

import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.LandVehicle;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Part;
import net.minecraftforge.event.RegistryEvent;

public abstract class HybridAddon implements Addon {

	private File file;
	
	public HybridAddon(File file){
		this.file = file;
	}
	
	public abstract void regMaterials(RegistryEvent.Register<Material> event);

	public abstract void regAttributes(RegistryEvent.Register<Attribute> event);
	
	public abstract void regParts(RegistryEvent.Register<Part> event);
	
	public abstract void regLandVehicles(RegistryEvent.Register<LandVehicle> event);
	
}