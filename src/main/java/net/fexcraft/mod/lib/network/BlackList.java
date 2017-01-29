package net.fexcraft.mod.lib.network;

import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.relauncher.Side;

public class BlackList {
	
	private Set<UUID> list;
	private boolean server, checked = false;
	private static BlackList instance;
	
	public BlackList(Side side){
		list = new HashSet<UUID>();
		server = side.isServer();
	}
	
	public static void initialize(Side side){
		instance = new BlackList(side);
		instance.getList();
	}
	
	public static BlackList getInstance(){
		return instance;
	}
	
	private void getList(){
		if(server){
			String net = "127.0.0.1";
			try{
				net = InetAddress.getLocalHost().getHostAddress();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			JsonObject check = Network.request("http://fexcraft.net/minecraft/fcl/request", "mode=blacklist&id=" + net);
			if(check == null){
				Print.log("Couldn't validate Server.");
			}
			if(check != null && check.has("unbanned")){
				if(!check.get("unbanned").getAsBoolean()){
					Print.log("ERROR, SERVER IS BLACKLISTED;");
					Print.log("CONTACT FEXCRAFT.NET STAFF IF YOU THINK IS AN ERROR;");
					Static.halt(1);
				}
			}
			JsonObject obj = Network.request("http://fexcraft.net/minecraft/fcl/request", "mode=blacklist");
			if(obj == null){
				Print.log("Couldn't retrieve BL.");
				return;
			}
			for(JsonElement elm : obj.get("blacklist").getAsJsonArray()){
				try{
					list.add(UUID.fromString(elm.getAsString()));
				}
				catch(Exception e){
					if(e instanceof IllegalArgumentException){
						Print.log("[BL] Couldn't parse " + elm.toString() + ".");
					}
				}
			}
		}
	}

	public boolean isBanned(UUID id){
		if(server){
			return list.contains(id);
		}
		else{
			if(!checked){
				JsonObject obj = Network.request("http://fexcraft.net/minecraft/fcl/request", "mode=blacklist&id=" + id.toString());
				if(obj != null){
					checked = true;
					return !obj.get("unbanned").getAsBoolean();
				}
				else return false;
			}
			else return false;
		}
	}
	
	public void kick(EntityPlayer player){
		if(server){
			((EntityPlayerMP)player).connection.disconnect("[FCL] Blacklisted.");
		}
		else{
			Static.halt(0);
		}
	}
}