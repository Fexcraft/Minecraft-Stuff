package net.fexcraft.mod.famm;

import java.io.File;

import net.fexcraft.mod.famm.blocks.FAMMBlocks;
import net.fexcraft.mod.famm.items.FAMMItems;
import net.fexcraft.mod.famm.register.HalfBlockRecipes;
import net.fexcraft.mod.famm.register.Recipes;
import net.fexcraft.mod.famm.util.Data;
import net.fexcraft.mod.famm.util.FAMMEventHandler;
import net.fexcraft.mod.famm.util.FI;
import net.fexcraft.mod.famm.util.UpdateHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

//@Mod(modid = "famm", name = "Fex's Alphabet & More Mod", version = FI.VERSION, updateJSON = "http://fexcraft.net/minecraft/fcl/request?mode=getForgeUpdateJson&modid=famm", dependencies = "required-after:fcl")
public class FAMM {
	
	//public static boolean conf1;
	public static boolean conf2;
	public static boolean conf3;
	public static boolean conf4;
	public static boolean conf5;
	public static boolean conf6;
	
	public static File temp_path;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		temp_path = new File(event.getModConfigurationDirectory().getParent(), "/FRSM/FRSM_Data/");
		if(!temp_path.exists()){
			temp_path.mkdirs();
		}
		
		//Config Stuff
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	    config.load();
	    //conf1 = config.getBoolean("enable_update_checker", "###[> General <]###", true, "Update Checker");
	    conf2 = config.getBoolean("enable_default_blocks", "###{> Blocks <]###", true, "Should default FAMM Blocks be enabled?");
	    conf3 = config.getBoolean("enable_half_blocks", "###{> Blocks <]###", true, "Should FAMM HalfBlocks be enabled?.");
	    conf4 = config.getBoolean("enable_centered_half_blocks", "###{> Blocks <]###", true, "Should FAMM Centered HalfBlocks be enabled?");
	    conf5 = config.getBoolean("enable_slabs", "###{> Blocks <]###", true, "Should FAMM Slabs be enabled?");
	    conf6 = config.getBoolean("enable_tiles", "###{> Blocks <]###", true, "Should FAMM Tiles be enabled?");
	    
	    config.save();
	    //Config End
		
		if(FAMM.conf2 == true){
			FAMMBlocks.initlizeDefault();
		}
		if(FAMM.conf3 == true){
			FAMMBlocks.initlizeHalfBlocks();
		}
		
		FAMMItems.init();
		Recipes.init();
		HalfBlockRecipes.init();
	}
	
	public static CreativeTabs tabFAMM = new CreativeTabs("tabFAMM"){
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Item.getItemFromBlock(FAMMBlocks.get("f")));
		}
	};
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new FAMMEventHandler());
		Data.getDataFromServer();
		UpdateHandler.init();
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
