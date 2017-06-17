package net.fexcraft.mod.fvm;

import net.fexcraft.mod.fvm.cmds.FvmCommand;
import net.fexcraft.mod.fvm.gui.FvmGuiHandler;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.fvm.util.FvmUpdateHandler;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.PacketHandler.PacketHandlerType;
import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.network.SimpleUpdateHandler;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Fex's Vehicle and Transportation Mod
 * A Modification adding a custom add-on part system to create customizable vehicles
 * and, <i>more</i>.
 * <br>
 * License: <a href="http://fexcraft.net/license?id=mods">http://fexcraft.net/license?id=mods</a>
 * @author Ferdinand
 *
 */
@Mod(modid = FVM.MODID, name = "Fex's Vehicle and Transportation Mod", version = FVM.VERSION, dependencies = "required-after:fcl")
public class FVM {
	
	@Mod.Instance(FVM.MODID)
	public static FVM INSTANCE;
	
	public static final String MODID = "fvm";
	public static final String PREFIX = Formatter.format("&0[&9FVM&0]&7 ");
	public static final String VERSION = "2.0-alpha11";
	
	@Mod.EventHandler
	public void init(FMLPreInitializationEvent event){
		Registry.registerAllBlocks(MODID);
		
		FvmResources.setup(event);
		FvmResources.scanForContent(event);
		if(event.getSide().isClient()){
			FvmResources.loadModels(event);
		}
		
		
		PermManager.setEnabled(MODID);
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new FvmGuiHandler());
		PacketHandler.registerListener(PacketHandlerType.NBT, Side.SERVER, new FvmGuiHandler.SReceiver());
		PacketHandler.registerListener(PacketHandlerType.NBT, Side.CLIENT, new FvmGuiHandler.CReceiver());
		//
		SimpleUpdateHandler.register("fvm", 1, VERSION);
		SimpleUpdateHandler.setUpdateMessage("fvm", PREFIX + "Update avaible! &3(" + SimpleUpdateHandler.getLatestVersionOf("fvm") + ")&7");
		FvmUpdateHandler.load();
		FvmUpdateHandler.register();
	}
	
	@Mod.EventHandler
	public void init(FMLPostInitializationEvent event){
		//
	}
	
	@Mod.EventHandler
	public void init(FMLServerStartingEvent event){
		event.registerServerCommand(new FvmCommand());
	}
	
}