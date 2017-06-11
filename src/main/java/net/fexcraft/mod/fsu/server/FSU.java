package net.fexcraft.mod.fsu.server;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import net.fexcraft.mod.fsu.server.modules.IModule;
import net.fexcraft.mod.fsu.server.modules.fModule;
import net.fexcraft.mod.fsu.server.network.WebIO;
import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.perms.PermissionNode;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.discovery.ASMDataTable.ASMData;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

//@Mod(modid = "fsu-server", name = "Fexcraft Server Utilities", version="x", acceptableRemoteVersions = "*", serverSideOnly = true, dependencies = "required-after:fcl")
public class FSU {
	
	@Mod.Instance("fsu-server")
	public static FSU INSTANCE;
	
	public static boolean NRR, ESC;
	public static int PORT;
	public static boolean WORLD;
	
	private static final Map<String, IModule> modules = new TreeMap<String, IModule>();
	
	@Mod.EventHandler
	public static void preInit(FMLPreInitializationEvent event){
		PermManager.setEnabled("fsu-server");
		Configuration config = new Configuration(event.getSuggestedConfigurationFile(), "1.0", true);	
		config.load();
		config.setCategoryRequiresMcRestart("Modules", true);
		config.setCategoryComment("Modules", "FSU Modules");
		config.setCategoryRequiresMcRestart("Network", true);
		config.setCategoryComment("Network", "FSU Network Settings");
		Set<ASMData> data = event.getAsmData().getAll(fModule.class.getCanonicalName());
		Print.debug("Scanning for Modules.");
		for(ASMData entry : data){
			try{
				Class<? extends IModule> clazz = (Class<? extends IModule>)Class.forName(entry.getClassName());
				IModule module = clazz.newInstance();
				fModule anno = clazz.getAnnotation(fModule.class);
				modules.put(anno.id(), module);
				module.setEnabled(config.getBoolean(module.getId(), "Modules", anno.def_enabled(), anno.config_description()));
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		PORT = config.getInt("port", "Network", 8136, 0, 10000, "Http Server Port");	
		config.save();
		
		
		for(IModule module : modules.values()){
			if(module.isEnabled()){
				module.preInit(event);
			}
		}
	}

	@Mod.EventHandler
	public static void init(FMLInitializationEvent event){
		PermManager.add("general.chat_message.send", PermissionNode.Type.BOOLEAN, true, true);
		for(IModule module : modules.values()){
			if(module.isEnabled()){
				module.init(event);
			}
		}
	}
	
	@Mod.EventHandler
	public static void serverLoad(FMLServerStartingEvent event){
		for(IModule module : modules.values()){
			if(module.isEnabled()){
				module.serverStart(event);
			}
		}
	}
	
	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event){
		WebIO.launch();
		
		for(IModule module : modules.values()){
			if(module.isEnabled()){
				module.postInit(event);
			}
		}
	}
	
	@Mod.EventHandler
	public static void serverStop(FMLServerStoppingEvent event){
		for(IModule module : modules.values()){
			if(module.isEnabled()){
				module.serverStop(event);
			}
		}
		WebIO.end(0);
	}
	
	public static boolean isModuleEnabled(String is){
		IModule module = modules.get(is);
		return module == null ? false : module.isEnabled();
	}
	
}