package net.fexcraft.mod.extensions.fve;

import net.fexcraft.mod.extensions.fve.blocks.FVELBlocks;
import net.fexcraft.mod.extensions.fve.blocks.FVERBlocks;
import net.fexcraft.mod.extensions.fve.register.RenderItemFVEL;
import net.fexcraft.mod.extensions.fve.register.RenderItemFVER;
import net.fexcraft.mod.extensions.fve.register.RenderRegistry;
import net.fexcraft.mod.extensions.fve.register.TileEntitiesL;
import net.fexcraft.mod.extensions.fve.register.TileEntitiesR;
import net.fexcraft.mod.extensions.fve.util.Data;
import net.fexcraft.mod.extensions.fve.util.FI;
import net.fexcraft.mod.extensions.fve.util.FVEEventHandler;
import net.fexcraft.mod.extensions.fve.util.UpdateHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

//@Mod(modid = FI.MODID, name = FI.NAME, version = FVE.VERSION, dependencies = "required-after:frsm@[3.6.81,)")
public class FVE {
    
    public static final String VERSION = "0.86c";
    
    @Mod.Instance(FI.MODID)
    public static FVE instance;
    
	public static boolean conf1;
	public static boolean conf2;
	public static boolean conf3;
	public static boolean conf4;

    @Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){;
    	
	    //Config Stuff
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	    config.load();
	    conf1 = config.getBoolean("enable_recipes", "###[> General <]###", true, "Not working yet.");
	    conf2 = config.getBoolean("enable_vehicles_for_right_sided_roads", "###{> General <]###", true, "Enable Vehicles for right sided Roads/Streets.");
	    conf3 = config.getBoolean("enable_vehicles_for_left_sided_roads", "###{> General <]###", true, "Enable Vehicles for right sided Roads/Streets.");
	    conf4 = config.getBoolean("enable_update_checker", "###{> General <]###", true, "Selfexplaining.");	    
	    config.save();
	    //Config End
		
	    if(FVE.conf2 == true){
	    	FVERBlocks.init();
	    	TileEntitiesR.init();
	    }
	    if(FVE.conf3 == true){
	    	FVELBlocks.init();
	    	TileEntitiesL.init();	
	    }
	    
	}
    
	public static CreativeTabs tabFVE = new CreativeTabs("tabFVE") {
	    @Override
	    public Item getTabIconItem() {
	    	return (Item.getItemFromBlock(FVERBlocks.C5R));
	    }
	};
    
	@Mod.EventHandler
    public void init(FMLInitializationEvent event) {
		
		if(FVE.conf2 == true){
			RenderItemFVER.init(event.getSide());
		}
		if(FVE.conf3 == true){
			RenderItemFVEL.init(event.getSide());
		}
		if(event.getSide() == Side.CLIENT){
	        RenderRegistry.register(event.getSide());
		}
        Data.getDataFromServer();
        UpdateHandler.load();
        MinecraftForge.EVENT_BUS.register(new FVEEventHandler());
        
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    	/*if (Loader.isModLoaded("frsm")){
    		fve.isFRSMloaded = true;
    	}*/
    }
}