package net.fexcraft.mod.fsu.server.modules.nvr;

import java.util.TreeMap;

import net.fexcraft.mod.fsu.server.modules.IModule;
import net.fexcraft.mod.fsu.server.modules.fModule;
import net.fexcraft.mod.fsu.server.modules.nvr.data.Chunk;
import net.fexcraft.mod.fsu.server.modules.nvr.events.ChunkEvents;
import net.fexcraft.mod.lib.util.common.Sql;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

@fModule(config_description = "NVR System", def_enabled = false, id = "nvr")
public class NVR implements IModule<NVR> {
	
	public static final String PLAYERDATA = "NVRPD", ADMINPERM = "fsu.nvr.admin";
	public static final String DEF_UUID = "66e70cb7-1d96-487c-8255-5c2d7a2b6a0e";
	private static NVR instance;
	private boolean enabled;
	public static final Sql SQL = new Sql(new String[]{"root", "genericpass3356-example", "3306", Static.dev() ? "fexcraft.net" : "localhost", "fsu_nvr"});/*ignore*/
	//
	public static TreeMap<DK, Chunk> chunks = new TreeMap<DK, Chunk>();
	
	public NVR(){
		instance = this;
	}

	@Override
	public String getId(){
		return "nvr";
	}

	@Override
	public void preInit(FMLPreInitializationEvent event){
		
	}
	@Override
	public void init(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new ChunkEvents());
		/*MinecraftForge.EVENT_BUS.register(new PlayerEvents());
		MinecraftForge.EVENT_BUS.register(new ChatEvents());
		MinecraftForge.EVENT_BUS.register(new TimeEvents());*/
		//PlayerPerms.addAdditionalData(PlayerData.class);
		
		//MappingUtil.init();
	}

	@Override
	public void postInit(FMLPostInitializationEvent event){
		
	}

	@Override
	public void serverStart(FMLServerStartingEvent event){
		/*event.registerServerCommand(new ConsoleCommand());
		event.registerServerCommand(new ChunkCommand());
		event.registerServerCommand(new ProvinceCommand());*/
	}

	@Override
	public void serverStop(FMLServerStoppingEvent event){
		NVR.save();
	}

	@Override
	public void setEnabled(boolean bool){
		enabled = bool;
	}

	@Override
	public boolean isEnabled(){
		return enabled;
	}

	@Override
	public NVR getInstace(){
		return instance;
	}

	public static void save(){
		
		//MappingUtil.save();
	}
	
	/** Double Key */
	public static class DK implements Comparable{
		private final int x, z;
		public DK(int i, int j){
			x = i;
			z = j;
		}
		@Override
		public boolean equals(Object obj){
			return obj instanceof DK ? (((DK)obj).x == x && ((DK)obj).z == z) : false;
		}
		@Override
		public int compareTo(Object o){
			if(o instanceof DK){
				int i = Integer.compare(((DK)o).x, x);
				return i == 0 ? Integer.compare(((DK)o).z, z) : i;
			}
			else return -1;
			//return obj instanceof DK ? (((DK)o).x == x && ((DK)o).z == z) ? 1 : -1 : -1;
		}
	}
	
}