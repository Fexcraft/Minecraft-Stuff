package net.fexcraft.mod.extensions.cae;

import net.fexcraft.mod.extensions.cae.blocks.CAEBlocks;
import net.fexcraft.mod.extensions.cae.gui.GuiHandler;
import net.fexcraft.mod.extensions.cae.gui.JsonPacketProcessor.Client;
import net.fexcraft.mod.extensions.cae.gui.JsonPacketProcessor.Server;
import net.fexcraft.mod.extensions.cae.render.RenderRegistry;
import net.fexcraft.mod.extensions.cae.tileentities.CABTE;
import net.fexcraft.mod.frsm.util.text.CCS;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.PacketHandler.PacketHandlerType;
import net.fexcraft.mod.lib.network.SimpleUpdateHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = CustomAsphaltExtension.FI.MODID, name = "Custom Asphalt Extension", version = CustomAsphaltExtension.FI.VERSION, dependencies = "required-after:frsm@[3.6.97,)")
public class CustomAsphaltExtension{
	
	private static final String version = "1.2";
	private static final String modid = "frsm_asphalt";
	private static final String prefix = CCS.BLACK + "[" + CCS.AQUA + "CAE" + CCS.BLACK + "]" + CCS.GRAY;
	
	@Mod.Instance(modid)
	private static CustomAsphaltExtension instance;
	
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		SimpleUpdateHandler.register(modid, 1, version);
		SimpleUpdateHandler.setUpdateMessage(modid, prefix + "New version avaible! (" + SimpleUpdateHandler.getLatestVersionOf(modid) + ")");
		CAEBlocks.register();
		
		GameRegistry.registerTileEntity(CABTE.class, "custom_asphalt");
	}
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event) {
		if(event.getSide().isClient()){
			RenderRegistry.register();
		}
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
	}
	
	@Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
		PacketHandler.registerListener(PacketHandlerType.JSON, Side.SERVER, new Server());
		if(event.getSide().isClient()){
			PacketHandler.registerListener(PacketHandlerType.JSON, Side.CLIENT, new Client());
		}
	}
	
	public static class FI{
		public static final String MODID = modid;
		public static final String VERSION  = version;
	}
	
	public static CustomAsphaltExtension getInstance(){
		return instance;
	}
}