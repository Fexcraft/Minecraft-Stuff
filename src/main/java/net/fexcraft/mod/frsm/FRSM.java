package net.fexcraft.mod.frsm;

import java.io.File;

import net.fexcraft.mod.frsm.blocks.FRSM_Blocks;
import net.fexcraft.mod.frsm.blocks.TileEntities;
import net.fexcraft.mod.frsm.commads.FRSM_Command;
import net.fexcraft.mod.frsm.commads.SummonRobo;
import net.fexcraft.mod.frsm.entities.Entities;
import net.fexcraft.mod.frsm.guis.GuiHandler;
import net.fexcraft.mod.frsm.items.FRSM_Items;
import net.fexcraft.mod.frsm.network.Network;
import net.fexcraft.mod.frsm.proxy.Common;
import net.fexcraft.mod.frsm.recipes.Recipes_Chairs;
import net.fexcraft.mod.frsm.recipes.Recipes_Chimneys;
import net.fexcraft.mod.frsm.recipes.Recipes_DecoBlocks;
import net.fexcraft.mod.frsm.recipes.Recipes_Flags;
import net.fexcraft.mod.frsm.recipes.Recipes_Food;
import net.fexcraft.mod.frsm.recipes.Recipes_Keys;
import net.fexcraft.mod.frsm.recipes.Recipes_Lamps;
import net.fexcraft.mod.frsm.recipes.Recipes_Laptops;
import net.fexcraft.mod.frsm.recipes.Recipes_Materials;
import net.fexcraft.mod.frsm.recipes.Recipes_Other;
import net.fexcraft.mod.frsm.recipes.Recipes_PaintStuff;
import net.fexcraft.mod.frsm.recipes.Recipes_Palets;
import net.fexcraft.mod.frsm.recipes.Recipes_Pillars;
import net.fexcraft.mod.frsm.recipes.Recipes_Rails;
import net.fexcraft.mod.frsm.recipes.Recipes_Robo;
import net.fexcraft.mod.frsm.recipes.Recipes_Stove_Pipes;
import net.fexcraft.mod.frsm.recipes.Recipes_TechnicalStuff;
import net.fexcraft.mod.frsm.recipes.Recipes_Tiles;
import net.fexcraft.mod.frsm.recipes.Recipes_Tools;
import net.fexcraft.mod.frsm.recipes.Recipes_TreePot;
import net.fexcraft.mod.frsm.util.FI;
import net.fexcraft.mod.frsm.util.PrintLog;
import net.fexcraft.mod.frsm.util.custom.CT;
import net.fexcraft.mod.frsm.util.custom.FuelHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = FI.MODID, name = FI.NAME, version = FRSM.version, updateJSON = "http://fexcraft.net/minecraft/fcl/request?mode=getForgeUpdateJson&modid=frsm", dependencies = "required-after:fcl")
public class FRSM{
	
	public static final String version = "3.7.15"; 
	public static final String vnote = "Perhaps not the main Mod anymore?";
	
	@SidedProxy(clientSide = "net.fexcraft.mod.frsm.proxy.Client", serverSide = "net.fexcraft.mod.frsm.proxy.Common")
    public static Common proxy;
	
	@Mod.Instance(FI.MODID)
	private static FRSM instance;
	
	public static boolean conf1, conf2, conf3, conf4, conf5;
	public static boolean custom/*, temt*/;
	public static File mainpath, datapath, tempdata;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		
		mainpath = new File(event.getModConfigurationDirectory(), "/frsm/");
		if(!mainpath.exists()){
			PrintLog.print("FRSM", "FRSM Main folder not found. Creating empty folder.");
			mainpath.mkdirs();
		}
		
		datapath = new File(mainpath, "data/");
		if (!datapath.exists()){
			PrintLog.print("FRSM", "FRSM Data folder not found. Creating empty folder.");
			datapath.mkdirs();
		}
		
		tempdata = new File(mainpath, "temp/");
		if(!tempdata.exists()){
			PrintLog.print("FRSM", "FRSM TempData folder not found. Creating empty folder.");
			tempdata.mkdirs();
		}
		for(File file : tempdata.listFiles()){
			file.delete();
		}
		
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	    config.load();
	    //librarymode = config.getBoolean("library_mode", "###[> Internal <]###", false, "Should only the util/base classes be loaded? (No Blocks/Items except needed ones)");
	    custom      = config.getBoolean("custom_stuff", "###[> Internal <]###", false, "Should the custom Item/Block/Recipe/Addon/etc. loader be enabled?");
	    conf1       = config.getBoolean("robo_crafting", "###[> RoboStuff <]###", true, "Robo Crafting Recipes");
	    conf2       = config.getBoolean("random_cookies_from_grass", "###{> Generator <]###", true, "Grass Dropping randomly cookies when breaking it");
	    conf3       = config.getBoolean("generate_stone_light_box", "###{> Generator <]###", true, "This function is unavaible actually.");
	    conf4       = config.getBoolean("enable_update_checker", "###{> Other <]###", true, "Selfexplaining.");
	    //angle       = config.getInt("model_rotation_angle", "###[> Model Config <]###", 0, -360, 360, "Set rotation angle of blocks with Custom model, valid values: 0, -90, -180, -270, 90, 180, 270.");
	    //temt        = config.getBoolean("model_render_customisation", "###[> Model Config <]###", false, "Should FRSM TEMT rendering be enabled?");
	    conf5       = config.getBoolean("robo_entities", "###[> RoboStuff <]###", true, "Should FRSM robots be enabled?");
	    config.save();
	    
	    Side side = event.getSide();
	    CT.initDefaults(side);
	    FRSM_Blocks.register();
	    FRSM_Blocks.registerItemRenders(side);
	    FRSM_Items.register();
	    FRSM_Items.registerItemRenders(side);
	    
	    TileEntities.register();
	    Entities.register();
	    
	    Recipes_PaintStuff.register();
	    Recipes_Chairs.register();
	    Recipes_Chimneys.register();
	    Recipes_DecoBlocks.register();
	    Recipes_Flags.register();
	    Recipes_Food.register();
	    Recipes_Keys.register();
	    Recipes_Lamps.register();
	    Recipes_Laptops.register();
	    Recipes_Materials.register();
	    Recipes_Other.register();
	    Recipes_Palets.register();
	    Recipes_Pillars.register();
	    Recipes_Rails.register();
	    Recipes_Stove_Pipes.register();
	    Recipes_Tools.register();
	    Recipes_TechnicalStuff.register();
	    Recipes_Tiles.register();
	    Recipes_TreePot.register();
	    
	    if(conf1 == true){
	    	Recipes_Robo.register();
		}
		if(conf2 == true){
			MinecraftForge.addGrassSeed(new ItemStack(Items.WHEAT), 1);
			MinecraftForge.addGrassSeed(new ItemStack(FRSM_Items.chocolate_cookie), 2);
		}
	    
	    //CUSTOM LOAD/INIT
	}
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event){
		proxy.reload();
		
		
		FuelHandler.init();
		GameRegistry.registerFuelHandler(new FuelHandler());
		MinecraftForge.addGrassSeed(new ItemStack(FRSM_Items.tomato_seeds), 1);
		proxy.registerRenders();
		
		Network.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
	}
	
	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event){
		event.registerServerCommand(new FRSM_Command());
		event.registerServerCommand(new SummonRobo());
	}
	
	@Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
		
    }
	
	public static FRSM getInstance(){
		return instance;
	}
}