package net.fexcraft.mod.fvm.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvm.data.LoadedIn;
import net.fexcraft.mod.fvm.data.Material;
import net.fexcraft.mod.fvm.data.PartType;
import net.fexcraft.mod.fvm.data.VehicleType;
import net.fexcraft.mod.fvm.items.MaterialItem;
import net.fexcraft.mod.fvm.items.PartItem;
import net.fexcraft.mod.fvm.items.VehicleItem;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.FMLModContainer;
import net.minecraftforge.fml.common.MetadataCollection;
import net.minecraftforge.fml.common.discovery.ContainerType;
import net.minecraftforge.fml.common.discovery.ModCandidate;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FvmResources {
	
	public static final ResourceLocation NULL_TEXTURE = new ResourceLocation("fvm:textures/entities/null_texture");
	public static boolean FFMM = false;
	public static final String MODID = "fvm";
	private static File configpath;
	//
	private static final TreeSet<VehicleType> rawTypes = new TreeSet<VehicleType>();
	private static final TreeSet<PartType> rawParts = new TreeSet<PartType>();
	private static final TreeSet<Material> rawMaterials = new TreeSet<Material>();
	private static final HashSet<JsonObject> temp_objs = new HashSet<JsonObject>();
	private static final HashSet<JsonObject> part_objs = new HashSet<JsonObject>();
	private static final HashSet<JsonObject> mate_objs = new HashSet<JsonObject>();
	
	public static final CreativeTabs VEHICLES = new CreativeTabs("fvm_vehicles"){
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(Registry.getItem("fvm:vehicle_item"));
		}
	};
	
	public static final CreativeTabs PARTS = new CreativeTabs("fvm_parts"){
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(Registry.getItem("fvm:part_null"));
		}
	};
	
	public static final CreativeTabs MATERIALS = new CreativeTabs("fvm_materials"){
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(Registry.getItem("fvm:material_null"));
		}
	};
	
	public static final CreativeTabs BLOCKS = new CreativeTabs("fvm_blocks"){
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(Blocks.IRON_BLOCK);
		}
	};
	
	public static void setup(FMLPreInitializationEvent event){
		configpath = new File(event.getSuggestedConfigurationFile().getParentFile(), "/fvm/");
		if(!configpath.exists()){
			configpath.mkdirs();
		}
	}
	
	public static final void scanForContent(FMLPreInitializationEvent event){
		List<File> mods = new ArrayList<File>();
		File modDir = new File(event.getModConfigurationDirectory().getParentFile(), "/mods");
		for(File file : modDir.listFiles()){
			if(file.isDirectory() || file.getName().endsWith(".zip") || file.getName().endsWith(".jar")){
				mods.add(file);
			}
		}
		for(File rpack : mods){
			temp_objs.addAll(getObjects(rpack, "/assets/" + MODID + "/config/vehicles", ".vehicle"));
			part_objs.addAll(getObjects(rpack, "/assets/" + MODID + "/config/parts", ".fvm"));
			mate_objs.addAll(getObjects(rpack, "/assets/" + MODID + "/config/materials", ".fvm"));
		}
		if(Static.dev()){
			temp_objs.addAll(getObjects(new File(modDir.getParentFile().getParentFile(), "/src/main/resources"), "/assets/" + MODID + "/config/vehicles", ".vehicle"));
			part_objs.addAll(getObjects(new File(modDir.getParentFile().getParentFile(), "/src/main/resources"), "/assets/" + MODID + "/config/parts", ".fvm"));
			mate_objs.addAll(getObjects(new File(modDir.getParentFile().getParentFile(), "/src/main/resources"), "/assets/" + MODID + "/config/materials", ".fvm"));
		}
		for(JsonObject obj : mate_objs){
			try{
				rawMaterials.add(new Material(LoadedIn.MEMORY, obj));
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		mate_objs.clear();
		ArrayList<Material> mtypes = new ArrayList<Material>();
		for(Material type : rawMaterials){
			if(type.registryname == null || type.registryname.equals("null")){
				mtypes.add(type);
			}
		}
		rawMaterials.removeAll(mtypes);
		//Load Parts after the Materials.
		for(JsonObject obj : part_objs){
			try{
				rawParts.add(new PartType(LoadedIn.MEMORY, obj));
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		part_objs.clear();
		ArrayList<PartType> ptypes = new ArrayList<PartType>();
		for(PartType type : rawParts){
			if(type.registryname == null || type.registryname.equals("null")){
				ptypes.add(type);
			}
		}
		rawParts.removeAll(ptypes);
		//Load Vehicles after the Parts.
		for(JsonObject obj : temp_objs){
			try{
				rawTypes.add(new VehicleType(LoadedIn.MEMORY, obj));
			}
			catch(Exception e){
				e.printStackTrace();
				Static.stop();
			}
		}
		temp_objs.clear();
		ArrayList<VehicleType> types = new ArrayList<VehicleType>();
		for(VehicleType type: rawTypes){
			if(type.registryname == null || type.registryname.equals("null")){
				types.add(type);
			}
		}
		rawTypes.removeAll(types);
		//Load Models
		for(VehicleType type : rawTypes){
			loadVehicleModel(type);
		}
		for(PartType type : rawParts){
			loadPartModel(type);
		}
	}

	public static final void loadVehicleModel(VehicleType type){
		if(Static.side().isServer()){
			return;
		}
		if(type.modelname == null || type.modelname.equals("null")){
			type.loadModel(null);
		}
		else if(type.modelname.endsWith(".class")){
			JsonObject obj = new JsonObject();
			obj.addProperty("type", "class");
			type.loadModel(obj);
		}
		else{
			type.loadModel(getObject(new ResourceLocation(type.modelname)));
		}
	}
	
	private static void loadPartModel(PartType type){
		if(Static.side().isServer()){
			return;
		}
		if(type.modelname == null || type.modelname.equals("null")){
			type.loadModel(null);
		}
		else if(type.modelname.endsWith(".class")){
			JsonObject obj = new JsonObject();
			obj.addProperty("type", "class");
			type.loadModel(obj);
		}
		else{
			type.loadModel(getObject(new ResourceLocation(type.modelname)));
		}
	}
	
	public static final VehicleType getVehicle(String s){
		for(VehicleType type : rawTypes){
			if(type.registryname.equals(s)){
				return type;
			}
		}
		return null;
	}
	
	public static final VehicleType getNewInstanceOf(LoadedIn state, String s){
		VehicleType type = getVehicle(s);
		if(type == null){
			Static.exception(4);
		}
		VehicleType vehc = (VehicleType)type.newInstance(state);
		vehc.model = type.model;
		return vehc;
	}
	
	public static VehicleType getNewInstanceOf(LoadedIn state, ItemStack itemstack){
		if(itemstack.getMetadata() == 0){
			VehicleType type = new VehicleType(state, itemstack.getTagCompound());
			loadVehicleModel(type);
			return type;
		}
		else{
			VehicleType type = ((VehicleItem)itemstack.getItem()).getType(itemstack);
			if(type == null){
				Static.exception(4);
			}
			VehicleType vehc = (VehicleType)type.newInstance(state);
			vehc.model = type.model;
			return vehc;
		}
	}
	
	public static final PartType getPart(String s){
		for(PartType type : rawParts){
			if(type.registryname.equals(s)){
				return type;
			}
		}
		//Static.stop();
		return null;
	}
	
	public static final ArrayList<PartType> getPartsByCategory(String s){
		ArrayList<PartType> list = new ArrayList<PartType>();
		for(PartType type : rawParts){
			if(type.category.equals(s)){
				list.add(type);
			}
		}
		return list;
	}
	
	@SideOnly(Side.CLIENT)
	public static final JsonObject getObject(ResourceLocation rs){
		try{
			return JsonUtil.getFromInputStream(Minecraft.getMinecraft().getResourceManager().getResource(rs).getInputStream());
		}
		catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	private static final Set<JsonObject> getObjects(File dfile, String prefix, String suffix){
		Set<JsonObject> set = new HashSet<JsonObject>();
		if(dfile.isDirectory()){
			File assets = new File(dfile, prefix);
			if(assets.exists()){
				for(File file : assets.listFiles()){
					if(file.getName().endsWith(suffix)){
						try{
							set.add(JsonUtil.getFromInputStream(new FileInputStream(file)));
						}
						catch(FileNotFoundException e){
							e.printStackTrace();
						}
					}
				}
			}
		}
		else{
			if(prefix.startsWith("/")){
				prefix = prefix.substring(1, prefix.length());
			}
			try{
				ZipFile zip = new ZipFile(dfile);
				ZipInputStream stream = new ZipInputStream(new FileInputStream(dfile));
				BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
				while(true){
					ZipEntry entry = stream.getNextEntry();
					if(entry == null){
						break;
					}
					if(entry.getName().contains(prefix) && entry.getName().endsWith(suffix)){
						try{
							set.add(JsonUtil.getFromInputStream(zip.getInputStream(entry)));
						}
						catch(FileNotFoundException e){
							e.printStackTrace();
						}
					}
				}
				reader.close();
				zip.close();
				stream.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		if(Static.side().isClient()){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("modid", MODID);
			map.put("name", "FMV : " + dfile.getName());
			map.put("version", "1");
			FMLModContainer container = new FMLModContainer("net.fexcraft.mod.fvm.FVM", new ModCandidate(dfile, dfile, dfile.isDirectory() ? ContainerType.DIR : ContainerType.JAR), map);
			container.bindMetadata(MetadataCollection.from(null, ""));
			net.minecraftforge.fml.client.FMLClientHandler.instance().addModAsResource(container);
		}
		return set;
	}
	
	public static void addPart(PartType type){
		rawParts.add(type);
	}
	
	public static void removePart(PartType type){
		if(type != null){
			rawParts.remove(type);
		}
	}
	
	public static void removePart(String string){
		removePart(getPart(string));
	}
	
	public static void addVehicle(VehicleType type){
		rawTypes.add(type);
	}
	
	public static void removeVehicle(VehicleType type){
		if(type != null){
			rawTypes.remove(type);
		}
	}
	
	public static void removeVehicle(String string){
		removeVehicle(getVehicle(string));
	}

	public static PartType getPart(ItemStack stack){
		return ((PartItem)stack.getItem()).getType(stack);
	}
	
	public static Material getMaterial(ItemStack stack){
		return ((MaterialItem)stack.getItem()).getType(stack);
	}

	public static boolean isDefaultPart(String registryname, String category){
		for(VehicleType type : rawTypes){
			if(type.registryname.equals(registryname)){
				if(type.requires.contains(category)){
					return true;
				}
			}
		}
		return false;
	}

	public static TreeSet<PartType> getParts(){
		return rawParts;
	}
	
	public static TreeSet<Material> getMaterails(){
		return rawMaterials;
	}
	
}