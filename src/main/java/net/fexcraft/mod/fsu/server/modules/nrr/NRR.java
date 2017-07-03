package net.fexcraft.mod.fsu.server.modules.nrr;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import net.fexcraft.mod.fsu.server.modules.IModule;
import net.fexcraft.mod.fsu.server.modules.fModule;
import net.fexcraft.mod.fsu.server.modules.nrr.cmds.ChunkCommand;
import net.fexcraft.mod.fsu.server.modules.nrr.cmds.ConsoleCommand;
import net.fexcraft.mod.fsu.server.modules.nrr.cmds.ProvinceCommand;
import net.fexcraft.mod.fsu.server.modules.nrr.data.Chunk;
import net.fexcraft.mod.fsu.server.modules.nrr.data.Invite;
import net.fexcraft.mod.fsu.server.modules.nrr.data.Nation;
import net.fexcraft.mod.fsu.server.modules.nrr.data.PlayerData;
import net.fexcraft.mod.fsu.server.modules.nrr.data.Province;
import net.fexcraft.mod.fsu.server.modules.nrr.data.Region;
import net.fexcraft.mod.fsu.server.modules.nrr.events.ChatEvents;
import net.fexcraft.mod.fsu.server.modules.nrr.events.ChunkEvents;
import net.fexcraft.mod.fsu.server.modules.nrr.events.PlayerEvents;
import net.fexcraft.mod.fsu.server.modules.nrr.events.TimeEvents;
import net.fexcraft.mod.fsu.server.modules.nrr.util.DoubleKey;
import net.fexcraft.mod.fsu.server.modules.nrr.util.MappingUtil;
import net.fexcraft.mod.lib.FCL;
import net.fexcraft.mod.lib.network.Network;
import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.perms.PermissionNode.Type;
import net.fexcraft.mod.lib.perms.player.PlayerPerms;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

@fModule(config_description = "NRR System", def_enabled = false, id = "nrr")
public class NRR implements IModule<NRR> {
	
	public static final String PLAYERDATA = "NRRPD", ADMINPERM = "fsu.nrr.admin";
	public static final String DEF_UUID = "66e70cb7-1d96-487c-8255-5c2d7a2b6a0e";
	private static NRR instance;
	private boolean enabled;
	//
	public static final TreeMap<DoubleKey, Chunk> chunks = new TreeMap<DoubleKey, Chunk>();
	public static final TreeMap<Integer, Province> provinces = new TreeMap<Integer, Province>();
	public static final TreeMap<Integer, Region> regions = new TreeMap<Integer, Region>();
	public static final TreeMap<Integer, Nation> nations = new TreeMap<Integer, Nation>();
	public static final HashSet<Invite> invites = new HashSet<Invite>();
	
	//public static final Generator gen = new Generator();
	
	public NRR(){
		instance = this;
	}

	@Override
	public String getId(){
		return "nrr";
	}

	@Override
	public void preInit(FMLPreInitializationEvent event){
		PermManager.add(ADMINPERM, Type.BOOLEAN, false, true);
		createDefaults();
		if(!getChunksFolder().exists()){
			getChunksFolder().mkdirs();
		}
		if(!getProvincesFolder().exists()){
			getProvincesFolder().mkdirs();
		}
		if(!getRegionsFolder().exists()){
			getRegionsFolder().mkdirs();
		}
		if(!getNationsFolder().exists()){
			getNationsFolder().mkdirs();
		}
		if(!getInvitesFolder().exists()){
			getInvitesFolder().mkdirs();
		}
		//Nations
		for(File file : getNationsFolder().listFiles()){
			Nation n = new Nation(JsonUtil.get(file));
			if(n.id != -100){
				nations.put(n.id, n);
			}
		}
		//Regions
		for(File file : getRegionsFolder().listFiles()){
			Region r = new Region(JsonUtil.get(file));
			if(r.id != -100){
				regions.put(r.id, r);
			}
		}
		//Provinces
		for(File file : getProvincesFolder().listFiles()){
			Province p = new Province(JsonUtil.get(file));
			if(p.id != -100){
				provinces.put(p.id, p);
			}
		}
		//Invites
		for(File file : getInvitesFolder().listFiles()){
			try{
				Invite inv = new Invite(JsonUtil.get(file));
				if(inv != null && !inv.cancelled){
					invites.add(inv);
				}
			}
			catch(Exception e){
				//
			}
		}
		
		//gen.load();
	}
	
	public static File getChunksFolder(){
		return new File(FCL.getInstance().getConfigDirectory().getParentFile(), "/fsu-nrr/chunks/");
	}
	
	public static File getChunkFile(int x, int z){
		return new File(FCL.getInstance().getConfigDirectory().getParentFile(), "/fsu-nrr/chunks/" + x + "_" + z + ".nrr");
	}
	
	public static File getProvincesFolder(){
		return new File(FCL.getInstance().getConfigDirectory().getParentFile(), "/fsu-nrr/provinces/");
	}
	
	public static File getProvinceFile(int id){
		return new File(FCL.getInstance().getConfigDirectory().getParentFile(), "/fsu-nrr/provinces/" + id + ".nrr");
	}
	
	public static File getRegionsFolder(){
		return new File(FCL.getInstance().getConfigDirectory().getParentFile(), "/fsu-nrr/regions/");
	}
	
	public static File getRegionFile(int id){
		return new File(FCL.getInstance().getConfigDirectory().getParentFile(), "/fsu-nrr/regions/" + id + ".nrr");
	}
	
	public static File getNationsFolder(){
		return new File(FCL.getInstance().getConfigDirectory().getParentFile(), "/fsu-nrr/nations/");
	}
	
	public static File getNationFile(int id){
		return new File(FCL.getInstance().getConfigDirectory().getParentFile(), "/fsu-nrr/nations/" + id + ".nrr");
	}
	
	public static File getInvitesFolder(){
		return new File(FCL.getInstance().getConfigDirectory().getParentFile(), "/fsu-nrr/invites/");
	}

	private void createDefaults(){
		//Nations
		JsonObject n1n = JsonUtil.get(getNationFile(-1));
		n1n.addProperty("id", -1);
		n1n.addProperty("color", 2);
		n1n.addProperty("name", "Neutral Territory");
		JsonUtil.write(getNationFile(-1), n1n, true);
		//
		JsonObject n0 = JsonUtil.get(getNationFile(0));
		n0.addProperty("id", 0);
		n0.addProperty("color", 6);
		n0.addProperty("name", "Centurian Union");
		JsonArray n0arr = n0.has("goverment") ? n0.get("goverment").getAsJsonArray() : new JsonArray();
		n0arr.add(new JsonPrimitive(DEF_UUID));
		n0.add("goverment", n0arr);
		JsonUtil.write(getNationFile(0), n0, true);
		
		//Regions
		JsonObject rg1n = JsonUtil.get(getRegionFile(-1));
		rg1n.addProperty("id", -1);
		rg1n.addProperty("nation", -1);
		rg1n.addProperty("name", "No Name");
		JsonUtil.write(getRegionFile(-1), rg1n, true);
		//
		JsonObject rg0 = JsonUtil.get(getRegionFile(0));
		rg0.addProperty("id", 0);
		rg0.addProperty("nation", 0);
		rg0.addProperty("name", "Centurian Main State");
		JsonArray rg0arr = rg0.has("rulership") ? rg0.get("rulership").getAsJsonArray() : new JsonArray();
		rg0arr.add(new JsonPrimitive(DEF_UUID));
		rg0.add("rulership", rg0arr);
		JsonUtil.write(getRegionFile(0), rg0, true);
		
		//Provinces
		JsonObject pr1n = JsonUtil.get(getProvinceFile(-1));
		pr1n.addProperty("id", -1);
		pr1n.addProperty("region", -1);
		pr1n.addProperty("name", "Wilderness");
		JsonUtil.write(getProvinceFile(-1), pr1n, true);
		//
		JsonObject pr0 = JsonUtil.get(getProvinceFile(0));
		pr0.addProperty("id", 0);
		pr0.addProperty("region", 0);
		pr0.addProperty("name", "Spawn");
		pr0.addProperty("hex", "#EBBE38");
		JsonArray pr0arr = rg0.has("leadership") ? n0.get("leadership").getAsJsonArray() : new JsonArray();
		pr0arr.add(new JsonPrimitive(DEF_UUID));
		pr0.add("leadership", pr0arr);
		JsonUtil.write(getProvinceFile(0), pr0, true);
		
	}

	@Override
	public void init(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new PlayerEvents());
		MinecraftForge.EVENT_BUS.register(new ChatEvents());
		MinecraftForge.EVENT_BUS.register(new ChunkEvents());
		MinecraftForge.EVENT_BUS.register(new TimeEvents());
		PlayerPerms.addAdditionalData(PlayerData.class);
		
		MappingUtil.init();
		//ForgeChunkManager.setForcedChunkLoadingCallback(FSU.INSTANCE, gen);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event){
		
	}

	@Override
	public void serverStart(FMLServerStartingEvent event){
		event.registerServerCommand(new ConsoleCommand());
		event.registerServerCommand(new ChunkCommand());
		event.registerServerCommand(new ProvinceCommand());
	}

	@Override
	public void serverStop(FMLServerStoppingEvent event){
		NRR.save();
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
	public NRR getInstace(){
		return instance;
	}
	
	public static final PlayerData getPlayerData(EntityPlayer player){
		return (PlayerData)PermManager.getPlayerPerms(player).getAdditionalData(PLAYERDATA);
	}

	public static PlayerData getPlayerData(String string){
		EntityPlayerMP player = Static.getServer().getPlayerList().getPlayerByUsername(string);
		if(player != null){
			return getPlayerData(player);
		}
		return null;
	}
	
	public static Chunk getChunk(int x, int z){
		return chunks.get(new DoubleKey(x, z));
	}

	public static Chunk getChunk(World world, BlockPos pos) {
		net.minecraft.world.chunk.Chunk chunk = world.getChunkFromBlockCoords(pos);
		return chunks.get(new DoubleKey(chunk.x, chunk.z));
	}

	public static Chunk getChunk(ICommandSender sender){
		net.minecraft.world.chunk.Chunk chunk = sender.getEntityWorld().getChunkFromBlockCoords(sender.getPosition());
		return chunks.get(new DoubleKey(chunk.x, chunk.z));
	}
	
	public static ArrayList<Invite> getInvites(String target){
		ArrayList<Invite> arr = new ArrayList<Invite>();
		for(Invite inv : invites){
			if(inv.target.equals(target)){
				arr.add(inv);
			}
		}
		return arr;
	}
	
	private static final HashMap<UUID, String> cache = new HashMap<UUID, String>();
	
	public static final String getPlayerNameByUUID(UUID uuid){
		if(cache.containsKey(uuid)){
			return cache.get(uuid);
		}
		JsonElement obj = Network.request(" https://sessionserver.mojang.com/session/minecraft/profile/" + uuid.toString().replace("-", ""));
		if(obj != null){
			JsonObject elm = obj.getAsJsonObject();
			cache.put(uuid, elm.get("name").getAsString());
			return elm.get("name").getAsString();
		}
		return "<null/errored>";
	}

	public static void sendToAll(String string){
		for(EntityPlayerMP player : Static.getServer().getPlayerList().getPlayers()){
			Print.chat(player, string);
		}
	}

	public static void sendToProvince(int id, String string){
		for(EntityPlayerMP player : Static.getServer().getPlayerList().getPlayers()){
			if(NRR.getPlayerData(player).province.id == id){
				Print.chat(player, string);
			}
		}
	}

	public static void save(){
		for(Province pr : provinces.values()){
			JsonUtil.write(pr.getFile(), pr.save());
		}
		for(Region rg : regions.values()){
			JsonUtil.write(rg.getFile(), rg.save());
		}
		for(Nation nn : nations.values()){
			JsonUtil.write(nn.getFile(), nn.save());
		}
		for(Chunk ck : chunks.values()){
			JsonUtil.write(NRR.getChunkFile(ck.x, ck.z), ck.save());
		}
		for(Invite inv : invites){
			inv.save();
		}
		
		MappingUtil.save();
		
		//gen.save();
	}
	
}