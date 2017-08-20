package net.fexcraft.mod.nvr.server;

import java.io.File;

import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.perms.player.PlayerPerms;
import net.fexcraft.mod.lib.util.common.Sql;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.nvr.server.data.Player;
import net.fexcraft.mod.nvr.server.events.ChatEvents;
import net.fexcraft.mod.nvr.server.util.Permissions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

@Mod(modid = NVR.MODID, name = "NVR Standalone", version="xxx.xxx", acceptableRemoteVersions = "*", serverSideOnly = true, dependencies = "required-after:fcl")
public class NVR {
	
	@Mod.Instance(NVR.MODID)
	public static NVR INSTANCE;
	
	public static final String MODID = "nvr";
	public static final String DATASTR = "nvr-sa";
	public static final String DEF_UUID = "66e70cb7-1d96-487c-8255-5c2d7a2b6a0e";
	public static Sql SQL;
	
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
		//
	}
	
	@Mod.EventHandler
	public static void serverStop(FMLServerStoppingEvent event){
		//
	}
	
	public static final Player getPlayerData(EntityPlayer player){
		return PermManager.getPlayerPerms(player).getAdditionalData(Player.class);
	}

	public static Player getPlayerData(String string){
		EntityPlayerMP player = Static.getServer().getPlayerList().getPlayerByUsername(string);
		return player == null ? null : getPlayerData(player);
	}
	
}