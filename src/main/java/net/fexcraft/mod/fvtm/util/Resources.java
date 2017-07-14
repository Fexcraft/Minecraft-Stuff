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
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.auto.GenericAddon;
import net.fexcraft.mod.fvtm.auto.GenericMaterial;
import net.fexcraft.mod.fvtm.auto.GenericMaterialItem;
import net.fexcraft.mod.fvtm.auto.GenericPart;
import net.fexcraft.mod.fvtm.auto.GenericPartItem;
import net.fexcraft.mod.lib.FCL;
import net.fexcraft.mod.lib.tmt.Model;
import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.common.ZipUtil;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.render.ModelType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
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
	public static final TreeMap<String, Object> MODELS = new TreeMap<String, Object>();
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
	}
	
	@SubscribeEvent
	public void regAddons(RegistryEvent.Register<Addon> event){
		File addonfolder = new File(FCL.getInstance().getConfigDirectory().getParentFile().getParentFile(), "/addons/");
		if(!addonfolder.exists()){
			addonfolder.mkdirs();
		}
		for(File file : addonfolder.listFiles()){
			if(Addon.isAddonContainer(file)){
				event.getRegistry().register(new GenericAddon(file));
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
				FMLClientHandler.instance().addModAsResource(container);
			}
		}
		if(Static.side().isClient()){
			net.minecraft.client.Minecraft.getMinecraft().refreshResources();
		}
	}
	
	@SubscribeEvent
	public void regMaterials(RegistryEvent.Register<Material> event){
		this.queryAddons();
		for(Addon addon : ADDONS.getValues()){
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
						GenericPart mat = new GenericPart(elm.getAsJsonObject());
						event.getRegistry().register(mat);
						net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericPartItem.INSTANCE, mat.getRegistryName());
						Print.debug(mat.getRegistryName());
					}
				}
			}
		}
	}

	public static Model getModel(String name, Class clazz){
		if(name == null || name.equals("") || name.equals("null")){
			return ModelBase.EMPTY;
		}
		if(MODELS.containsKey(name)){
			return (Model)MODELS.get(name);
		}
		ModelType type = getModelType(name);
		Model model = null;
		try{
			switch(type){
				case JAVA:
				case TMT:
					Class clasz = Class.forName(name.replace(".class", ""));
					model = (Model)clasz.newInstance();
					break;
				case JTMT:
					//TODO
					break;
				case JSON:
					JsonObject obj = JsonUtil.getObjectFromInputStream(net.minecraft.client.Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(name)).getInputStream());
					model = (Model)clazz.getConstructor(JsonObject.class).newInstance(obj);
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
	
}