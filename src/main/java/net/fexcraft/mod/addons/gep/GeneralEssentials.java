package net.fexcraft.mod.addons.gep;

import java.io.File;

import net.fexcraft.mod.addons.gep.attributes.*;
import net.fexcraft.mod.addons.gep.fuels.*;
import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Fuel;
import net.fexcraft.mod.fvtm.api.LandVehicle;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.impl.HybridAddon;
import net.minecraftforge.event.RegistryEvent.Register;

public class GeneralEssentials extends HybridAddon {

	public GeneralEssentials(File file){
		super(file);
	}

	@Override
	public void regMaterials(Register<Material> event){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void regAttributes(Register<Attribute> event){
		event.getRegistry().register(new EngineAttribute());
	}

	@Override
	public void regParts(Register<Part> event){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void regLandVehicles(Register<LandVehicle> event){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void regFuels(Register<Fuel> event){
		event.getRegistry().registerAll(new Gasoline(), new Diesel());
	}

	@Override
	public boolean skipDefaultRegistryMethods(){
		return false;
	}
	
}