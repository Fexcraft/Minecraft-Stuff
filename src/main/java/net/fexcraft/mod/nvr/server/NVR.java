package net.fexcraft.mod.nvr.server;

import java.io.File;
import java.util.TreeMap;

import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.perms.player.PlayerPerms;
import net.fexcraft.mod.lib.util.common.Sql;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.lang.ArrayList;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.nvr.server.data.Chunk;
import net.fexcraft.mod.nvr.server.data.District;
import net.fexcraft.mod.nvr.server.data.DoubleKey;
import net.fexcraft.mod.nvr.server.data.Municipality;
import net.fexcraft.mod.nvr.server.data.Nation;
import net.fexcraft.mod.nvr.server.data.Player;
import net.fexcraft.mod.nvr.server.data.Province;
import net.fexcraft.mod.nvr.server.events.ChatEvents;
import net.fexcraft.mod.nvr.server.events.ChunkEvents;
import net.fexcraft.mod.nvr.server.events.PlayerEvents;
import net.fexcraft.mod.nvr.server.util.Permissions;
import net.fexcraft.mod.nvr.server.util.Sender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

//@Mod(modid = NVR.MODID, name = "NVR Standalone", version="xxx.xxx", acceptableRemoteVersions = "*", serverSideOnly = true, dependencies = "required-after:fcl")
public class NVR {
	
	@Mod.Instance(NVR.MODID)
	public static NVR INSTANCE;
	
	public static final String MODID = "nvr";
	public static final String DATASTR = "nvr-sa";
	public static final String DEF_UUID = "66e70cb7-1d96-487c-8255-5c2d7a2b6a0e";
	public static Sql SQL;

	public static final TreeMap<DoubleKey, Chunk> CHUNKS = new TreeMap<DoubleKey, Chunk>();
	public static final TreeMap<Integer, District> DISTRICTS = new TreeMap<Integer, District>();
	public static final TreeMap<Integer, Municipality> MUNICIPALITIES = new TreeMap<Integer, Municipality>();
	public static final TreeMap<Integer, Province> PROVINCES = new TreeMap<Integer, Province>();
	public static final TreeMap<Integer, Nation> NATIONS = new TreeMap<Integer, Nation>();
	
	@Mod.EventHandler
	public static void preInit(FMLPreInitializationEvent event){
		/* SQL */{
			File file = new File(event.getModConfigurationDirectory(), "/nvr.sql");
			JsonObject obj = JsonUtil.get(file);
			String user = JsonUtil.getIfExists(obj, "user", "nvrusr");
			String pass = JsonUtil.getIfExists(obj, "password", "null");
			String data = JsonUtil.getIfExists(obj, "database", "nvr");
			String host = JsonUtil.getIfExists(obj, "host", "fexcraft.net");
			String port = JsonUtil.getIfExists(obj, "port", "3306");
			JsonUtil.write(file, obj);
			SQL = new Sql(new String[]{user, pass, port, host, data});
			Launch.classLoader.addClassLoaderExclusion("com.mysql.");
		}
		//
		PermManager.setEnabled(MODID);
	}

	@Mod.EventHandler
	public static void init(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new ChatEvents());
		MinecraftForge.EVENT_BUS.register(new ChunkEvents());
		MinecraftForge.EVENT_BUS.register(new PlayerEvents());
		//
		Permissions.register();
		PlayerPerms.addAdditionalData(Player.class);
	}
	
	@Mod.EventHandler
	public static void serverLoad(FMLServerStartingEvent event){
		//
	}
	
	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event){
		if(!SQL.exists("id", "nations", "id='-1'", false)){
			Nation nat = new Nation(-1, null);
			nat.name = "Wilderness";
			nat.changed = Time.getDate();
			nat.account.setBalance(20000000f);
			nat.save();
		}
		if(!SQL.exists("id", "nations", "id='0'", false)){
			Nation nat = new Nation(0, null);
			nat.name = "Centurian Union";
			nat.changed = Time.getDate();
			nat.account.setBalance(80000000f);
			nat.save();
		}
		ArrayList<Integer> nations = SQL.getArray("id", "nations", "id", false, -1);
		nations.forEach((id) -> {
			NATIONS.put(id, new Nation(id, null));
		});
		//
		if(!SQL.exists("id", "provinces", "id='-1'", false)){
			Province pro = new Province(-1, null);
			pro.name = "Neural Territory";
			pro.changed = Time.getDate();
			pro.nation = getNation(-1);
			pro.save();
		}
		if(!SQL.exists("id", "provinces", "id='0'", false)){
			Province pro = new Province(0, null);
			pro.name = "Spawn";
			pro.changed = Time.getDate();
			pro.nation = getNation(0);
			pro.save();
		}
		ArrayList<Integer> provinces = SQL.getArray("id", "provinces", "id", false, -1);
		provinces.forEach((id) -> {
			PROVINCES.put(id, new Province(id, null));
		});
		//
		if(!SQL.exists("id", "municipalities", "id='-1'", false)){
			Municipality mun = new Municipality(-1, null);
			mun.name = "Unnamed Place";
			mun.changed = Time.getDate();
			mun.citizentax = -1;
			mun.province = getProvince(-1);
			mun.save();
		}
		if(!SQL.exists("id", "municipalities", "id='0'", false)){
			Municipality mun = new Municipality(0, null);
			mun.name = "Centuria";
			mun.type = mun.type.METROPOLIS;
			mun.changed = Time.getDate();
			mun.citizentax = 0;
			mun.province = getProvince(0);
			mun.save();
		}
		ArrayList<Integer> municipalities = SQL.getArray("id", "municipalities", "id", false, -1);
		municipalities.forEach((id) -> {
			MUNICIPALITIES.put(id, new Municipality(id, null));
		});
		//
		if(!SQL.exists("id", "districts", "id='-1'", false)){
			District dis = new District(-1, null);
			dis.name = "Unclaimed Area";
			dis.changed = Time.getDate();
			dis.tax = -1;
			dis.municipality = getMunicipality(-1);
			dis.save();
		}
		if(!SQL.exists("id", "districts", "id='0'", false)){
			District dis = new District(0, null);
			dis.name = "Spawn";
			dis.changed = Time.getDate();
			dis.tax = 0;
			dis.municipality = getMunicipality(0);
			dis.save();
		}
		ArrayList<Integer> districts = SQL.getArray("id", "districts", "id", false, -1);
		districts.forEach((id) -> {
			DISTRICTS.put(id, new District(id, null));
		});
	}
	
	@Mod.EventHandler
	public static void serverStop(FMLServerStoppingEvent event){
		NATIONS.values().forEach((nat) -> {
			nat.save();
		});
		PROVINCES.values().forEach((pro) -> {
			pro.save();
		});
		MUNICIPALITIES.values().forEach((mun) -> {
			mun.save();
		});
		DISTRICTS.values().forEach((dis) -> {
			dis.save();
		});
		/*CHUNKS.values().forEach((chunk) -> {
			chunk.save();
		});*/ //Actually they should be unloaded on server stop, so another event handles this.
	}
	
	public static final Player getPlayerData(EntityPlayer player){
		return PermManager.getPlayerPerms(player).getAdditionalData(Player.class);
	}

	public static final Player getPlayerData(String string){
		EntityPlayerMP player = Static.getServer().getPlayerList().getPlayerByUsername(string);
		return player == null ? null : getPlayerData(player);
	}
	
	public static final void save(){
		Sender.serverMessage("&5Saving data. Expect a short lag.");
		new Runnable(){ @Override public void run(){ NATIONS.forEach((key, pro) -> { pro.save(); Sender.serverMessage("&3Done saving nation data.");});}};
		new Runnable(){ @Override public void run(){ PROVINCES.forEach((key, pro) -> { pro.save(); Sender.serverMessage("&3Done saving province data.");});}};
		new Runnable(){ @Override public void run(){ MUNICIPALITIES.forEach((key, dis) -> { dis.save(); Sender.serverMessage("&3Done saving municipality data.");});}};
		new Runnable(){ @Override public void run(){ DISTRICTS.forEach((key, dis) -> { dis.save(); Sender.serverMessage("&3Done saving district data.");});}};
		//new Runnable(){ @Override public void run(){ CHUNKS.forEach((key, chunk) -> { chunk.save(); Sender.serverMessage("&3Done saving chunk data.");});}}; //Should be handled on chunk unload
		Sender.serverMessage("&5Done saving all data.");
	}

	public static Nation getNation(int i){
		Nation nat = NATIONS.get(i);
		return nat == null ? NATIONS.get(-1) : nat;
	}

	public static Province getProvince(int i){
		Province pro = PROVINCES.get(i);
		return pro == null ? PROVINCES.get(-1) : pro;
	}
	
	public static Municipality getMunicipality(int i){
		Municipality mun = MUNICIPALITIES.get(i);
		return mun == null ? MUNICIPALITIES.get(-1) : mun;
	}

	public static District getDistrict(int i){
		District dis = DISTRICTS.get(i);
		return dis == null ? DISTRICTS.get(-1) : dis;
	}
	
	public static Chunk getChunk(int x, int z){
		return CHUNKS.get(new DoubleKey(x, z));
	}

	public static Chunk getChunk(World world, BlockPos pos){
		int x = world.getChunkFromBlockCoords(pos).x;
		int z = world.getChunkFromBlockCoords(pos).z;
		return getChunk(x, z);
	}
	
}