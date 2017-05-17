package net.fexcraft.mod.fvm.util;

import java.io.File;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.FVM;
import net.fexcraft.mod.fvm.data.Addon;
import net.fexcraft.mod.fvm.data.Material;
import net.fexcraft.mod.fvm.data.Vehicle;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.common.ZipUtil;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLModContainer;
import net.minecraftforge.fml.common.MetadataCollection;
import net.minecraftforge.fml.common.discovery.ContainerType;
import net.minecraftforge.fml.common.discovery.ModCandidate;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class FvmResources {
	
	public static final String DEFPACKCFGFILENAME = "addonpack.fvm";
	//
	public static final ResourceLocation NULL_TEXTURE = new ResourceLocation("fvm:textures/entities/null_texture");
	public static final TreeMap<String, Addon> addons = new TreeMap<String, Addon>();
	public static final TreeMap<String, Boolean> packstate = new TreeMap<String, Boolean>();
	//
	public static final TreeMap<String, Object> models = new TreeMap<String, Object>();
	public static final TreeMap<String, Material> materials = new TreeMap<String, Material>();
	//TODO Parts
	//TODO Air
	public static final TreeMap<String, Vehicle> vehicles = new TreeMap<String, Vehicle>();
	//TODO Water
	//TODO Railed
	//
	private static File configpath, addonconfig;
	
	public static void setup(FMLPreInitializationEvent event){
		configpath = new File(event.getSuggestedConfigurationFile().getParentFile(), "/fvm/");
		if(!configpath.exists()){
			configpath.mkdirs();
		}
		//get addons
		File addonfolder = new File(event.getSuggestedConfigurationFile().getParentFile().getParentFile(), "/addons/");
		if(!addonfolder.exists()){
			addonfolder.mkdirs();
		}
		for(File file : addonfolder.listFiles()){
			if(Addon.isAddonContainer(file)){
				Addon addon = new Addon(file);
				if(!addons.containsKey(addon.id)){
					addons.put(addon.id, addon);
				}
				else{
					Print.log("[ERROR]: ADDON PACK WITH ID `" + addon.id + "` REGISTERED TWICE!");
					Static.halt();
				}
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
		for(String id : addons.keySet()){
			if(!packstate.containsKey(id)){
				packstate.put(id, true);
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
		for(Addon pack : addons.values()){
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
		for(Entry<String, Addon> entry : addons.entrySet()){
			Addon addon = entry.getValue();
			if(packstate.get(entry.getKey())){
				Print.log("Scanning Addonpack '" + addon.name + " (" + addon.id + ")' for content...");
				if(event.getSide().isClient()){
					Print.log("Registering Addonpack into Forge/Minecraft resources...");
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("modid", FVM.MODID);
					map.put("name", "[FVM]: " + addon.file.getName());
					map.put("version", "1");
					FMLModContainer container = new FMLModContainer("net.fexcraft.mod.fvm.FVM", new ModCandidate(addon.file, addon.file, addon.file.isDirectory() ? ContainerType.DIR : ContainerType.JAR), map);
					container.bindMetadata(MetadataCollection.from(null, ""));
					FMLClientHandler.instance().addModAsResource(container);
				}
				Print.log("Searching for Materials...");
				if(addon.file.isDirectory()){
					File matfol = new File(addon.file, "assets/fvm/config/materials/");
					if(!matfol.exists()){ matfol.mkdirs(); }
					for(File file : matfol.listFiles()){
						if(!file.isDirectory() && file.getName().endsWith(".material")){
							Material mat = new Material(JsonUtil.get(file));
							materials.put(mat.registryname, mat);
							Print.log("Registered Material '" + mat.registryname + "';");
						}
						//else skip;
					}
				}
				else{
					JsonArray array = ZipUtil.getJsonObjectsAt(addon.file, "assets/fvm/config/vehicles/", ".material");
					for(JsonElement elm : array){
						Material mat = new Material(elm.getAsJsonObject());
						materials.put(mat.registryname, mat);
						Print.log("Registered Material '" + mat.registryname + "'.");
					}
				}
				Print.log("Searching for Parts...");
				//TODO
				Print.log("Searching for Air Vehicles...");
				//TODO
				Print.log("Searching for Land Vehicles...");
				if(addon.file.isDirectory()){
					File vehfol = new File(addon.file, "assets/fvm/config/vehicles/");
					if(!vehfol.exists()){ vehfol.mkdirs(); }
					for(File file : vehfol.listFiles()){
						if(!file.isDirectory() && file.getName().endsWith(".vehicle")){
							Vehicle veh = new Vehicle(JsonUtil.get(file));
							vehicles.put(veh.registryname, veh);
							Print.log("Registered Vehicle '" + veh.registryname + "';");
						}
						//else skip;
					}
				}
				else{
					JsonArray array = ZipUtil.getJsonObjectsAt(addon.file, "assets/fvm/config/vehicles/", ".vehicle");
					for(JsonElement elm : array){
						Vehicle veh = new Vehicle(elm.getAsJsonObject());
						vehicles.put(veh.registryname, veh);
						Print.log("Registered Vehicle '" + veh.registryname + "'.");
					}
				}
				Print.log("Searching for Water Vehicles...");
				//TODO
				Print.log("Searching for Railed Vehicles...");
				//TODO
				Print.log("Initializing Models...");
				//TODO
				Print.log("Finished loading Addonpack with id: '" + addon.id + "'!");
			}
			else{
				Print.log("Skipping Addonpack '" + addon.name + " (" + addon.id + ")' since it's disabled.");
			}
		}
		if(event.getSide().isClient()){
			net.minecraft.client.Minecraft.getMinecraft().refreshResources();
		}
	}
	
}