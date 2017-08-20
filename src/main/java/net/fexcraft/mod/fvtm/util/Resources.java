package net.fexcraft.mod.fvtm.util;

import java.io.File;
import java.util.HashMap;
import java.util.TreeMap;

import org.apache.commons.io.FilenameUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Fuel;
import net.fexcraft.mod.fvtm.api.LandVehicle;
import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleData;
import net.fexcraft.mod.fvtm.api.LandVehicle.LandVehicleItem;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Part.PartItem;
import net.fexcraft.mod.fvtm.impl.GenericAddon;
import net.fexcraft.mod.fvtm.impl.GenericLandVehicle;
import net.fexcraft.mod.fvtm.impl.GenericLandVehicleItem;
import net.fexcraft.mod.fvtm.impl.GenericMaterial;
import net.fexcraft.mod.fvtm.impl.GenericMaterialItem;
import net.fexcraft.mod.fvtm.impl.GenericPart;
import net.fexcraft.mod.fvtm.impl.GenericPartItem;
import net.fexcraft.mod.fvtm.impl.HybridAddon;
import net.fexcraft.mod.lib.FCL;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.common.ZipUtil;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.render.ModelType;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLModContainer;
import net.minecraftforge.fml.common.MetadataCollection;
import net.minecraftforge.fml.common.discovery.ContainerType;
import net.minecraftforge.fml.common.discovery.ModCandidate;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

public class Resources {
	
	public static final String DEFPACKCFGFILENAME = "addonpack.fvm";
	public static final IForgeRegistry<Addon> ADDONS = (IForgeRegistry<Addon>)new RegistryBuilder<Addon>().setName(new ResourceLocation("fvtm:addons")).setType(Addon.class).create();
	public static final IForgeRegistry<Material> MATERIALS = (IForgeRegistry<Material>)new RegistryBuilder<Material>().setName(new ResourceLocation("fvtm:materials")).setType(Material.class).create();
	public static final IForgeRegistry<Part> PARTS = (IForgeRegistry<Part>)new RegistryBuilder<Part>().setName(new ResourceLocation("fvtm:parts")).setType(Part.class).create();
	public static final IForgeRegistry<LandVehicle> LANDVEHICLES = (IForgeRegistry<LandVehicle>)new RegistryBuilder<LandVehicle>().setName(new ResourceLocation("fvtm:landvehicles")).setType(LandVehicle.class).create();
	public static final TreeMap<String, Object> MODELS = new TreeMap<String, Object>();
	public static final IForgeRegistry<Attribute> PARTATTRIBUTES = (IForgeRegistry<Attribute>)new RegistryBuilder<Attribute>().setName(new ResourceLocation("fvtm:attributes")).setType(Attribute.class).create();
	public static final IForgeRegistry<Fuel> FUELS = (IForgeRegistry<Fuel>)new RegistryBuilder<Fuel>().setName(new ResourceLocation("fvtm:fuels")).setType(Fuel.class).create();
	public static ResourceLocation NULL_TEXTURE = new ResourceLocation("fvtm:textures/entities/null_texture.png");
	private final File configpath, addonconfig;
	
	public Resources(){
		MinecraftForge.EVENT_BUS.register(this);
		configpath = new File(FCL.getInstance().getConfigDirectory().getParentFile(), "/fvtm/");
		if(!configpath.exists()){
			configpath.mkdirs();
		}
		addonconfig = new File(configpath, "/addonpacks.fex");
	}

	public void updateAddonConfig() {
		JsonArray array = new JsonArray();
		for(Addon addon : ADDONS.getValues()){
			JsonObject obj = new JsonObject();
			obj.addProperty("id", addon.getRegistryName().toString());
			obj.addProperty("state", addon.isEnabled());
			array.add(obj);
		}
		JsonUtil.write(addonconfig, array);
	}

	private void queryAddons(){
		try{
			JsonArray array = JsonUtil.read(addonconfig, true).getAsJsonArray();
			for(JsonElement elm : array){
				try{
					Addon addon = ADDONS.getValue(new ResourceLocation(elm.getAsJsonObject().get("id").getAsString()));
					if(addon != null){
						addon.setEnabled(elm.getAsJsonObject().get("state").getAsBoolean());
					}
				}
				catch(Exception e){
					//
				}
			}
			this.updateAddonConfig();
			for(Addon pack : ADDONS.getValues()){
				for(ResourceLocation id : pack.getDependencies()){
					if(ADDONS.getValue(id) == null){
						pack.setMissingDependencies(true);
						continue;
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@SubscribeEvent
	public void regItems(RegistryEvent.Register<Item> event){
		event.getRegistry().register(GenericMaterialItem.INSTANCE);
		if(Static.side().isClient()){
			net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(GenericMaterialItem.INSTANCE, new GenericMaterialItem.ItemMeshDef());
		}
		event.getRegistry().register(GenericPartItem.INSTANCE);
		if(Static.side().isClient()){
			net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(GenericPartItem.INSTANCE, new GenericPartItem.ItemMeshDef());
		}
		event.getRegistry().register(GenericLandVehicleItem.INSTANCE);
		if(Static.side().isClient()){
			net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(GenericLandVehicleItem.INSTANCE, new GenericLandVehicleItem.ItemMeshDef());
		}
	}
	
	@SubscribeEvent
	public void regAddons(RegistryEvent.Register<Addon> event){
		File addonfolder = new File(FCL.getInstance().getConfigDirectory().getParentFile().getParentFile(), "/addons/");
		if(!addonfolder.exists()){
			addonfolder.mkdirs();
		}
		for(File file : addonfolder.listFiles()){
			if(Addon.isAddonContainer(file)){
				try{
					Addon addon = GenericAddon.isHybrid(file) ? HybridAddon.getClass(file).getConstructor(File.class).newInstance(file) : new GenericAddon(file);
					event.getRegistry().register(addon);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		for(Addon addon : ADDONS.getValues()){
			if(Static.side().isClient()){
				Print.log("Registering Addonpack into Forge/Minecraft resources...");
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("modid", FVTM.MODID + "");
				map.put("name", "[FVTM]: " + addon.getFile().getName());
				map.put("version", addon.getVersion());
				FMLModContainer container = new FMLModContainer("net.fexcraft.mod.fvtm.FVTM", new ModCandidate(addon.getFile(), addon.getFile(), addon.getFile().isDirectory() ? ContainerType.DIR : ContainerType.JAR), map);
				container.bindMetadata(MetadataCollection.from(null, ""));
				net.minecraftforge.fml.client.FMLClientHandler.instance().addModAsResource(container);
			}
		}
		if(Static.side().isClient() && ADDONS.getEntries().size() > 0){
			net.minecraft.client.Minecraft.getMinecraft().refreshResources();
		}
	}
	
	@SubscribeEvent
	public void regMaterials(RegistryEvent.Register<Material> event){
		this.queryAddons();
		for(Addon addon : ADDONS.getValues()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon)addon).isHybrid()){
					((HybridAddon)addon).regMaterials(event);
					if(((HybridAddon)addon).skipDefaultRegistryMethods()){
						continue;
					}
				}
			}
			else{
				continue;
			}
			Print.debug(addon.getRegistryName());
			if(addon.isEnabled()/* && !addon.hasMissingDependencies()*/){
				if(addon.getFile().isDirectory()){
					File matfol = new File(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/materials/");
					Print.debug(matfol.getPath());
					if(!matfol.exists()){ matfol.mkdirs();}
					for(File file : matfol.listFiles()){
						if(!file.isDirectory() && file.getName().endsWith(".material")){
							GenericMaterial mat = new GenericMaterial(JsonUtil.get(file));
							event.getRegistry().register(mat);
							net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericMaterialItem.INSTANCE, mat.getRegistryName());
							Print.debug(mat.getRegistryName());
						}
						Print.debug(file.getPath());
						//else skip;
					}
				}
				else{
					JsonArray array = ZipUtil.getJsonObjectsAt(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/materials/", ".material");
					for(JsonElement elm : array){
						GenericMaterial mat = new GenericMaterial(elm.getAsJsonObject());
						event.getRegistry().register(mat);
						net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericMaterialItem.INSTANCE, mat.getRegistryName());
						Print.debug(mat.getRegistryName());
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void regParts(RegistryEvent.Register<Part> event){
		this.queryAddons();
		for(Addon addon : ADDONS.getValues()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon)addon).isHybrid()){
					((HybridAddon)addon).regParts(event);
					if(((HybridAddon)addon).skipDefaultRegistryMethods()){
						continue;
					}
				}
			}
			else{
				continue;
			}
			Print.debug(addon.getRegistryName());
			if(addon.isEnabled()/* && !addon.hasMissingDependencies()*/){
				if(addon.getFile().isDirectory()){
					File partfol = new File(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/parts/");
					Print.debug(partfol.getPath());
					if(!partfol.exists()){ partfol.mkdirs();}
					for(File file : partfol.listFiles()){
						if(!file.isDirectory() && file.getName().endsWith(".part")){
							GenericPart part = new GenericPart(JsonUtil.get(file));
							event.getRegistry().register(part);
							net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericPartItem.INSTANCE, part.getRegistryName());
							Print.debug(part.getRegistryName());
						}
						Print.debug(file.getPath());
						//else skip;
					}
				}
				else{
					JsonArray array = ZipUtil.getJsonObjectsAt(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/parts/", ".part");
					for(JsonElement elm : array){
						GenericPart part = new GenericPart(elm.getAsJsonObject());
						event.getRegistry().register(part);
						net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericPartItem.INSTANCE, part.getRegistryName());
						Print.debug(part.getRegistryName());
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void regLandVehicles(RegistryEvent.Register<LandVehicle> event){
		this.queryAddons();
		for(Addon addon : ADDONS.getValues()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon)addon).isHybrid()){
					((HybridAddon)addon).regLandVehicles(event);
					if(((HybridAddon)addon).skipDefaultRegistryMethods()){
						continue;
					}
				}
			}
			else{
				continue;
			}
			Print.debug(addon.getRegistryName());
			if(addon.isEnabled()/* && !addon.hasMissingDependencies()*/){
				if(addon.getFile().isDirectory()){
					File vehfol = new File(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/vehicles/");
					Print.debug(vehfol.getPath());
					if(!vehfol.exists()){ vehfol.mkdirs();}
					for(File file : vehfol.listFiles()){
						if(!file.isDirectory() && file.getName().endsWith(".vehicle")){
							GenericLandVehicle veh = new GenericLandVehicle(JsonUtil.get(file));
							event.getRegistry().register(veh);
							net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericLandVehicleItem.INSTANCE, veh.getRegistryName());
							Print.debug(veh.getRegistryName());
						}
						Print.debug(file.getPath());
						//else skip;
					}
				}
				else{
					JsonArray array = ZipUtil.getJsonObjectsAt(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/vehicles/", ".vehicle");
					for(JsonElement elm : array){
						GenericLandVehicle veh = new GenericLandVehicle(elm.getAsJsonObject());
						event.getRegistry().register(veh);
						net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericLandVehicleItem.INSTANCE, veh.getRegistryName());
						Print.debug(veh.getRegistryName());
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void regPartAttributes(RegistryEvent.Register<Attribute> event){
		for(Addon addon : ADDONS.getValues()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon)addon).isHybrid()){
					((HybridAddon)addon).regAttributes(event);
					if(((HybridAddon)addon).skipDefaultRegistryMethods()){
						continue;
					}
				}
			}
			else{
				continue;
			}
		}
	}
	
	@SubscribeEvent
	public void regFuels(RegistryEvent.Register<Fuel> event){
		for(Addon addon : ADDONS.getValues()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon)addon).isHybrid()){
					((HybridAddon)addon).regFuels(event);
					if(((HybridAddon)addon).skipDefaultRegistryMethods()){
						continue;
					}
				}
			}
			else{
				continue;
			}
		}
	}

	public static <T> T getModel(String name, Class<T> clazz, T def){
		if(name == null || name.equals("") || name.equals("null")){
			return def;
		}
		if(MODELS.containsKey(name)){
			return (T)MODELS.get(name);
		}
		ModelType type = getModelType(name);
		T model = null;
		try{
			switch(type){
				case JAVA:
				case TMT:
					Class clasz = Class.forName(name.replace(".class", ""));
					model = (T)clasz.newInstance();
					break;
				case JTMT:
					JsonObject obj = JsonUtil.getObjectFromInputStream(net.minecraft.client.Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(name)).getInputStream());
					model = (T)clazz.getConstructor(JsonObject.class).newInstance(obj);
					break;
				case JSON:
					//TODO
					break;
				case NONE:
				case OBJ:
				default:
					break;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		MODELS.put(name, model);
		return model;
	}
	
	public static ModelType getModelType(String modelname){
		String str = FilenameUtils.getExtension(modelname);
		switch(str){
			case "class": return ModelType.TMT;
			case "json": return ModelType.JSON;
			case "jtmt": return ModelType.JTMT;
			case "obj": return ModelType.OBJ;
		}
		return ModelType.NONE;
	}
	
	public static final LandVehicleData getLandVehicleData(NBTTagCompound compound, boolean remote){
		if(compound.hasKey(LandVehicleItem.NBTKEY)){
			LandVehicle vehicle = LANDVEHICLES.getValue(new ResourceLocation(compound.getString(LandVehicleItem.NBTKEY)));
			if(vehicle != null){
				try{
					return vehicle.getDataClass().getConstructor(LandVehicle.class).newInstance(vehicle).readFromNBT(compound, remote);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public static final PartData getPartData(NBTTagCompound compound){
		if(compound.hasKey(PartItem.NBTKEY)){
			Part part = PARTS.getValue(new ResourceLocation(compound.getString(PartItem.NBTKEY)));
			if(part != null){
				try{
					return part.getDataClass().getConstructor(Part.class).newInstance(part).readFromNBT(compound);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public static final PartData getPartData(ResourceLocation rs){
		Part part = PARTS.getValue(rs);
		if(part != null){
			try{
				return part.getDataClass().getConstructor(Part.class).newInstance(part).readFromNBT(new NBTTagCompound());
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	
}