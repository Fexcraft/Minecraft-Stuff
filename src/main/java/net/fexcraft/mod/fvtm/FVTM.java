package net.fexcraft.mod.fvtm;

import net.fexcraft.mod.fvtm.blocks.ConstructorController;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.PacketHandler.PacketHandlerType;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.registry.RegistryUtil.AutoRegisterer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

/**
 * Fex's Vehicle and Transportation Mod
 * A Modification adding a custom add-on part system to create customizable vehicles
 * and, <i>more</i>.
 * <br>
 * License: <a href="http://fexcraft.net/license?id=mods">http://fexcraft.net/license?id=mods</a>
 * @author Ferdinand
 *
 */
@Mod(modid = FVTM.MODID, name = "Fex's Vehicle and Transportation Mod", version = FVTM.VERSION, dependencies = "required-after:fcl")
public class FVTM {
	
	public static final String MODID = "fvtm";
	public static final String PREFIX = Formatter.format("&0[&9FVTM&0]&7 ");
	public static final String VERSION = "2.0";
	
	@Mod.Instance(FVTM.MODID)
	private static FVTM INSTANCE;
	private static Resources RESOURCES;
	private static AutoRegisterer REGISTERER;
	
	@Mod.EventHandler
	public void initPre(FMLPreInitializationEvent event){
		RESOURCES = new Resources();
		REGISTERER = new AutoRegisterer(MODID);
		new ConstructorController();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new GuiHandler());
		PacketHandler.registerListener(PacketHandlerType.NBT, Side.SERVER, new GuiHandler.SReceiver());
		PacketHandler.registerListener(PacketHandlerType.NBT, Side.CLIENT, new GuiHandler.CReceiver());
	}
	
	@Mod.EventHandler
	public void initPost(FMLPostInitializationEvent event){
				
	}
	
	@Mod.EventHandler
	public void onStart(FMLServerStartingEvent event){
		event.registerServerCommand(new Command());
	}
	
	
	public static Resources getResources(){
		return RESOURCES;
	}
	
	public static FVTM getInstance(){
		return INSTANCE;
	}
	
	public static AutoRegisterer getRegisterer(){
		return REGISTERER;
	}
	
}