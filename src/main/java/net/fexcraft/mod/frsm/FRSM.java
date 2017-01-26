package net.fexcraft.mod.frsm;

import java.io.File;

import net.fexcraft.mod.frsm.commads.MainCommand;
import net.fexcraft.mod.frsm.guis.GuiHandler;
import net.fexcraft.mod.frsm.util.*;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = FI.MODID, name = FI.NAME, version = FRSM.version, updateJSON = "http://fexcraft.net/minecraft/fcl/request?mode=getForgeUpdateJson&modid=frsm", dependencies = "required-after:fcl")
public class FRSM{
	
	public static final String version = "4.0.00"; 
	public static final String vnote = "Some new stuffs. Finally?";
	
	@Mod.Instance(FI.MODID)
	private static FRSM instance;
	
	public static boolean conf1, conf2, conf3, conf4, conf5;
	public static File mainpath, datapath, tempdata;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		mainpath = new File(event.getModConfigurationDirectory(), "/frsm/");
		if(!mainpath.exists()){
			Print.log("FRSM", "FRSM Main folder not found. Creating empty folder.");
			mainpath.mkdirs();
		}
		datapath = new File(mainpath, "data/");
		if (!datapath.exists()){
			Print.log("FRSM", "FRSM Data folder not found. Creating empty folder.");
			datapath.mkdirs();
		}
		tempdata = new File(mainpath, "temp/");
		if(!tempdata.exists()){
			Print.log("FRSM", "FRSM TempData folder not found. Creating empty folder.");
			tempdata.mkdirs();
		}
		for(File file : tempdata.listFiles()){
			file.delete();
		}
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	    config.load();
	    conf1       = config.getBoolean("robo_crafting", "###[> RoboStuff <]###", true, "Robo Crafting Recipes");
	    conf2       = config.getBoolean("random_cookies_from_grass", "###{> Generator <]###", true, "Grass Dropping randomly cookies when breaking it");
	    conf3       = config.getBoolean("generate_stone_light_box", "###{> Generator <]###", true, "This function is unavaible actually.");
	    conf4       = config.getBoolean("enable_update_checker", "###{> Other <]###", true, "Selfexplaining.");
	    conf5       = config.getBoolean("robo_entities", "###[> RoboStuff <]###", true, "Should FRSM robots be enabled?");
	    config.save();
	    
	    Registry.registerAllBlocks(FI.MODID, event.getAsmData());
	    Registry.loadLoadAnnotations(event.getAsmData(), 99);
	    Registry.registerAllItems(FI.MODID, event.getAsmData());
	    Registry.registerAllEntities(FI.MODID, event.getAsmData());
	    
	    /*Recipes_PaintStuff.register();
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
	    Recipes_TreePot.register();*/
	    
	    if(conf1 == true){
	    	//Recipes_Robo.register();
		}
		if(conf2 == true){
			MinecraftForge.addGrassSeed(new ItemStack(Items.WHEAT), 1);
			MinecraftForge.addGrassSeed(new ItemStack(Registry.getItem("frsm:chocolate_cookie")), 2);
		}
	}
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event){
		FuelHandler.initialize();
		GameRegistry.registerFuelHandler(new FuelHandler());
		MinecraftForge.addGrassSeed(new ItemStack(Registry.getItem("frsm:tomato_seeds")), 1);
		
		Data.getDataFromServer();
		MinecraftForge.EVENT_BUS.register(new UpdateHandler.EventHandler());
		UpdateHandler.load();
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
	}
	
	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event){
		event.registerServerCommand(new MainCommand());
	}
	
	@Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
		
    }
	
	public static FRSM getInstance(){
		return instance;
	}
	
}