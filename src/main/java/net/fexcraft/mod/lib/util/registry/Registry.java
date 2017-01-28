package net.fexcraft.mod.lib.util.registry;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import net.fexcraft.mod.lib.FCL;
import net.fexcraft.mod.lib.api.block.öBlock;
import net.fexcraft.mod.lib.api.common.öCreativeTab;
import net.fexcraft.mod.lib.api.common.öLoad;
import net.fexcraft.mod.lib.api.entity.öEntity;
import net.fexcraft.mod.lib.api.item.öItem;
import net.fexcraft.mod.lib.api.render.öModel;
import net.fexcraft.mod.lib.api.render.öTESR;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.render.ModelType;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.discovery.ASMDataTable;
import net.minecraftforge.fml.common.discovery.ASMDataTable.ASMData;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Registry {
	
	private static final boolean writetofile = false;
	private static Map<ResourceLocation, Block> blocks = new HashMap<ResourceLocation, Block>();
	private static Map<ResourceLocation, Item> items = new HashMap<ResourceLocation, Item>();
	private static Map<ResourceLocation, Entity> entities = new HashMap<ResourceLocation, Entity>();
	private static Map<ResourceLocation, Object> models = new HashMap<ResourceLocation, Object>();
	private static final String blöck = öBlock.class.getCanonicalName();
	private static final String itém = öItem.class.getCanonicalName();
	private static final String éntity = öEntity.class.getCanonicalName();
	private static final String mödel = öModel.class.getCanonicalName();
	private static final String tésr = öTESR.class.getCanonicalName();
	private static int eid = 0;
	
	public static void registerAllBlocks(String modid, ASMDataTable table){
		Set<ASMData> data = table.getAll(blöck);
		ArrayList<String> arr = new ArrayList<String>();
		for(ASMData entry : data){
			try{
				Class<? extends Block> cBlock = (Class<? extends Block>)Class.forName(entry.getClassName());
				öBlock block = cBlock.getAnnotation(öBlock.class);
				if(block.modid().equals(modid)){
					Block mBlock = cBlock.newInstance();
					mBlock.setRegistryName(block.modid(), block.name());
					mBlock.setUnlocalizedName(mBlock.getRegistryName().toString());
					blocks.put(mBlock.getRegistryName(), mBlock);
					GameRegistry.register(mBlock);
					//Item
					ItemBlock itemblock = block.item().getConstructor(Block.class).newInstance(mBlock);
					itemblock.setRegistryName(mBlock.getRegistryName());
					itemblock.setUnlocalizedName(mBlock.getUnlocalizedName());
					GameRegistry.register(itemblock);
					registerItemModelLocation(itemblock, block.variants(), block.custom_variants());
					//TileEntity
					if(mBlock instanceof ITileEntityProvider){
						GameRegistry.registerTileEntity(block.tileentity(), mBlock.getRegistryName().toString());
					}
					if(Static.dev()){
						Print.log("Registered Block: " + mBlock.getRegistryName().toString());
						arr.add(mBlock.getRegistryName().toString());
					}
				}
				else continue;
			}
			catch(Exception e){
				error(e, entry.getClassName());
			}
		}
		write(modid, "block", arr);
	}
	
	private static final void write(String modid, String type, ArrayList<String> arr){
		try{
			if(!Static.dev() || !writetofile){
				return;
			}
			@SuppressWarnings("unused")
			File file = new File(FCL.getInstance().getConfigDirectory(), "/fcl/LANG-TEMP/" + modid + "_" + type + ".fcl");
			if(!file.exists()){
				file.getParentFile().mkdirs();
				FileWriter flw = new FileWriter(file);
				flw.write("");
				flw.close();
			}
			Collections.sort(arr);
			FileWriter fw = new FileWriter(file);
			fw.write(new String(Files.readAllBytes(file.toPath())));
			String prefix = type.contains("block") ? "tile." : "item.";
			for(String s : arr){
				if(!contains(file, s)){
					fw.append(prefix + s + ".name=\n");
				}
			}
			fw.flush();
			fw.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static boolean contains(File file, String string){
		try{
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				if(scanner.nextLine().contains(string)){
					scanner.close();
					return true;
				}
			}
			scanner.close();
			return false;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public static void registerAllItems(String modid, ASMDataTable table){
		Set<ASMData> data = table.getAll(itém);
		ArrayList<String> arr = new ArrayList<String>();
		for(ASMData entry : data){
			try{
				Class<? extends Item> cItem = (Class<? extends Item>)Class.forName(entry.getClassName());
				öItem item = cItem.getAnnotation(öItem.class);
				if(item.modid().equals(modid)){
					Item mItem = cItem.newInstance();
					mItem.setRegistryName(item.modid(), item.name());
					mItem.setUnlocalizedName(mItem.getRegistryName().toString());
					items.put(mItem.getRegistryName(), mItem);
					GameRegistry.register(mItem);
					registerItemModelLocation(mItem, item.variants(), item.custom_variants());
					if(Static.dev()){
						Print.log("Registered Item: " + mItem.getRegistryName().toString());
						arr.add(mItem.getRegistryName().toString());
					}
				}
				else continue;
			}
			catch(Exception e){
				error(e, entry.getClassName());
			}
		}
		write(modid, "item", arr);
	}
	
	public static void registerAllEntities(String modid, ASMDataTable table){
		Set<ASMData> data = table.getAll(éntity);
		for(ASMData entry : data){
			try{
				Class<? extends Entity> cEntity = (Class<? extends Entity>)Class.forName(entry.getClassName());
				öEntity entity = cEntity.getAnnotation(öEntity.class);
				if(entity.modid().equals(modid)){
					ResourceLocation rs = new ResourceLocation(entity.modid(), entity.name());
					EntityRegistry.registerModEntity(rs, cEntity, rs.toString(), eid++, entity.modid(), entity.tracking_range(), entity.update_frequency(), entity.send_velocity_updates());
					if(Static.dev()){
						Print.log("Registered Entity: " + rs.toString());
					}
				}
				else continue;
			}
			catch(Exception e){
				error(e, entry.getClassName());
			}
		}
	}
	
	public static void scanForModels(ASMDataTable table){
		Set<ASMData> data = table.getAll(mödel);
		for(ASMData entry : data){
			try{
				öModel model = entry.getClass().getAnnotation(öModel.class);
				models.put(new ResourceLocation(model.type().toString(), model.name()), entry.getClass().newInstance());
			}
			catch(Exception e){
				error(e, entry.getClassName());
			}
		}
	}
	
	public static void loadLoadAnnotations(ASMDataTable table, int l){
		Set<ASMData> data = table.getAll(öLoad.class.getCanonicalName());
		for(ASMData entry : data){
			try{
				Class<?> clazz = Class.forName(entry.getClassName());
				öLoad load = clazz.getAnnotation(öLoad.class);
				if(load.turn() == l){
					clazz.newInstance();
					if(load.value()){
						//scan for other stuffs
						for(Field field : clazz.getDeclaredFields()){
							öCreativeTab ct = field.getAnnotation(öCreativeTab.class);
							if(ct!= null){
								CreativeTabs cts = new CreativeTab(ct.name(), ct.icon(), ct.meta());
								field.set(CreativeTabs.class, cts);
							}
						}
					}
				}
			}
			catch(Exception e){
				error(e, entry.getClassName());
			}
		}
	}
	
	public static Object getModel(ResourceLocation rs){
		for(ResourceLocation res : models.keySet()){
			if(res.equals(rs)){
				return models.get(res);
			}
		}
		return null;
	}
	
	public static Object getModel(String rs){
		return getModel(new ResourceLocation(rs));
	}
	
	public static Object getModel(ModelType type, String s){
		return getModel(new ResourceLocation(type.toString(), s));
	}
	
	private static void registerItemModelLocation(Item item, int meta, String[] names){
		if(FCL.getSide().isServer()){
			return;
		}
		if(meta > 1){
			if(names == null || names.length < 1){
				for(int i = 0; i < meta; i++){
					net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName() + "_" + i, "inventory"));
				}
			}
			else{
				for(int i = 0; i < meta; i++){
					net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName() + "_" + names[i], "inventory"));
				}
			}
		}
		else{
			net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
	}
	
	private static final void error(Exception e, String s){
		Print.log("Error while constructing " + s + "!");
		e.printStackTrace();
		Static.stop();
	}
	
	public static Material getMaterial(String material){
		switch(material){
			case "air": return Material.AIR;
			case "grass": return Material.GRASS;
			case "ground": return Material.GROUND;
			case "wood": return Material.WOOD;
			case "rock": return Material.ROCK;
			case "iron": return Material.IRON;
			case "anvil": return Material.ANVIL;
			case "water": return Material.WATER;
			case "lava": return Material.LAVA;
			case "leaves": return Material.LEAVES;
			case "plants": return Material.PLANTS;
			case "vine": return Material.VINE;
			case "sponge": return Material.SPONGE;
			case "cloth": return Material.CLOTH;
			case "fire": return Material.FIRE;
			case "sand": return Material.SAND;
			case "circuits": return Material.CIRCUITS;
			case "carpet": return Material.CARPET;
			case "glass": return Material.GLASS;
			case "redstone_light": return Material.REDSTONE_LIGHT;
			case "tnt": return Material.TNT;
			case "coral": return Material.CORAL;
			case "ice": return Material.ICE;
			case "packed_ice": return Material.PACKED_ICE;
			case "snow": return Material.SNOW;
			case "crafted_snow": return Material.CRAFTED_SNOW;
			case "cactus": return Material.CACTUS;
			case "clay": return Material.CLAY;
			case "gourd": return Material.GOURD;
			case "dragon_egg": return Material.DRAGON_EGG;
			case "portal": return Material.PORTAL;
			case "cake": return Material.CAKE;
			case "web": return Material.WEB;
			default: return Material.AIR;
		}
	}

	public static final void registerAll(ASMDataTable table){
		registerAllBlocks("fcl", table);
		//registerAllItems("fcl", table);
		//registerAllEntities("fcl", table);
		registerTESRs(table);
		scanForModels(table);
		loadLoadAnnotations(table, 0);
	}

	public static Item getItem(String string){
		return getItem(new ResourceLocation(string));
	}

	private static Item getItem(ResourceLocation rs) {
		for(ResourceLocation res : items.keySet()){
			if(res.equals(rs)){
				return items.get(res);
			}
		}
		Static.exception(3, rs.toString());
		return null;
	}
	
	public static Block getBlock(String string){
		return getBlock(new ResourceLocation(string));
	}

	private static Block getBlock(ResourceLocation rs) {
		for(ResourceLocation res : blocks.keySet()){
			if(res.equals(rs)){
				return blocks.get(res);
			}
		}
		Static.exception(3, rs.toString());
		return null;
	}

	public static void registerTESRs(ASMDataTable table){
		if(FCL.getSide().isServer()){
			return;
		}
		Set<ASMData> data = table.getAll(tésr);
		for(ASMData entry : data){
			try{
				Class<? extends TileEntitySpecialRenderer> cTESR = (Class<? extends TileEntitySpecialRenderer>)Class.forName(entry.getClassName());
				öTESR tesr = cTESR.getAnnotation(öTESR.class);
				net.minecraftforge.fml.client.registry.ClientRegistry.bindTileEntitySpecialRenderer(tesr.tileentity(), cTESR.newInstance());
			}
			catch(Exception e){
				error(e, entry.getClassName());
			}
		}
	}

	public static void registerItemManually(String modid, String name, int meta, String[] custom, Item item) {
		item.setRegistryName(modid, name);
		item.setUnlocalizedName(item.getRegistryName().toString());
		items.put(item.getRegistryName(), item);
		GameRegistry.register(item);
		registerItemModelLocation(item, meta, custom);
		if(Static.dev()){
			Print.log("Registered Item: " + item.getRegistryName().toString());
		}
		//ArrayList<String> arr = new ArrayList<String>();
		//arr.add(item.getRegistryName().toString());
		//write(modid, "item_manual", arr);
	}
	
}