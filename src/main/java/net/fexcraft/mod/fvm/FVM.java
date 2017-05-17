package net.fexcraft.mod.fvm;

import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.fvm.util.FvmUpdateHandler;
import net.fexcraft.mod.lib.network.SimpleUpdateHandler;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
	public static final String VERSION = "1.1-alpha11";
	
	@Mod.EventHandler
	public void init(FMLPreInitializationEvent event){
		FvmResources.setup(event);
		FvmResources.scanForContent(event);
		
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		
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
	
}