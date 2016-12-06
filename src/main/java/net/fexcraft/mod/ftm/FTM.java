package net.fexcraft.mod.ftm;

import net.fexcraft.mod.ftm.entities.EntityCart;
import net.fexcraft.mod.ftm.render.RenderCart;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
//@Mod(modid = "ftm", name = "Fex's Train Mod", version = FTM.version, acceptableRemoteVersions = "*", updateJSON = "http://fexcraft.net/minecraft/fcl/request?mode=getForgeUpdateJson&modid=ftm")
public class FTM {
    
    public static final String prefix = TextFormatting.BLACK + "[" + TextFormatting.DARK_PURPLE + "FTM" + TextFormatting.BLACK + "]" + TextFormatting.GRAY + " ";
    public static final String version = "0.1";
    public static final String mcv = "1.10.2";
    
    @Mod.Instance("ftm")
    private static FTM instance;
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	EntityRegistry.registerModEntity(new ResourceLocation("ftm", "cart"), EntityCart.class, "cart", 0, instance, 64, 1, true);
    	RenderingRegistry.registerEntityRenderingHandler(EntityCart.class, RenderCart::new);
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
    }
    
    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event){
    	
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) throws Exception{
    	
    }
    
    public static FTM getInstance(){
        return instance;
    }
    
}