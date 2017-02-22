package net.fexcraft.mod.fvm;

import net.fexcraft.mod.fvm.entities.EntityLandVehicle;
import net.fexcraft.mod.fvm.entities.RenderLandVehicle;
import net.fexcraft.mod.fvm.gui.FvmGuiHandler;
import net.fexcraft.mod.fvm.items.PartItem;
import net.fexcraft.mod.fvm.items.VehicleItem;
import net.fexcraft.mod.fvm.network.FvmPacketHandler;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.fvm.util.KeyHandler;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(modid = FvmResources.MODID, name = "Fex's Vehicle and Transportation Mod (It's a parasite, isn't it?)", version = FVM.VERSION, dependencies = "required-after:fcl")
public class FVM {
	
	@Mod.Instance
	public static FVM INSTANCE;
	
	public static final String VERSION = "1.0";
	
	@Mod.EventHandler
	public void init(FMLPreInitializationEvent event){
		Registry.registerAllBlocks(FvmResources.MODID);
		Registry.registerAllItems(FvmResources.MODID);
		Registry.registerAllEntities(FvmResources.MODID);
		
		int id = 0;
    	EntityRegistry.registerModEntity(new ResourceLocation(FvmResources.MODID, "landvehicle"), EntityLandVehicle.class, "landvehicle", id++, INSTANCE, 256, 2, true);
		
    	FvmResources.setup(event);
		FvmResources.scanForContent(event);
		
		
		if(event.getSide().isClient()){
			PartItem.reRegisterItemModels();
			VehicleItem.reRegisterItemModels();
			RenderingRegistry.registerEntityRenderingHandler(EntityLandVehicle.class, RenderLandVehicle::new);
		}
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new FvmGuiHandler());
		
		MinecraftForge.EVENT_BUS.register(new KeyHandler());
		
	}
	
	@Mod.EventHandler
	public void init(FMLPostInitializationEvent event){
		FvmResources.FFMM = Loader.isModLoaded("flansmod");
		FvmPacketHandler.initialize();
	}
	
}