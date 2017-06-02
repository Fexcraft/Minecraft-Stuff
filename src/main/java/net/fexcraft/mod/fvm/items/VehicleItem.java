package net.fexcraft.mod.fvm.items;

import net.fexcraft.mod.fvm.FVM;
import net.fexcraft.mod.fvm.data.Vehicle;
import net.fexcraft.mod.fvm.util.FvmTabs;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.item.Item;

public class VehicleItem extends Item {
	
	private Vehicle type;
	
	public VehicleItem(Vehicle type){
		this.setCreativeTab(FvmTabs.VEHICLES);
		this.setHasSubtypes(true);
		this.setMaxStackSize(1);
		this.type = type;
		Registry.registerItemManually(FVM.MODID, "landvehicle_" + type.registryname, 0, null, this);
	}

	public static Item register(Vehicle material){
		return new VehicleItem(material);
	}
	
}