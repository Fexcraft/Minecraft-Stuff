package net.fexcraft.mod.extensions.ce;

import java.io.IOException;

import net.fexcraft.mod.extensions.ce.blocks.CE_Blocks;
import net.fexcraft.mod.extensions.ce.items.CE_Items;
import net.fexcraft.mod.extensions.ce.proxy.Common;
import net.fexcraft.mod.extensions.ce.util.CE_EventHandler;
import net.fexcraft.mod.extensions.ce.util.Data;
import net.fexcraft.mod.extensions.ce.util.RenderItemCE;
import net.fexcraft.mod.extensions.ce.util.UpdateHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

//@Mod(modid = "frsm_ce", name = "Calendar Extension", version = CE.version, dependencies = "required-after:frsm@[3.7.14,)")
public class CE {
    
    @SidedProxy(clientSide = "net.fexcraft.mod.extensions.ce.proxy.Client", serverSide = "net.fexcraft.mod.extensions.ce.proxy.Common")
    public static Common proxy;
	
    public static final String version = "0.80c";
    public static final String mcv = "1.10.2";
    
    @Mod.Instance("frsm_ce")
    public static CE instance;

    @Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) throws IOException{
    	
    	//Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	    //config.load();;
	    //config.save();

	    CE_Blocks.init();
	    CE_Items.init();
	    
	    GameRegistry.registerTileEntity(CE_Blocks.Clock2.TE.class, "frsm_ce_Clock2");
	    GameRegistry.registerTileEntity(CE_Blocks.Calendar1.TE.class, "frsm_ce_Calendar1");
	    GameRegistry.registerTileEntity(CE_Blocks.Clock1C.TEC.class, "frsm_ce_Clock1C");
	    GameRegistry.registerTileEntity(CE_Blocks.Clock2C.TEC.class, "frsm_ce_Clock2C");
	    GameRegistry.registerTileEntity(CE_Blocks.Calendar1C.TECL.class, "frsm_ce_Calendar1C");
	    GameRegistry.registerTileEntity(CE_Blocks.Clock3_W.TE.class, "frsm_ce_Clock3_W");
	    GameRegistry.registerTileEntity(CE_Blocks.Clock3_B.TE.class, "frsm_ce_Clock3_B");
	}
    
	public static CreativeTabs tabCE = new CreativeTabs("tabCE") {
	    @Override
	    public Item getTabIconItem() {
	    	return Item.getItemFromBlock(CE_Blocks.Clock_2);
	    }
	};
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event) {
		
		RenderItemCE.init(event.getSide());
		
		proxy.registerRenderThings();

		Data.getDataFromServer();
		UpdateHandler.init();
		MinecraftForge.EVENT_BUS.register(new CE_EventHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }
}