package net.fexcraft.mod.fvm.items;

import net.fexcraft.mod.fvm.FVM;
import net.fexcraft.mod.fvm.data.Vehicle;
import net.fexcraft.mod.fvm.util.FvmTabs;
import net.fexcraft.mod.lib.util.registry.RegistryUtil;
import net.minecraft.item.Item;

public class VehicleItem extends Item {
	
	private Vehicle type;
	
	public VehicleItem(Vehicle type){
		this.setCreativeTab(FvmTabs.VEHICLES);
		this.setHasSubtypes(true);
		this.setMaxStackSize(1);
		this.type = type;
		RegistryUtil.get(FVM.MODID).addItem("landvehicle_" + type.registryname, this, 0, null);
	}

	public static Item register(Vehicle material){
		return new VehicleItem(material);
	}

	public Vehicle getVehicle(){
		return type;
	}
	
}