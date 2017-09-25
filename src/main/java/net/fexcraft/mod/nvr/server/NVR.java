package net.fexcraft.mod.nvr.server;

import java.io.File;
import java.util.TreeMap;
import java.util.UUID;

import org.apache.commons.lang3.math.NumberUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fsmm.account.AccountManager.Account;
import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.perms.player.PlayerPerms;
import net.fexcraft.mod.lib.util.common.Log;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Time;
import net.fexcraft.mod.nvr.server.cmds.InfoCmd;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import scala.actors.threadpool.Arrays;

@Mod(modid = NVR.MODID, name = "NVR Standalone", version="xxx.xxx", acceptableRemoteVersions = "*", serverSideOnly = true, dependencies = "required-after:fcl")
public class NVR {
	
	@Mod.Instance(NVR.MODID)
	public static NVR INSTANCE;
	
	public static final String MODID = "nvr";
	public static final String DATASTR = "nvr-sa";
	public static final String DEF_UUID = "66e70cb7-1d96-487c-8255-5c2d7a2b6a0e";
	//public static Sql SQL;
	public static File PATH, CHUNK_DIR, DISTRICT_DIR, MUNICIPALITY_DIR, PROVINCE_DIR, NATION_DIR;
	public static final Log LOGGER = new Log("NVR", "&0[&4NVR&0]&7 ");

	public static final TreeMap<DoubleKey, Chunk> CHUNKS = new TreeMap<DoubleKey, Chunk>();
	public static final TreeMap<Integer, District> DISTRICTS = new TreeMap<Integer, District>();
	public static final TreeMap<Integer, Municipality> MUNICIPALITIES = new TreeMap<Integer, Municipality>();
	public static final TreeMap<Integer, Province> PROVINCES = new TreeMap<Integer, Province>();
	public static final TreeMap<Integer, Nation> NATIONS = new TreeMap<Integer, Nation>();
	
	@Mod.EventHandler
	public static void preInit(FMLPreInitializationEvent event){
		/*{
			File file = new File(event.getModConfigurationDirectory(), "/nvr.sql");
			JsonObject obj = JsonUtil.get(file);
			String user = JsonUtil.getIfExists(obj, "user", "nvrusr");
			String pass = JsonUtil.getIfExists(obj, "password", "null");
			String data = JsonUtil.getIfExists(obj, "database", "nvr");
			String host = JsonUtil.getIfExists(obj, "host", "fexcraft.net");
			String port = JsonUtil.getIfExists(obj, "port", "3306");
			JsonUtil.write(file, obj);
			SQL = new Sql(new String[]{user, pass, port, host, data});
			//Launch.classLoader.addClassLoaderExclusion("com.mysql.");
		}*/
		PATH = new File(event.getModConfigurationDirectory().getParentFile(), "/nvr/");
		LOGGER.debug(PATH, event.getModConfigurationDirectory());
		if(!PATH.exists()){
			PATH.mkdirs();
		}
		CHUNK_DIR = new File(PATH, "chunks/");
		if(!CHUNK_DIR.exists()){
			CHUNK_DIR.mkdirs();
		}
		DISTRICT_DIR = new File(PATH, "districts/");
		if(!DISTRICT_DIR.exists()){
			DISTRICT_DIR.mkdirs();
		}
		MUNICIPALITY_DIR = new File(PATH, "municipalities/");
		if(!MUNICIPALITY_DIR.exists()){
			MUNICIPALITY_DIR.mkdirs();
		}
		PROVINCE_DIR = new File(PATH, "provinces/");
		if(!PROVINCE_DIR.exists()){
			PROVINCE_DIR.mkdirs();
		}
		NATION_DIR = new File(PATH, "nations/");
		if(!NATION_DIR.exists()){
			NATION_DIR.mkdirs();
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
		event.registerServerCommand(new InfoCmd());
	}
	
	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event){
		Arrays.asList(NATION_DIR.listFiles()).forEach((nationfile) -> {
			JsonElement obj = JsonUtil.read((File)nationfile, false);
			if(obj != null){
				Nation nation = Nation.load(obj.getAsJsonObject());
				if(nation != null){
					NATIONS.put(nation.id, nation);
				}
			}
		});
		Arrays.asList(PROVINCE_DIR.listFiles()).forEach((provincefile) -> {
			JsonElement obj = JsonUtil.read((File)provincefile, false);
			if(obj != null){
				Province prov = Province.load(obj.getAsJsonObject());
				if(prov != null){
					PROVINCES.put(prov.id, prov);
				}
			}
		});
		Arrays.asList(MUNICIPALITY_DIR.listFiles()).forEach((municipalitiesfile) -> {
			JsonElement obj = JsonUtil.read((File)municipalitiesfile, false);
			if(obj != null){
				Municipality mun = Municipality.load(obj.getAsJsonObject());
				if(mun != null){
					MUNICIPALITIES.put(mun.id, mun);
				}
			}
		});
		Arrays.asList(DISTRICT_DIR.listFiles()).forEach((districtsfile) -> {
			JsonElement obj = JsonUtil.read((File)districtsfile, false);
			if(obj != null){
				District dis = District.load(obj.getAsJsonObject());
				if(dis != null ){
					DISTRICTS.put(dis.id, dis);
				}
			}
		});
		//Check for existence of default Stuff.
		if(!NATIONS.containsKey(-1)){
			Nation nat = new Nation();
			nat.id = -1;
			nat.account = Account.getAccountManager().loadAccount("nation", "nation:-1");
			nat.name = "No Nation";
			nat.icon = "https://i.imgur.com/8z76Cbr.png";
			nat.type = Nation.Type.ANARCHY;
			nat.gov_title = "Finest Anarchy";
			nat.gov_name = "Anarchist";
			nat.incharge = null;
			nat.incharge_title = "Leader";
			nat.creator = UUID.fromString(DEF_UUID);
			nat.created = Time.getDate();
			nat.changed = Time.getDate();
			nat.prev_income = 0;
			nat.parent = null;
			nat.save();
			NATIONS.put(-1, nat);
		}
		if(!NATIONS.containsKey(0)){
			Nation nat = new Nation();
			nat.id = 0;
			nat.account = Account.getAccountManager().loadAccount("nation", "nation:0");
			nat.name = "Testarian Union";
			nat.icon = "";
			nat.type = Nation.Type.MONARCHY;
			nat.gov_title = "Union";
			nat.gov_name = "Unionist";
			nat.incharge = UUID.fromString(DEF_UUID);
			nat.incharge_title = "Selected One";
			nat.creator = UUID.fromString(DEF_UUID);
			nat.created = Time.getDate();
			nat.changed = Time.getDate();
			nat.prev_income = 0;
			nat.parent = null;
			nat.save();
			NATIONS.put(0, nat);
		}
		if(!PROVINCES.containsKey(-1)){
			Province prov = new Province();
			prov.id = -1;
			prov.name = "Neutral Territory";
			prov.icon = "https://i.imgur.com/oxJw52L.png";
			prov.nation = NATIONS.get(-1);
			prov.ruler = null;
			prov.ruler_title = "Landlord";
			prov.creator = UUID.fromString(DEF_UUID);
			prov.created = Time.getDate();
			prov.changed = Time.getDate();
			prov.previncome = 0;
			prov.save();
			PROVINCES.put(-1, prov);
		}
		if(!PROVINCES.containsKey(0)){
			Province prov = new Province();
			prov.id = 0;
			prov.name = "Spawn";
			prov.icon = "";
			prov.nation = NATIONS.get(0);
			prov.ruler = UUID.fromString(DEF_UUID);
			prov.ruler_title = "Area Director";
			prov.creator = UUID.fromString(DEF_UUID);
			prov.created = Time.getDate();
			prov.changed = Time.getDate();
			prov.previncome = 0;
			prov.save();
			PROVINCES.put(0, prov);
		}
		if(!MUNICIPALITIES.containsKey(-1)){
			Municipality mun = new Municipality();
			mun.id = -1;
			mun.name = "Unnamed Place";
			mun.account = Account.getAccountManager().loadAccount("municipality", "municipality:-1");
			mun.icon = "https://i.imgur.com/RFGyyOD.png";
			mun.type = Municipality.Type.ABANDONED;
			mun.province = PROVINCES.get(-1);
			mun.creator = UUID.fromString(DEF_UUID);
			mun.created = Time.getDate();
			mun.changed = Time.getDate();
			mun.previncome = 0;
			mun.citizentax = 0;
			mun.save();
			MUNICIPALITIES.put(-1, mun);
		}
		if(!MUNICIPALITIES.containsKey(0)){
			Municipality mun = new Municipality();
			mun.id = 0;
			mun.name = "Spawn";
			mun.account = Account.getAccountManager().loadAccount("municipality", "municipality:0");
			mun.icon = "";//
			mun.type = Municipality.Type.TOO_LARGE;
			mun.province = PROVINCES.get(0);
			mun.creator = UUID.fromString(DEF_UUID);
			mun.created = Time.getDate();
			mun.changed = Time.getDate();
			mun.previncome = 0;
			mun.citizentax = 0;
			mun.save();
			MUNICIPALITIES.put(0, mun);
		}
		if(!DISTRICTS.containsKey(-1)){
			District dis = new District();
			dis.id = -1;
			dis.type = District.Type.UNSPECIFIED;
			dis.name = "Unclaimed Area";
			dis.municipality = MUNICIPALITIES.get(-1);
			dis.manager = null;
			dis.creator = UUID.fromString(DEF_UUID);
			dis.created = Time.getDate();
			dis.changed = Time.getDate();
			dis.previncome = 0;
			dis.tax = -10;
			dis.save();
			DISTRICTS.put(-1, dis);
		}
		if(!DISTRICTS.containsKey(0)){
			District dis = new District();
			dis.id = 0;
			dis.type = District.Type.CENTER;
			dis.name = "TPP";
			dis.municipality = MUNICIPALITIES.get(0);
			dis.manager = UUID.fromString(DEF_UUID);
			dis.creator = UUID.fromString(DEF_UUID);
			dis.created = Time.getDate();
			dis.changed = Time.getDate();
			dis.previncome = 0;
			dis.tax = 0;
			dis.save();
			DISTRICTS.put(0, dis);
		}
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
		return getPlayerData(string, false);
		//EntityPlayerMP player = Static.getServer().getPlayerList().getPlayerByUsername(string);
		//return player == null ? null : getPlayerData(player);
	}
	
	/** @param bool load if offline */
	public static Player getPlayerData(String string, boolean bool){
		EntityPlayerMP player = Static.getServer().getPlayerList().getPlayerByUsername(string);
		if(player == null && bool){
			JsonObject obj = JsonUtil.read(new File(PermManager.userDir, string + ".perm"), false).getAsJsonObject();
			UUID uuid = null;
			try{
				uuid = UUID.fromString(string);
			}
			catch(Exception e){
				uuid = Static.getServer().getPlayerProfileCache().getGameProfileForUsername(string).getId();
			}
			return obj == null ? null : Player.loadOffline(uuid, obj);
		}
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

	public static Chunk getChunk(EntityPlayer player){
		return getChunk(player.world, player.getPosition());
	}

	public static Nation getNation(String[] args, int off){
		if(NumberUtils.isCreatable(args[off])){
			return getNation(Integer.parseInt(args[1]));
		}
		String str = args[off];
		if(args.length > off + 1){
			for(int i = 2; i < args.length; i++){
				str += " " + args[i];
			}
		}
		Nation nat = null;
		for(Nation n : NATIONS.values()){
			if(n.name.equals(str)){
				nat = n;
			}
		}
		return nat;
	}

	public static Province getProvince(String[] args, int off){
		if(NumberUtils.isCreatable(args[off])){
			return getProvince(Integer.parseInt(args[1]));
		}
		String str = args[off];
		if(args.length > off + 1){
			for(int i = 2; i < args.length; i++){
				str += " " + args[i];
			}
		}
		Province prov = null;
		for(Province p : PROVINCES.values()){
			if(p.name.equals(str)){
				prov = p;
			}
		}
		return prov;
	}

	public static Municipality getMunicipality(String[] args, int off){
		if(NumberUtils.isCreatable(args[off])){
			return getMunicipality(Integer.parseInt(args[1]));
		}
		String str = args[off];
		if(args.length > off + 1){
			for(int i = 2; i < args.length; i++){
				str += " " + args[i];
			}
		}
		Municipality mun = null;
		for(Municipality m : MUNICIPALITIES.values()){
			if(m.name.equals(str)){
				mun = m;
			}
		}
		return mun;
	}

	public static District getDistrict(String[] args, int off){
		if(NumberUtils.isCreatable(args[off])){
			return getDistrict(Integer.parseInt(args[1]));
		}
		String str = args[off];
		if(args.length > off + 1){
			for(int i = 2; i < args.length; i++){
				str += " " + args[i];
			}
		}
		District dis = null;
		for(District d : DISTRICTS.values()){
			if(d.name.equals(str)){
				dis = d;
			}
		}
		return dis;
	}
	
}