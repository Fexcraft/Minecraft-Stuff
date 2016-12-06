package net.fexcraft.mod.extensions.ve;

import net.fexcraft.mod.extensions.ve.entities.EntityVehicle;
import net.fexcraft.mod.extensions.ve.handlers.KeyHandler;
import net.fexcraft.mod.extensions.ve.render.RenderRegistry;
import net.fexcraft.mod.extensions.ve.util.CTS;
import net.fexcraft.mod.frsm.FRSM;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = "frsm_vm", name = "Fex's Vehicle Mod", version = VE.version, dependencies = "required-after:frsm@[3.6.97,)")
public class VE{
	
	public static final String version = "0.1";
	public static final String mcv = "1.10.2";
	public static final String VE = CCS.DGRAY + "[" + CCS.DRED + "FVM" + CCS.DGRAY + "]" + CCS.GRAY + "";
	
	@Mod.Instance("frsm_vm")
	private static VE instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		
		EntityRegistry.registerModEntity(EntityVehicle.class, "Entity_Vehicle", 0, FRSM.getInstance(), 72, 2, false);
		
		if(event.getSide() == Side.CLIENT){
			KeyHandler.init();
			KeyHandler.register();
		}
	}
	
	@EventHandler
    public void init(FMLInitializationEvent event) {
		CTS.init();
		
		if(event.getSide().isClient()){
			RenderRegistry.register();
			MinecraftForge.EVENT_BUS.register(new KeyHandler.Event());
		}
	}
	
	@EventHandler
    public void postInit(FMLPostInitializationEvent event) {
		
    }
	
	public static VE getInstance(){
		return instance;
	}
}