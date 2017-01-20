package net.fexcraft.mod.extensions.ce;

import java.io.IOException;

import net.fexcraft.mod.extensions.ce.blocks.CE_Blocks;
import net.fexcraft.mod.extensions.ce.blocks.ClockTileEntityBase;
import net.fexcraft.mod.extensions.ce.items.CE_Items;
import net.fexcraft.mod.extensions.ce.render.RenderRegistry;
import net.fexcraft.mod.extensions.ce.util.CE_EventHandler;
import net.fexcraft.mod.extensions.ce.util.CTS;
import net.fexcraft.mod.extensions.ce.util.UpdateHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = CE.MODID, name = "Calendar Extension", version = CE.VERSION, dependencies = "required-after:frsm@[3.7.14,)")
public class CE {
	
	public static final String MODID = "frsm_ce";
    public static final String VERSION = "1.1";
    public static final String MCV = "1.11";
    public static boolean e;
    
    @Mod.Instance(MODID)
    private static CE instance;

    @Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) throws IOException {
	    CE_Blocks.register();
	    CE_Items.register();
	    GameRegistry.registerTileEntity(CE_Blocks.Calendar1C.TECL.class, "frsm_ce:calendar1c");
	    GameRegistry.registerTileEntity(ClockTileEntityBase.class, "frsm_ce:clock");
	    
	    CTS.tabClocks.getTabIndex();
	}
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event){
		if(event.getSide().isClient()){
			RenderRegistry.register();
		}
		UpdateHandler.initialize();
		MinecraftForge.EVENT_BUS.register(new CE_EventHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }
    
    public static CE getInstance(){
    	return instance;
    }
    
}