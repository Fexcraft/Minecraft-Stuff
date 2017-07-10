package net.fexcraft.mod.fvm.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;
import org.apache.commons.io.FilenameUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.FVM;
import net.fexcraft.mod.fvm.data.Addon;
import net.fexcraft.mod.fvm.data.Material;
import net.fexcraft.mod.fvm.data.Part;
import net.fexcraft.mod.fvm.data.Vehicle;
import net.fexcraft.mod.fvm.items.MaterialItem;
import net.fexcraft.mod.fvm.items.PartItem;
import net.fexcraft.mod.fvm.items.VehicleItem;
import net.fexcraft.mod.lib.FCL;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.common.ZipUtil;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.render.ModelType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLModContainer;
import net.minecraftforge.fml.common.MetadataCollection;
import net.minecraftforge.fml.common.discovery.ContainerType;
import net.minecraftforge.fml.common.discovery.ModCandidate;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

public class FvmResources {
	
	public static IForgeRegistry<Addon> ADDONS = (IForgeRegistry<Addon>)new RegistryBuilder<Addon>().setName(new ResourceLocation("fvm:addons")).setType(Addon.class).create();
	public static IForgeRegistry<Material> MATERIALS = (IForgeRegistry<Material>)new RegistryBuilder<Material>().setName(new ResourceLocation("fvm:materials")).setType(Material.class).create();
	public static IForgeRegistry<Part> PARTS = (IForgeRegistry<Part>)new RegistryBuilder<Part>().setName(new ResourceLocation("fvm:parts")).setType(Part.class).create();
	public static IForgeRegistry<Vehicle> VEHICLES = (IForgeRegistry<Vehicle>)new RegistryBuilder<Vehicle>().setName(new ResourceLocation("fvm:vehicles")).setType(Vehicle.class).create();
	
	public static final String DEFPACKCFGFILENAME = "addonpack.fvm";
	//
	public static final ResourceLocation NULL_TEXTURE = new ResourceLocation("fvm:textures/entities/null_texture.png");
	//public static final TreeMap<String, Boolean> packstate = new TreeMap<String, Boolean>();
	//
	public static final TreeMap<String, Object> models = new TreeMap<String, Object>();
	//TODO Water
	//TODO Railed
	//
	private static File configpath, addonconfig;
	private static final Random random = new Random();
	
	public static void setup(IForgeRegistry<Addon> reg){
		configpath = new File(FCL.getInstance().getConfigDirectory().getParentFile(), "/fvm/");
		if(!configpath.exists()){
			configpath.mkdirs();
		}
		//get addons
		File addonfolder = new File(FCL.getInstance().getConfigDirectory().getParentFile().getParentFile(), "/addons/");
		if(!addonfolder.exists()){
			addonfolder.mkdirs();
		}
		for(File file : addonfolder.listFiles()){
			if(Addon.isAddonContainer(file)){
				reg.register(new Addon(file));
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
					Addon addon = ADDONS.getValue(new ResourceLocation(elm.getAsJsonObject().get("id").getAsString()));
					if(addon != null){
						addon.enabled = elm.getAsJsonObject().get("state").getAsBoolean();
					}
				}
				catch(Exception e){
					//
				}
			}
		}
		//check if a pack is missing in config;
		/*for(String id : addons.keySet()){
			if(!packstate.containsKey(id)){
				packstate.put(id, true);
			}
		}*/
		//update config file
		array = new JsonArray();
		for(Addon addon : ADDONS.getValues()){
			JsonObject obj = new JsonObject();
			obj.addProperty("id", addon.regname());
			obj.addProperty("state", addon.enabled);
			array.add(obj);
		}
		JsonUtil.write(addonconfig, array);
		//check if all dependencies are installed; if not, mark as not working;
		for(Addon pack : ADDONS.getValues()){
			for(ResourceLocation id : pack.dependencies){
				if(ADDONS.getValue(id) == null){
					pack.missing_dependencies = true;
					continue;
				}
			}
		}
		for(Addon addon : ADDONS.getValues()){
			if(Static.side().isClient()){
				Print.log("Registering Addonpack into Forge/Minecraft resources...");
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("modid", FVM.MODID + "");
				map.put("name", "[FVM]: " + addon.file.getName());
				map.put("version", addon.version);
				FMLModContainer container = new FMLModContainer("net.fexcraft.mod.fvm.FVM", new ModCandidate(addon.file, addon.file, addon.file.isDirectory() ? ContainerType.DIR : ContainerType.JAR), map);
				container.bindMetadata(MetadataCollection.from(null, ""));
				FMLClientHandler.instance().addModAsResource(container);
			}
		}
	}
	
	public static void updateAddonConfig(){
		JsonArray array = new JsonArray();
		for(Addon addon : ADDONS.getValues()){
			JsonObject obj = new JsonObject();
			obj.addProperty("id", addon.regname());
			obj.addProperty("state", addon.enabled);
			array.add(obj);
		}
		JsonUtil.write(addonconfig, array);
	}

	/*public static void scanForContent(FMLPreInitializationEvent event){
		for(Entry<ResourceLocation, Addon> entry : ADDONS.getEntries()){
			Addon addon = entry.getValue();
			if(addon.enabled && !addon.missing_dependencies){
				Print.log("Scanning Addonpack '" + addon.name + " (" + addon.regname() + ")' for content...");
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
					JsonArray array = ZipUtil.getJsonObjectsAt(addon.file, "assets/fvm/config/materials/", ".material");
					for(JsonElement elm : array){
						Material mat = new Material(elm.getAsJsonObject());
						materials.put(mat.registryname, mat);
						Print.log("Registered Material '" + mat.registryname + "'.");
					}
				}
				Print.log("Searching for Parts...");
				if(addon.file.isDirectory()){
					File matfol = new File(addon.file, "assets/fvm/config/parts/");
					if(!matfol.exists()){ matfol.mkdirs(); }
					for(File file : matfol.listFiles()){
						if(!file.isDirectory() && file.getName().endsWith(".part")){
							Part part = new Part(JsonUtil.get(file));
							parts.put(part.registryname, part);
							Print.log("Registered Part '" + part.registryname + "';");
						}
						//else skip;
					}
				}
				else{
					JsonArray array = ZipUtil.getJsonObjectsAt(addon.file, "assets/fvm/config/parts/", ".part");
					for(JsonElement elm : array){
						Part part = new Part(elm.getAsJsonObject());
						parts.put(part.registryname, part);
						Print.log("Registered Part '" + part.registryname + "'.");
					}
				}
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
				Print.log("Finished loading Addonpack with id: '" + addon.regname()+ "'!");
			}
			else{
				Print.log("Skipping Addonpack '" + addon.name + " (" + addon.regname() + ")' since it's disabled.");
			}
		}
		if(event.getSide().isClient()){
			net.minecraft.client.Minecraft.getMinecraft().refreshResources();
		}
	}*/

	public static void loadModels(FMLPreInitializationEvent event){
		Print.log("Initializing Models...");
		for(Part part : PARTS.getValues()){
			part.loadModel();
		}
		for(Vehicle veh : VEHICLES.getValues()){
			veh.loadModel();
		}
	}

	public static ModelType findOutModelType(String modelname){
		String str = FilenameUtils.getExtension(modelname);
		switch(str){
			case "class": return ModelType.TMT;
			case "json": return ModelType.JSON;
			case "jtmt": return ModelType.JTMT;
			case "obj": return ModelType.OBJ;
		}
		return ModelType.NONE;
	}
	
	@SubscribeEvent
	public void registerAddons(RegistryEvent.Register<Addon> event){
		IForgeRegistry<Addon> reg = event.getRegistry();
		FvmResources.setup(reg);
	}
	
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event){
		event.getRegistry().register(MaterialItem.INSTANCE);
		//net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(MaterialItem.INSTANCE, 0, new ModelResourceLocation(MaterialItem.INSTANCE.getRegistryName(), "inventory"));
		net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(MaterialItem.INSTANCE, new MaterialItem.MaterialItemMesh());
		event.getRegistry().register(PartItem.INSTANCE);
		//net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(PartItem.INSTANCE, 0, new ModelResourceLocation(PartItem.INSTANCE.getRegistryName(), "inventory"));
		net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(PartItem.INSTANCE, new PartItem.PartItemMesh());
		event.getRegistry().register(VehicleItem.INSTANCE);
		//net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(VehicleItem.INSTANCE, 0, new ModelResourceLocation(VehicleItem.INSTANCE.getRegistryName(), "inventory"));
		net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(VehicleItem.INSTANCE, new VehicleItem.VehicleItemMesh());
	}
	
	@SubscribeEvent
	public void registerMaterials(RegistryEvent.Register<Material> event){
		IForgeRegistry<Material> reg = event.getRegistry();
		for(Entry<ResourceLocation, Addon> entry : ADDONS.getEntries()){
			Addon addon = entry.getValue();
			if(addon.enabled && !addon.missing_dependencies){
				if(addon.file.isDirectory()){
					File matfol = new File(addon.file, "assets/fvm/config/materials/");
					if(!matfol.exists()){ matfol.mkdirs(); }
					for(File file : matfol.listFiles()){
						if(!file.isDirectory() && file.getName().endsWith(".material")){
							Material mat = new Material(JsonUtil.get(file));
							reg.register(mat);
							net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(MaterialItem.INSTANCE, new ResourceLocation(MaterialItem.INSTANCE.getRegistryName() + "_" + mat.getRegistryName().getResourcePath()));
							Print.debug(MaterialItem.INSTANCE.getRegistryName() + "_" + mat.getRegistryName().getResourcePath());
						}
						//else skip;
					}
				}
				else{
					JsonArray array = ZipUtil.getJsonObjectsAt(addon.file, "assets/fvm/config/materials/", ".material");
					for(JsonElement elm : array){
						Material mat = new Material(elm.getAsJsonObject());
						reg.register(mat);
						net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(MaterialItem.INSTANCE, new ResourceLocation(MaterialItem.INSTANCE.getRegistryName() + "_" + mat.getRegistryName().getResourcePath()));
						Print.debug(MaterialItem.INSTANCE.getRegistryName() + "_" + mat.getRegistryName().getResourcePath());
					}
				}
			}
		}
		if(Static.side().isClient()){
			net.minecraft.client.Minecraft.getMinecraft().refreshResources();
		}
	}
	
	@SubscribeEvent
	public void registerParts(RegistryEvent.Register<Part> event){
		//TODO
	}
	
	@SubscribeEvent
	public void registerVehicles(RegistryEvent.Register<Vehicle> event){
		//TODO
	}
	
}