package net.fexcraft.mod.extensions.ce;

import java.io.IOException;

import net.fexcraft.mod.extensions.ce.blocks.CE_Blocks;
import net.fexcraft.mod.extensions.ce.items.CE_Items;
import net.fexcraft.mod.extensions.ce.render.RenderRegistry;
import net.fexcraft.mod.extensions.ce.util.CE_EventHandler;
import net.fexcraft.mod.extensions.ce.util.UpdateHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = "frsm_ce", name = "Calendar Extension", version = CE.version, dependencies = "required-after:frsm@[3.7.14,)")
public class CE {
	
    public static final String version = "1.0";
    public static final String mcv = "1.11";
    
    @Mod.Instance("frsm_ce")
    private static CE instance;

    @Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) throws IOException{

	    CE_Blocks.init();
	    CE_Items.init();
	    
	    GameRegistry.registerTileEntity(CE_Blocks.Clock2.TE.class, "frsm_ce:clock2");
	    GameRegistry.registerTileEntity(CE_Blocks.Calendar1.TE.class, "frsm_ce:calendar1");
	    GameRegistry.registerTileEntity(CE_Blocks.Clock1C.TEC.class, "frsm_ce:clock1C");
	    GameRegistry.registerTileEntity(CE_Blocks.Clock2C.TEC.class, "frsm_ce:clock2C");
	    GameRegistry.registerTileEntity(CE_Blocks.Calendar1C.TECL.class, "frsm_ce:alendar1C");
	    GameRegistry.registerTileEntity(CE_Blocks.Clock3_W.TE.class, "frsm_ce:clock3_W");
	    GameRegistry.registerTileEntity(CE_Blocks.Clock3_B.TE.class, "frsm_ce:clock3_B");
	}
    
	public static CreativeTabs tabCE = new CreativeTabs("tabCE") {
	    @Override
	    public ItemStack getTabIconItem() {
	    	return new ItemStack(Item.getItemFromBlock(CE_Blocks.Clock_2));
	    }
	};
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event) {
		RenderRegistry.register();
		UpdateHandler.init();
		MinecraftForge.EVENT_BUS.register(new CE_EventHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }
    
    public static CE getInstance(){
    	return instance;
    }
}