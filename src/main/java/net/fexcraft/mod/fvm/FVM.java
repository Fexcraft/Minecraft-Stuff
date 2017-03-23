package net.fexcraft.mod.fvm;

import net.fexcraft.mod.fvm.data.RecipeObject;
import net.fexcraft.mod.fvm.entities.EntityLandVehicle;
import net.fexcraft.mod.fvm.entities.RenderLandVehicle;
import net.fexcraft.mod.fvm.gui.FvmGuiHandler;
import net.fexcraft.mod.fvm.gui.Receiver;
import net.fexcraft.mod.fvm.network.FvmPacketHandler;
import net.fexcraft.mod.fvm.util.FvmPerms;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.fvm.util.KeyHandler;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.SimpleUpdateHandler;
import net.fexcraft.mod.lib.network.PacketHandler.PacketHandlerType;
import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.util.common.Formatter;
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
import net.minecraftforge.fml.relauncher.Side;

/**
 * Fex's Vehicle Mod
 * A Modification adding a custom add-on part system to create customizable vehicles.
 * Currently makes use of other mod's entities, although can also run stand-alone,
 * but then only the construction and display blocks are available.
 * 
 * License: http://fexcraft.net/license?id=mods
 * @author Ferdinand
 *
 */
@Mod(modid = FvmResources.MODID, name = "Fex's Vehicle and Transportation Mod (It's a parasite, isn't it?)", version = FVM.VERSION, dependencies = "required-after:fcl")
public class FVM {
	
	@Mod.Instance
	public static FVM INSTANCE;
	
	public static final String PREFIX = Formatter.format("&0[&9FVM&0]&7 ");
	public static final String VERSION = "1.0-alpha4";
	
	@Mod.EventHandler
	public void init(FMLPreInitializationEvent event){
		Registry.registerAllBlocks(FvmResources.MODID);
		Registry.registerAllItems(FvmResources.MODID);
		Registry.registerAllEntities(FvmResources.MODID);
		
		int id = 0;
    	EntityRegistry.registerModEntity(new ResourceLocation(FvmResources.MODID, "landvehicle"), EntityLandVehicle.class, "landvehicle", id++, INSTANCE, 256, 2, true);
		
    	FvmResources.setup(event);
		FvmResources.scanForContent(event);
		RecipeObject.registerRecipes();
		
		if(event.getSide().isClient()){
			RenderingRegistry.registerEntityRenderingHandler(EntityLandVehicle.class, RenderLandVehicle::new);
		}
		
		//PermStuff
		PermManager.setEnabled(FvmResources.MODID);
		FvmPerms.register();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new FvmGuiHandler());
		
		if(event.getSide().isClient()){
			MinecraftForge.EVENT_BUS.register(new KeyHandler());
		}
		
		SimpleUpdateHandler.register("fvm", 1, VERSION);
		SimpleUpdateHandler.setUpdateMessage("fvm", PREFIX + "Update avaible! &3(" + SimpleUpdateHandler.getLatestVersionOf("fvm") + ")&7");
		PacketHandler.registerListener(PacketHandlerType.JSON, Side.SERVER, new Receiver());
	}
	
	@Mod.EventHandler
	public void init(FMLPostInitializationEvent event){
		FvmResources.FFMM = Loader.isModLoaded("flansmod");
		FvmPacketHandler.initialize();
	}
	
}