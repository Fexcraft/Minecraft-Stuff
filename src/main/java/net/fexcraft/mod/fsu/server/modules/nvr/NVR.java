package net.fexcraft.mod.fsu.server.modules.nvr;

import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.TreeMap;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fsu.server.modules.IModule;
import net.fexcraft.mod.fsu.server.modules.fModule;
import net.fexcraft.mod.fsu.server.modules.nvr.data.*;
import net.fexcraft.mod.fsu.server.modules.nvr.events.ChatEvents;
import net.fexcraft.mod.fsu.server.modules.nvr.events.ChunkEvents;
import net.fexcraft.mod.fsu.server.modules.nvr.events.PlayerEvents;
import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.perms.PermissionNode.Type;
import net.fexcraft.mod.lib.perms.player.PlayerPerms;
import net.fexcraft.mod.lib.util.common.Sql;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
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
	public static Sql SQL;
	//
	public static TreeMap<DK, Chunk> chunks = new TreeMap<DK, Chunk>();
	public static DataMap<Integer, District> districts = new DataMap<Integer, District>(-1);
	public static DataMap<Integer, Municipality> municipalities = new DataMap<Integer, Municipality>(-1);
	public static DataMap<Integer, Province> provinces = new DataMap<Integer, Province>(-1);
	public static DataMap<Integer, Nation> nations = new DataMap<Integer, Nation>(-1);
	
	public NVR(){
		instance = this;
	}

	@Override
	public String getId(){
		return "nvr";
	}

	@Override
	public void preInit(FMLPreInitializationEvent event){
		File file = new File(event.getModConfigurationDirectory(), "/fsu-nvr.sql");
		JsonObject obj = JsonUtil.get(file);
		String user = JsonUtil.getIfExists(obj, "user", "nvrusr");
		String pass = JsonUtil.getIfExists(obj, "password", "null");
		JsonUtil.write(file, obj);
		SQL = new Sql(new String[]{user, pass, "3306", Static.dev() ? "fexcraft.net" : "localhost", "fsu_nvr"});
		Launch.classLoader.addClassLoaderExclusion("com.mysql.");
		//
		PermManager.add(ADMINPERM, Type.BOOLEAN, false, true);
	}
	@Override
	public void init(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new ChunkEvents());
		MinecraftForge.EVENT_BUS.register(new PlayerEvents());
		MinecraftForge.EVENT_BUS.register(new ChatEvents());
		/*MinecraftForge.EVENT_BUS.register(new TimeEvents());*/
		PlayerPerms.addAdditionalData(Player.class);
		
		//MappingUtil.init();
	}

	@Override
	public void postInit(FMLPostInitializationEvent event){
		ArrayList<Integer> list;
		ResultSet set;
		try{
			//Nations
			set = SQL.query("SELECT id FROM nations ORDER BY id ASC;");
			list = new ArrayList<Integer>();
			while(set.next()){
				list.add(set.getInt("id"));
			}
			for(int i : list){
				Nation nat = new Nation(i);
				this.nations.put(i, nat);
			}
			
			//Provinces
			set = SQL.query("SELECT id FROM provinces;");
			list = new ArrayList<Integer>();
			while(set.next()){
				list.add(set.getInt("id"));
			}
			for(int i : list){
				Province prov = new Province(i);
				this.provinces.put(i, prov);
			}
			
			//Municipalities
			set = SQL.query("SELECT id FROM municipalities;");
			list = new ArrayList<Integer>();
			while(set.next()){
				list.add(set.getInt("id"));
			}
			for(int i : list){
				Municipality muni = new Municipality(i);
				this.municipalities.put(i, muni);
			}
			
			//Districts
			set = SQL.query("SELECT id FROM districts;");
			list = new ArrayList<Integer>();
			while(set.next()){
				list.add(set.getInt("id"));
			}
			for(int i : list){
				District disc = new District(i);
				this.districts.put(i, disc);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			Static.stop();
		}
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
		chunks.forEach((key, value) -> {
			value.save(SQL);
		});
		districts.forEach((key, value) -> {
			value.save(SQL);
		});
		municipalities.forEach((key, value) ->{
			value.save(SQL);
		});
		provinces.forEach((key, value) ->{
			value.save(SQL);
		});
		nations.forEach((key, value) ->{
			value.save(SQL);
		});
		//MappingUtil.save();
		
		
		try{
			SQL.disconnect();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static final Player getPlayerData(EntityPlayer player){
		return (Player)PermManager.getPlayerPerms(player).getAdditionalData(PLAYERDATA);
	}

	public static Player getPlayerData(String string){
		EntityPlayerMP player = Static.getServer().getPlayerList().getPlayerByUsername(string);
		if(player != null){
			return getPlayerData(player);
		}
		return null;
	}
	
	/** Double Key */
	public static class DK implements Comparable {
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
		public int x(){return x;}
		public int z(){return z;}
	}
	
	public static class DataMap<K, V> extends TreeMap<K, V>{
		private final int def;
		public DataMap(int i){
			this.def = i;
		}
		@Override
		public V get(Object k){
			return containsKey(k) ? super.get(k) : super.get(def);
		}
	}

	public static Chunk getChunk(World world, BlockPos pos) {
		net.minecraft.world.chunk.Chunk chunk = world.getChunkFromBlockCoords(pos);
		return chunks.get(new DK(chunk.xPosition, chunk.zPosition));
	}
	
}