package net.fexcraft.mod.lib.network;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.util.cls.Print;
import net.minecraftforge.fml.relauncher.Side;

public class DonorValidator {
	
	private static boolean server;
	private static Set<UUID> list;
	private static Map<UUID, Boolean> ls;
	private static boolean checked, is;
	
	public static void initialize(Side side){
		server = side.isServer();
		if(server){
			list = new HashSet<UUID>();
			ls = new HashMap<UUID, Boolean>();
			getList();
		}
		checked = is = false;
	}

	private static void getList(){
		JsonObject obj = Network.request("http://fexcraft.net/minecraft/fcl/request", "mode=isDonor");
		if(obj == null){
			Print.log("Couldn't retrieve DVL.");
		}
		for(JsonElement elm : obj.get("list").getAsJsonArray()){
			try{
				list.add(UUID.fromString(elm.getAsString()));
			}
			catch(Exception e){
				Print.log("[DVL] Couldn't parse " + elm.toString() + ".");
			}
		}
	}
	
	public static boolean isDonor(UUID id){
		if(server){
			if(!ls.containsKey(id)){
				boolean found = false;
				for(UUID uuid : list){
					if(uuid.equals(id)){
						found = true;
						break;
					}
				}
				ls.put(id, found);
			}
			return ls.get(id);
		}
		else{
			if(!checked){
				JsonObject obj = Network.request("http://fexcraft.net/minecraft/fcl/request", "mode=isDonor&id=" + id.toString());
				if(obj != null){
					checked = true;
					is = !obj.get("expired").getAsBoolean();
					return is;
				}
				else return false;
			}
			else return is;
		}
	}
}