package net.fexcraft.mod.fvm.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.data.Addon;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class FvmResources {
	
	public static final ResourceLocation NULL_TEXTURE = new ResourceLocation("fvm:textures/entities/null_texture");
	public static final ArrayList<Addon> addons = new ArrayList<Addon>();
	public static final TreeMap<String, Boolean> packstate = new TreeMap<String, Boolean>();
	private static File configpath, addonconfig;
	
	public static void setup(FMLPreInitializationEvent event){
		configpath = new File(event.getSuggestedConfigurationFile().getParentFile(), "/fvm/");
		if(!configpath.exists()){
			configpath.mkdirs();
		}
		//get addons
		File addonfolder = new File(event.getSuggestedConfigurationFile().getParentFile(), "/addons/");
		if(!addonfolder.exists()){
			addonfolder.mkdirs();
		}
		for(File file : addonfolder.listFiles()){
			if(Addon.isAddonContainer(file)){
				addons.add(new Addon(file));
			}
		}
		//get config
		addonconfig = new File(configpath, "/addonpacks.fex");
		JsonArray array = null;
		try{
			array = JsonUtil.read(addonconfig, true).getAsJsonArray();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//read config
		if(array != null){
			for(JsonElement elm : array){
				try{
					packstate.put(elm.getAsJsonObject().get("id").getAsString(), elm.getAsJsonObject().get("state").getAsBoolean());
				}
				catch(Exception e){
					//
				}
			}
		}
		//check if a pack is missing in config;
		for(Addon pack : addons){
			if(!packstate.containsKey(pack.id)){
				packstate.put(pack.id, true);
			}
		}
		//update config file
		array = new JsonArray();
		for(Entry<String, Boolean> entry : packstate.entrySet()){
			JsonObject obj = new JsonObject();
			obj.addProperty("id", entry.getKey());
			obj.addProperty("state", entry.getValue());
			array.add(obj);
		}
		JsonUtil.write(addonconfig, array);
		//check if dependencies are installed; if not, disable;
		for(Addon pack : addons){
			for(String id : pack.dependencies){
				if(packstate.containsKey(id)){
					if(!packstate.get(id)){
						packstate.put(pack.id, false);
					}
				}
				else{
					packstate.put(pack.id, false);
				}
			}
		}
	}

	public static void scanForContent(FMLPreInitializationEvent event){
		//TODO
	}
	
}